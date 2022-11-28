import com.sun.source.tree.TryTree;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class Handle {
    public dictionary readFile(String path) {
        dictionary result = new dictionary();
        HashMap<String, String> add = new HashMap<String, String>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            String line;

            while ((line = reader.readLine()) != null){

                String[] map = line.split("`");
                //0: key
                //1: value

                if (map.length > 1) {
                    add.put(map[0], map[1]);
                }
                else {
                    continue;
                }

            }
            reader.close();
        } catch (IOException ex){
            ex.printStackTrace();
        }

        result.setDict(add);

        return result;
    }

    public void printDefinition(ArrayList<String> list){
        for (int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }
    }

    //write file
    public void writeFile(dictionary dict) {
        String path = "now_slang.txt";
        HashMap<String, String> result = dict.getDict();
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(path));
            for (String index: result.keySet()) {
                String add = index.concat("`");
                add = add.concat(result.get(index));
                writer.write(add);
                writer.write("\n");
            }
            writer.close();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void saveHistory(dictionary dict) {
        String path = "history.txt";

        LinkedList<String> result = dict.getHistory();

        //open file and handle
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(path));

            for (int i = 0; i < result.size(); i++) {
                String add = result.get(i);
                writer.write(add);
                writer.write("\n");
            }

            writer.close();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public LinkedList<String> loadHistory(String path) {
        LinkedList<String> result = new LinkedList<String>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));

            String line;

            while ((line = reader.readLine()) != null) {
                result.add(line);
            }

            reader.close();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }

        return result;
    }

    public void writeFileHistory(dictionary dict) {
        String path = "history.txt";
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(path));

            LinkedList<String> result = dict.getHistory();

            for (int i = 0; i < result.size(); i++) {
                writer.write(result.get(i));
                writer.write("\n");
            }

            writer.close();
        }
        catch(IOException ex) {
            ex.printStackTrace();
        }
    }

    public void clearFile(String path) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(path));

            writer.write("");

            writer.close();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
