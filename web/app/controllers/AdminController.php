<?php

use Phalcon\Http\Response;

class AdminController extends ControllerBase
{

    public function indexAction()
    {
    	$this->view->setVar("title", "Admin Panel");
    }
}

