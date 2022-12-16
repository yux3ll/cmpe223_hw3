package part2;
public class BinarySearchTree {
    private Node root;

    private static class Node{

        Node left; // left child
        Node right; // right child
        int key; // key of the node, also id of captain
        int ratingStar; // rating of the captain
        String name; // name of the captain
        boolean isAvailable; // availability of the captain

        public Node(int key, String name, int ratingStar, boolean isAvailable) { // constructor of Node
            this.key = key; // set the key
            this.name = name; // set the name
            this.ratingStar = ratingStar; // set the rating
            this.isAvailable = isAvailable; // set the availability
        }

    }

    public BinarySearchTree() {
        root = null;
    } // constructor

    public void addCaptain(int key, String name) { // public method to add a new captain, calls upon another method that is private and recursive
        System.out.println("Add Captain: Add a new captain record in the System\n"); // print the name of the method
        root = addCaptain(root, key, name); // set the root to the return value of the recursive method
        System.out.println("----------------------------------------------------------------"); // print a line to separate the methods
    }
    private Node addCaptain(Node node, int key, String name) { // private method to add a new captain, recursive
        if (node == null) { // if the node is null, then it means that the tree is empty, so we create a new node and return it
            node = new Node(key, name, 0, true);
            System.out.println("\t\t\tID: " + key + "\n\t\t\tName: " + name + "\n\t\t\tAvailable: True\n\t\t\tRating star: 0"); // print the captain's info
        } else {
            if (key <= node.key) { // if the key is less than or equal to the key of the node, then we go to the left subtree
                node.left = addCaptain(node.left, key, name);
            } else { // if the key is greater than the key of the node, then we go to the right subtree
                node.right = addCaptain(node.right, key, name);
            }
        }
        return node;
    }



    public void printCaptain(int key) { // public method to print the info of a captain, calls upon another method that is private and recursive
        System.out.print("Display Captain:"); // print the name of the method
        printCaptain(root, key); // call the recursive method
        System.out.println("----------------------------------------------------------------"); // print a line to separate the methods

    }
    private Node printCaptain(Node node, int key) { // private method to print the info of a captain, recursive
        if (node == null) { // if the node is null, then it means that the tree is empty, so we print that the captain is not found
            System.out.println(" Couldn't find any captain with ID number " + key);
            return null;
        } else {
            if (key < node.key) { // if the key is less than the key of the node, then we go to the left subtree
                node.left = printCaptain(node.left, key);
            } else if (key > node.key) { // if the key is greater than the key of the node, then we go to the right subtree
                node.right = printCaptain(node.right, key);
            } else { // if the key is equal to the key of the node, then we print the captain's info
                System.out.println("\n\n\t\t\tID: " + node.key + "\n\t\t\tName: " + node.name + "\n\t\t\tAvailable: " + node.isAvailable + "\n\t\t\tRating star:" + node.ratingStar);

            }
        }
        return node;
    }

    public void printAllCaptain() { // public method to print the info of all the captains, calls upon another method that is private and recursive
        System.out.println("----------ALL CAPTAINS----------"); // print the name of the method
        printAllCaptain(root); // call the recursive method
    }
    private void printAllCaptain(Node node) { // private method to print the info of all the captains, recursive
        if (node != null) { // if the node is not null, then we print the captain's info
            printAllCaptain(node.left); // go to the left subtree
            System.out.println("--CAPTAIN:\n\n\t\t\tID: " + node.key + "\n\t\t\tName: " + node.name + "\n\t\t\tAvailable: " + node.isAvailable + "\n\t\t\tRating star: " + node.ratingStar + "\n"); // print the captain's info
            printAllCaptain(node.right); // go to the right subtree
        }
    }
    private Node findMin(Node node) { // private method to find the minimum node in the tree, recursive, useful for the deletion method
        if (node == null) { // if the node is null, then it means that the tree is empty, so we return null
            return null;
        } else if (node.left == null) { // if the left child of the node is null, then we return the node
            return node;
        } else {
            return findMin(node.left); // go to the left subtree
        }
    }

    public void startRide(int key) { // public method to start a ride, calls upon another method that is private and recursive
        System.out.print("IsAvailable: "); // print the name of the method
        root = startRide(root, key); // set the root to the return value of the recursive method
        System.out.println("\n----------------------------------------------------------------"); // print a line to separate the methods
    }

