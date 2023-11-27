package vladproduction.com.files_and_IO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

//Save Object in a file
public class SerializeObject {

    public static void main(String[] args) throws Exception {

        //Serializable
        UserProfile userProfileLocal = new UserProfile(
                "User1", "user1@gmail.com", "Red/White", "Some special data"
        );
        try (ObjectOutputStream output = new ObjectOutputStream(
                new FileOutputStream("src/main/java/vladproduction/com/files_and_IO/userProfile.txt"))) {
            output.writeObject(userProfileLocal);
        }

        //Deserialize
        UserProfile userProfileRestored;
        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(
                "src/main/java/vladproduction/com/files_and_IO/userProfile.txt"))) {
            userProfileRestored = (UserProfile) input.readObject();

            System.out.println(userProfileRestored);
        }
    }

//    public static void main(String[] args) throws Exception {
//
//        ObjectOutputStream output = null;
//
//        UserProfile userProfileLocal = new UserProfile(
//            "User1", "user1@gmail.com", "Red/White", "Some special data"
//        );
//
//        //Serializable
//        try {
//            output = new ObjectOutputStream( new FileOutputStream( "src/main/java/vladproduction/com/files_and_IO/userProfile.txt" ) );
//            output.writeObject(userProfileLocal);
//        } finally {
//            if (output != null){
//                output.close();
//            }
//        }
//
//        //Deserialize
//        UserProfile userProfileRestored;
//        ObjectInputStream input = null;
//        try {
//            input = new ObjectInputStream(new FileInputStream(
//                    "src/main/java/vladproduction/com/files_and_IO/userProfile.txt" ) );
//            userProfileRestored = (UserProfile) input.readObject();
//
//            System.out.println(userProfileRestored);
//        } finally {
//            if (input != null){
//                input.close();
//            }
//        }
//    }
}

