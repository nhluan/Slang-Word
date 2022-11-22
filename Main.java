import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] arg){
        dictionary dict = new dictionary();

        Handle handle = new Handle();

        dict = handle.readFile("now_slang.txt");

        LinkedList<String> addHistory = handle.loadHistory("history.txt");

        dict.setHistory(addHistory);

//        HashMap<String, String> assignDict = dict.getDict();

        Scanner myInput = new Scanner(System.in);

        int n;

        //menu
        do {
            System.out.println("-----------------MENU-----------------");
            System.out.println("1. Find by slang word");
            System.out.println("2. Find by definition");
            System.out.println("3. History"); //hien thi cac slang word da tim kiem
            System.out.println("4. Add slang word");
            System.out.println("5. Edit slang word");
            System.out.println("6. Delete slang word");
            System.out.println("7. Reset");
            System.out.println("8. Random slang word");
            System.out.println("9. Random question by slang");
            System.out.println("10. Random question by definition");
            System.out.println("11. Print dictionary slang");
            System.out.println("0. Stop");

            System.out.print("Enter your choice: ");
            n = myInput.nextInt();

            //handle if else
            if (n == 1){ // tim kiem definition dua tren slang word
                System.out.print("Enter your slang need find: ");
                myInput.nextLine();
                String slangUser = myInput.nextLine();

                //luu vao lich su tim kiem boi slang word:
                dict.addHistory(slangUser);
                handle.writeFileHistory(dict);

                String result = dict.findBySlang(slangUser);

                if (result.equals("no")){
                    System.out.println("Not find!!!");
                }
                else {
                    System.out.println("Denifition: " + result);
                }
            }
            else if (n == 2){ // tim kiem dua tren definition
                System.out.print("Enter your definition need find: ");
                myInput.nextLine();
                String defiUser = myInput.nextLine();

               ArrayList<String> result = dict.findByDefinition(defiUser);

                if (result.size() == 0) {
                    //khong co tim thay bat cu slang word nao phu hop
                    System.out.println("Not find!!!");
                }
                else {
                    handle.printDefinition(result);
                }
            }
            else if (n == 3) {
                //in ra lich su tim kiem
                dict.printHistory();
            }
            else if (n == 4) {
                //them tu slang moi
                System.out.print("Enter your new slang: ");
                myInput.nextLine();
                String slang = myInput.nextLine();
                System.out.print("Enter your new defition: ");
                String defi = myInput.nextLine();

                //them

                int checkAdd = dict.addSlang(slang, defi);

                if (checkAdd == 1) {
                    System.out.println("Added!!!");
                }
                else {
                    //co trung xuat hien
                    System.out.print("Overwrite or Duplicate? (1/0): ");
                    //1: over
                    //2: dup
                    int choice = myInput.nextInt();
                    if (choice == 1) {
                        dict.editSlang(slang, defi);
                        System.out.println("Overwrited!!!");
                    }
                    else {
                        // duplicate
                        dict.duplicateSlang(slang, defi);
                        System.out.println("Duplicated!!!");
                    }
                }

                //update file "now_slang.txt"
                handle.writeFile(dict);
            }
            else if (n == 5) {
                //edit slang word
                //chon slang word can feed
                System.out.print("Enter your slang need edit: ");
                myInput.nextLine();
                String slang = myInput.nextLine();
                System.out.print("Enter your new definition: ");
                String defi = myInput.nextLine();

                int checkEdit = dict.editSlang(slang, defi);

                if (checkEdit == 1) {
                    System.out.println("Edited!!!");
                }
                else {
                    System.out.println("Fail edit!!!");
                }

                //update file "now_slang.txt"
                handle.writeFile(dict);
            }
            else if (n == 6) {
                //delete
                System.out.print("Enter your slang need delete: ");
                myInput.nextLine();
                String slang = myInput.nextLine();

                System.out.print("Are you sure? (0: no, 1: yes");
                int check = myInput.nextInt();

                if (check == 1){
                    int checkDelete = dict.deleteSlang(slang);

                    if (checkDelete == 1) {
                        // xoa thanh cong
                        System.out.println("Deleted!!!");
                    }
                    else {
                        //xoa that bai
                        System.out.println("Fail delete!!!");
                    }
                }
                else {
                    System.out.println("Canceled!!!");
                }

                //update file "now_slang.txt"
                handle.writeFile(dict);

            }
            else if (n == 7) {
                //reset data
//               dict.setDict(assignDict);

                //doc file data goc
                dictionary reset = new dictionary();

                reset = handle.readFile("slang.txt");

                //update file "now_slang.txt"
                handle.writeFile(reset);

                //clear history full item
                dict.resetHistory();

                //clear content on file:
                handle.clearFile("history.txt");
            }
            else if (n == 8) {
                //random slang
                System.out.println("Random: ");
                ArrayList<String> random = dict.randomSlang();

                System.out.println(random.get(0) + " - " + random.get(1));
            }
            else if (n == 9) {
                //random 4 ans
                ArrayList<String> result = dict.randomSlangQuestion();
                //0: slang
                // 1 2 3 4: answer
                // 5: key value true
                System.out.println("Slang word: " + result.get(0));
                int posTrue = 0;
                for (int i = 1; i < 5; i++) {
                    if (result.get(i).equals(result.get(5))){
                        posTrue = i;
                    }
                    System.out.println(i + ". " + result.get(i));
                }

                System.out.print("Enter your choice: ");
                int choice = myInput.nextInt();

                if (choice == posTrue) {
                    System.out.println("Correct!!!");
                }
                else {
                    System.out.println("Incorrect!!!");
                }


            }

            else if (n == 10) {
                //random 4 ans
                ArrayList<String> result = dict.randomDefiQuestion();
                //0: definition
                // 1 2 3 4: answer
                // 5: key value true
                System.out.println("Definition: " + result.get(0));
                int posTrue = 0;
                for (int i = 1; i < 5; i++) {
                    if (result.get(i).equals(result.get(5))){
                        posTrue = i;
                    }
                    System.out.println(i + ". " + result.get(i));
                }

                System.out.print("Enter your choice: ");
                int choice = myInput.nextInt();

                if (choice == posTrue) {
                    System.out.println("Correct!!!");
                }
                else {
                    System.out.println("Incorrect!!!");
                }
            }

            else if (n == 11) {
                dict.printDict();
            }
        } while (n != 0);

    }
}
