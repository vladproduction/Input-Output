package vladproduction.com;

import java.io.Serializable;

public class Car implements Serializable {

    private String model;
    private int price;

    public Car(String model, int price) {
        this.model = model;
        this.price = price;
    }

    public Car() {

    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getPrice() {
        return String.valueOf(price);
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car: ("+model +", "+price + ')';
    }
}
