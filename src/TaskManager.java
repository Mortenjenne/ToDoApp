import java.util.List;

public class TaskManager {

    private ItemLoader itemLoader;
    private ToDoList toDoList;
    private UserInterface ui;
    private List<Item> items;
    private boolean appRunning;
    private final String path = "data/todo.csv";
    private final String header = "Description, Done";

    public TaskManager() {
        this.itemLoader = new ItemLoader();
        this.items = itemLoader.loadFile(path);
        this.toDoList = new ToDoList(items);
        this.ui = new UserInterface();
    }

    public void start(){
        appRunning = true;
        while (appRunning){
         ui.showMenu();
         String input = ui.readInput("Awaiting command");

         switch (input){
             case "1":
                 showToDoList();
                 break;
             case "2":
                 addToDo();
                 break;
             case "3":
                 markToDoAsDone();
                 break;
             case "4":
                 removeToDo();
                 break;
             case "x":
                 quit();
                 break;
             default:
                 ui.printMessage("Didnt recognize this command, try again");
                 break;
         }
        }
    }

    private void showToDoList() {
        toDoList.displayItems();
    }

    private void addToDo() {
        String input = ui.readInput("Add a task, by writing a description");
        toDoList.addTask(input);
    }

    private void markToDoAsDone() {
        toDoList.displayItems();
        int index = ui.promptNumeric("Which task should be marked as done (give the number)");
        index --;
        if(isValidTaskNumber(index)){
            toDoList.markTaskAsDone(index);
        }

    }

    private void removeToDo(){
        toDoList.displayItems();
        int index = ui.promptNumeric("Which task should be removed (give the number)");
        index --;
        if(isValidTaskNumber(index)){
            toDoList.remove(index);
        }

    }

    private void quit() {
        ui.printMessage("Thank you");
        itemLoader.saveData(this.items,this.path,this.header);
        appRunning = false;
    }

    private boolean isValidTaskNumber(int index){
        if(index >= 0 && index < this.items.size()){
            return true;
        } else {
            ui.printMessage("Invalid task number, try again");
            return false;
        }
    }


}
