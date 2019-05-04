/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m06.uf1.audioplayer;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author jmartin
 */
public class LlegeixJSON {
private static final String filePath = "json/lista1.json";
    public static void main(String[] args) {
        try{
            JSONParser parser = new JSONParser();
        Object obj = parser.parse(new FileReader(filePath));
        JSONArray json = (JSONArray) obj;
        for (int i = 0; i<json.size();i++){
            JSONObject object = (JSONObject) json.get(i);
            String nom = object.get("nom").toString();
            String autor = object.get("autor").toString();
            String album = object.get("album").toString();
            String durada = object.get("durada").toString();
            String ruta = object.get("ruta").toString();
            System.out.println(nom);
            System.out.println(autor);
            System.out.println(album);
            System.out.println(durada);
            System.out.println(ruta);
            }
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
        catch(IOException e){
            e.printStackTrace();
        }
        catch(ParseException e){
            e.printStackTrace();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

}
    


