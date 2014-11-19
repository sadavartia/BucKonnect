import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.*;
import org.xml.sax.SAXException;
import java.io.*;

public class UserValidator
{
    public void validateUser() throws Exception
    {
        Source schemaFile = new StreamSource(new File("user.xsd"));
        Source xmlFile = new StreamSource(new File("user.xml"));

        SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Schema schema = schemaFactory.newSchema(schemaFile);
        Validator validator = schema.newValidator();

        try
        {
            validator.validate(xmlFile);
            System.out.println(xmlFile.getSystemId() + " is valid");
        }
        catch (SAXException e) 
        {
            System.out.println(xmlFile.getSystemId() + " is NOT valid");
            System.out.println("Reason: " + e.getLocalizedMessage());
        }
    }
}

/* Code taken from http://stackoverflow.com/questions/13884084/java-xml-schema-validation */
