package net.mcribbs.ds;

public class AVLTree<T extends Comparable<T>> extends BasicBinaryTree<T> {

    public AVLTree() {
        root = null;
        size = 0;
    }



//    public void add(T item) {
//        Node node = new Node(item);
//
//        if (root == null) {
//            this.root = node;
//            node.setDepth(0);
//            System.out.println("Set root: " + node.getItem());
//            this.size++;
//        } else {
//            insert(this.root, node);
//        }
//        root.recalcHeights();
//
//        int balance = node.getLeft().getHeight() - node.getRight().getHeight();
//
//        // Left Left
//        if (balance > 1 && item.compareTo(node.getLeft().getItem()) < 0) {
//            return rightRotate(node);
//        }
//
//        // Right Right
//        if (balance < -1 && item.compareTo(node.getRight().getItem()) > 0) {
//            return leftRotate(node);
//        }
//
//        // Left Right
//        if (balance > 1 && item.compareTo(node.getLeft().getItem()) > 0) {
//            node.setLeft(leftRotate(node.getLeft()));
//            return rightRotate(node);
//        }
//
//        // Right Left
//        if (balance < -1 && item.compareTo(node.getRight().getItem()) < 0) {
//            node.setRight(rightRotate(node.getRight()));
//            return leftRotate(node);
//        }
//    }
//
//    public boolean delete(T item) {
//        if (root == null) {
//            return false;
//        }
//
//        Node nodeToDelete = get(item);
//        if (nodeToDelete == null) {
//            return false;
//        }
//
//        if (nodeToDelete.getLeft() == null && nodeToDelete.getRight() == null) { // no children
//            unlink(nodeToDelete, null);
//        } else if (nodeToDelete.getRight() == null && nodeToDelete.getLeft() != null) { // only left
//            unlink(nodeToDelete, nodeToDelete.getLeft());
//        } else if (nodeToDelete.getLeft() == null && nodeToDelete.getRight() != null) { // only right
//            unlink(nodeToDelete, nodeToDelete.getRight());
//        } else {
//            Node child = nodeToDelete.getRight();
//            while (child.getLeft() != null) {
//                child = child.getLeft();
//            }
//            if (child.getRight() != null) {
//                child.getRight().setParent(child.getParent());
//            }
//            child.getParent().setLeft(child.getRight());
//            unlink(nodeToDelete, child);
//            child.setRight(nodeToDelete.getRight());
//            child.getRight().setParent(child);
//            child.setLeft(nodeToDelete.getLeft());
//            child.getLeft().setParent(child);
//        }
//        size--;
//        root.recalcHeights();
//        return true;
//    }
}
