package tree.balanced.tree;

import main.java.tree.balanced.tree.Node;

public class App {
    private Node root;

    public App() {
        root = null;
    }

    public void insert(int data) {
        root = insertNode(root, data);
    }

    private Node insertNode(Node node, int data) {
        if (node == null) {
            node = new Node(data);
        } else {
            if (data <= node.getData()) {
                node.setLeft(insertNode(node.getLeft(), data));
            } else {
                node.setRight(insertNode(node.getRight(), data));
            }
        }
        return node;
    }

    public boolean isBalanced() {
        return checkBalanced(root);
    }

    private boolean checkBalanced(Node node) {
        if (node == null) {
            return true;
        }
        int leftHeight = getHeight(node.getLeft());
        int rightHeight = getHeight(node.getRight());
        int balanceFactor = Math.abs(leftHeight - rightHeight);
        if (balanceFactor <= 1 && checkBalanced(node.getLeft()) && checkBalanced(node.getRight())) {
            return true;
        }
        return false;
    }

    private int getHeight(Node node) {
        if (node == null) {
            return 0;
        }
        int leftHeight = getHeight(node.getLeft());
        int rightHeight = getHeight(node.getRight());
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void main(String[] args) {
        App tree = new App();

        tree.insert(3);
        tree.insert(1);
        tree.insert(5);
        tree.insert(2);
        tree.insert(4);

        boolean isBalanced = tree.isBalanced();
        System.out.println("Is the tree balanced? " + isBalanced);
    }
}