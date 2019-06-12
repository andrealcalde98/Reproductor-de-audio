package m06.uf1.audioplayer;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.xml.parsers.ParserConfigurationException;

public class Vista extends JFrame {

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
    private JPanel panelScrollBar;
    private JSlider slider;
    public Vista() throws IOException, ParserConfigurationException {

        finestra = new JFrame("Reproductor Àudio");
        finestra.setSize(1200, 800);
        finestra.setResizable(true);
        finestra.setLocationRelativeTo(null);
        finestra.setLayout(new BoxLayout(finestra.getContentPane(), BoxLayout.Y_AXIS));

        //superior
        panellsup = new JPanel();
        //ETIQUETA
        reproduint = new JLabel("cancion en reproduccion");
        //COMBOBOX
        listas = new JComboBox();
        listas.addItem("Lista 1");
        listas.addItem("Lista 2");
        listas.addItem("Totes les cançons");       
        //MODIFICACION TABLA
         
        ArrayList<Cancion> list = LeerCancionXML.LeerCancion();

        Object rowData[] = new Object[5];                         
        Object[][] datos = null;          
        String[] columnNames = {"Titulo","Autor","Album","Durada","Ruta Archius","Any"}; 
        DefaultTableModel dtm= new DefaultTableModel(datos, columnNames); 
        canciones = new JTable(dtm);
        JScrollPane scrollPane = new JScrollPane(canciones);
        canciones.setFillsViewportHeight(true);
        canciones.setPreferredScrollableViewportSize(new Dimension(250, 100));
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
        panellinf.add(play);
        panellinf.add(pausa);
        panellinf.add(continuar);
        panellinf.add(stop);

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

        for(int i = 0; i < list.size(); i++)
        {
            rowData[0] = list.get(i).nom;
            rowData[1] = list.get(i).autor;
            rowData[2] = list.get(i).album;
            rowData[3] = list.get(i).durada;
            rowData[4] = list.get(i).rutaArxiu;
            rowData[5] = list.get(i).any;
            dtm.addRow(rowData);
           
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
}
                
