package part2;

public class BinarySearchTree {
     private Node root;

     private class Node{

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
            System.out.println("Add Captain: Add a new captain record in the System \n");
            root = addCaptain(root, key, name);
            System.out.println("----------------------------------------------------------------");
        }
        private Node addCaptain(Node node, int key, String name) {
            if (node == null) {
                node = new Node(key, name, 0,true);
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

        public void deleteCaptain(int key) {
            System.out.print("Delete Captain:");
            root = deleteCaptain(root, key);
        }
        private Node deleteCaptain(Node node, int key) {
            if (node == null) {
                System.out.println(" Couldn't find any captain with ID number");
                return null;
            } else {
                if (key < node.key) {
                    node.left = deleteCaptain(node.left, key);
                } else if (key > node.key) {
                    node.right = deleteCaptain(node.right, key);
                } else {
                    if (node.left == null && node.right == null) {
                        node = null;
                    } else if (node.left == null) {
                        node = node.right;
                    } else if (node.right == null) {
                        node = node.left;
                    } else {
                        Node temp = findMin(node.right);
                        node.key = temp.key;
                        node.right = deleteCaptain(node.right, temp.key);
                    }
                    System.out.println("The captain left CDRC");
                }
            }
            return node;
        }

        public void printCaptain(int key) {
            printCaptain(root, key);
        }
        private Node printCaptain(Node node, int key) {
            if (node == null) {
                System.out.println("Couldn't find any captain with ID number");
                return null;
            } else {
                if (key < node.key) {
                    node.left = printCaptain(node.left, key);
                } else if (key > node.key) {
                    node.right = printCaptain(node.right, key);
                } else {
                    System.out.println("Captain's name: " + node.name);
                    System.out.println("Captain's ID number: " + node.key);
                    System.out.println("Captain's rating: " + node.ratingStar);
                    System.out.println("Captain's availability: " + node.isAvailable);
                }
            }
            return node;
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

}