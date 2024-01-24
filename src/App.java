public class App {
    public static void main(String[] args) throws Exception {
        Fish fs = new Fish();
        fs.readFile();
        System.out.println("\nFeladat 1:");
        fs.feladat01();
        System.out.println("\nFeladat 2:");
        fs.feladat02();
    }
}
