package part2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Driver {
    //-----------------------------------------------------
    // Title: Driver
    // Author: Yüksel Çağlar Baypınar & Melisa Subaşı
    // ID: 43951623744 & 22829169256
    // Section: 02
    // Assignment: 3 - Q2
    // Description: This class is the driver class of the program, it reads the file and calls the methods from the BinarySearchTree class using a switch statement in a loop
    //-----------------------------------------------

    public static void main(String[] args) throws FileNotFoundException {
        int key, ratingStar; // key is the ID number of the captain, ratingStar is the rating of the captain, these variables are created as temporary placeholders for data read from the file
        String name; // name is the name of the captain, this variable is created as a temporary placeholder for data read from the file
        BinarySearchTree tree = new BinarySearchTree(); // create a new BinarySearchTree object called tree

        Scanner sc = new Scanner(System.in); // create a new Scanner object called sc
        String filePath = sc.nextLine(); // read the file path from the console
        Scanner input = new Scanner(new File(filePath)); // create a new Scanner object called input, and read the file from the file path

        System.out.println("--------------- WELCOME TO CDRC SYSTEM ---------------"); // print the welcome message

        while(true) { // loop until the user enters the "Quit" command
            String temp = input.next(); // read the next word from the file, that will determine the operation to be done
            switch (temp) { // switch statement to determine the operation to be done
                case "Add_Captain" : {  // if the user enters the "Add_Captain" command, call the addCaptain method from the BinarySearchTree class after reading the necessary data from the file
                    key = input.nextInt();
                    name = input.next();
                    tree.addCaptain(key, name);
                    input.nextLine();
                    break;
                }
                case "Is_Available" : { // if the user enters the "Is_Available" command, call the startCaptain method from the BinarySearchTree class after reading the necessary data from the file
                    key = input.nextInt();
                    tree.startRide(key);
                    input.nextLine();
                    break;
                }
                case "Finish" : { // if the user enters the "Finish" command, call the finishRide method from the BinarySearchTree class after reading the necessary data from the file
                    key = input.nextInt();
                    ratingStar = input.nextInt();
                    tree.endRide(key, ratingStar);
                    input.nextLine();
                    break;
                }
                case "Display_captain" : { // if the user enters the "Display_captain" command, call the printCaptain method from the BinarySearchTree class after reading the necessary data from the file
                    key = input.nextInt();
                    tree.printCaptain(key);
                    input.nextLine();
                    break;
                }
                case "Display_all_captains" : { // if the user enters the "Display_all_captains" command, call the printAllCaptains method from the BinarySearchTree class
                    tree.printAllCaptain();
                    input.nextLine();
                    break;
                }
                case "Delete_captain" : { // if the user enters the "Delete_captain" command, call the deleteCaptain method from the BinarySearchTree class after reading the necessary data from the file
                    key = input.nextInt();
                    tree.deleteCaptain(key);
                    input.nextLine();
                    break;
                }
                case "Quit" : { // if the user enters the "Quit" command, print the goodbye message and exit the program
                    System.out.println("Thank you for using CDRC, Good Bye!");
                    System.exit(0);
                }
                default : System.out.println("Invalid operation!"); // if the user enters an invalid operation, print the invalid operation message
            }
        }
    }
}
