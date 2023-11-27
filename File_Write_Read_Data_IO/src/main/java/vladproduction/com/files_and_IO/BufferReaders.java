package vladproduction.com.files_and_IO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

//Just reading bytes
public class BufferReaders {
    public static void main(String[] args) throws Exception {
        BufferedReader input = null;
        BufferedWriter output = null;

        //Byte per Byte
        try {
            input = new BufferedReader(new FileReader("src/main/java/vladproduction/com/files_and_IO/inputFigures.txt"));
            output = new BufferedWriter(new FileWriter("src/main/java/vladproduction/com/files_and_IO/outputFigures.txt"));

            int character;

            while ((character = input.read()) != -1) {
                System.out.printf("0x%02X", character);
                System.out.print("\n");
                output.write(character);
            }
        } finally {
            if (input != null) {
                input.close();
            }
            if (output != null) {
                input.close();
            }
        }
    }
}