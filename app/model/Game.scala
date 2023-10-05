package model

import play.api.data._
import play.api.data.Forms._

final case class Game(name: String, genre: String, price: BigDecimal, release: String, dev: String)

object Game {
    val form = Form[Game](
        mapping(
            "name" -> text,
            "genre" -> text,
            "price" -> bigDecimal,
            "release" -> text,
            "dev" -> text
        )(Game.apply)(Game.unapply)
    )
}