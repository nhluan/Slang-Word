import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class dictionary {
    private HashMap<String, String> dict; //luu tru slang va definition
    private LinkedList<String> history = new LinkedList<String>(); //luu tru cac tu da kiem

    public void setDict(HashMap<String, String> dict) {
        this.dict = new HashMap<String, String>(dict);
    }

    //get dictionary:
    public HashMap<String, String> getDict() {
        HashMap<String, String> result = new HashMap<String, String>();

        for (String index: dict.keySet()) {
            result.put(index, dict.get(index));
        }

        return result; 
    }
    //in tu dien
    public void printDict(){
        for(String index: dict.keySet()){
            System.out.println(index + ": " + dict.get(index));
        }
    }

    //in lich su
    public void printHistory(){
        for (int i = 0; i < history.size(); i++){
            System.out.println(history.get(i));
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

        for (String index: dict.keySet()) {
            String defi = dict.get(index);

            if (defi.contains(de)) {
                result.add(index);
            }
        }

        return result;
    }

    //luu lich su tim kiem boi tu slang
    public void addHistory(String slangFind) {
        history.add(slangFind);
    }

    //check trung => dua tren slang word
    public int checkSlang(String slangInput) {
        // 1: true => co ton tai
        // 0: false => khong ton tai
        for (String index: dict.keySet()){
            if (index.equals(slangInput)) {
                return 1;
            }
        }
        return 0;
    }

    public int addSlang(String slang, String defi) {
        if (this.checkSlang(slang) == 0) {
            dict.put(slang, defi);
            return 1; // da them thanh cong
        }
        return 0; //them that bai

    }

    //edit slang:
    public int editSlang(String slang, String defi) {
        if (this.checkSlang(slang) == 1) {
            // co ton tai
            dict.replace(slang, defi);
            return 1; // edit thanh cong
        }
        return 0; //edit that bai do khong tim thay slang can edit
    }

    //delete
    public int deleteSlang(String slang) {
        if (this.checkSlang(slang) == 1) {
            //co ton tai de xoa
            dict.remove(slang);
            return 1; //da xoa thanh cong
        }
        return 0; //xoa that bai do khong ton tai
    }
}
