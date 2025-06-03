
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ItemLoader {

    public List<Item> loadFile(String path){
        List<Item> toDoList = new ArrayList<>();
        List<String> data = loadData(path);
        if(!data.isEmpty()){
           for(String s: data){
               String[] values = s.split(",");
               String description = values[0].trim();
               boolean isDone = Boolean.parseBoolean(values[1].trim());
               toDoList.add(new Item(description,isDone));
           }
            return toDoList;
        } else {
            return new ArrayList<>();
        }
    }

    private List<String> loadData(String path){
        List<String> data = new ArrayList<>();
        File file = new File(path);
        try {
            Scanner scan = new Scanner(file);
            scan.nextLine();
            while(scan.hasNextLine()){
              String line = scan.nextLine();
              data.add(line);
            }
            scan.close();
        } catch (FileNotFoundException e){
            System.out.println("Couldn't read file " + e.getMessage());
        }
        return data;
    }

    public void saveData(List<Item> data, String path, String header){

        try{
            FileWriter writer = new FileWriter(path);
            writer.write(header + "\n");
            for(Item items: data){
                writer.write(items.saveToCsv() + "\n");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Could not save file" + e.getMessage());
        }
    }

}
