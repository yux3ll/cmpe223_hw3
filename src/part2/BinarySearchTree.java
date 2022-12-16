package part2;
public class BinarySearchTree {
    private Node root;

    private static class Node{

        Node left;
        Node right;

        int key;
        int ratingStar;
        String name;
        boolean isAvailable;

        public Node(int key, String name, int ratingStar, boolean isAvailable) {
            this.key = key;
            this.name = name;
            this.ratingStar = ratingStar;
            this.isAvailable = isAvailable;
        }

    }

    public BinarySearchTree() {
        root = null;
    }

    public void addCaptain(int key, String name) {
        System.out.println("Add Captain: Add a new captain record in the System\n");
        root = addCaptain(root, key, name);
        System.out.println("----------------------------------------------------------------");
    }
    private Node addCaptain(Node node, int key, String name) {
        if (node == null) {
            node = new Node(key, name, 0, true);
            System.out.println("\t\t\tID: " + key + "\n\t\t\tName: " + name + "\n\t\t\tAvailable: True\n\t\t\tRating star: 0");
        } else {
            if (key <= node.key) {
                node.left = addCaptain(node.left, key, name);
            } else {
                node.right = addCaptain(node.right, key, name);
            }
        }
        return node;
    }



    public void printCaptain(int key) {
        System.out.print("Display Captain:");
        printCaptain(root, key);
        System.out.println("----------------------------------------------------------------");

    }
    private Node printCaptain(Node node, int key) {
        if (node == null) {
            System.out.println(" Couldn't find any captain with ID number " + key);
            return null;
        } else {
            if (key < node.key) {
                node.left = printCaptain(node.left, key);
            } else if (key > node.key) {
                node.right = printCaptain(node.right, key);
            } else {
                System.out.println("\n\n\t\t\tID: " + node.key + "\n\t\t\tName: " + node.name + "\n\t\t\tAvailable: " + node.isAvailable + "\n\t\t\tRating star:" + node.ratingStar);

            }
        }
        return node;
    }

    public void printAllCaptain() {
        System.out.println("----------ALL CAPTAINS----------");
        printAllCaptain(root);
    }
    private void printAllCaptain(Node node) {
        if (node != null) {
            printAllCaptain(node.left);
            System.out.println("--CAPTAIN:\n\n\t\t\tID: " + node.key + "\n\t\t\tName: " + node.name + "\n\t\t\tAvailable: " + node.isAvailable + "\n\t\t\tRating star: " + node.ratingStar + "\n");
            printAllCaptain(node.right);
        }
    }
    private Node findMin(Node node) {
        if (node == null) {
            return null;
        } else if (node.left == null) {
            return node;
        } else {
            return findMin(node.left);
        }
    }

    public void startRide(int key) {
        System.out.print("IsAvailable: ");
        root = startRide(root, key);
        System.out.println("\n----------------------------------------------------------------");
    }

    private Node startRide(Node node, int key) {
        if (node == null) {
            System.out.println("Couldn't find any captain with ID number " + key);
            return null;
        } else {
            if (key < node.key) {
                node.left = startRide(node.left, key);
            } else if (key > node.key) {
                node.right = startRide(node.right, key);
            } else {
                if(node.isAvailable) {
                    node.isAvailable = false;
                    System.out.println("Reserve a new Ride with captain " + key);
                }else System.out.println("The captain " + node.name + " is not available. He is on another ride!");
            }
        }
        return node;
    }

    public void endRide(int key, int ratingStar) {
        System.out.print("Finish: ");
        root = endRide(root, key, ratingStar);
        System.out.println("----------------------------------------------------------------");
    }

    private Node endRide(Node node, int key, int ratingStar) {
        if (node == null) {
            System.out.println("Couldn't find any captain with ID number " + key);
            return null;
        } else {
            if (key < node.key) {
                node.left = endRide(node.left, key, ratingStar);
            } else if (key > node.key) {
                node.right = endRide(node.right, key, ratingStar);
            } else {
                if(!node.isAvailable) {
                    node.isAvailable = true;
                    node.ratingStar = ratingStar;
                    System.out.println("Finish ride with captain " + key);
                    System.out.println("\n\t\t\tID: " + node.key + "\n\t\t\tName: " + node.name + "\n\t\t\tAvailable: " + node.isAvailable + "\n\t\t\tRating star: " + node.ratingStar);
                }else System.out.println("The captain " + node.name + " is not in a ride");
            }
        }
        return node;
    }


    public void deleteCaptain(int key){
        System.out.print("Delete Captain:");
        root = deleteCaptain(root, key);
        System.out.println("----------------------------------------------------------------");
    }
    private Node deleteCaptain(Node node, int key){
        if(node == null){
            System.out.println(" Couldn't find any captain with ID number " + key);
            return null;
        }else{
            if(key < node.key){
                node.left = deleteCaptain(node.left, key);
            }else if(key > node.key){
                node.right = deleteCaptain(node.right, key);
            }else{
                if(node.left == null && node.right == null){
                    System.out.println("The captain " + node.name + " left CCR");
                    node = null;
                }else if(node.left == null){
                    System.out.println("The captain " + node.name + " left CCR");
                    node = node.right;
                }else if(node.right == null){
                    System.out.println("The captain " + node.name + " left CCR");
                    node = node.left;
                }else{
                    Node temp = findMin(node.right);
                    node.key = temp.key;
                    node.right = deleteCaptain(node.right, temp.key);
                }

            }
        }
        return node;
    }
}