package com.mycompany.filehandlingutility;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class FileHandlingUtility {

    // Use absolute path to avoid confusion
    static String fileName = "C:\\Users\\Shweta\\Desktop\\Owner\\CodeTech(Java)\\Task-1\\Sample.txt";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n---- FILE HANDLING MENU ----");
            System.out.println("1. Write File");
            System.out.println("2. Read File");
            System.out.println("3. Modify File");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    writeFile();
                    break;

                case 2:
                    readFile();
                    break;

                case 3:
                    modifyFile();
                    break;

                case 4:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice");
            }

        } while (choice != 4);

        sc.close();
    }

    // WRITE FILE
    static void writeFile() {
        try {
            FileWriter fw = new FileWriter(fileName);
            fw.write("Hello CODTECH\n");
            fw.write("This is Task 1 - Java File Handling\n");
            fw.close();

            System.out.println("File written successfully!!");
            System.out.println("File Location: " + new File(fileName).getAbsolutePath());

        } catch (Exception e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }

    // READ FILE
    static void readFile() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line;

            System.out.println("\nFile Content:");
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            br.close();

        } catch (Exception e) {
            System.out.println("Error reading file. Please write the file first.");
        }
    }

    // MODIFY FILE
    static void modifyFile() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String text = "";
            String line;

            while ((line = br.readLine()) != null) {
                text = text + line.replace("CODTECH", "CODTECH INTERNSHIP") + "\n";
            }
            br.close();

            FileWriter fw = new FileWriter(fileName);
            fw.write(text);
            fw.close();

            System.out.println("File modified successfully!!");

        } catch (Exception e) {
            System.out.println("Error modifying file. Please write the file first.");
        }
    }
}
