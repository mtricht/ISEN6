<?php

use Phalcon\Http\Response;

class AdminController extends ControllerBase
{

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
    	if ($id == 0 || count($registration = Registrations::find($id)) == 0) {
    		$response = new Response();
    		return $response->redirect('admin/createbitpin');
    	}
    	$this->view->setVar("title", "Accept Registration");
    	$this->view->setVar("registration", $registration);
        // Create RSA key for the Java applet.
        $openssl = Keys::generateKey(512);
        $this->view->setVar("id", $id);
        $this->view->setVar("privateKey", $openssl['privateKey']);
        $this->session->set("passphrase", $openssl['passphrase']);
    }

    public function acceptedAction()
    {
        $this->assets->addCss('css/print.css');
        $this->view->setVar("title", "Accepted");
    }
}

