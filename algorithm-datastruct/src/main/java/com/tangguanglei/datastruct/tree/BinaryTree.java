package com.tangguanglei.datastruct.tree;

import com.tangguanglei.datastruct.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 二叉树
 * @param <T>
 */
public class BinaryTree<T extends Comparable<T>> {

    protected TreeNode<T> root;

    public BinaryTree(TreeNode<T> root) {
        this.root = root;
    }

    /**
     * 前序遍历
     * @param root
     */
    public void preOrder(TreeNode<T> root) {
        if (root == null) {
            return;
        }
        System.out.println(root);
        preOrder(root.left);
        preOrder(root.right);
    }

    public void preOrderWithStack(TreeNode<T> root) {
        if (root == null) {
            return;
        }

        Stack<TreeNode<T>> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode<T> node = stack.pop();
            System.out.print(node.data + " ");

            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
    }

    /**
     * 中序遍历
     * @param root
     */
    public void inOrder(TreeNode<T> root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.println(root);
        inOrder(root.right);
    }

    public void inOrderWithStack(TreeNode<T> root) {
        if (root == null) {
            return;
        }

        Stack<TreeNode<T>> stack = new Stack<>();
        TreeNode<T> node = root;

        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }

            node = stack.pop();
            System.out.print(node.data + " ");
            node = node.right;
        }
    }

    /**
     * 后序遍历
     * @param root
     */
    public void postOrder(TreeNode<T> root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root);
    }

    public void  postOrderWithStack(TreeNode<T> root) {
        if (root == null) {
            return;
        }

        Stack<TreeNode<T>> stack1 = new Stack<>();
        Stack<TreeNode<T>> stack2 = new Stack<>();
        stack1.push(root);

        while (!stack1.isEmpty()) {
            TreeNode<T> node = stack1.pop();
            stack2.push(node);

            if (node.left != null) {
                stack1.push(node.left);
            }
            if (node.right != null) {
                stack1.push(node.right);
            }
        }

        while (!stack2.isEmpty()) {
            System.out.print(stack2.pop().data + " ");
        }
    }

    /**
     * 层次遍历
     * @param root
     */
    public void levelOrder(TreeNode<T> root) {
        if (root == null) {
            return;
        }

        Queue<TreeNode<T>> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode<T> node = queue.poll();
            System.out.println(node);
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
    }

    public void deepOrder(TreeNode<T> root) {
        if (root == null) {
            return;
        }
        Deque<TreeNode<T>> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode<T> node = stack.pop();
            System.out.println(node);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
    }
}
