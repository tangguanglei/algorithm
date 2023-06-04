package com.tangguanglei.datastruct.tree;

import com.tangguanglei.datastruct.TreeNode;

/**
 * 二叉查找树(BST)
 */
public class BinarySearchTree<T extends Comparable<T>> {

    private TreeNode<T> root;

    public BinarySearchTree(TreeNode<T> root) {
        this.root = root;
    }

}
