package m06.uf1.audioplayer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import javazoom.jlgui.basicplayer.BasicPlayerException;

public class Controlador implements ActionListener {

    private Vista vista;
    private ArrayList<Audio> audio;
    private int pos = 0;


    public Controlador() throws ParserConfigurationException, IOException {
        vista = new Vista();
        audio = Obtenercanciones();
        afegirListenerBotons();
    }

    public void afegirListenerBotons() {
        vista.getPlay().addActionListener(this);
        vista.getStop().addActionListener(this);
        vista.getPausa().addActionListener(this);
        vista.getContinuar().addActionListener(this);
        vista.getsiguiente().addActionListener(this);
        vista.getAnterior().addActionListener(this);
        vista.getComboBox().addActionListener(this);
    }

    public ArrayList<Audio> Obtenercanciones() {
        try {

            String a = (String) vista.getComboBox().getSelectedItem();
            int lista = Integer.parseInt(a);
            System.out.println(lista);
            llistaReproduccio llista = LlegeixJSON.LlegeixJSON(lista);
            ArrayList<Cancion> can = LeerXML.LeerCancion();

            ArrayList<Audio> list = new ArrayList<>();
            for (int i = 0; i < can.size(); i++) {
                
                Audio audio = new Audio(can.get(i).getRutaArxiu());
                list.add(audio);
                System.out.println("Cancion " + can.get(i).getRutaArxiu());
            }

            return audio;
        } catch (IOException | ParserConfigurationException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }
    
    //Dotem de funcionalitat als botons
    public void actionPerformed(ActionEvent esdeveniment) {
        //Declarem el gestor d'esdeveniments
        Object gestorEsdeveniments = esdeveniment.getSource();
        ArrayList<Cancion> canciones = null;
        if (gestorEsdeveniments.equals(vista.getPlay())) {
            //Si hem pitjat el boto play
            
                try {
                    canciones = LeerXML.LeerCancion();
                } catch (IOException ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ParserConfigurationException ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (gestorEsdeveniments.equals(vista.getPlay())) { try {
                    //Si hem pitjat el boto play
                    audio.getPlayer().play(); //reproduim l'àudio
                } catch (BasicPlayerException ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }
                    
                } else if (gestorEsdeveniments.equals(vista.getStop())) {
                try {
                    //Si hem pitjat el boto stop
                    audio.getPlayer().stop(); //parem la reproducció de l'àudio
                } catch (BasicPlayerException ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }
                } else if (gestorEsdeveniments.equals(vista.getPausa())) {
                try {
                    //Si hem pitjat el boto stop
                    audio.getPlayer().pause(); //pausem la reproducció de l'àudio
                } catch (BasicPlayerException ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }
                } else if (gestorEsdeveniments.equals(vista.getContinuar())) {
                try {
                    //Si hem pitjat el boto stop
                    audio.getPlayer().resume(); //continuem la reproducció de l'àudio
                } catch (BasicPlayerException ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }
                }else if (gestorEsdeveniments.equals(vista.getComboBox())) {
                    Obtenercanciones();
                    Object data[][] = null;
                } else if (gestorEsdeveniments.equals(vista.getsiguiente())) {
                    try {
                        audio.getPlayer().stop();
                        pos++;
                        audio.getPlayer().play();
                        
                    } catch (IndexOutOfBoundsException e) {
                        pos = 0;
                        try {
                            audio.getPlayer().play();
                        } catch (BasicPlayerException ex) {
                            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } catch (BasicPlayerException ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }
                }
        }
    }
}
