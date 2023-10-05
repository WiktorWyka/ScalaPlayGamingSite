package controllers

import javax.inject._
import play.api._
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._

import model.Animal
import play.api.db.Database
import play.api.i18n.Messages
import play.api.i18n.I18nSupport
import java.sql.Connection

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class HomeController @Inject()(controllerComponents: ControllerComponents, db : Database) 
extends AbstractController(controllerComponents) with I18nSupport{

  private def createTable(connection : Connection): Unit = {
    val SQLStatement = 
    """
    CREATE TABLE IF NOT EXISTS Animals (
      legs INT,
      sound VARCHAR (50)
    );
    """
    val result = db.getConnection().createStatement().execute(SQLStatement)
    if(result){ println("Created new table 'animals'")}
  }

  def processForm() = Action { implicit request =>
    val connection = db.getConnection()
    createTable(connection)
    val statement = connection.createStatement()
    val result = Animal.form.bindFromRequest().get
    val legs = result.legs
    val sound = result.sound
    println(legs)
    println(sound)
    val SQLStatement = s"""
    INSERT INTO animals(legs, sound) 
    VALUES ($legs, '$sound');
    """
    Ok(views.html.addAnimalForm(Animal.form))
  }

  def showForm() = Action { implicit request =>
    Ok(views.html.addAnimalForm(Animal.form))
  }

  // Add in a successful request page for a GET request redirect after the POST request
  def success() = TODO

  def index() = Action {
    Ok(views.html.index())
  }
}
