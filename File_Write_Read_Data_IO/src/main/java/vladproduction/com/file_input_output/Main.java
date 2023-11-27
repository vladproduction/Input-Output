package vladproduction.com.file_input_output;

public class Main {
    public static void main(String[] args) {
        DataHelper dataHelper = new DataHelper();
        dataHelper.writeData("Hello World!!!"); //with block finally
        dataHelper.write("Hello World HelloWorld"); //autocloseable

        String data = dataHelper.read();
        System.out.println(data);

    }
}
