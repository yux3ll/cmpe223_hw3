package part1;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Driver {

    public static void main(String[] args) throws FileNotFoundException {

        int key, quantity;
        String name;
        BinarySearchTree tree = new BinarySearchTree();

        Scanner sc = new Scanner(System.in);
        String filePath = sc.nextLine();
        Scanner input = new Scanner(new File(filePath));

        System.out.println("--------------- WELCOME TO ITS SYSTEM ---------------");




        while(true) {
            String temp = input.next();
            switch (temp) {
                case "Add_product":
                    System.out.println("Create Product: \n");
                    key = input.nextInt();
                    name = input.next();
                    quantity = input.nextInt();
                    tree.addProduct(key, name, quantity);
                    input.nextLine();
                    break;
                case "Is_Available":
                    key = input.nextInt();
                    tree.searchProduct(key);
                    input.nextLine();
                    break;
                case "Quit":
                    System.out.println("Thank you for using ITS, Good Bye!");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid operation!");
                    break;
            }
        }
    }

}


