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
        if ($_POST) {
            // Save everything submitted!
            if ($this->forms->get('signup')->isValid($_POST)) {
                // TO-DO: In production redirect user to the selected payment method.
                $registration = new Registration();
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
    }

    public function featuresAction()
    {
    	$this->view->setVar("title", "Features");
    }

}

