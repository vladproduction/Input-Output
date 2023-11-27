package vladproduction.com.files_and_IO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

//Search for Tokens, delimited
public class ScannerFile {
//    public static void main(String[] args) throws Exception {
//        Scanner input = null;
//
//        //Token per Token
//        try {
//            input = new Scanner(new BufferedReader(new FileReader(
//                    "src/main/java/vladproduction/com/files_and_IO/inputFigures.txt")));
//
//            while(input.hasNext()){
//                System.out.print(" > " + input.next() + "\n");
//            }
//        } finally {
//            if (input != null){
//                input.close();
//            }
//        }
//    }

    public static void main(String[] args) throws Exception {

        //Token per Token
        try (Scanner input = new Scanner(new BufferedReader(new FileReader(
                "src/main/java/vladproduction/com/files_and_IO/inputFigures.txt")))) {

            while (input.hasNext()) {
                System.out.print(" delimiter--> " + input.next() + "\n");
            }
        }
    }
}