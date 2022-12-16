package part1;

public class BinarySearchTree {
    private Node root;

    public BinarySearchTree() {
        root = null;
    }








    private static class Node {
        private final int key;
        private Node left;
        private Node right;

        private String productName;
        private int productQuantity;

        public Node (int key,String productName, int productQuantity) {
            this.key = key;
            this.productName = productName;
            this.productQuantity = productQuantity;
            left = null;
            right = null;
        }
    }

   public void addProduct(int key, String productName, int productQuantity) {
        root = addProduct(root, key, productName, productQuantity);
    }

    private Node addProduct(Node node, int key, String productName, int productQuantity) {
        if (node == null) {
            System.out.println("\t\t ID: " + key + "\n\t\tName: " + productName + "\n\t\tPiece: " + productQuantity);
            node = new Node(key, productName, productQuantity);
        } else {
            if (key < node.key) {
                node.left = addProduct(node.left, key, productName, productQuantity);
            } else if (key== node.key) {
                node.productQuantity+=productQuantity;
                System.out.println("Product already exists, quantity increased by " + productQuantity);
            } else {
                node.right = addProduct(node.right, key, productName, productQuantity);
            }
        }
        return node;
    }


    public void searchProduct(int key) {
        root = searchProduct(root, key);
    }
    public Node searchProduct(Node node, int key) {
        if (node == null) {
            System.out.println("The product is out of stock!!!");
        } else {
            if (key == node.key) {
                if(node.productQuantity > 0)
                    System.out.println("There are " +node.productQuantity + " products \n");
                else
                    System.out.println("The product is out of stock!!! \n");
            } else if (key < node.key) {
                return searchProduct(node.left, key);
            } else {
                return searchProduct(node.right, key);
            }
        }
    return node;
    }


}
