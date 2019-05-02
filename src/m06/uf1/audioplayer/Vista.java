package m06.uf1.audioplayer;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

public class Vista {

    private JFrame finestra;
    private JPanel panellsup;
    private JPanel panellinf;
    private JLabel reproduint;
    private JComboBox listas;
    private JTable canciones;
    private JButton play;
    private JButton stop;
    private JButton pausa;
    private JButton continuar;

    public Vista() {

        finestra = new JFrame("Reproductor Àudio");
        finestra.setSize(1200, 800);
        //finestra.setResizable(false);
        finestra.setLocationRelativeTo(null);
        finestra.setLayout(new BoxLayout(finestra.getContentPane(),BoxLayout.Y_AXIS));
        //superior
        panellsup = new JPanel();
        panellsup.setLayout(new GridLayout(1, 3));
        reproduint = new JLabel("cancion en reproduccion");
        listas = new JComboBox();
        canciones = new JTable();
        panellsup.add(canciones);
        panellsup.add(reproduint);
        panellsup.add(listas);
        //inferior
        panellinf = new JPanel();
        panellinf.setLayout(new GridLayout(1,4));
        play = new JButton("Play");
        stop = new JButton("Stop");
        pausa = new JButton("Pause");
        continuar = new JButton("Continue");
        panellinf.add(play);
        panellinf.add(pausa);
        panellinf.add(continuar);
        panellinf.add(stop);
       
        
                    
        finestra.add(panellsup);
        finestra.add(panellinf);
        finestra.pack();
        finestra.setVisible(true);        
        finestra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }


    public JFrame getFinestra() {
        return finestra;
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
