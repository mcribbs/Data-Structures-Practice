package net.mcribbs.ds;

public class BasicBinaryTree<T extends Comparable<T>> extends AbstractBinaryTree<T> {

    public BasicBinaryTree() {
        root = null;
        size = 0;
    }

    public void add(T item) {
        Node newNode = new Node(item);

        if (root == null) {
            this.root = newNode;
            newNode.setDepth(0);
            System.out.println("Set root: " + newNode.getItem());
            this.size++;
        } else {
            insert(this.root, newNode);
        }
        root.recalcHeights();
    }

    private void insert(Node parent, Node child) {
        // Left
        if (child.getItem().compareTo(parent.getItem()) < 0 ) {
            if (parent.getLeft() == null) {
                parent.setLeft(child);
                child.setParent(parent);
                child.setDepth(parent.getDepth() + 1);
                this.size++;
            } else {
                insert(parent.getLeft(), child);
            }
        } else if (child.getItem().compareTo(parent.getItem()) > 0) { // do this b/c the demo is unique values only
            if (parent.getRight() == null) {
                parent.setRight(child);
                child.setParent(parent);
                child.setDepth(parent.getDepth() + 1);
                this.size++;
            } else {
                insert(parent.getRight(), child);
            }
        }
    }

    public boolean delete(T item) {
        if (root == null) {
            return false;
        }

        Node nodeToDelete = get(item);
        if (nodeToDelete == null) {
            return false;
        }

        if (nodeToDelete.getLeft() == null && nodeToDelete.getRight() == null) { // no children
            unlink(nodeToDelete, null);
        } else if (nodeToDelete.getRight() == null && nodeToDelete.getLeft() != null) { // only left
            unlink(nodeToDelete, nodeToDelete.getLeft());
        } else if (nodeToDelete.getLeft() == null && nodeToDelete.getRight() != null) { // only right
            unlink(nodeToDelete, nodeToDelete.getRight());
        } else {
            Node child = nodeToDelete.getRight();
            while (child.getLeft() != null) {
                child = child.getLeft();
            }
            if (child.getRight() != null) {
                child.getRight().setParent(child.getParent());
            }
            child.getParent().setLeft(child.getRight());
            unlink(nodeToDelete, child);
            child.setRight(nodeToDelete.getRight());
            child.getRight().setParent(child);
            child.setLeft(nodeToDelete.getLeft());
            child.getLeft().setParent(child);
        }
        size--;
        root.recalcHeights();
        return true;
    }

    private void unlink(Node current, Node replacement) {
        if (current == root) {
            replacement.setLeft(current.getLeft());
            replacement.setRight(current.getRight());
            replacement.setParent(null);
            replacement.setDepth(0);
            root = replacement;
        } else if (current.getParent().getLeft() == current) {
            current.getParent().setLeft(replacement);
            if (replacement != null) {
                replacement.setParent(current.getParent());
                replacement.setDepth(replacement.getParent().getDepth() + 1);
            }

        } else {
            current.getParent().setRight(replacement);
            if (replacement != null) {
                replacement.setParent(current.getParent());
                replacement.setDepth(replacement.getParent().getDepth() + 1);
            }
        }
    }
}
