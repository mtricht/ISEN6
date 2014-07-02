<?php

return new \Phalcon\Config(array(
    'database' => array(
        'adapter'     => 'Mysql',
        'host'        => 'localhost',
        'username'    => 'root',
        'password'    => '',
        'dbname'      => 'test',
    ),
    'application' => array(
        'controllersDir' => __DIR__ . '/../../app/controllers/',
        'modelsDir'      => __DIR__ . '/../../app/models/',
        'viewsDir'       => __DIR__ . '/../../app/views/',
        'pluginsDir'     => __DIR__ . '/../../app/plugins/',
        'libraryDir'     => __DIR__ . '/../../app/library/',
        'cacheDir'       => __DIR__ . '/../../app/cache/',
        'listenersDir'       => __DIR__ . '/../../app/listeners/',
        'formsDir'       => __DIR__ . '/../../app/forms/',
        'baseUri'        => '/web/',
        'compileAlways'  => true, // Set to true for development enviroment.
    ),
    'root_routes' => array(
        'signup' => 'index',
        'login' => 'index',
        'features' => 'index',
        'logout' => 'index'
    )
));
