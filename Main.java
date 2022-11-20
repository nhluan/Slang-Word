public class Main {
    public static void main(String[] arg){
        dictionary demo = new dictionary();

        File test = new File();

        demo = test.readFile();

        demo.printDict();
    }
}
