import com.example.generated.ObjectFactory;
import com.example.generated.YourRootElement;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;

public class XmlGenerator {
    public static void main(String[] args) {
        try {
            // Create JAXB context
            JAXBContext context = JAXBContext.newInstance(YourRootElement.class);

            // Create a Marshaller
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            // Create the root element
            ObjectFactory factory = new ObjectFactory();
            YourRootElement root = factory.createYourRootElement();
            root.setSomeField("Example Value");

            // Marshal to an XML file
            marshaller.marshal(root, new File("output.xml"));
            System.out.println("XML file created successfully!");
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}