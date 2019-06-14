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

    private Vista vista;
    private ArrayList<Audio> audio;
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
        vista.getsiguiente().addActionListener(this);
        vista.getAnterior().addActionListener(this);
        vista.getComboBox().addActionListener(this);
    }

    public ArrayList<Audio> Obtenercanciones() {
        try {

            String a = vista.getComboBox().getSelectedItem().toString();
            ArrayList<Cancion> song = LeerXML.LeerCancion();

            ArrayList<Audio> list = new ArrayList<>();
            if ("1".equals(a)) {
                for (int i = 0; i < song.size(); i++) {

                    Audio audio = new Audio(song.get(i).getRutaArxiu());
                    list.add(audio);
                    System.out.println("Cancion " + song.get(i).getRutaArxiu());
                }
            } else if ("2".equals(a)) {
                for (int i = 2; i < song.size(); i++) {

                    Audio audio = new Audio(song.get(i).getRutaArxiu());
                    list.add(audio);
                    System.out.println("Cancion " + song.get(i).getRutaArxiu());
                }
            }

            return list;
        } catch (IOException | ParserConfigurationException ex) {
            Logger.getLogger(ControladorAudio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    @Override
    public void actionPerformed(ActionEvent esdeveniment) {
        Object gestorAction = esdeveniment.getSource();
        if (gestorAction.equals(vista.getPlay())) {
            ArrayList<Cancion> canciones = null;

            try {
                try {
                    canciones = LeerXML.LeerCancion();
                } catch (IOException ex) {
                    Logger.getLogger(ControladorAudio.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ParserConfigurationException ex) {
                    Logger.getLogger(ControladorAudio.class.getName()).log(Level.SEVERE, null, ex);
                }

                audio.get(pos).getPlayer().play();
            } catch (BasicPlayerException ex) {
                Logger.getLogger(ControladorAudio.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else if (gestorAction.equals(vista.getStop())) {
            try {
                audio.get(pos).getPlayer().stop();
            } catch (BasicPlayerException ex) {
                Logger.getLogger(ControladorAudio.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else if (gestorAction.equals(vista.getPausa())) {
            try {
                audio.get(pos).getPlayer().pause();
            } catch (BasicPlayerException ex) {
                Logger.getLogger(ControladorAudio.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (gestorAction.equals(vista.getContinuar())) {
            try {
                audio.get(pos).getPlayer().resume();
            } catch (BasicPlayerException ex) {
                Logger.getLogger(ControladorAudio.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else if (gestorAction.equals(vista.getsiguiente())) {
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
        } else if (gestorAction.equals(vista.getAnterior())) {
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
        }
    }
}
