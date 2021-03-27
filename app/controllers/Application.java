package controllers;

import akka.http.impl.engine.ws.FrameHandler;
import play.mvc.*;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class Application extends Controller {

    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */


    public Result index() {
        return ok(views.html.index.render());
    }

    public Result about() {
        return ok(views.html.about.render());
    }

    // Affiche toutes les tâches (voir variable taches) dans le template views/listTache.html
    public  Result listTache() {
        // A COMPLETER
        // ...
        return (ok("Salut"));
    }

}
