package vladproduction.com.countries;


import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


public class Country {

    private String name;
    private String capital;
    private int  population;
    private String continent;
    private String currency;


    public String getName() {
        return name;
    }
    @XmlAttribute
    public void setName(String name) {
        this.name = name;
    }

    public String getCapital() {
        return capital;
    }
    @XmlElement
    public void setCapital(String capital) {
        this.capital = capital;
    }
    @XmlElement
    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public String getContinent() {
        return continent;
    }
    @XmlElement
    public void setContinent(String continent) {
        this.continent = continent;
    }

    public String getCurrency() {
        return currency;
    }
    @XmlAttribute
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "Country{" +
                "name='" + name + '\'' +
                ", capital='" + capital + '\'' +
                ", population=" + population +
                ", continent='" + continent + '\'' +
                ", currency='" + currency + '\'' +
                '}';
    }
}
