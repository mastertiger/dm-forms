package org.dupontmanual.forms.widgets

import scala.xml._

import play.api.libs.json.JsArray

import org.dupontmanual.forms.validators.ValidationError

/**
 * A Widget that uses the Bootstrap typeahead javascript.
 */
class AutocompleteInput(
  required: Boolean,
  array: JsArray = new JsArray(Nil),
  attrs: MetaData = Null) extends Widget(required, attrs) {

  /**
   * Renders the field using xml.
   */
  def render(name: String, value: Seq[String], attrList: MetaData = Null) = {
    val valueAttr = if (value.isEmpty) "" else value(0)
    <input type="text" name={name} class="ac" value={valueAttr} data-provide="typeahead" data-source={ array.toString } data-items="12" autocomplete="off"/> % attrs % reqAttr % attrList
  }
}
