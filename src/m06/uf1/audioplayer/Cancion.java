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
import javax.swing.table.DefaultTableModel;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author analc
 */
public class Cancion {
    String nom;
    String autor;
    String album;

    public Cancion(String nom, String autor, String album) {
        this.nom = nom;
        this.autor = autor;
        this.album = album;
    }

    @Override
    public String toString() {
        return nom +' '+ autor +' '+ album;
    }
}
