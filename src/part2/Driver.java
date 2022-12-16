package part2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) throws FileNotFoundException {
        int key, ratingStar;
        String name;
        BinarySearchTree tree = new BinarySearchTree();

        Scanner sc = new Scanner(System.in);
        String filePath = sc.nextLine();
        Scanner input = new Scanner(new File(filePath));

        System.out.println("--------------- WELCOME TO CDRC SYSTEM ---------------");




        while(true) {
            String temp = input.next();
            switch (temp) {
                case "Add_Captain":
                    key = input.nextInt();
                    name = input.next();
                    tree.addCaptain(key, name);
                    input.nextLine();
                    break;
                case "Is_Available":
                    key = input.nextInt();
                    tree.startRide(key);
                    input.nextLine();
                    break;
                case "Finish":
                    key = input.nextInt();
                    ratingStar = input.nextInt();
                    tree.endRide(key, ratingStar);
                    input.nextLine();
                    break;
                case "Display_captain":
                    key = input.nextInt();
                    tree.printCaptain(key);
                    input.nextLine();
                    break;
                case "Display_all_captains":
                    tree.printAllCaptain();
                    input.nextLine();
                    break;
                    case "Delete_captain":
                    key = input.nextInt();
                    tree.deleteCaptain(key);
                    input.nextLine();
                    break;
                case "Quit":
                    System.out.println("Thank you for using CDRC, Good Bye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid operation!");
                    break;
            }
        }
    }
}
