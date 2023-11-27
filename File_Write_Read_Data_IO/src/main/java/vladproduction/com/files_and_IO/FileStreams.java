package vladproduction.com.files_and_IO;

import java.io.FileInputStream;
import java.io.FileOutputStream;

//Just reading bytes
public class FileStreams {
    public static void main(String[] args) throws Exception {
        FileInputStream input = null;
        FileOutputStream output = null;

        //Byte per Byte
        try {
            input = new FileInputStream("src/main/java/vladproduction/com/files_and_IO/inputFigures.txt");
            output = new FileOutputStream("src/main/java/vladproduction/com/files_and_IO/outputFigures.txt");
            
            int character;
            
            while( (character = input.read()) != -1 ){
                System.out.printf("0x%02X",character);
                System.out.print("\n");
                output.write(character);
            }
        } finally {
            if (input != null){
                input.close();
            }
            if (output != null){
                input.close();
            }
        }
    }
}