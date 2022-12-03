package domP2GNFT;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class DomWriteP2GNFT {

    public static void main(String[] args) throws ParserConfigurationException, TransformerException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document doc = builder.newDocument();

        Element root = doc.createElementNS("DomP2GNFT", "users");
        doc.appendChild(root);

        root.appendChild(createUser(doc, "01", "Balint", "Takacs", "IT"));
        root.appendChild(createUser(doc, "02", "Peter", "Pelda", "Project manager"));
        root.appendChild(createUser(doc, "01", "Miklos", "Minta", "Engineer"));

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();

        transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");

        DOMSource domSource = new DOMSource(doc);

        File outputFile = new File("users1P2GNFT.xml");

        StreamResult console = new StreamResult(System.out);
        StreamResult file = new StreamResult(outputFile);

        transformer.transform(domSource, console);
        transformer.transform(domSource, file);
    }

    private static Element createUser(Document doc, String id, String firstName, String lastName, String profession) {
        Element user = doc.createElement("user");

        user.setAttribute("id", id);

        user.appendChild(createUserElement(doc, "firstname", firstName));
        user.appendChild(createUserElement(doc, "lastname", lastName));
        user.appendChild(createUserElement(doc, "profession", profession));

        return user;
    }

    private static Node createUserElement(Document doc, String tagName, String content) {
        Node node = doc.createElement(tagName);
        node.setTextContent(content);
        return node;
    }

}
