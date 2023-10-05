package model

import org.scalatestplus.play._
import org.scalatestplus.play.guice._
import org.scalatestplus.play.PlaySpec  

import model.Game

class GameTest extends PlaySpec {
  "A Game object" must {
    "have its fields defined with the correct values as when it was created" in {
    val game = Game("Baldur's Gate 3", "RPG", BigDecimal(59.99), "3/08/23", "Larian Games")
    assert(game.name == "Baldur's Gate 3")
    assert(game.genre == "RPG")
    assert(game.price == BigDecimal(59.99))
    assert(game.release == "3/08/23")
    assert(game.dev == "Larian Games")
    }
  }
}