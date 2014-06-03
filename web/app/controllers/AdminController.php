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
        $this->assets->addCss('css/print.css');
        $this->view->setVar("title", "Admin Panel");
    }
}

