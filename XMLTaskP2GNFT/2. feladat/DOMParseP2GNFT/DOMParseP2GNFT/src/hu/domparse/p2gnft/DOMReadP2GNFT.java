package hu.domparse.p2gnft;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import org.xml.sax.SAXException;

public class DOMReadP2GNFT {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {

        File xmlFile = new File("XMLP2GNFT.xml");

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = factory.newDocumentBuilder();

        Document doc = dBuilder.parse(xmlFile);

        doc.getDocumentElement().normalize();

        System.out.println("Root element: " + doc.getDocumentElement().getNodeName());

        NodeList nList1 = doc.getElementsByTagName("csapat");

        // Csapatok

        System.out.println("\n--Csapatok--\n");

        for (int i = 0; i < nList1.getLength(); i++) {

            Node node = nList1.item(i);

            System.out.println("\nCurrent Element: " + node.getNodeName());

            if (node.getNodeType() == Node.ELEMENT_NODE) {

                Element elem = (Element) node;

                String uid = elem.getAttribute("csapat_ID");

                Node node1 = elem.getElementsByTagName("nev").item(0);
                String name = node1.getTextContent();

                Node node2 = elem.getElementsByTagName("szekhely").item(0);
                String place = node2.getTextContent();

                Node node3 = elem.getElementsByTagName("alapitas_eve").item(0);
                String found = node3.getTextContent();

                Node node4 = elem.getElementsByTagName("szin").item(0);
                String color = node4.getTextContent();

                System.out.printf("Csapat ID = %s%n", uid);
                System.out.printf("Nev = %s%n", name);
                System.out.printf("Szekhely = %s%n", place);
                System.out.printf("Alapitas eve = %s%n", found);
                System.out.printf("Szin = %s%n", color);

            }
        }

        NodeList nList2 = doc.getElementsByTagName("jatekos");

        // Játékosok

        System.out.println("\n--Jatekosok--\n");

        for (int i = 0; i < nList2.getLength(); i++) {

            Node node = nList2.item(i);

            System.out.println("\nCurrent Element: " + node.getNodeName());

            if (node.getNodeType() == Node.ELEMENT_NODE) {

                Element elem = (Element) node;

                String uid = elem.getAttribute("jatekos_ID");

                Node node1 = elem.getElementsByTagName("vezeteknev").item(0);
                String lname = node1.getTextContent();

                Node node2 = elem.getElementsByTagName("keresztnev").item(0);
                String fname = node2.getTextContent();

                Node node3 = elem.getElementsByTagName("poszt").item(0);
                String position = node3.getTextContent();

                Node node4 = elem.getElementsByTagName("kor").item(0);
                String age = node4.getTextContent();

                Node node5 = elem.getElementsByTagName("nemzetiseg").item(0);
                String nation = node5.getTextContent();

                System.out.printf("Jatekos ID = %s%n", uid);
                System.out.printf("Vezeteknev = %s%n", fname);
                System.out.printf("Keresztnev = %s%n", lname);
                System.out.printf("Poszt = %s%n", position);
                System.out.printf("Kor = %s%n", age);
                System.out.printf("Nemzetiseg = %s%n", nation);

            }
        }

        NodeList nList3 = doc.getElementsByTagName("edzo");

        // Edzők

        System.out.println("\n--Edzok--\n");

        for (int i = 0; i < nList3.getLength(); i++) {

            Node node = nList3.item(i);

            System.out.println("\nCurrent Element: " + node.getNodeName());

            if (node.getNodeType() == Node.ELEMENT_NODE) {

                Element elem = (Element) node;

                String uid = elem.getAttribute("edzo_ID");

                Node node1 = elem.getElementsByTagName("vezeteknev").item(0);
                String lname = node1.getTextContent();

                Node node2 = elem.getElementsByTagName("keresztnev").item(0);
                String fname = node2.getTextContent();

                Node node3 = elem.getElementsByTagName("kor").item(0);
                String age = node3.getTextContent();

                Node node4 = elem.getElementsByTagName("nemzetiseg").item(0);
                String nation = node4.getTextContent();

                System.out.printf("Edzo ID = %s%n", uid);
                System.out.printf("Vezeteknev = %s%n", fname);
                System.out.printf("Keresztnev = %s%n", lname);
                System.out.printf("Kor = %s%n", age);
                System.out.printf("Nemzetiseg = %s%n", nation);

            }
        }

        NodeList nList4 = doc.getElementsByTagName("biro");

        // Bírók

        System.out.println("\n--Birok--\n");

        for (int i = 0; i < nList4.getLength(); i++) {

            Node node = nList4.item(i);

            System.out.println("\nCurrent Element: " + node.getNodeName());

            if (node.getNodeType() == Node.ELEMENT_NODE) {

                Element elem = (Element) node;

                String uid = elem.getAttribute("biro_ID");

                Node node1 = elem.getElementsByTagName("vezeteknev").item(0);
                String lname = node1.getTextContent();

                Node node2 = elem.getElementsByTagName("keresztnev").item(0);
                String fname = node2.getTextContent();

                Node node3 = elem.getElementsByTagName("beosztas").item(0);
                String role = node3.getTextContent();

                Node node4 = elem.getElementsByTagName("kor").item(0);
                String age = node4.getTextContent();

                Node node5 = elem.getElementsByTagName("nemzetiseg").item(0);
                String nation = node5.getTextContent();

                System.out.printf("Biro ID = %s%n", uid);
                System.out.printf("Vezeteknev = %s%n", fname);
                System.out.printf("Keresztnev = %s%n", lname);
                System.out.printf("Beosztas = %s%n", role);
                System.out.printf("Kor = %s%n", age);
                System.out.printf("Nemzetiseg = %s%n", nation);

            }
        }

        NodeList nList5 = doc.getElementsByTagName("meccs");

        // Meccsek

        System.out.println("\n--Meccsek--\n");

        for (int i = 0; i < nList5.getLength(); i++) {

            Node node = nList5.item(i);

            System.out.println("\nCurrent Element: " + node.getNodeName());

            if (node.getNodeType() == Node.ELEMENT_NODE) {

                Element elem = (Element) node;

                String uid = elem.getAttribute("meccs_ID");

                Node node1 = elem.getElementsByTagName("idopont").item(0);
                String date = node1.getTextContent();

                Node node2 = elem.getElementsByTagName("helyszin").item(0);
                String place = node2.getTextContent();

                System.out.printf("Meccs ID = %s%n", uid);
                System.out.printf("Idopont = %s%n", date);
                System.out.printf("Helyszin = %s%n", place);

            }
        }
    }

}