import java.util.*;

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

    public void duplicateSlang(String slang, String defi) {
        String concat = dict.get(slang);
        concat = concat.concat("|");
        concat =  concat.concat(defi);

        dict.replace(slang, concat);
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

    //random
    public int randomMinMax(int min, int max) {
        Random random = new Random();

        int result = random.nextInt(max + 1 - min) + min ;

        return result;

    }

    public ArrayList<String> getSlang(int pos) {
        ArrayList<String> result = new ArrayList<String>();
        int i = 0;

        for (String index: dict.keySet()) {
            if (i == pos) {
                result.add(index);
                result.add(dict.get(index));
                break;
            }
            i++;

        }

        return result;
    }
    public ArrayList<String> randomSlang() {

        ArrayList<String> result = new ArrayList<String>();
        int posRand = this.randomMinMax(0, dict.size());

        int step = 1;
        for (String index: dict.keySet()){
            if (step == posRand) {
                result.add(index);
                result.add(dict.get(index));
                result.add(Integer.toString(posRand));
                break;
            }
            else {
                step++;
            }
        }

        return result;
    }

    public int checkExist(ArrayList<Integer> number, int num) {
        //1: co ton tai
        //0: khong ton tai

        for (int i = 0; i < number.size(); i++) {
            if (number.get(i) == num) {
                return 1; // co ton tai
            }
        }
        return 0; //khong ton tai
    }

    //random with question:
    public ArrayList<String> randomSlangQuestion() {
        ArrayList<String> result = new ArrayList<String>();
        ArrayList<Integer> store = new ArrayList<Integer>(); // luu cac vi tri da random de lay value lam answer
        ArrayList<Integer> posRand = new ArrayList<Integer>(); //luu cac vi tri da duoc luu trong bien result

        //lay slang va defi goc
        ArrayList<String> root = randomSlang();
        result.add(root.get(0));

        store.add(Integer.parseInt(root.get(2)));

        for (int i = 1; i < 5; i++) {
            result.add("");
        }

        int count = 0;

        while (true) {
            if (count == 3) {
                break;
            }

            int number = randomMinMax(0, dict.size() - 1);

            if (checkExist(store, number) == 0) {
                count++;
                store.add(number);
            }
        }

        count = 1; //da co 1 cai duoc add vao result (answer random)
        int posAnsAdd = store.get(0);
        String ansAdd = getSlang(posAnsAdd).get(1);
        result.set(1, ansAdd);

        int posTrue = randomMinMax(2, 4);
        result.set(posTrue, root.get(1)); // luu tru dap an dung trong vi tri random bat ki

        int pos2;

        while (true) {
            pos2 = randomMinMax(2, 4);

            if (pos2 != posTrue) {
                result.set(pos2, getSlang(store.get(1)).get(1));
                break;
            }
        }

        while (true) {
            int pos = randomMinMax(2, 4);

            if (pos != pos2 && pos != posTrue) {
                result.set(pos, getSlang(store.get(2)).get(1));
                break;
            }
        }

        //true value
        result.add(root.get(1));


        return result;
    }


    public ArrayList<String> randomDefiQuestion() {
        ArrayList<String> result = new ArrayList<String>();
        ArrayList<Integer> store = new ArrayList<Integer>(); // luu cac vi tri da random de lay value lam answer
        ArrayList<Integer> posRand = new ArrayList<Integer>(); //luu cac vi tri da duoc luu trong bien result

        //lay slang va defi goc
        ArrayList<String> root = randomSlang();
        result.add(root.get(1));

        store.add(Integer.parseInt(root.get(2)));

        for (int i = 1; i < 5; i++) {
            result.add("");
        }

        int count = 0;

        while (true) {
            if (count == 3) {
                break;
            }

            int number = randomMinMax(0, dict.size() - 1);

            if (checkExist(store, number) == 0) {
                count++;
                store.add(number);
            }
        }

        count = 1; //da co 1 cai duoc add vao result (answer random)
        int posAnsAdd = store.get(0);
        String ansAdd = getSlang(posAnsAdd).get(0);
        result.set(1, ansAdd);

        int posTrue = randomMinMax(2, 4);
        result.set(posTrue, root.get(0)); // luu tru dap an dung trong vi tri random bat ki



        int pos2;

        while (true) {
            pos2 = randomMinMax(2, 4);

            if (pos2 != posTrue) {
                result.set(pos2, getSlang(store.get(1)).get(0));
                break;
            }
        }

        while (true) {
            int pos = randomMinMax(2, 4);

            if (pos != pos2 && pos != posTrue) {
                result.set(pos, getSlang(store.get(2)).get(0));
                break;
            }
        }

        //true value
        result.add(root.get(0));


        return result;
    }

}
