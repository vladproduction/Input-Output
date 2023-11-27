package vladproduction.com.countries;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class DataProcessClass {
    public File file = new File("src/main/java/vladproduction/com/countries/countries.xml");


    // Marshalling --> save list to xml:
    public void saveList(CountryList list) {
        System.out.println("save process start");
        try {
            JAXBContext context = JAXBContext.newInstance(CountryList.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(list, file);
            System.out.println("save process finish");
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }



    // Unmarshalling --> load list from xml to console :
    public CountryList loadList(){
        System.out.println("load process start");
        try {
            JAXBContext context = JAXBContext.newInstance(CountryList.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            System.out.println("load process finish");
            return (CountryList) unmarshaller.unmarshal(file);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }




}
