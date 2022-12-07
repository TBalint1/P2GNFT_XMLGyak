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

public class DOMQueryP2GNFT {

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {

        File xmlFile = new File("XMLP2GNFT.xml");

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = factory.newDocumentBuilder();

        Document doc = dBuilder.parse(xmlFile);

        doc.getDocumentElement().normalize();

        System.out.println("Root element: " + doc.getDocumentElement().getNodeName());

        NodeList nList = doc.getElementsByTagName("jatekos");

        // Csatárok kiíratása

        System.out.println("\n--Csatárok kiíratása--\n");

        for (int i = 0; i < nList.getLength(); i++) {

            Node node = nList.item(i);

            if (node.getNodeType() == Node.ELEMENT_NODE) {

                Element elem = (Element) node;

                Node node3 = elem.getElementsByTagName("poszt").item(0);
                String position = node3.getTextContent();

                if (position.equals("Csatár")) {

                    System.out.println("\nCurrent Element: " + node.getNodeName());

                    String uid = elem.getAttribute("jatekos_ID");

                    Node node1 = elem.getElementsByTagName("vezeteknev").item(0);
                    String lname = node1.getTextContent();

                    Node node2 = elem.getElementsByTagName("keresztnev").item(0);
                    String fname = node2.getTextContent();

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
        }

        // Idegen légiósok kiíratása

        System.out.println("\n--Idegen légiósok kiíratása--\n");

        for (int i = 0; i < nList.getLength(); i++) {

            Node node = nList.item(i);

            if (node.getNodeType() == Node.ELEMENT_NODE) {

                Element elem = (Element) node;

                Node node5 = elem.getElementsByTagName("nemzetiseg").item(0);
                String nation = node5.getTextContent();

                if (!nation.equals("Magyar")) {

                    System.out.println("\nCurrent Element: " + node.getNodeName());

                    String uid = elem.getAttribute("jatekos_ID");

                    Node node1 = elem.getElementsByTagName("vezeteknev").item(0);
                    String lname = node1.getTextContent();

                    Node node2 = elem.getElementsByTagName("keresztnev").item(0);
                    String fname = node2.getTextContent();

                    Node node3 = elem.getElementsByTagName("poszt").item(0);
                    String position = node3.getTextContent();

                    Node node4 = elem.getElementsByTagName("kor").item(0);
                    String age = node4.getTextContent();

                    System.out.printf("Jatekos ID = %s%n", uid);
                    System.out.printf("Vezeteknev = %s%n", fname);
                    System.out.printf("Keresztnev = %s%n", lname);
                    System.out.printf("Poszt = %s%n", position);
                    System.out.printf("Kor = %s%n", age);
                    System.out.printf("Nemzetiseg = %s%n", nation);

                }

            }
        }

        // 30 év alattiak kiíratása

        System.out.println("\n--30 év alattiak kiíratása--\n");

        for (int i = 0; i < nList.getLength(); i++) {

            Node node = nList.item(i);

            if (node.getNodeType() == Node.ELEMENT_NODE) {

                Element elem = (Element) node;

                Node node4 = elem.getElementsByTagName("kor").item(0);
                int age = Integer.parseInt(node4.getTextContent());

                if (age < 30) {

                    System.out.println("\nCurrent Element: " + node.getNodeName());

                    String uid = elem.getAttribute("jatekos_ID");

                    Node node1 = elem.getElementsByTagName("vezeteknev").item(0);
                    String lname = node1.getTextContent();

                    Node node2 = elem.getElementsByTagName("keresztnev").item(0);
                    String fname = node2.getTextContent();

                    Node node3 = elem.getElementsByTagName("poszt").item(0);
                    String position = node3.getTextContent();

                    Node node5 = elem.getElementsByTagName("nemzetiseg").item(0);
                    String nation = node5.getTextContent();

                    System.out.printf("Jatekos ID = %s%n", uid);
                    System.out.printf("Vezeteknev = %s%n", fname);
                    System.out.printf("Keresztnev = %s%n", lname);
                    System.out.printf("Poszt = %s%n", position);
                    System.out.printf("Kor = %d%n", age);
                    System.out.printf("Nemzetiseg = %s%n", nation);

                }

            }
        }

        NodeList nList2 = doc.getElementsByTagName("csapat");

        // 1900 után alapított csapatok kiíratása

        System.out.println("\n--1900 után alapított csapatok kiíratása--\n");

        for (int i = 0; i < nList2.getLength(); i++) {

            Node node = nList2.item(i);

            if (node.getNodeType() == Node.ELEMENT_NODE) {

                Element elem = (Element) node;

                Node node4 = elem.getElementsByTagName("alapitas_eve").item(0);
                int year = Integer.parseInt(node4.getTextContent());

                if (year > 1900) {

                    System.out.println("\nCurrent Element: " + node.getNodeName());

                    String uid = elem.getAttribute("csapat_ID");

                    Node node1 = elem.getElementsByTagName("nev").item(0);
                    String name = node1.getTextContent();

                    Node node2 = elem.getElementsByTagName("szekhely").item(0);
                    String place = node2.getTextContent();

                    Node node3 = elem.getElementsByTagName("szin").item(0);
                    String color = node3.getTextContent();

                    System.out.printf("Csapat ID = %s%n", uid);
                    System.out.printf("Nev = %s%n", name);
                    System.out.printf("Szekhely = %s%n", place);
                    System.out.printf("Alapitas eve = %d%n", year);
                    System.out.printf("Szin = %s%n", color);

                }

            }
        }

        // Budapesti csapatok kiíratása

        System.out.println("\n--Budapesti csapatok--\n");

        for (int i = 0; i < nList2.getLength(); i++) {

            Node node = nList2.item(i);

            if (node.getNodeType() == Node.ELEMENT_NODE) {

                Element elem = (Element) node;

                Node node2 = elem.getElementsByTagName("szekhely").item(0);
                String place = node2.getTextContent();

                if (place.equals("Budapest")) {

                    System.out.println("\nCurrent Element: " + node.getNodeName());

                    String uid = elem.getAttribute("csapat_ID");

                    Node node1 = elem.getElementsByTagName("nev").item(0);
                    String name = node1.getTextContent();

                    Node node3 = elem.getElementsByTagName("alapitas_eve").item(0);
                    int year = Integer.parseInt(node3.getTextContent());

                    Node node4 = elem.getElementsByTagName("szin").item(0);
                    String color = node4.getTextContent();

                    System.out.printf("Csapat ID = %s%n", uid);
                    System.out.printf("Nev = %s%n", name);
                    System.out.printf("Szekhely = %s%n", place);
                    System.out.printf("Alapitas eve = %s%n", year);
                    System.out.printf("Szin = %s%n", color);

                }

            }
        }

    }

}
