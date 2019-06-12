package m06.uf1.audioplayer;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class LlegeixJSON {

    public static llistaReproduccio LlegeixJSON(int option) {
        JSONParser parser = new JSONParser();
        llistaReproduccio llistarepro = null;
        String nom;
        String num;
        ArrayList cançons;

        try {
            JSONObject llista1 = (JSONObject) parser.parse(new FileReader("llista" + option + ".json"));

            nom = (String) llista1.get("nom");
            num = (String) llista1.get("num");
            cançons = (ArrayList) llista1.get("cançons");
            llistarepro = new llistaReproduccio(nom, num, cançons);

        } catch (FileNotFoundException e) {
        } catch (IOException | ParseException e) {
        }
        return llistarepro;
    }

}
