package m06.uf1.audioplayer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class EscriuXML {

    public void EscribirCancionXML() throws FileNotFoundException, IOException {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.newDocument();
            Element raiz = doc.createElement("listaTotal");
            doc.appendChild(raiz);

            //Cancion1
            Element cancion1 = doc.createElement("cancion");
            // Nom
            Element nom1 = doc.createElement("nom");
            nom1.appendChild(doc.createTextNode("Hells Bells"));
            cancion1.appendChild(nom1);
            // Autor
            Element autor1 = doc.createElement("autor");
            autor1.appendChild(doc.createTextNode("AC/DC"));
            cancion1.appendChild(autor1);
            // Album
            Element album1 = doc.createElement("album");
            album1.appendChild(doc.createTextNode("Back in Black"));
            cancion1.appendChild(album1);
            // Duracio
            Element durada1 = doc.createElement("durada");
            durada1.appendChild(doc.createTextNode("311"));
            cancion1.appendChild(durada1);
            // Ruta Arxiu
            Element ruta1 = doc.createElement("ruta");
            ruta1.appendChild(doc.createTextNode("audios/acdc - hells bells.mp3"));
            cancion1.appendChild(ruta1);
            raiz.appendChild(cancion1);

            //Cancion2
            Element cancion2 = doc.createElement("cancion");
            // Nom
            Element nom2 = doc.createElement("nom");
            nom2.appendChild(doc.createTextNode("Highway to Hell"));
            cancion2.appendChild(nom2);
            // Autor
            Element autor2 = doc.createElement("autor");
            autor2.appendChild(doc.createTextNode("AC/DC"));
            cancion2.appendChild(autor2);
            // Album
            Element album2 = doc.createElement("album");
            album2.appendChild(doc.createTextNode("Highway to Hell"));
            cancion2.appendChild(album2);
            // Duracio
            Element durada2 = doc.createElement("durada");
            durada2.appendChild(doc.createTextNode("227"));
            cancion2.appendChild(durada2);
            // Ruta Arxiu
            Element ruta2 = doc.createElement("ruta");
            ruta2.appendChild(doc.createTextNode("audios/nickelback - how you remind me.mp3"));
            cancion2.appendChild(ruta2);
            raiz.appendChild(cancion2);

            //Cancion3
            Element cancion3 = doc.createElement("cancion");
            // Nom
            Element nom3 = doc.createElement("nom");
            nom3.appendChild(doc.createTextNode("Controlla"));
            cancion3.appendChild(nom3);
            // Autor
            Element autor3 = doc.createElement("autor");
            autor3.appendChild(doc.createTextNode("Drake"));
            cancion3.appendChild(autor3);
            // Album
            Element album3 = doc.createElement("album");
            album3.appendChild(doc.createTextNode("R&B"));
            cancion3.appendChild(album3);
            // Duracio
            Element durada3 = doc.createElement("durada");
            durada3.appendChild(doc.createTextNode("235"));
            cancion3.appendChild(durada3);
            // Ruta Arxiu
            Element ruta3 = doc.createElement("ruta");
            ruta3.appendChild(doc.createTextNode("audios/drake - controlla.mp3"));
            cancion3.appendChild(ruta3);
            raiz.appendChild(cancion3);

            //Cancion4
            Element cancion4 = doc.createElement("cancion");
            // Nom
            Element nom4 = doc.createElement("nom");
            nom4.appendChild(doc.createTextNode("Hotline Bling"));
            cancion4.appendChild(nom4);
            // Autor
            Element autor4 = doc.createElement("autor");
            autor4.appendChild(doc.createTextNode("Drake"));
            cancion4.appendChild(autor4);
            // Album
            Element album4 = doc.createElement("album");
            album4.appendChild(doc.createTextNode("R&B"));
            cancion4.appendChild(album4);
            // Duracio
            Element durada4 = doc.createElement("durada");
            durada4.appendChild(doc.createTextNode("295"));
            cancion4.appendChild(durada4);
            // Ruta Arxiu
            Element ruta4 = doc.createElement("ruta");
            ruta4.appendChild(doc.createTextNode("audios/drake - hotline bling.mp3"));
            cancion4.appendChild(ruta4);
            raiz.appendChild(cancion4);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "3");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("canciones.xml"));
            transformer.transform(source, result);
            
        } catch (ParserConfigurationException ex) {
        } catch (TransformerException ex) {
            System.out.println("Error al crear archivo");
        }

    }
}
