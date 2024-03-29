import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;
import java.time.LocalDateTime;


public class TaskTest {

  @Before
  public void setUp() {
    DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/to_do_test", null, null);
  }


  @After
  public void tearDown() {
    try(Connection con = DB.sql2o.open()) {
      String deleteTasksQuery = "DELETE FROM tasks *;";
      // String deleteCategoriesQuery = "DELETE FROM categories *;";
      con.createQuery(deleteTasksQuery).executeUpdate();
      // con.createQuery(deleteCategoriesQuery).executeUpdate();
    }
  }

  @Test
  public void save_assignsIdToObject() {
    Task myTask = new Task("Mow the lawn");
    myTask.save();
    Task savedTask = Task.all().get(0);
    System.out.println(savedTask.getCreatedAt());
    assertEquals(myTask.getId(), savedTask.getId());
  }

  @Test
  public void find_findsTaskInDatabase_true() {
    Task myTask = new Task("Mows the lawn");
    myTask.save();
    Task savedTask = Task.find(myTask.getId());
    assertTrue(myTask.equals(savedTask));
  }

  @Test
  public void all_emptyAtFirst() {
    assertEquals(0, Task.all().size());
  }

  @Test
  public void equals_returnsTrueIfDescriptionsAretheSame() {
    Task firstTask = new Task("Mow the lawn");
    Task secondTask = new Task("Mow the lawn");
    assertTrue(firstTask.equals(secondTask));
  }

  @Test
  public void Task_instantiatesCorrectly_true() {
    Task myTask = new Task("Mow the lawn");
    assertEquals(true, myTask instanceof Task);
  }
  @Test
  public void getDescription_instantiatesWithDescription_String() {
    Task myTask = new Task("Mow the lawn");
    assertEquals("Mow the lawn", myTask.getDescription());
  }

  @Test
  public void isCompleted_isFalseAfterInstantiation_false() {
    Task myTask = new Task("Mow the lawn");
    assertEquals(false, myTask.isCompleted());
  }


  // @Test
  // public void getCreatedAt_instantiatesWithCurrentTime_today() {
  //   Task myTask = new Task("Mow the lawn");
  //   assertEquals(LocalDateTime.now().getDayOfWeek(), myTask.getCreatedAt().getDayOfWeek());
  // }

  // @Test
  // public void all_returnsAllInstancesOfTask_true() {
  //   Task firstTask = new Task("Mow the lawn");
  //   Task secondTask = new Task("Buy groceries");
  //   // System.out.println(firstTask.all());
  //   assertTrue(secondTask.all().contains(firstTask));
  //   assertTrue(Task.all().contains(secondTask));
  // }

  // @Test
  // public void clear_emptiesAllTasksFromArrayList_0() {
  //   Task myTask = new Task("Mow the lawn");
  //   Task.clear();
  //   assertEquals(Task.all().size(), 0);
  // }

  // @Test
  // public void getId_tasksInstantiateWithAnID_1() {
  //   Task.clear();  // THIS TEST WILL FAIL WITHOUT THIS LINE!
  //   Task myTask = new Task("Mow the lawn");
  //   assertEquals(0, myTask.getId());
  // }

//   @Test
//   public void find_returnsTaskWithSameId_secondTask() {
//     Task.clear();
//     Task firstTask = new Task("Mow the lawn");
//     Task secondTask = new Task("Buy groceries");
//     assertEquals(Task.find(secondTask.getId()), secondTask);
//   }
 }
