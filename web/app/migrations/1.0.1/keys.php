<?php 

use Phalcon\Db\Column;
use Phalcon\Db\Index;
use Phalcon\Db\Reference;
use Phalcon\Mvc\Model\Migration;

class KeysMigration_101 extends Migration
{

    public function up()
    {
        $this->morphTable(
            'keys',
            array(
            'columns' => array(
                new Column(
                    'card_id',
                    array(
                        'type' => Column::TYPE_VARCHAR,
                        'notNull' => true,
                        'size' => 16,
                        'first' => true
                    )
                ),
                new Column(
                    'rsa_public_key',
                    array(
                        'type' => Column::TYPE_VARCHAR,
                        'notNull' => true,
                        'size' => 1,
                        'after' => 'card_id'
                    )
                )
            ),
            'indexes' => array(
                new Index('PRIMARY', array('card_id'))
            ),
            'options' => array(
                'TABLE_TYPE' => 'BASE TABLE',
                'AUTO_INCREMENT' => '',
                'ENGINE' => 'MyISAM',
                'TABLE_COLLATION' => 'latin1_swedish_ci'
            )
        )
        );
    }
}
