package vladproduction.com.car;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class CarDataBuilder {

    private final File carFile = new File("src/main/java/vladproduction/com/car/carFile.xml");

    public void save(Car car) throws JAXBException {
        try{
            JAXBContext context = JAXBContext.newInstance(Car.class);
            Marshaller m = context.createMarshaller();
            m.marshal(car,carFile);

        }catch (JAXBException e){
            throw new RuntimeException(e);
        }

    }

    public Car load(){
        try{
            JAXBContext context = JAXBContext.newInstance(Car.class);
            Unmarshaller unMarsh = context.createUnmarshaller();
            return (Car)unMarsh.unmarshal(carFile);
        }catch (JAXBException e){
            throw new RuntimeException(e);
        }
    }

}
