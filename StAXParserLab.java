import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamConstants;
import java.io.FileInputStream;

public class StAXParserLab {
    public static void main(String[] args) throws Exception {
        // Sample XML content (usually read from a file)
        // <students><student id="1"><name>Alice</name></student></students>
        
        XMLInputFactory factory = XMLInputFactory.newInstance();
        XMLStreamReader reader = factory.createXMLStreamReader(new FileInputStream("students.xml"));

        String currentTag = "";
        
        while (reader.hasNext()) {
            int event = reader.next();

            switch (event) {
                case XMLStreamConstants.START_ELEMENT:
                    currentTag = reader.getLocalName();
                    if ("student".equals(currentTag)) {
                        System.out.print("Student ID: " + reader.getAttributeValue(null, "id") + ", ");
                    }
                    break;
                    
                case XMLStreamConstants.CHARACTERS:
                    String content = reader.getText().trim();
                    if (!content.isEmpty() && "name".equals(currentTag)) {
                        System.out.println("Name: " + content);
                    }
                    break;
                    
                case XMLStreamConstants.END_ELEMENT:
                    currentTag = "";
                    break;
            }
        }
        reader.close();
    }
}
