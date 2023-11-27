package vladproduction.com.phone_book;

public class Phone {

    public String model;
    public int price;

    @Override
    public String toString() {
        return "Phone{" +
                "model='" + model + '\'' +
                ", price=" + price +
                '}';
    }
}
