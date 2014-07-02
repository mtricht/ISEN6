<?php

use Phalcon\Http\Response;

class IndexController extends ControllerBase
{

    public function indexAction()
    {
    	$this->view->setVar("title", "Home");
    }

    public function signupAction()
    {
    	$this->view->setVar("title", "Sign up");

        // Run validation if we're posting.
        if ($this->request->isPost()) {
            // Save everything submitted!
            if ($this->forms->get('signup')->isValid($_POST)) {
                // TO-DO: In production redirect user to the selected payment method.
                $registration = new Registrations();
                if ($registration->save($_POST)) {
                    // Redirect if everything went well saving it.
                    $response = new Response();
                    return $response->redirect('login');
                }
            }
            // Else let the view and form handle the rest.
        }
    }

    public function loginAction()
    {
    	$this->view->setVar("title", "Login");

        // Are we posting?
        if ($this->request->isPost()) {
            $username = $this->request->getPost('username');
            $password = $this->request->getPost('password');
            $user = Users::query()->where("username = '$username'")->execute();
            if ($user) {
                if ($this->security->checkHash($password, $user->password)) {
                    die('ja');
                } else {
                    die('nee');
                }
            } else {
                die('nee');
            }
        }
    }

    public function featuresAction()
    {
    	$this->view->setVar("title", "Features");
    }

}

