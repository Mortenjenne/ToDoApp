public class Item {

    private String description;
    private boolean isDone;

    public Item(String description, boolean isDone){
        this.description = description;
        this.isDone = isDone;
    }

    public String getDescription() {
        return this.description;
    }

    public boolean isTaskDone(){
        return this.isDone;
    }

    @Override
    public String toString(){
        if(this.isDone){
            return this.description + ", done";
        } else {
            return this.description + ", not done";
        }
    }

    public void markIsDone(){
        if(!this.isDone) {
            this.isDone = true;
        }
    }

    public String saveToCsv(){
        return this.description + ", " + this.isDone;
    }
}
