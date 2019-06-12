package m06.uf1.audioplayer;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.TableModel;
import javax.xml.parsers.ParserConfigurationException;

public class Vista {

    private JFrame finestra;
    private JPanel panell;
    private JPanel panelArriba;
    private JPanel panelCentro;
    private JButton play;
    private JButton stop;
    private JButton pausa;
    private JButton continuar;
    private JButton anterior;

    private JButton siguiente;
    private JComboBox seleccionarLista;
    private JTextArea descripcionAlbum;
    private JTable descripcionCancion;
    private JScrollBar slider;

    private JScrollPane pane;
    private int lista;

    public Vista() throws IOException, ParserConfigurationException {

        finestra = new JFrame("Reproductor Àudio");
        finestra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        finestra.setResizable(false);
        finestra.setLocationRelativeTo(null);
        Object data[][] = null;
        panell = new JPanel(new BorderLayout(1, 8));
        panelArriba = new JPanel(new FlowLayout());
        panelCentro = new JPanel(new FlowLayout());


        panell.setLayout(new GridLayout(0, 6));
        panelArriba.setLayout(new GridLayout(0, 3));
        siguiente = new JButton("Siguiente");
        play = new JButton("Play");
        stop = new JButton("Stop");
        pausa = new JButton("Pause");
        continuar = new JButton("Continuar");
        anterior = new JButton("Anterior");
        seleccionarLista = new JComboBox();
        seleccionarLista.addItem("1");
        seleccionarLista.addItem("2");
        ArrayList<Cancion> can = LeerXML.LeerCancion();

        String l = (String) seleccionarLista.getSelectedItem();
        lista = Integer.valueOf(l);

        seleccionarLista.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s = (String) seleccionarLista.getSelectedItem();
                String columnNames[] = new String[]{"Nom", "Autor", "Album", "Durada", "Ruta Archius", "Any"};

                switch (s) {
                    case "1":
                        Object da[][] = obtenerObject(1);
                        for (int i = 0; i < da.length; i++) {
                            for (int j = 0; j < da.length; j++) {
                                System.out.println("data " + da[i][j]);
                            }
                        }
                        JTable table = new JTable(data, columnNames);
                        table.getTableHeader().setReorderingAllowed(false);
                        table.setEnabled(false);
                        table.setCellSelectionEnabled(true);
                        JScrollPane p = new JScrollPane(table);
                        panelCentro.add(p);

                        break;
                    case "2":

                        TableModel tb = new javax.swing.table.DefaultTableModel(
                                new Object[][]{
                                    {null, null, null, null, null, null, null,},
                                    {null, null, null, null, null, null, null,},
                                    {null, null, null, null, null, null, null,},},
                                new String[]{"Nom", "Autor", "Album", "Durada", "Ruta Archius", "Any"}
                        );
                        descripcionCancion.setModel(tb);

                        Object data[][] = obtenerObject(2);
                        for (int i = 0; i < data.length; i++) {
                            for (int j = 0; j < data.length; j++) {
                                System.out.println("data " + data[i][j]);
                            }
                        }
                        JTable tabla2 = new JTable(data, columnNames);

                        tabla2.getTableHeader().setReorderingAllowed(false);
                        tabla2.setEnabled(false);
                        tabla2.setCellSelectionEnabled(true);
                        JScrollPane panel = new JScrollPane(tabla2);
                        panelCentro.add(panel);
                }

            }
        });

        slider = new JScrollPane().getHorizontalScrollBar();
        panell.add(slider);
        panell.add(play);
        panell.add(pausa);
        panell.add(continuar);
        panell.add(stop);
        panell.add(siguiente);
        panell.add(anterior);
        

        //  panelCentro.setBorder(BorderFactory.createMatteBorder(20, 20, 20, 20, Color.WHITE));
        //panelCentro.add(imagen);
        panelCentro.add(pane);
        panelArriba.add(seleccionarLista);
        finestra.add(panell, BorderLayout.SOUTH);
        finestra.add(panelCentro, BorderLayout.CENTER);
        finestra.add(panelArriba, BorderLayout.NORTH);
        finestra.pack();
        finestra.setLocationRelativeTo(null);
        finestra.setVisible(true);
        finestra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public Object[][] obtenerObject(int lista) {
        Object[][] data = null;
        llistaReproduccio llistarepro = null;
        llistarepro = LlegeixJSON.LlegeixJSON(lista);
        ArrayList<Cancion> can = new ArrayList();
        String columnNames[] = new String[]{"Nom", "Autor", "Album", "Durada", "Ruta Arxius", "Any"};
        int a = llistarepro.getCanciones().size();
        try {
            can = null;
            can = LeerXML.LeerCancion();
            data = new String[3][columnNames.length];
            for (int i = 0; i < can.size(); i++) {
                for (int j = 0; j < llistarepro.getCanciones().size(); j++) {
                    if (can.get(i).getRutaArxiu().equalsIgnoreCase((String) llistarepro.getCanciones().get(j))) {

                        data[j][0] = can.get(i).getNom();
                        data[j][1] = can.get(i).getAutor();
                        data[j][2] = can.get(i).getAlbum();
                        data[j][3] = can.get(i).getDurada();
                        data[j][4] = can.get(i).getRutaArxiu();
                        data[j][6] = Integer.toString(can.get(i).getAny());
                    }
                }
            }

        } catch (IOException ex) {
            Logger.getLogger(Vista.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(Vista.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }

    public JTable crearTabla(Object data[][], int lista) throws IOException, ParserConfigurationException {

        llistaReproduccio llistarepro = null;
        llistarepro = LlegeixJSON.LlegeixJSON(lista);
        ArrayList<Cancion> can = new ArrayList();
        String columnNames[] = new String[]{"Nom", "Autor", "Album", "Durada", "Ruta Arxius", "Any"};
        can = null;
        can = LeerXML.LeerCancion();
        data = new String[can.size()][columnNames.length];
        for (int i = 0; i < can.size(); i++) {
            
            data[i][0] = can.get(i).getNom();
            data[i][1] = can.get(i).getAutor();
            data[i][2] = can.get(i).getAlbum();
            data[i][3] = can.get(i).getDurada();
            data[i][4] = can.get(i).getRutaArxiu();
            data[i][6] = Integer.toString(can.get(i).getAny());
            
        }

        JTable tabla = new JTable(data, columnNames);
        tabla.setCellSelectionEnabled(true);
        return tabla;
    }

    public JPanel getPaneCentro() {
        return panelCentro;
    }

   
    public JComboBox getComboBox() {
        return seleccionarLista;
    }

    public JFrame getFinestra() {
        return finestra;
    }

    public JButton getAnterior() {
        return anterior;
    }

    public JScrollBar getSlider() {
        return slider;
    }

    public void setSlider(JScrollBar slider) {
        this.slider = slider;
    }

    public void setAnterior(JButton anterior) {
        this.anterior = anterior;
    }

    public void setFinestra(JFrame finestra) {
        this.finestra = finestra;
    }

    public JPanel getPanell() {
        return panell;
    }

    public void setPanell(JPanel panell) {
        this.panell = panell;
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

    public JButton getsiguiente() {
        return siguiente;
    }

    public void setsiguiente(JButton siguiente) {
        this.siguiente = siguiente;
    }

   
}
