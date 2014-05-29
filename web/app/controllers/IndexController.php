<?php

class IndexController extends ControllerBase
{

    public function indexAction()
    {
    	$this->view->setVar("title", "Home");
    }

    public function signupAction()
    {
    	$this->view->setVar("title", "Sign up");
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

