package model

import play.api.data._
import play.api.data.Forms._

case class Animal (val legs : Int, val sound : String)

object Animal {
    val form: Form[Animal] = Form(
        mapping(
            "legs" -> number,
            "sound" -> text
        )(Animal.apply)(Animal.unapply)
    )
}