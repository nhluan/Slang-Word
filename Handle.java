import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Handle {
    public dictionary readFile(){
        String path = "slang.txt";
        dictionary result = new dictionary();
        HashMap<String, String> add = new HashMap<String, String>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            String line;

            while ((line = reader.readLine()) != null){
                String[] map = line.split("`");
                //0: key
                //1: value
                add.put(map[0], map[1]);
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

    //input user

}