/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m06.uf1.audioplayer;

import m06.uf1.audioplayer.Cancion;
import java.awt.List;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class llistaReproduccioJSON {

    //private ArrayList<llistaReproduccio> llista;
    private String nomllista;
    //private String rutaImatge;
    private ArrayList<Cancion> canciones;
    private String nomArxiu;

    public llistaReproduccioJSON(String nomArxiu) {
        this.nomArxiu = nomArxiu;
        canciones = new ArrayList();
        JSONParser parser = new JSONParser();
        try {
            JSONObject llistaReproduccio = (JSONObject) parser.parse(new FileReader(nomArxiu));
            nomllista = (String) llistaReproduccio.get("nom Llista");
            JSONArray jcanciones = (JSONArray) llistaReproduccio.get("canciones");
            for (Object obj : jcanciones) {
                JSONObject jcancion = (JSONObject) obj;
                Cancion cancion = new Cancion();
                cancion.setAlbum((String) jcancion.get("album"));
                cancion.setNom((String) jcancion.get("nom"));
                cancion.setAutor((String) jcancion.get("autor"));
                cancion.setAny((Integer) jcancion.get("any"));
                cancion.setDurada((int) jcancion.get("durada"));
                canciones.add(cancion);
            }
        } catch (FileNotFoundException e) {
            System.out.println("No s'ha trobat l'arxiu " + nomArxiu);
        } catch (IOException e) {
            System.out.println("Error de lectura de l'arxiu");;
        } catch (ParseException e) {
            System.out.println("Error en interpretar l'arxiu JSON");
        }
    }

    public String getNomllista() {
        return nomllista;
    }

    public void setNomllista(String nomllista) {
        this.nomllista = nomllista;
    }

    

    public ArrayList<Cancion> getCanciones() {
        return canciones;
    }

    public void setCanciones(ArrayList<Cancion> canciones) {
        this.canciones = canciones;
    }

    public String llistarCancons() {
        String retorn = "LLISTAT DE CANÇONS: \nHi ha un total de " + canciones.size() + " cançons.\n";
        for (Cancion cancion : canciones) {
            retorn += cancion.toString() + "\n";
        }
        return retorn;
    }

}