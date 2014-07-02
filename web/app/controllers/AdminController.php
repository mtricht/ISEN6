<?php

use Phalcon\Http\Response;

class AdminController extends ControllerBase
{

    public function onConstruct()
    {
        $exceptions = array();
        if (!$this->session->has('login') && !in_array($this->dispatcher->getActionName(), $exceptions)) {
            $this->response->redirect('login');
        }
    }

    public function indexAction()
    {
    	$this->view->setVar("title", "Admin Panel");
    }

    public function createbitpinAction()
    {
        $this->view->setVar("title", "Registrations");
        $this->view->setVar("registrations", Registrations::find());
    }

    public function acceptAction($id = 0)
    {
        // Does it exist?
        if ($id == 0 || count($registration = Registrations::find($id)) == 0) {
            $response = new Response();
            return $response->redirect('admin/createbitpin');
        }
        // Are we posting?
        if ($this->request->isPost()) {
            // Save the user.
            $credentials = Users::generateCredentials();
            $user = new Users();
            $user->save(array(
                'username' => $credentials['username'] ,
                'password' => $this->security->hash($credentials['password']),
                'card_id' => $_POST['uuid']
            ));
            // Save the card ID with public key.
            $key = new Keys();
            $key->save(array(
                'card_id' => $_POST['uuid'],
                'rsa_public_key' => $this->session->get('publicKey')
            ));
            // Delete registration as it's accepted now.
            $registration->delete();
            // Unset session
            $passphrase = $this->session->get("passphrase");
            $this->session->remove("publicKey");
            $this->session->remove("passphrase");
            // Display PDF.
            include '../app/libraries/mPDF/mpdf.php';
            $mpdf = new mPDF();
            $mpdf->WriteHTML("Pincode: " . $passphrase . "<br />" .
                "Gebruikersnaam: " . $credentials['username'] . "<br />" .
                "Wachtwoord: " . $credentials['password']);
            $mpdf->Output();
            die();
            
        }
    	$this->view->setVar("title", "Accept Registration");
    	$this->view->setVar("registration", $registration);
        // Create RSA key for the Java applet.
        $openssl = Keys::generateKey(512);
        $this->view->setVar("id", $id);
        $this->view->setVar("privateKey", $openssl['privateKey']);
        $this->session->set("publicKey", $openssl['publicKey']);
        $this->session->set("passphrase", $openssl['passphrase']);
    }

    public function acceptedAction()
    {
        $this->assets->addCss('css/print.css');
        $this->view->setVar("title", "Accepted");
    }
}

