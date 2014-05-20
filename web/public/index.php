<?php

error_reporting(E_ALL);

try {

    /**
     * Read the configuration
     */
    $config = include __DIR__ . "/../app/config/config.php";

    /**
     * Read auto-loader
     */
    include __DIR__ . "/../app/config/loader.php";

    /**
     * Read services
     */
    include __DIR__ . "/../app/config/services.php";

    /**
     * Handle the request
     */




    $application = new \Phalcon\Mvc\Application($di);
    $di->set('dispatcher', function() use($config){

        //Create an event manager
        $eventsManager = new Phalcon\Events\Manager();

        //Attach a listener for type "dispatch"
        $eventsManager->attach("dispatch", new RouteListener($config));

        $dispatcher = new Phalcon\Mvc\Dispatcher();

        //Bind the eventsManager to the view component
        $dispatcher->setEventsManager($eventsManager);

        return $dispatcher;

    }, true);
    echo $application->handle()->getContent();

} catch (\Exception $e) {
    echo $e->getMessage();
}
