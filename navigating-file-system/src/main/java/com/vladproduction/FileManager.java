package com.vladproduction;

import java.io.*;
import java.io.Console;

public class FileManager {
    public static void main(String[] args) {

        Console console = System.console();

        if (console == null) {
            System.out.println("No console available. Please run this program in a command line.");
            return;
        }

        // Step 1: Get directory path from user
        String dirPath = console.readLine("Enter directory path: ");
        File directory = new File(dirPath);

        // Step 2: List files in the directory
        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles();
            System.out.println("Files in the directory:");
            if (files != null) {
                for (File file : files) {
                    System.out.println(file.getName());
                }
            }

            // Step 3: Read from a specified file
            String readFileName = console.readLine("Enter a file name to read (in the same directory): ");
            File readFile = new File(directory, readFileName);
            if (readFile.exists() && readFile.isFile()) {
                try (BufferedReader reader = new BufferedReader(new FileReader(readFile))) {
                    String line;
                    System.out.println("Contents of the file:");
                    while ((line = reader.readLine()) != null) {
                        System.out.println(line);
                    }
                } catch (IOException e) {
                    System.err.println("Error reading the file: " + e.getMessage());
                }
            } else {
                System.err.println("File does not exist.");
            }

            // Step 4: Write to a new file
            String writeFileName = console.readLine("Enter a file name to write (it will be created/overwritten): ");
            File writeFile = new File(directory, writeFileName);
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(writeFile))) {
                String content = console.readLine("Enter content to write to the file: ");
                writer.write(content);
                System.out.println("Content written to " + writeFileName);
            } catch (IOException e) {
                System.err.println("Error writing to the file: " + e.getMessage());
            }

            // Step 5: Option to append content to the same file
            if (console.readLine("Do you want to append content to the same file? (yes/no): ").equalsIgnoreCase("yes")) {
                try (PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(writeFile, true)))) {
                    String additionalContent = console.readLine("Enter additional content to append: ");
                    printWriter.println(additionalContent);
                    System.out.println("Additional content appended to " + writeFileName);
                } catch (IOException e) {
                    System.err.println("Error appending to the file: " + e.getMessage());
                }
            }

        } else {
            System.err.println("Invalid directory. Please check the path.");
        }

    }
}
