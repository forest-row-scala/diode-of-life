package controllers

import play.api.mvc._


object Application extends Controller {

  def index = Action {
    Ok(views.html.index("Game of Life"))
  }

  def logging = Action(parse.anyContent) { implicit request =>
    request.body.asJson.foreach(msg => println(s"CLIENT - $msg"))
    Ok("")
  }
}
