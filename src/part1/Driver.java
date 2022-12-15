package part1;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Driver {

    public static void main(String[] args) throws FileNotFoundException {

        Scanner sc = new Scanner(System.in);
        String filePath = sc.nextLine();
        Scanner input = new Scanner(new File(filePath));

        System.out.println("--------------- WELCOME TO ITS SYSTEM ---------------");

        BinarySearchTree tree = new BinarySearchTree();




    }
public int readOperation(Scanner input, String operation) {
        String temp = input.next();
        int numerator = 0;
        switch (temp) {
            case "Add_product":
                operation = input.nextLine();
                numerator = 1;
                break;
            case "Is_avaliable":
                operation = input.nextLine();
                numerator = 2;
                break;
            case "Quit":
                System.out.println("--------------- THANK YOU FOR USING OUR SYSTEM ---------------");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid operation!");
                break;
        }
     return numerator;
        }
}


