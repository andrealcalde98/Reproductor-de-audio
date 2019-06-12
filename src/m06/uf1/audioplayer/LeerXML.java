/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m06.uf1.audioplayer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class LeerXML {

    public static ArrayList<Cancion> LeerCancion() throws FileNotFoundException, IOException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        Document document;
        DocumentBuilder builder = factory.newDocumentBuilder();
        ArrayList<Cancion> canciones = new ArrayList<>();
        try {

            document = builder.parse(new File("cancion.xml"));
            Element arrel = document.getDocumentElement();
            NodeList llistacanciones = arrel.getChildNodes();
            for (int i = 0; i < llistacanciones.getLength(); i++) {
                Node node = llistacanciones.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element cancion = (Element) node;
                    // int id = Integer.parseInt(cancion.getAttribute("id"));
                    Element nom = (Element) cancion.getElementsByTagName("nom").item(0);
                    Element autor = (Element) cancion.getElementsByTagName("autor").item(0);
                    Element album = (Element) cancion.getElementsByTagName("album").item(0);
                    Element durada = (Element) cancion.getElementsByTagName("durada").item(0);
                    Element rutaArxiu = (Element) cancion.getElementsByTagName("rutaArxiu").item(0);

                    /*Cancion song = new Cancion(
                            nom.getChildNodes().item(0).getNodeValue(),
                            autor.getChildNodes().item(0).getNodeValue(),
                            album.getChildNodes().item(0).getNodeValue(),
                            durada.getChildNodes().item(0).getNodeValue(),
                            rutaArxiu.getChildNodes().item(0).getNodeValue());

                    canciones.add(song);*/
                }
            }
        } catch (SAXException ex) {
            ex.printStackTrace();
        }
        return canciones;
    }

}
