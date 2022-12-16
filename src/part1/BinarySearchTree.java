package part1;

public class BinarySearchTree {
    //-----------------------------------------------------
    // Title: BinarySearchTree
    // Author: Yüksel Çağlar Baypınar & Melisa Subaşı
    // ID: 43951623744 & 22829169256
    // Section: 02
    // Assignment: 3 - Q1
    // Description: This class is the BinarySearchTree class of the program, it contains the methods to add a product and search for a product
    //-----------------------------------------------

    private Node root;

    public BinarySearchTree() {     // constructor
        root = null;
    }

    private static class Node { // inner class Node that contains the data of the tree
        private final int key; // key of the node
        private Node left; // left child
        private Node right; // right child

        private String productName; // name of the product
        private int productQuantity; // quantity of the product

        public Node (int key,String productName, int productQuantity) {     // constructor of Node
            this.key = key;    // set the key
            this.productName = productName;   // set the name
            this.productQuantity = productQuantity;  // set the quantity
            left = null;   // set the left child to null
            right = null; // set the right child to null
        }
    }

   public void addProduct(int key, String productName, int productQuantity) {    // public method to add a new product, calls upon another method that is private and recursive
        root = addProduct(root, key, productName, productQuantity);  // set the root to the return value of the recursive method
    }

    private Node addProduct(Node node, int key, String productName, int productQuantity) {   // private method to add a new product, recursive
        if (node == null) {    // if the node is null, then it means that the tree is empty, so we create a new node and return it
            System.out.println("\t\tID: " + key + "\n\t\tName: " + productName + "\n\t\tPiece: " + productQuantity);
            node = new Node(key, productName, productQuantity);
        } else {
            if (key < node.key) {  // if the key is less than the key of the node, then we go to the left subtree
                node.left = addProduct(node.left, key, productName, productQuantity);
            } else if (key== node.key) {   // if the key is equal to the key of the node, then we update the quantity of the product
                node.productQuantity+=productQuantity;
                System.out.println("Product already exists, quantity increased by " + productQuantity);
            } else {  // if the key is greater than the key of the node, then we go to the right subtree
                node.right = addProduct(node.right, key, productName, productQuantity);
            }
        }
        return node;
    }

    public void searchProduct(int key) { // public method to search a product, calls upon another method that is private and recursive
        root = searchProduct(root, key); // set the root to the return value of the recursive method
    }
    public Node searchProduct(Node node, int key) { // private method to search a product, recursive
        if (node == null) { // if the node is null, then it means that the tree is empty, so we return null
            System.out.println("The product is out of stock!!!");
        } else {
            if (key == node.key) { // if the key is equal to the key of the node, then we return the node
                if(node.productQuantity > 0) // if the quantity of the product is greater than 0, we print the product quantity
                    System.out.println("There are " +node.productQuantity + " products \n");
                else
                    System.out.println("The product is out of stock!!! \n"); // if the quantity of the product is equal to 0, we print that the product is out of stock, since vpl asks for it, same is done for nonexistent products
            } else if (key < node.key) { // if the key is less than the key of the node, then we go to the left subtree
                return searchProduct(node.left, key);
            } else { // if the key is greater than the key of the node, then we go to the right subtree
                return searchProduct(node.right, key);
            }
        }
    return node;
    }


}
