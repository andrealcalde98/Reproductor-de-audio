/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m06.uf1.audioplayer;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author jmartin
 */
public class LlegeixJSON {

    public static void main(String[] args) throws ParseException, FileNotFoundException, IOException {
        JSONParser parser = new JSONParser();
        
            JSONObject cançons = (JSONObject) parser.parse(new FileReader("json/cançons.json"));
            System.out.println(cançons.get("nom"));
            System.out.println(cançons.get("autor"));
            System.out.println(cançons.get("àlbum"));
            System.out.println(cançons.get("durada"));
            System.out.println(cançons.get("ruta"));
    }        
}
    


