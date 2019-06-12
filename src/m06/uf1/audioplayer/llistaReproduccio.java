package m06.uf1.audioplayer;

import java.util.ArrayList;

public class llistaReproduccio {
    private String nom;
    private String num;
    private ArrayList canciones;

    public llistaReproduccio(String nom, String num, ArrayList<Cancion> canciones) {
        this.nom = nom;
        this.canciones = canciones;
        this.num = num;
    }

    public llistaReproduccio() {
    }

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

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "llistaReproduccio{" + "nom=" + nom + ", canciones=" + canciones + '}';
    }
}
