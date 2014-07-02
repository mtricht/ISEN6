<?php

use Phalcon\Mvc\Controller;

class ControllerBase extends Controller
{

	public function onConstruct()
    {
        if (!$this->session->has('login') && !in_array($this->dispatcher->getActionName(), $this->exceptions)) {
            $this->response->redirect('login');
        } else if ($this->session->has('login')) {
            $this->user = Users::find($this->session->get('user'));
        }
    }

}
