import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.Gson;

public class Fish {
    ArrayList<Place> fishermans = new ArrayList<>();

    public void readFile() {
        try {
            tryReadFile();
        } catch (FileNotFoundException e) {
            System.err.println("A file nem található:" + e);
        }
    }

    public void tryReadFile() throws FileNotFoundException {
        FileReader fr = new FileReader("database.json");
        BufferedReader br = new BufferedReader(fr);
        Gson gson = new Gson();
        Places spots = gson.fromJson(br, Places.class);
        for (Place place : spots.fishingspots) {
            fishermans.add(place);
        }
        for (Place place : fishermans) {
            System.out.println(place.name);
        }

    }

    public void feladat01() {
        for (Place place : fishermans) {
            System.out.println(place.name);
        }
    }

    public void feladat02() {
        ArrayList<Place> moreList = new ArrayList<>();
        for (Place place : fishermans) {
            if (place.rods > 3) {
                moreList.add(place);
            }
        }
        writeMore(moreList);
    }

    
    public void writeMore(ArrayList<Place> moreList){
        try {
            tryWriteMore(moreList);
        } catch (IOException e) {
            System.err.println("Hiba, a kiírás sikertelen: "+ e);
        }
    }

    public void tryWriteMore(ArrayList<Place> moreList) throws IOException{
        FileWriter fw = new FileWriter("sok.csv");
        for(Place place : moreList){
            fw.write(place.id+",");
            fw.write(place.name+",");
            fw.write(place.spot+",");
            fw.write(place.date+",");
            fw.write(place.rods+",");
            fw.write(place.paid+"\n");
        }
        fw.close();
    }
}
