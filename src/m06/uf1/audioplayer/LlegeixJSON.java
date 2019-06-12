/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m06.uf1.audioplayer;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class LlegeixJSON {
    public static llistaReproduccio LlegeixJSON(int opt) {
        JSONParser parser = new JSONParser();
        llistaReproduccio llistareproduccio = null;
        String nom;
        ArrayList can;

        try {
//            ArrayList<Cancion> canciones = new ArrayList();
            JSONObject llista1 = (JSONObject) parser.parse(new FileReader("llista" + opt + ".json"));
            //System.out.println(llista1.get("nom"));

            nom = (String) llista1.get("nom");

            can = (ArrayList) llista1.get("llistatJSON");

            llistareproduccio = new llistaReproduccio(nom, can);

        } catch (FileNotFoundException e) {
        } catch (IOException | ParseException e) {
        }
        return llistareproduccio;
    }
}