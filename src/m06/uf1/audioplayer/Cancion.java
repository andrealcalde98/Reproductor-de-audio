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
    int durada;
    String rutaArxiu;
    String rutaImatge;
    int any;

    public Cancion(String nom, String autor, String album, int durada, String rutaArxiu, int any) {
        this.nom = nom;
        this.autor = autor;
        this.album = album;
        this.durada = durada;
        this.rutaArxiu = rutaArxiu;
        this.any = any;
    }

    public Cancion() {
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public int getDurada() {
        return durada;
    }

    public void setDurada(int durada) {
        this.durada = durada;
    }

    public String getRutaArxiu() {
        return rutaArxiu;
    }

    public void setRutaArxiu(String rutaArxiu) {
        this.rutaArxiu = rutaArxiu;
    }

    public int getAny() {
        return any;
    }

    public void setAny(int any) {
        this.any = any;
    }
    
    @Override
    public String toString() {
        return "Cancion{" + "nom=" + nom + ", autor=" + autor + ", album=" + album + ", durada=" + durada + ", rutaArxiu=" + rutaArxiu + ", any=" + any + '}';
    }
}
