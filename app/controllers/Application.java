package controllers;

import akka.http.impl.engine.ws.FrameHandler;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.JsonNode;
import dto.TaskDTO;
import models.Task;
import play.data.DynamicForm;
import play.data.Form;
import play.libs.Json;
import play.mvc.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

        return ok(views.html.ajouterTacheForm.render());
    }

    // Ajoute une nouvelle tâche en base de données et affiche le template views/ajouterTache.html
    public  Result ajouterTache(Http.Request request) {
        Task task = request.body().parseJson(Task.class).get();
        task.save();
        return  ok();
    }

    // Change le statut d'une tâche en base de données
    public  Result validerTache(Http.Request request) {
        Task task = request.body().parseJson(Task.class).get();
        task.update();
        return ok();
    }

    // Supprime une tâche en base de données
    public  Result supprimerTache(Http.Request request) {
        long id = request.body().asJson().findValue("id").asLong();
        Task task = Task.findById(id);
        task.delete();
        return ok(Json.toJson(new TaskDTO(task)));
    }

    // Modifie une tâche en base de données

    public  Result editTache(Http.Request request) {
        Task newTask = request.body().parseJson(Task.class).get();
        newTask.update();
        return ok(Json.toJson(new TaskDTO(newTask)));
    }



}
