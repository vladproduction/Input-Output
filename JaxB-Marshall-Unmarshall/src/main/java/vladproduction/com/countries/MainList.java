package vladproduction.com.countries;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

public class MainList {
    public static void main(String[] args) {

        Country italy = new Country();
        italy.setName("Italy");
        italy.setCapital("Roma");
        italy.setPopulation(58983122);
        italy.setContinent("Europe");
        italy.setCurrency("€");

        Country usa = new Country();
        usa.setName("USA");
        usa.setCapital("Washington");
        usa.setPopulation(333449281);
        usa.setContinent("North America");
        usa.setCurrency("$");

        Country japan = new Country();
        japan.setName("japan");
        japan.setCapital("Tokyo");
        japan.setPopulation(125309000);
        japan.setContinent("East Asia");
        japan.setCurrency("¥");

        Country ukraine = new Country();
        ukraine.setName("ukraine");
        ukraine.setCapital("Kiev");
        ukraine.setPopulation(40_000_000);
        ukraine.setContinent("East Europe");
        ukraine.setCurrency("UAH");

        List<Country> countries = new ArrayList<>();
        countries.add(italy);
        countries.add(usa);
        countries.add(japan);
        countries.add(ukraine);

        CountryList countryList = new CountryList();
        countryList.setCountries(countries);


        DataProcessClass dataProcessClass = new DataProcessClass();
        dataProcessClass.saveList(countryList);

        CountryList list = dataProcessClass.loadList();
        System.out.println(list);


        convertList(list);

        formPrint(countries);

    }

    // Marshalling --> convert list (countries) to console as xml:
    private static void convertList (CountryList list){
        try {
            JAXBContext context = JAXBContext.newInstance(CountryList.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            StringWriter stringWriter = new StringWriter();
            marshaller.marshal(list,stringWriter);
            String xmlResult = stringWriter.toString();
            System.out.println(xmlResult);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }

    private static void formPrint(List<Country> countries){

        StringBuilder sb = new StringBuilder();
        sb.append("List of countries: \n");
        for (Country country : countries) {
            sb.append(country).append("\n");
        }
        System.out.println(sb);
    }
}
