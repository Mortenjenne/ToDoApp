import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class ToDoListTest {
    private ToDoList toDoList;

    @BeforeEach
    public void setUp() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("Køb mælk", false));
        items.add(new Item("Løb en tur", false));
        toDoList = new ToDoList(items);
    }

    @Test
    public void testGetItems() {
        assertEquals(2, toDoList.getItems().size());
    }

    @Test
    public void testSize() {
        assertEquals(2, toDoList.size());
    }

    @Test
    public void testAddTask() {
        toDoList.addTask("Gå til eksamen");
        assertEquals(3, toDoList.size());
        assertEquals("Gå til eksamen", toDoList.getItem(2).getDescription());
    }

    @Test
    public void testAddEmptyTask() {
        toDoList.addTask("");
        assertEquals(2, toDoList.size());
    }

    @Test
    public void testRemoveTask() {
        toDoList.remove(0);
        assertEquals(1, toDoList.size());
        assertEquals("Løb en tur", toDoList.getItem(0).getDescription());
    }

    @Test
    public void testMarkTaskAsDone() {
        toDoList.markTaskAsDone(1);
        assertTrue(toDoList.getItem(1).isTaskDone());
    }
  
}