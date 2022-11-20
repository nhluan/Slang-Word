import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class dictionary {
    private HashMap<String, String> dict; //luu tru slang va definition
    private LinkedList<String> history; //luu tru cac tu da kiem

    public void setDict(HashMap<String, String> dict) {
        this.dict = new HashMap<String, String>(dict);
    }

    //in tu dien
    public void printDict(){
        for(String index: dict.keySet()){
            System.out.println(index + ": " + dict.get(index));
        }
    }

    //tim kiem definition dua tren slang word tu nguoi dung
    public String findBySlang(String keyFind){
        //tra ve "no" neu khong co tim thay
        //tra ve value neu tim thay
        String result = "no";
        for (String index: dict.keySet()){
            //index = key
            if (index.equalsIgnoreCase(keyFind)){
                result = dict.get(index);
            }
        }

        return result;
    }

    //tim kiem slang word
    public ArrayList<String> findByDefinition(String de){
        ArrayList<String> result = new ArrayList<String>();
        
    }
}
