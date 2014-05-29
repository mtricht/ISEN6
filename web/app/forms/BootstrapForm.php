<?php

use Phalcon\Forms\Form,
    Phalcon\Forms\Element\Text,
    Phalcon\Forms\Element\Hidden;

class BootstrapForm extends Form
{

    public function renderDecorated($name)
    {
        $element = $this->get($name);

        // Validation messages.
        $messages = $this->getMessagesFor($element->getName());

        // TODO: display errors messages in a tooltip.

        $decoratedInput = '<div class="form-group">';
        $decoratedInput .= '<label for="' . $element->getName() . '">' . $element->getLabel() . '</label>';
        $element->setAttribute('class', 'form-control');
        $decoratedInput .= $element;
        $decoratedInput .= '</div>';

        return $decoratedInput;
    }

    public function render()
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