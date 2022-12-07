package hu.domparse.p2gnft;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DOMModifyP2GNFT {

    public static void main(String[] args) {

        try {

            // Forrás fájl beolvsása

            File inputFile = new File("XMLP2GNFT_Copy.xml");

            DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();

            Document doc = docBuilder.parse(inputFile);

            // Egy csapat és egy játékos adatainak a mentése

            Node csapat1 = doc.getElementsByTagName("csapat").item(0);
            Node jatekos1 = doc.getElementsByTagName("jatekos").item(0);

            // Gyökérelem

            Node bajnoksag = doc.getFirstChild();

            // A DVTK azonosítójának megváltoztatása 01-ről 00-ra

            NamedNodeMap attr = csapat1.getAttributes();
            Node nodeAttr = attr.getNamedItem("csapat_ID");
            nodeAttr.setTextContent("00");

            // A DVTK nevének megváltoztatása "Diósgyőri VTK"-ra

            NodeList csapatnev = csapat1.getChildNodes();

            for (int temp = 0; temp < csapatnev.getLength(); temp++) {
                Node node = csapatnev.item(temp);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element elem = (Element) node;

                    if ("nev".equals(elem.getNodeName())) {

                        elem.setTextContent("Diósgyőri VTK");

                    }
                }
            }

            // Könyves Norbert korának korrigálása 35-ről 33-ra

            NodeList list = jatekos1.getChildNodes();

            for (int temp = 0; temp < list.getLength(); temp++) {
                Node node = list.item(temp);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element elem = (Element) node;

                    if ("kor".equals(elem.getNodeName())) {

                        elem.setTextContent("33");

                    }
                }
            }

            // Könyves Norbert posztjának módosítása középpályásra

            NodeList list2 = jatekos1.getChildNodes();

            for (int temp = 0; temp < list2.getLength(); temp++) {
                Node node = list2.item(temp);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element elem = (Element) node;

                    if ("poszt".equals(elem.getNodeName())) {

                        elem.setTextContent("Középpályás");

                    }
                }
            }

            // Meccsek törlése

            NodeList childNodes = bajnoksag.getChildNodes();

            for (int count = 0; count < childNodes.getLength(); count++) {
                Node node = childNodes.item(count);

                if ("meccs".equals(node.getNodeName())) {
                    bajnoksag.removeChild(node);
                }
            }

            // Kiíratás

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();

            DOMSource source = new DOMSource(doc);

            System.out.println("-------Módosított fájl--------");
            StreamResult consoleResult = new StreamResult(System.out);
            transformer.transform(source, consoleResult);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
