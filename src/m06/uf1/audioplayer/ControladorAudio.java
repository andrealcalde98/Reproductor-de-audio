package m06.uf1.audioplayer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import javazoom.jlgui.basicplayer.BasicPlayerException;

public class ControladorAudio implements ActionListener {

    private final Vista vista;
    private final ArrayList<Audio> audio;
    private int pos = 0;

    public ControladorAudio() throws ParserConfigurationException, IOException {
        vista = new Vista();
        audio = Obtenercanciones();
        
    }

    public void afegirListenerBotons() {
        vista.getPlay().addActionListener(this);
        vista.getStop().addActionListener(this);
        vista.getPausa().addActionListener(this);
        vista.getContinuar().addActionListener(this);
        
        //vista.getComboBox().addActionListener(this);
    }

    public ArrayList<Audio> Obtenercanciones() {
        try {

            //String a = (String) vista.getComboBox().getSelectedItem();
            //int lista = Integer.parseInt(a);
            //System.out.println(lista);
            //llistaReproduccio llista = LlegeixJSON.LlegeixJSON(lista);
            ArrayList<Cancion> can = LeerXML.LeerCancion();

            ArrayList<Audio> list = new ArrayList<>();
            for (int i = 0; i < can.size(); i++) {

                Audio audio = new Audio(can.get(i).getRutaArxiu());
                list.add(audio);
                System.out.println("Cancion " + can.get(i).getRutaArxiu());
            }

            return audio;
        } catch (IOException | ParserConfigurationException ex) {
            Logger.getLogger(ControladorAudio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

     @Override
    public void actionPerformed(ActionEvent esdeveniment) {
        Object gestorEsdeveniments = esdeveniment.getSource();
        if (gestorEsdeveniments.equals(vista.getPlay())) {
            ArrayList<Cancion> cançons = null;

            try {
                try {
                    cançons = LeerXML.LeerCancion();
                } catch (IOException ex) {
                    Logger.getLogger(ControladorAudio.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ParserConfigurationException ex) {
                    Logger.getLogger(ControladorAudio.class.getName()).log(Level.SEVERE, null, ex);
                }       
                audio.get(pos).getPlayer().play();
            } catch (BasicPlayerException ex) {
                Logger.getLogger(ControladorAudio.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else if (gestorEsdeveniments.equals(vista.getStop())) {
            try {
                audio.get(pos).getPlayer().stop();
            } catch (BasicPlayerException ex) {
                Logger.getLogger(ControladorAudio.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else if (gestorEsdeveniments.equals(vista.getPausa())) {
            try {
                audio.get(pos).getPlayer().pause();
            } catch (BasicPlayerException ex) {
                Logger.getLogger(ControladorAudio.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (gestorEsdeveniments.equals(vista.getContinuar())) {
            try {
                audio.get(pos).getPlayer().resume();
            } catch (BasicPlayerException ex) {
                Logger.getLogger(ControladorAudio.class.getName()).log(Level.SEVERE, null, ex);
            }

        /*} else if (gestorEsdeveniments.equals(vista.getComboBox())) {
            Obtenercanciones();
            Object elements[][] = null;*/

        } /*else if (gestorEsdeveniments.equals(vista.getsiguiente())) {
            try {
                audio.get(pos).getPlayer().stop();
                pos++;
                audio.get(pos).getPlayer().play();

            } catch (BasicPlayerException ex) {
                Logger.getLogger(ControladorAudio.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IndexOutOfBoundsException e) {
                pos = 0;
                try {
                    audio.get(pos).getPlayer().play();
                } catch (BasicPlayerException ex) {
                    Logger.getLogger(ControladorAudio.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else if (gestorEsdeveniments.equals(vista.getAnterior())) {
            try {
                audio.get(pos).getPlayer().stop();
                pos--;
                audio.get(pos).getPlayer().play();
            } catch (BasicPlayerException ex) {
                Logger.getLogger(ControladorAudio.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IndexOutOfBoundsException e) {
                pos = 0;
                try {
                    audio.get(pos).getPlayer().play();
                } catch (BasicPlayerException ex) {
                    Logger.getLogger(ControladorAudio.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }*/
    }
}