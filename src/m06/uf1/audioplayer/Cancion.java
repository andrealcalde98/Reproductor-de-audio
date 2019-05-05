/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m06.uf1.audioplayer;

/**
 *
 * @author analc
 */
public class Cancion {
    private String nom;
    private String autor;
    private String album;

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
