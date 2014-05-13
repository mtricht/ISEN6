<?php

class RouteListener
{
    public $routes = array();

    public function __construct($config){
        $this->routes = $config->root_routes;
    }


    public function beforeDispatchLoop($event, $dispatcher){
        if(array_key_exists($dispatcher->getControllerName(), $this->routes)){
            $dispatcher->forward(array(
                "controller" => $this->routes[$dispatcher->getControllerName()],
                "action" => $dispatcher->getControllerName()
            ));
        }
    }
}