import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;
import java.util.ArrayList;

public class App {
  public static void main(String[] args) {

  //
  //   staticFileLocation("/public");
  //
  //   get("/", (request, response) -> {
  //     Map<String, Object> model = new HashMap<String, Object>();
  //     // System.out.println(Task.getDatabaseTest());
  //
  //     model.put("tasks", request.session().attribute("tasks"));
  //     model.put("template", "templates/index.vtl");
  //     return new ModelAndView(model, "templates/layout.vtl");
  //   }, new VelocityTemplateEngine());
  //
  //   post("/tasks", (request, response) -> {
  //     Map<String, Object> model = new HashMap<String, Object>();
  //
  //     ArrayList<Task> tasks = request.session().attribute("tasks");
  //     if (tasks == null) {
  //       tasks = new ArrayList<Task>();
  //       request.session().attribute("tasks", tasks);
  //     }
  //
  //     String description = request.queryParams("description");
  //     Task newTask = new Task(description);
  //     tasks.add(newTask);
  //     // request.session().attribute("tasks",newTask);
  //
  //     model.put("template", "templates/success.vtl");
  //     return new ModelAndView(model, "templates/layout.vtl");
  //   }, new VelocityTemplateEngine());
  //
  //
  //   get("/currentTask/:id", (request, response) -> {
  //
  //     Task task = Task.find(Integer.parseInt(request.params(":id")));
  //
  //
  //     Map<String, Object> model = new HashMap<String, Object>();
  //     model.put("task", task);
  //     model.put("taskName", task.getDescription());
  //     model.put("timeMade", task.getCreatedAt());
  //     model.put("template", "templates/currentTask.vtl");
  //     return new ModelAndView(model, "templates/layout.vtl");
  //   }, new VelocityTemplateEngine());
  //
  //   get("/currentTask/:id/complete", (request, response) -> {
  //
  //     Task task = Task.find(Integer.parseInt(request.params(":id")));
  //     task.completedTask();
  //     // System.out.println(task.isCompleted());
  //     Map<String, Object> model = new HashMap<String, Object>();
  //     model.put("task", task);
  //     model.put("taskName", task.getDescription());
  //     model.put("timeMade", task.getCreatedAt());
  //     model.put("template", "templates/currentTask.vtl");
  //     return new ModelAndView(model, "templates/layout.vtl");
  //   }, new VelocityTemplateEngine());
  //
  //
  //   get("/currentTask/:id/uncomplete", (request, response) -> {
  //
  //     Task task = Task.find(Integer.parseInt(request.params(":id")));
  //     task.completedTask();
  //     // System.out.println(task.isCompleted());
  //     Map<String, Object> model = new HashMap<String, Object>();
  //     model.put("task", task);
  //     model.put("taskName", task.getDescription());
  //     model.put("timeMade", task.getCreatedAt());
  //     model.put("template", "templates/currentTask.vtl");
  //     return new ModelAndView(model, "templates/layout.vtl");
  //   }, new VelocityTemplateEngine());
  }
}
