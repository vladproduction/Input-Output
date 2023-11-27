package vladproduction.com.car;

import javax.xml.bind.JAXBException;

public class MainCar {
    public static void main(String[] args) throws JAXBException {
        CarDataBuilder cdb = new CarDataBuilder();
        cdb.save(new Car("bmw", 2024));
        Car carFromFile = cdb.load();
        System.out.println(carFromFile);

    }
}
