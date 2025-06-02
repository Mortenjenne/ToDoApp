import java.util.List;

public class ToDoList {

    private List<Item> items;

    public ToDoList(List<Item> items){
        this.items = items;
    }

    public List<Item> getItems(){
        return this.items;
    }

    public Item getItem(int index){
        return this.items.get(index);
    }

    public int size(){
        return this.items.size();
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
        this.items.get(index).markAsDone();
    }

    public void remove(int index){
        this.items.remove(index);
    }

    public void addTask(String description){
        if(description != null && !description.trim().isEmpty()){
            this.items.add(new Item(description,false));
        } else {
            System.out.println("Task description cannot be empty.");
        }
    }
}
