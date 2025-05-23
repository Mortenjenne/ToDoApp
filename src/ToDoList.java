import java.util.List;

public class ToDoList {

    private List<Item> items;

    public ToDoList(List<Item> items){
        this.items = items;
    }

    public void displayItems(){
        if(!items.isEmpty()) {
            for (int i = 0; i < items.size(); i++){
                System.out.println(i+1 + ". " + items.get(i));
            }
        } else {
            System.out.println("Nothing added to list yet");
        }
    }

    public void markTaskAsDone(int index){
        this.items.get(index).markIsDone();
    }

    public void remove(int index){
        this.items.remove(index);
    }

    public void addTask(String description){
        this.items.add(new Item(description,false));
    }
}
