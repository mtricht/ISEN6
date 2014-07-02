<?php

class IndexController extends ControllerBase
{

    public $exceptions = array('login', 'index', 'features', 'signup');

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
                    $this->response->redirect('');
                }
            }
            // Else let the view and form handle the rest.
        }
    }

    public function loginAction()
    {
        if ($this->session->has('login')) {
            $this->response->redirect('');
        }
    	$this->view->setVar("title", "Login");
        // Are we posting?
        if ($this->request->isPost()) {
            $username = $this->request->getPost('username');
            $password = $this->request->getPost('password');
            $user = Users::findFirst("username = '$username'");
            if (count($user) > 0) {
                if ($this->security->checkHash($password, $user->password)) {
                    $this->session->set('login', true);
                    $this->session->set('user', $user->id);
                    // Redirect to home page.
                    $this->response->redirect('');
                }
            }
            // TODO: Dit op een of andere manier in de view krijgen.
            $this->flash->error('Wrong username/password combination.');
        }
    }

    public function logoutAction()
    {
        $this->session->remove('login');
        $this->session->remove('user');
        $this->response->redirect('');
    }

}

