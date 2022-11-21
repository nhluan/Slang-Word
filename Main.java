import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] arg){
        dictionary dict = new dictionary();

        Handle handle = new Handle();

        dict = handle.readFile();

        HashMap<String, String> assignDict = dict.getDict();

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
                    System.out.println("Fail add!!!");
                }
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

            }
            else if (n == 7) {
                //reset data
                dict.setDict(assignDict);
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
                System.out.print("Slang word: " + result.get(0));


            }
        } while (n != 0);

    }
}
