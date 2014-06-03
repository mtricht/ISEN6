<?php

use \Phalcon\Db\Column as Column;

class ClientTable
{
    function __construct($connection)
    {
        $connection->createTable(
            "registrations",
            null,
            array(
               "columns" => array(
                    new Column("id",
                        array(
                            "type"          => Column::TYPE_INTEGER,
                            "size"          => 10,
                            "notNull"       => true,
                            "autoIncrement" => true,
                        )
                    ),
                    new Column("email",
                        array(
                            "type"          => Column::TYPE_VARCHAR,
                            "size"          => 128,
                            "notNull"       => true,
                        )
                    ),
                    new Column("adress_street",
                        array(
                            "type"    => Column::TYPE_VARCHAR,
                            "size"    => 70,
                            "notNull" => true,
                        )
                    ),
                    new Column("adress_number",
                        array(
                            "type"    => Column::TYPE_VARCHAR,
                            "size"    => 11,
                            "notNull" => true,
                        )
                    ),
                    new Column("postal_code", // This only allows for dutch postal codes
                       array(
                           "type"    => Column::TYPE_VARCHAR,
                           "size"    => 6,
                           "notNull" => true,
                       )
                    ), 
                    new Column("payment_method", // This only allows for dutch postal codes
                       array(
                           "type"    => Column::TYPE_VARCHAR,
                           "size"    => 20,
                           "notNull" => true,
                       )
                    ),             
                )
            )
        );
    }
}