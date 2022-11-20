import java.io.*;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class File {
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
}
