package m06.uf1.audioplayer;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.xml.parsers.ParserConfigurationException;

public class Vista extends JFrame {

    Object data[][] = null;
    private JFrame finestra;
    private JPanel panellsup;
    private final JPanel panellinf;
    private final JLabel reproduint;
    private final JComboBox listas;
    private JTable canciones;
    private JButton play;
    private JButton stop;
    private JButton pausa;
    private JButton continuar;
    private JButton anterior;
    private JButton siguiente;
    private JPanel panelScrollBar;
    private JSlider slider;


    public Vista() throws ParserConfigurationException, IOException {

        finestra = new JFrame("Reproductor Àudio");
        finestra.setSize(1200, 800);
        finestra.setResizable(true);
        finestra.setLocationRelativeTo(null);
        finestra.setLayout(new BoxLayout(finestra.getContentPane(), BoxLayout.Y_AXIS));

        //superior
        panellsup = new JPanel();
        //ETIQUETA
        //ControladorAudio co = new ControladorAudio();
        reproduint = new JLabel();
        reproduint.setText("Llista reproduint: ROCK" );
        //COMBOBOX
        //MODIFICACION TABLA
        listas = new JComboBox();
        listas.addItem("1");
        listas.addItem("2");
        canciones = setTabla2(data, 1);
        JScrollPane scrollPane = new JScrollPane(canciones);
        canciones.setFillsViewportHeight(true);
        canciones.setPreferredScrollableViewportSize(new Dimension(250, 100));
        canciones.setCellSelectionEnabled(true);
        
        listas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s = listas.getSelectedItem().toString();
                if ("1".equals(s)) {
                        reproduint.setText("Llista reproduint: ROCK");
                        canciones.removeAll();
                        canciones = setTabla1(data, 1);
                } else if ("2".equals(s)){        
                        reproduint.setText("Llista reproduint: RB");
                        canciones.removeAll();
                        canciones = setTabla2(data, 1);
                }

            }
        });
        

        
        panellsup.add(scrollPane);
        panellsup.add(reproduint);
        panellsup.add(listas);

        //inferior
        panellinf = new JPanel();
        panellinf.setLayout(new GridLayout(1, 4));
        play = new JButton("Play");
        stop = new JButton("Stop");
        pausa = new JButton("Pause");
        continuar = new JButton("Continue");
        siguiente = new JButton("Siguiente");
        anterior = new JButton("Anterior");
        panellinf.add(play);
        panellinf.add(pausa);
        panellinf.add(continuar);
        panellinf.add(stop);
        panellinf.add(siguiente);
        panellinf.add(anterior);

        //scroll
        panelScrollBar = new JPanel();
        slider = new JSlider();
        slider.setOrientation(0);
        slider.setValue(0);
        panelScrollBar.add(slider);

        finestra.add(panellsup);
        finestra.add(panellinf);
        finestra.add(panelScrollBar);
        finestra.pack();
        finestra.setVisible(true);
        finestra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    
    public JTable setTabla1(Object data[][], int lista) {

        ArrayList<Cancion> song = new ArrayList();
        String columnNames[] = new String[]{"Nom", "Autor", "Album", "Durada", "Ruta Arxius"};
        try {
            song = null;
            song = LeerXML.LeerCancion();
            data = new String[song.size()][columnNames.length];
            for (int i = 0; i < song.size()/2; i++) {

                data[i][0] = song.get(i).getNom();
                data[i][1] = song.get(i).getAutor();
                data[i][2] = song.get(i).getAlbum();
                data[i][3] = song.get(i).getDurada();
                data[i][4] = song.get(i).getRutaArxiu();
            }

        } catch (IOException ex) {
            Logger.getLogger(Vista.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(Vista.class.getName()).log(Level.SEVERE, null, ex);
        }

        JTable tabla = new JTable(data, columnNames);
        tabla.setCellSelectionEnabled(true);
        return tabla;
    }
    
    public JTable setTabla2(Object data[][], int lista) {

        ArrayList<Cancion> song = new ArrayList();
        String columnNames[] = new String[]{"Nom", "Autor", "Album", "Durada", "Ruta Arxius"};
        try {
            song = null;
            song = LeerXML.LeerCancion();
            data = new String[song.size()][columnNames.length];
            for (int i = 2; i < song.size(); i++) {

                data[i][0] = song.get(i).getNom();
                data[i][1] = song.get(i).getAutor();
                data[i][2] = song.get(i).getAlbum();
                data[i][3] = song.get(i).getDurada();
                data[i][4] = song.get(i).getRutaArxiu();
            }

        } catch (IOException ex) {
            Logger.getLogger(Vista.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(Vista.class.getName()).log(Level.SEVERE, null, ex);
        }

        JTable tabla = new JTable(data, columnNames);
        tabla.setCellSelectionEnabled(true);
        return tabla;
    }

    public JFrame getFinestra() {
        return finestra;
    }

    public JPanel getPanellsup() {
        return panellsup;
    }

    public void setPanellsup(JPanel panellsup) {
        this.panellsup = panellsup;
    }

    public JPanel getPanelScrollBar() {
        return panelScrollBar;
    }

    public void setPanelScrollBar(JPanel panelScrollBar) {
        this.panelScrollBar = panelScrollBar;
    }

    public JSlider getSlider() {
        return slider;
    }

    public void setSlider(JSlider slider) {
        this.slider = slider;
    }

    public void setFinestra(JFrame finestra) {
        this.finestra = finestra;
    }

    public JPanel getPanell() {
        return panellsup;
    }

    public void setPanell(JPanel panell) {
        this.panellsup = panell;
    }

    public JButton getPlay() {
        return play;
    }

    public void setPlay(JButton play) {
        this.play = play;
    }

    public JButton getStop() {
        return stop;
    }

    public void setStop(JButton stop) {
        this.stop = stop;
    }

    public JButton getPausa() {
        return pausa;
    }

    public void setPausa(JButton pausa) {
        this.pausa = pausa;
    }

    public JButton getContinuar() {
        return continuar;
    }

    public void setContinuar(JButton continuar) {
        this.continuar = continuar;
    }

    public JComboBox getComboBox() {
        return listas;
    }
     public JButton getAnterior() {
        return anterior;
    }
     public void setAnterior(JButton anterior) {
        this.anterior = anterior;
    }
     public JButton getsiguiente() {
        return siguiente;
    }

    public void setsiguiente(JButton siguiente) {
        this.siguiente = siguiente;
    }
}
