package com.tangguanglei.datastruct.tree;

public class RedBlackTree {
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private Node root;

    private class Node {
        private int key;
        private boolean color;
        private Node left;
        private Node right;

        public Node(int key, boolean color) {
            this.key = key;
            this.color = color;
            this.left = null;
            this.right = null;
        }
    }

    public RedBlackTree() {
        root = null;
    }

    public void insert(int key) {
        root = insert(root, key);
        root.color = BLACK;
    }

    private Node insert(Node node, int key) {
        if (node == null) {
            return new Node(key, RED);
        }
        if (key < node.key) {
            node.left = insert(node.left, key);
        } else if (key > node.key) {
            node.right = insert(node.right, key);
        } else {
            // 如果已经存在相同的键值，则不进行插入操作
            return node;
        }

        // 调整红黑树，保持平衡性
        if (isRed(node.right) && !isRed(node.left)) {
            node = rotateLeft(node);
        }
        if (isRed(node.left) && isRed(node.left.left)) {
            node = rotateRight(node);
        }
        if (isRed(node.left) && isRed(node.right)) {
            flipColors(node);
        }

        return node;
    }

    public void delete(int key) {
        if (!contains(key)) {
            return;
        }
        // 如果根节点为黑色，则需要先将其变为红色，以便后续删除操作
        if (!isRed(root.left) && !isRed(root.right)) {
            root.color = RED;
        }
        root = delete(root, key);
        if (root != null) {
            root.color = BLACK;
        }
    }

    private Node delete(Node node, int key) {
        if (key < node.key) {
            if (!isRed(node.left) && !isRed(node.left.left)) {
                node = moveRedLeft(node);
            }
            node.left = delete(node.left, key);
        } else {
            if (isRed(node.left)) {
                node = rotateRight(node);
            }
            if (key == node.key && node.right == null) {
                return null;
            }
            if (!isRed(node.right) && !isRed(node.right.left)) {
                node = moveRedRight(node);
            }
            if (key == node.key) {
                Node minNode = findMin(node.right);
                node.key = minNode.key;
                node.right = deleteMin(node.right);
            } else {
                node.right = delete(node.right, key);
            }
        }
        return balance(node);
    }

    public boolean contains(int key) {
        return contains(root, key);
    }

    private boolean contains(Node node, int key) {
        if (node == null) {
            return false;
        }
        if (key == node.key) {
            return true;
        } else if (key < node.key) {
            return contains(node.left, key);
        } else {
            return contains(node.right, key);
        }
    }

    private Node rotateLeft(Node h) {
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        return x;
    }

    private Node rotateRight(Node h) {
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        return x;
    }

    private void flipColors(Node h) {
        h.color = !h.color;
        h.left.color = !h.left.color;
        h.right.color = !h.right.color;
    }

    private boolean isRed(Node node) {
        if (node == null) {
            return false;
        }
        return node.color == RED;
    }

    private Node moveRedLeft(Node h) {
        flipColors(h);
        if (isRed(h.right.left)) {
            h.right = rotateRight(h.right);
            h = rotateLeft(h);
            flipColors(h);
        }
        return h;
    }

    private Node moveRedRight(Node h) {
        flipColors(h);
        if (isRed(h.left.left)) {
            h = rotateRight(h);
            flipColors(h);
        }
        return h;
    }

    private Node balance(Node h) {
        if (isRed(h.right) && !isRed(h.left)) {
            h = rotateLeft(h);
        }
        if (isRed(h.left) && isRed(h.left.left)) {
            h = rotateRight(h);
        }
        if (isRed(h.left) && isRed(h.right)) {
            flipColors(h);
        }
        return h;
    }

    private Node findMin(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    private Node deleteMin(Node node) {
        if (node.left == null) {
            return null;
        }
        if (!isRed(node.left) && !isRed(node.left.left)) {
            node = moveRedLeft(node);
        }
        node.left = deleteMin(node.left);
        return balance(node);
    }


}

