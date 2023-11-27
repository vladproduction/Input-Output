package vladproduction.com.countries;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
public class CountryList {

    private List<Country> countries;

    public List<Country> getCountries() {
        return this.countries;
    }
    @XmlElement
    public void setCountries(List<Country> countries) {
        this.countries = countries;
    }

    @Override
    public String toString() {
        return "CountryList{" +
                "countries=" + countries +
                '}';
    }


}
