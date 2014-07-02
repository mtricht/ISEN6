<?php

use Phalcon\Forms\Form,
    Phalcon\Forms\Element\Text,
    Phalcon\Forms\Element\Hidden;

class BootstrapForm extends Form
{

    public function renderDecorated($name)
    {
        $element = $this->get($name);

        // Validation error messages.
        $messages = $this->getMessagesFor($element->getName());

        $decoratedInput = '<div class="form-group' . (count($messages)
            ? ' has-error'
            : ''
            ) . '">';
        $decoratedInput .= '<label for="' . $element->getName() . '">' . $element->getLabel() . '</label>';
        $element->setAttribute('class', 'form-control');
        // Display first error message.
        if (count($messages)) {
            $element->setAttribute('data-toggle', 'tooltip');
            $element->setAttribute('title', $messages[0]);
        }
        $decoratedInput .= $element;
        $decoratedInput .= '</div>';

        return $decoratedInput;
    }

    public function render($name = '', $attributes = NULL)
    {
        // Loop through every field.
        $decoratedForm = '<form role="form" method="post">';
        foreach ($this->getElements() as $k => $v) {
            $decoratedForm .= $this->renderDecorated($k);
        }
        $decoratedForm .= '</form>';
        return $decoratedForm;
    }
}