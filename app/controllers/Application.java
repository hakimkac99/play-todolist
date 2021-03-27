package controllers;

import akka.http.impl.engine.ws.FrameHandler;
import models.Task;
import play.mvc.*;

import java.util.ArrayList;
import java.util.List;

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


        List<Task> taskList = Task.find.all();

        return ( ok(views.html.listTache.render(taskList)));
    }

    // Affiche le template views/ajouterTacheForm.html (formulaire d'ajout d'une tâche)
    public  Result ajouterTacheForm() {
        // A COMPLETER
        // ...
        return null;
    }

    // Ajoute une nouvelle tâche en base de données et affiche le template views/ajouterTache.html
    public  Result ajouterTache() {
        // A COMPLETER
        // ...
        return null;
    }

    // Change le statut d'une tâche en base de données
    public  Result validerTache() {
        // A COMPLETER
        // ...
        return null;
    }

    // Supprime une tâche en base de données
    public  Result supprimerTache() {
        // A COMPLETER
        // ...
        return null;
    }

    // Modifie une tâche en base de données
    public  Result editTache() {
        // A COMPLETER
        // ...
        return null;
    }
}
