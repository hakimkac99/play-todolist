package controllers;
import com.google.gson.*;
import dto.TaskDTO;
import models.Task;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;
import scala.util.parsing.json.JSONArray;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ServiceWeb extends Controller {

    // Ajoute une tâche en base de données (CREATE => POST)
    // Test (curl) : curl --data "nomTache=task-from-curl" localhost:9000/api/tache
    public Result ajouterTache(Http.Request request) {
        Task task = request.body().parseJson(Task.class).get();
        if(task!=null) {
            task.setDone(false);
            task.save();
            return ok(Json.toJson(new TaskDTO(task)));
        }
        return badRequest("Task not created !");
    }

    // Retourne au format JSON la liste des tâches (READ => GET)
    // Test (curl) : curl localhost:9000/api/taches.json
    public Result listTache() {
        //Serialization
        Gson g = new Gson();
        List<TaskDTO> listTask = new ArrayList<TaskDTO>();
        for (Task task : Task.find.all()){
            listTask.add(new TaskDTO(task));
        }
        return ok(g.toJson(listTask));
    }

    // Retourne au format JSON une tâche (READ => GET)
    // Test (curl) : curl localhost:9000/api/tache/1.json
    public Result getTache(Long id) {
        Task task = Task.findById(id);
        if(task!=null) {
            return ok(Json.toJson(new TaskDTO(task)));
        }
        return badRequest("Task not found !");
    }

    // Modifie le titre d'une tâche (UPDATE => PUT)
    // Test (curl) : curl -X PUT --data "title=aaabbb" localhost:9000/api/tache/1
    public Result editTitleTache(Long id, Http.Request request) {
        String newTitle = request.body().asJson().findValue("title").asText();
        Task oldTask = Task.findById(id);
        oldTask.setTitle(newTitle);
        oldTask.update();
        return ok(Json.toJson(new TaskDTO(oldTask)));
    }

    // Change le statut d'une tâche (UPDATE => PUT)
    // Test (curl) : curl -X PUT --data "title=aaabbb" localhost:9000/api/tache/1
    public Result changeStatutTache(Long id) {
        Task task = Task.findById(id);
        if(task!=null) {
            task.setDone(!task.isDone());
            task.update();
            return ok(Json.toJson(new TaskDTO(task)));
        }
        return badRequest("Task not found !");
    }

    // Supprime une tâche (DELETE => DELETE)
    // Test (curl) : curl -X DELETE localhost:9000/api/tache/1
    public Result supprimeTache(Long id) {
        Task task = Task.findById(id);
        if(task!=null) {
            task.delete();
            return ok("Task deleted");
        }
        return badRequest("Task not found !");
    }

}
