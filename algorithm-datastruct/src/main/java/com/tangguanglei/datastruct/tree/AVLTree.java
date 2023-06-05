package com.tangguanglei.datastruct.tree;

class Node {
    int val;
    int height;
    Node left;
    Node right;

    Node(int val) {
        this.val = val;
        this.height = 1;
    }
}

public class AVLTree {
    private Node root;

    public void insert(int val) {
        root = insert(root, val);
    }

    private Node insert(Node node, int val) {
        if (node == null) {
            return new Node(val);
        }
        if (val < node.val) {
            node.left = insert(node.left, val);
        } else if (val > node.val) {
            node.right = insert(node.right, val);
        } else {
            // 如果已经存在相同的值，则不进行插入操作
            return node;
        }
        // 更新节点的高度
        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
        // 计算节点的平衡因子
        int balance = getBalance(node);
        // 如果节点的平衡因子大于 1，说明左子树高度大于右子树，需要进行右旋操作
        if (balance > 1 && val < node.left.val) {
            return rightRotate(node);
        }
        // 如果节点的平衡因子小于 -1，说明右子树高度大于左子树，需要进行左旋操作
        if (balance < -1 && val > node.right.val) {
            return leftRotate(node);
        }
        // 如果节点的平衡因子大于 1 且插入的值大于节点的左子树的值，需要进行左右旋操作
        if (balance > 1 && val > node.left.val) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        // 如果节点的平衡因子小于 -1 且插入的值小于节点的右子树的值，需要进行右左旋操作
        if (balance < -1 && val < node.right.val) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
        return node;
    }

    public void delete(int val) {
        root = delete(root, val);
    }

    private Node delete(Node node, int val) {
        if (node == null) {
            return null;
        }
        if (val < node.val) {
            node.left = delete(node.left, val);
        } else if (val > node.val) {
            node.right = delete(node.right, val);
        } else {
            // 找到要删除的节点
            if (node.left == null || node.right == null) {
                // 要删除的节点只有一个子节点或者没有子节点
                node = (node.left != null) ? node.left : node.right;
            } else {
                // 要删除的节点有两个子节点，找到右子树中的最小值节点
                Node minNode = node.right;
                while (minNode.left != null) {
                    minNode = minNode.left;
                }
                // 将最小值赋给当前节点
                node.val = minNode.val;
                // 将最小值节点删除
                node.right = delete(node.right, minNode.val);
            }
        }
        if (node == null) {
            return null;
        }
        // 更新节点的高度
        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
        // 计算节点的平衡因子
        int balance = getBalance(node);
        // 如果节点的平衡因子大于 1，说明左子树高度大于右子树，需要进行右旋操作
        if (balance > 1 && getBalance(node.left) >= 0) {
            return rightRotate(node);
        }
        // 如果节点的平衡因子小于 -1，说明右子树高度大于左子树，需要进行左旋操作
        if (balance < -1 && getBalance(node.right) <= 0) {
            return leftRotate(node);
        }
        // 如果节点的平衡因子大于 1 且插入的值大于节点的左子树的值，需要进行左右旋操作
        if (balance > 1 && getBalance(node.left) < 0) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        // 如果节点的平衡因子小于 -1 且插入的值小于节点的右子树的值，需要进行右左旋操作
        if (balance < -1 && getBalance(node.right) > 0) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
        return node;
    }
    private int getHeight(Node node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }

    private int getBalance(Node node) {
        if (node == null) {
            return 0;
        }
        return getHeight(node.left) - getHeight(node.right);
    }

    private Node leftRotate(Node node) {
        Node rightChild = node.right;
        Node leftGrandchild = rightChild.left;
        // 进行左旋操作
        rightChild.left = node;
        node.right = leftGrandchild;
        // 更新节点的高度
        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
        rightChild.height = 1 + Math.max(getHeight(rightChild.left), getHeight(rightChild.right));
        return rightChild;
    }

    private Node rightRotate(Node node) {
        Node leftChild = node.left;
        Node rightGrandchild = leftChild.right;
        // 进行右旋操作
        leftChild.right = node;
        node.left = rightGrandchild;
        // 更新节点的高度
        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
        leftChild.height = 1 + Math.max(getHeight(leftChild.left), getHeight(leftChild.right));
        return leftChild;
    }

}

