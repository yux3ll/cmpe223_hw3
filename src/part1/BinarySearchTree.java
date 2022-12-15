package part1;

public class BinarySearchTree {
    private Node root;

    public BinarySearchTree() {
        root = null;
    }

    public void insert(int key) {
        root = insert(root, key);
    }

    private Node insert(Node node, int key) {
        if (node == null) {
            node = new Node(key);
        } else {
            if (key <= node.key) {
                node.left = insert(node.left, key);
            } else {
                node.right = insert(node.right, key);
            }
        }
        return node;
    }

    public void delete(int key) {
        root = delete(root, key);
    }

    private Node delete(Node node, int key) {
        if (node == null) {
            return null;
        } else {
            if (key == node.key) {
                if (node.left == null && node.right == null) {
                    return null;
                } else if (node.left == null) {
                    return node.right;
                } else if (node.right == null) {
                    return node.left;
                } else {
                    int min = findMin(node.right);
                    node.key = min;
                    node.right = delete(node.right, min);
                    return node;
                }
            } else if (key < node.key) {
                node.left = delete(node.left, key);
                return node;
            } else {
                node.right = delete(node.right, key);
                return node;
            }
        }
    }

    private int findMin(Node node) {
        if (node.left == null) {
            return node.key;
        } else {
            return findMin(node.left);
        }
    }

    public boolean search(int key) {
        return search(root, key);
    }

    private boolean search(Node node, int key) {
        if (node == null) {
            return false;
        } else {
            if (key == node.key) {
                return true;
            } else if (key < node.key) {
                return search(node.left, key);
            } else {
                return search(node.right, key);
            }
        }
    }

    public void print() {
        print(root);
    }


    private void print(Node node) {
        if (node != null) {
            print(node.left);
            System.out.print(node.key + " ");
            print(node.right);
        }
    }

    private class Node {
        private int key;
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
        public Node(int key) {
            this.key = key;
            left = null;
            right = null;
        }
    }

   public void addProduct(int key, String productName, int productQuantity) {
        root = addProduct(root, key, productName, productQuantity);
    }

    private Node addProduct(Node node, int key, String productName, int productQuantity) {
        if (node == null) {
            System.out.println("\t\t ID: " + key + "\nName: " + productName + "\nPiece: " + productQuantity);
            node = new Node(key, productName, productQuantity);
        } else {
            if (key <= node.key) {
                node.left = addProduct(node.left, key, productName, productQuantity);
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
