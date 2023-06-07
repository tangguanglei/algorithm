package com.tangguanglei.datastruct.tree;

import com.tangguanglei.datastruct.TreeNode;

/**
 * 二叉查找树(BST)
 */
public class BinarySearchTree<T extends Comparable<T>> extends BinaryTree<T>{

    public BinarySearchTree(TreeNode<T> root) {
        super(root);
    }

    /**
     * 添加
     * @param node
     */
    public void insert(TreeNode<T> node) {
        root = insert(root, node);
    }

    private TreeNode<T> insert(TreeNode<T> root, TreeNode<T> node) {
        if (root == null) {
            return node;
        }
        int k = root.data.compareTo(node.data);
        if (k > 0) {
            root.left = insert(root.left, node);
        } else if (k < 0) {
            root.right = insert(root.right, node);
        }
        return root;
    }

    public void insertNode(TreeNode<T> node) {
        if (root == null) {
            root = node;
            return;
        }
        TreeNode<T> t = root;
        while (t != null) {
            int k = root.data.compareTo(node.data);
            if (k > 0) {
                if (t.left == null) {
                    t.left = node;
                    return;
                }
                t = t.left;
            } else {
                if (t.right == null) {
                    t.right = node;
                    return;
                }
                t = t.right;
            }
        }
    }

    /**
     * 查找
     * @param node
     * @return
     */
    public boolean contains(TreeNode<T> node) {
        return contains(root, node);
    }

    private boolean contains(TreeNode<T> root, TreeNode<T> node) {
        if (root == null) {
            return false;
        }
        int k = root.data.compareTo(node.data);
        if (k == 0) {
            return true;
        } else if (k > 0) {
            return contains(root.left, node);
        } else {
            return contains(root.right, node);
        }
    }

    public boolean containsNode(TreeNode<T> node) {
        if (node == null) {
            return false;
        }
        TreeNode<T> t = root;
        while (t != null) {
            int k = t.data.compareTo(node.data);
            if (k == 0) {
                return true;
            }
            if (k > 0) {
                t = t.left;
            } else {
                t = t.right;
            }
        }
        return false;
    }

    /**
     * 删除
     * @param node
     */
    public void delete(TreeNode<T> node) {
        root = delete(root, node);
    }

    private TreeNode<T> delete(TreeNode<T> root, TreeNode<T> node) {
        if (root == null) {
            return null;
        }
        int k = root.data.compareTo(node.data);
        if (k > 0) {
            root.left = delete(root.left, node);
        } else if (k < 0) {
            root.right = delete(root.right, node);
        } else {
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            } else {
                TreeNode<T> t = root;
                root = min(t.right);
                root.right = deleteMin(t.right);
                root.left = t.left;
            }
        }
        return root;
    }

    public void deleteNode(TreeNode<T> node) {
        TreeNode<T> dNode = root; //要删除的节点，初始化指向根节点
        TreeNode<T> dParentNode = null; //要删除的节点的父节点
        while (dNode != null && dNode.data != node.data) { //循环找出待删除节点
            dParentNode = dNode;
            int k = dNode.data.compareTo(node.data);
            if (k > 0) {
                dNode = dNode.left;
            } else {
                dNode = dNode.right;
            }
        }
        if (dNode == null) {
            return;
        }
        if (dNode.left != null && dNode.right != null) { //待删除节点左右字数都存在的case
            TreeNode<T> minNode = dNode.right;
            TreeNode<T> minParentNode = dNode;
            while (minNode.left != null) {
                minParentNode = minNode;
                minNode = minNode.left;
            }
            dNode.data = minNode.data; //用待删除节点的右子树最小节点代替它
            dNode = minNode; //转化为删除右子树最小节点
            dParentNode = minParentNode;
        }
        TreeNode<T> childNode;
        if (dNode.left != null) { //待删除节点只有一个子节点的case
            childNode = dNode.left;
        } else if (dNode.right != null) {
            childNode = dNode.right;
        } else {
            childNode = null;
        }
        if (dParentNode == null) {
            root = childNode;
        } else if (dParentNode.left == dNode) {
            dParentNode.left = childNode;
        } else {
            dParentNode.right = childNode;
        }
    }

    /**
     * 获取后继节点
     * @param node
     * @return
     */
    public TreeNode<T> getSuccessor(TreeNode<T> node) {
        if (node.right != null) {
            return min(node.right);
        }
        TreeNode<T> successor = null;
        TreeNode<T> curr = root;
        while (curr != null) {
            int k = curr.data.compareTo(node.data);
            if (k > 0) {
                successor = curr;
                curr = curr.left;
            } else if (k < 0) {
                curr = curr.right;
            } else {
                break;
            }
        }
        return successor;
    }

    /**
     * 获取前驱节点
     * @param node
     * @return
     */
    public TreeNode<T> getPredecessor(TreeNode<T> node) {
        if (node.left != null) {
            return max(node.left);
        }
        TreeNode<T> predecessor = null;
        TreeNode<T> curr = root;
        while (curr != null) {
            int k = curr.data.compareTo(node.data);
            if (k > 0) {
                curr = curr.left;
            } else if (k < 0) {
                predecessor = curr;
                curr = curr.right;
            } else {
                break;
            }
        }
        return predecessor;
    }

    public TreeNode<T> max(TreeNode<T> root) {
        if (root == null) {
            return null;
        }
        if (root.right == null) {
            return root;
        } else {
            return max(root.right);
        }
    }

    public TreeNode<T> min(TreeNode<T> root) {
        if (root == null) {
            return null;
        }
        if (root.left == null) {
            return root;
        } else {
            return min(root.left);
        }
    }

    private TreeNode<T> deleteMin(TreeNode<T> node) {
        if (node.left == null) {
            return node.right;
        }
        node.left = deleteMin(node.left);
        return node;
    }

}
