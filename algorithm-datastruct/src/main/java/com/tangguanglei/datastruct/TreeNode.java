package com.tangguanglei.datastruct;

public class TreeNode<T extends Comparable<T>> {

    public T data;

    public int height = 1;

    public TreeNode<T> left;

    public TreeNode<T> right;

    public TreeNode() {}

    public TreeNode(T data) {
        this.data = data;
    }

    public TreeNode(T data, TreeNode<T> left, TreeNode<T> right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}
