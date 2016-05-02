import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.sql2o.*;

public class Task {
  // private String mDescription;
  //
  // private LocalDateTime mCreatedAt;
  // private static ArrayList<Task> instantFood = new ArrayList<Task>();
  // private int mId;


//server-database
  private boolean completed;
  private int id;
  private String description;
  private String createdAt;


  public Task(String description) {
    this.description = description;
    createdAt = LocalDateTime.now().toString();
    completed = false;
  }

  public String getDescription() {
    return description;
  }

  public String getCreatedAt() {
    return createdAt;
  }

  public int getId() {
    return id;
  }

  public boolean isCompleted() {
    return completed;
  }

  public static List<Task> all(){
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM tasks;";
      return con.createQuery(sql).executeAndFetch(Task.class);
    }
  }

  public static Task find(int id) {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM tasks where id=:id";
      Task task = con.createQuery(sql).addParameter("id", id).executeAndFetchFirst(Task.class);
      return task;
    }
  }

  @Override
  public boolean equals(Object otherTask) {
    if (!(otherTask instanceof Task)) {
      return false;
    } else {
      Task newTask = (Task) otherTask;
      return this.getDescription().equals(newTask.getDescription());
    }
  }

  public void save() {
    try(Connection con = DB.sql2o.open()){
      String sql = "INSERT INTO tasks (description, createdAt, completed) VALUES (:description, :createdAt, :completed)";
      this.id = (int) con.createQuery(sql, true)
      .addParameter("description", description)
      .addParameter("createdAt", createdAt)
      .addParameter("completed", completed)
      .executeUpdate().getKey();
    }
  }


// // server-client
//   public Task(String description) {
//     mDescription = description;
//     mCompleted = false;
//     mCreatedAt = LocalDateTime.now();
//     mId = instantFood.size();
//     instantFood.add(this);
//   }
//
//   public static Task find(int id) {
// //     try {
// //       return instantFood.get(id);
// //     } catch (IndexOutOfBoundsException e) {
// //       System.out.println(e);
// //       return null;
// //     }
// //   }

//   public String getDescription() {
//     return mDescription;
//   }
//

//
  // public void completedTask(){
//     if(mCompleted){
//       mCompleted = false;
//     } else {
//       mCompleted = true;
//     }
//   }
//

//
//   public static ArrayList<Task> all() {
//     return instantFood;
//   }
//
//   public static void clear() {
//     instantFood.clear();
//   }
//
//   public int getId() {
//     return mId;
//   }



}
