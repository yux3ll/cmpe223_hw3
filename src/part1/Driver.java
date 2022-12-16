package part1;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Driver {

    public static void main(String[] args) throws FileNotFoundException {

        int key, quantity; // key is the ID number of the captain, quantity is the number of the captain, these variables are created as temporary placeholders for data read from the file
        String name; // name is the name of the captain, this variable is created as a temporary placeholder for data read from the file
        BinarySearchTree tree = new BinarySearchTree(); // create a new BinarySearchTree object called tree

        Scanner sc = new Scanner(System.in); // create a new Scanner object called sc
        String filePath = sc.nextLine(); // read the file path from the console
        Scanner input = new Scanner(new File(filePath)); // create a new Scanner object called input, and read the file from the file path

        System.out.println("--------------- WELCOME TO ITS SYSTEM ---------------"); // print the welcome message

        while(true) { // loop until the user enters the "Quit" command
            String temp = input.next(); // read the next word from the file, that will determine the operation to be done
            switch (temp) { // switch statement to determine the operation to be done
                case "Add_product" -> {
                    System.out.println("Create Product: \n");
                    key = input.nextInt(); // read the ID number of the product from the file
                    name = input.next();  // read the name of the product from the file
                    quantity = input.nextInt(); // read the quantity of the product from the file
                    tree.addProduct(key, name, quantity); // call the addProduct method from the BinarySearchTree class
                    input.nextLine(); // read the next line from the file, done to avoid reading the same line twice
                }
                case "Is_Available" -> {
                    key = input.nextInt(); // read the ID number of the product from the file
                    tree.searchProduct(key); // call the searchProduct method from the BinarySearchTree class
                    input.nextLine(); // read the next line from the file, done to avoid reading the same line twice
                }
                case "Quit" -> { // if the user enters the "Quit" command, print the goodbye message and exit the program
                    System.out.println("Thank you for using ITS, Good Bye!");
                    System.exit(0); // exit the program
                }
                default -> System.out.println("Invalid operation!"); // if the user enters an invalid operation, print the invalid operation message
            }
        }
    }

}


