package com.tangguanglei.datastruct.tree;

import com.tangguanglei.datastruct.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 二叉树
 * @param <T>
 */
public class BinaryTree<T extends Comparable<T>> {

    private TreeNode<T> root;

    public BinaryTree(TreeNode<T> root) {
        this.root = root;
    }

    /**
     * 前序遍历
     * @param node
     */
    public void preOrder(TreeNode<T> node) {
        if (node == null) {
            return;
        }
        System.out.println(node);
        preOrder(node.left);
        preOrder(node.right);
    }

    public void preOrderWithStack(TreeNode<T> node) {
        Stack<TreeNode<T>> stack = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()) {
            node = stack.pop();
            System.out.println(node);
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
     * @param node
     */
    public void inOrder(TreeNode<T> node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.println(node);
        inOrder(node.right);
    }

    public void inOrderWithStack(TreeNode<T> root) {
        Stack<TreeNode<T>> stack = new Stack<>();
        TreeNode<T> node = root;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            TreeNode<T> n = stack.pop();
            System.out.println(n);
            node = n.right;
        }
    }

    /**
     * 后序遍历
     * @param node
     */
    public void postOrder(TreeNode<T> node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node);
    }

    public void  postOrderWithStack(TreeNode<T> node) {
        Stack<TreeNode<T>> stack1 = new Stack<>();
        Stack<TreeNode<T>> stack2 = new Stack<>();
        stack1.push(node);
        while (!stack1.isEmpty()) {
            TreeNode<T> n = stack1.pop();
            stack2.push(n);
            if (n.left != null) {
                stack1.push(n.left);
            }
            if (n.right != null) {
                stack1.push(n.right);
            }
        }
        while (!stack2.isEmpty()) {
            TreeNode<T> n = stack2.pop();
            System.out.println(n);
        }
    }

    /**
     * 层次遍历
     * @param node
     */
    public void levelOrder(TreeNode<T> node) {
        Queue<TreeNode<T>> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            node = queue.poll();
            System.out.println(node);
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
    }

}
