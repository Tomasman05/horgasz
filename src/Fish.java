import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

import com.google.gson.Gson;

public class Fish {
    public void readFile(){
        try {
            tryReadFile();
        } catch (FileNotFoundException e) {
            System.err.println("A file nem található:"+ e);
        }
    }

    public void tryReadFile() throws FileNotFoundException{
        FileReader fr = new FileReader("database.json");
        BufferedReader br = new BufferedReader(fr);
        Gson gson = new Gson();
        Places spots = gson.fromJson(br, Places.class);
        System.out.println(spots.helyek);
    }
}