    private Node startRide(Node node, int key) { // private method to start a ride, recursive
        if (node == null) { // if the node is null, then it means that the tree is empty, so we print that the captain is not found
            System.out.println("Couldn't find any captain with ID number " + key);
            return null;
        } else {
            if (key < node.key) { // if the key is less than the key of the node, then we go to the left subtree
                node.left = startRide(node.left, key);
            } else if (key > node.key) { // if the key is greater than the key of the node, then we go to the right subtree
                node.right = startRide(node.right, key);
            } else {
                if(node.isAvailable) { // if the captain is available, then we set the availability to false and print that the captain is reserved successfully
                    node.isAvailable = false;
                    System.out.println("Reserve a new Ride with captain " + key);
                }else  { // if the captain is not available, then we print that the captain is not available
                    System.out.println("The captain " + node.name + " is not available. He is on another ride!");}
            }
        }
        return node;
    }

    public void endRide(int key, int ratingStar) { // public method to end a ride, calls upon another method that is private and recursive
        System.out.print("Finish: ");  // print the name of the method
        root = endRide(root, key, ratingStar); // set the root to the return value of the recursive method
        System.out.println("----------------------------------------------------------------"); // print a line to separate the methods
    }

    private Node endRide(Node node, int key, int ratingStar) { // private method to end a ride, recursive
        if (node == null) { // if the node is null, then it means that the tree is empty, so we print that the captain is not found
            System.out.println("Couldn't find any captain with ID number " + key);
            return null;
        } else {
            if (key < node.key) { // if the key is less than the key of the node, then we go to the left subtree
                node.left = endRide(node.left, key, ratingStar);
            } else if (key > node.key) { // if the key is greater than the key of the node, then we go to the right subtree
                node.right = endRide(node.right, key, ratingStar);
            } else {
                if(!node.isAvailable) { // if the captain is not available, then we set the availability to true and print that the captain is available again
                    node.isAvailable = true;
                    node.ratingStar = ratingStar;
                    System.out.println("Finish ride with captain " + key);
                    System.out.println("\n\t\t\tID: " + node.key + "\n\t\t\tName: " + node.name + "\n\t\t\tAvailable: " + node.isAvailable + "\n\t\t\tRating star: " + node.ratingStar);
                }else System.out.println("The captain " + node.name + " is not in a ride"); // if the captain is available, then we print that the captain is not in a ride
            }
        }
        return node;
    }


    public void deleteCaptain(int key){ // public method to delete a captain, calls upon another method that is private and recursive
        System.out.print("Delete Captain:"); // print the name of the method
        root = deleteCaptain(root, key); // set the root to the return value of the recursive method
        System.out.println("----------------------------------------------------------------"); // print a line to separate the methods
    }
    private Node deleteCaptain(Node node, int key){ // private method to delete a captain, recursive
        if(node == null){ // if the node is null, then it means that the tree is empty, so we print that the captain is not found
            System.out.println(" Couldn't find any captain with ID number " + key);
            return null;
        }else{
            if(key < node.key){ // if the key is less than the key of the node, then we go to the left subtree
                node.left = deleteCaptain(node.left, key);
            }else if(key > node.key){ // if the key is greater than the key of the node, then we go to the right subtree
                node.right = deleteCaptain(node.right, key);
            }else{
                if(node.left == null && node.right == null){ // if the node has no children, then we set the node to null and print the deletion message
                    System.out.println("The captain " + node.name + " left CCR");
                    node = null;
                }else if(node.left == null){ // if the node has only one child, then we set the node to the child and print the deletion message
                    System.out.println("The captain " + node.name + " left CCR");
                    node = node.right;
                }else if(node.right == null){ // if the node has only one child, then we set the node to the child and print the deletion message
                    System.out.println("The captain " + node.name + " left CCR");
                    node = node.left;
                }else{ // if the node has two children, then we find the minimum node in the right subtree and set the node to the minimum node and print the deletion message
                    Node temp = findMin(node.right);
                    node.key = temp.key;
                    node.right = deleteCaptain(node.right, temp.key);
                }

            }
        }
        return node;
    }
}