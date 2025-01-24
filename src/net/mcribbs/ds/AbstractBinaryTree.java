package net.mcribbs.ds;

public abstract class AbstractBinaryTree<T extends Comparable<T>> implements BinaryTree<T> {
    protected Node root;
    protected int size;
    private int nullcount;

    public int size() {
        return size;
    }

    public boolean contains(T item) {
        return get(item) != null;
    }

    protected Node get(T item) {
        Node current = root;
        while (current != null) {
            if (item.compareTo(current.getItem()) == 0) {
                return current;
            } else if (item.compareTo(current.getItem()) < 0) {
                current = current.getLeft();
            } else {
                current = current.getRight();
            }
        }
        return null;
    }

    public String toString() {
        StringBuilder retVal = new StringBuilder();
        nullcount = 0;
        retVal.append("Tree graphviz (http://www.webgraphviz.com/): graph tree {");
        retVal.append(printNode(root));
        retVal.append("}");
        return retVal.toString();
    }

    private String printNode(Node current) {
        StringBuilder out = new StringBuilder();

        if (current.getLeft() != null) {
            out.append(formatNode(current)).append(" -- ");
            out.append(formatNode(current.getLeft())).append(";");
            out.append(printNode(current.getLeft()));
        } else {
            out.append("null").append(nullcount).append("[shape=point];");
            out.append(formatNode(current)).append(" -- ");
            out.append("null").append(nullcount++).append(";");
        }

        if (current.getRight() != null) {
            out.append(formatNode(current)).append(" -- ");
            out.append(formatNode(current.getRight())).append(";");
            out.append(printNode(current.getRight()));
        } else {
            out.append("null").append(nullcount).append("[shape=point];");
            out.append(formatNode(current)).append(" -- ");
            out.append("null").append(nullcount++).append(";");
        }
        return out.toString();
    }

    private String formatNode(Node node) {
        StringBuilder out = new StringBuilder();
        out.append("\"");
        out.append(node.getItem().toString());
        out.append(":d").append(node.getDepth());
        out.append(":h").append(node.getHeight());
        out.append(" - P(").append(node.getParent());
        out.append(")\"");
        return out.toString();
    }

    protected class Node {
        private Node left, right, parent;
        private int depth, height;
        private T item;

        public Node(T item) {
            this.item = item;
            left = right = parent = null;
            depth = height = 0;
        }

        public String toString() {
            StringBuilder out = new StringBuilder();
            out.append(item.toString());
            return out.toString();
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public Node getParent() {
            return parent;
        }

        public void setParent(Node parent) {
            this.parent = parent;
        }

        public T getItem() {
            return item;
        }

        public int getDepth() {
            return depth;
        }

        public void setDepth(int depth) {
            this.depth = depth++;
            if (this.left != null) {
                this.left.setDepth(depth);
            }
            if (this.right != null) {
                this.right.setDepth(depth);
            }
        }

        public int getHeight() {
            return height;
        }

        private void setHeight(int height) {
            this.height = height;
        }

        public void recalcHeights() {
           height = calcHeight(root);
        }

        private int calcHeight(Node node) {
            if (node == null) {
                return -1;
            }

            int lHeight = calcHeight(node.getLeft());
            int rHeight = calcHeight(node.getRight());
            int thisHeight = (lHeight > rHeight ? lHeight : rHeight) + 1;
            node.setHeight(thisHeight);
            return thisHeight;
        }
    }
}
