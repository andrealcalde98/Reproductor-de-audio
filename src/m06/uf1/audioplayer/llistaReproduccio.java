/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m06.uf1.audioplayer;

import java.util.ArrayList;
import java.util.Scanner;

public class llistaReproduccio {

    private String nom;
    private ArrayList canciones;

    public llistaReproduccio(String nom, ArrayList<Cancion> canciones) {
        this.nom = nom;
        this.canciones = canciones;
    }
    public llistaReproduccio(){}

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

 

    public ArrayList getCanciones() {
        return canciones;
    }

    public void setCanciones(ArrayList canciones) {
        this.canciones = canciones;
    }

    @Override
    public String toString() {
        return "llistaReproduccio{" + "nom=" + nom + ", canciones=" + canciones + '}';
    }

}
