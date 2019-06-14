package m06.uf1.audioplayer;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.parsers.ParserConfigurationException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class GeneraJSON {

    public void escriu() throws FileNotFoundException, IOException, ParserConfigurationException {
        
        ArrayList<Cancion> canciones = LeerXML.LeerCancion();
        
        JSONObject reproduccion1 = new JSONObject();
        JSONArray cançons2 = new JSONArray();
        reproduccion1.put("nom", "Rock");
        reproduccion1.put("num", "1 ");

        for (int i = 0; i < canciones.size() / 2; i++) {
            cançons2.add(canciones.get(i).getRutaArxiu());
        }
        reproduccion1.put("cançons", cançons2);
        try {
            FileWriter fitxer = new FileWriter("JSON/llista1.json");
            fitxer.write(reproduccion1.toString());
            fitxer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        JSONObject reporduccion2 = new JSONObject();
        JSONArray llistatarxius2 = new JSONArray();

        reporduccion2.put("nom", "R&B");
        reporduccion2.put("num", "2");
        for (int i = canciones.size() / 2; i < canciones.size(); i++) {
            llistatarxius2.add(canciones.get(i).getRutaArxiu());
        }
        reporduccion2.put("cançons", llistatarxius2);

        try {
            FileWriter fitxer = new FileWriter("JSON/llista2.json");
            fitxer.write(reporduccion2.toString());
            fitxer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
