package vladproduction.com.SAX.cars2;

public class Auto {
    private String name;
    private String model;
    private String equipment;
    private String color;
    private String price;
    private String priceUAH;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getEquipment() {
        return equipment;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPriceUAH() {
        return priceUAH;
    }

    public void setPriceUAH(String priceUAH) {
        this.priceUAH = priceUAH;
    }

    @Override
    public String toString() {
        return "Auto{" +
                "name='" + name + '\'' +
                ", model='" + model + '\'' +
                ", equipment='" + equipment + '\'' +
                ", color='" + color + '\'' +
                ", price=" + price +
                ", priceUAH=" + priceUAH +
                '}';
    }
}

