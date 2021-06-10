package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.insert(1);
        solution.insert(2);
        solution.insert(3);
        solution.insert(4);
        solution.insert(5);
        solution.insert(6);
        solution.insert(7);
        solution.insert(8);
        solution.prinTheSum();
    }
}
class Solution {
    Node root;
    public void insert(int key)  {
        root = insert_Recursive(root, key);
    }

    public Node insert_Recursive(Node root, int key) {
        //tree is empty
        if (root == null) {
            root = new Node(key);
            return root;
        }
        //traverse the tree
        if (key < root.val)     //insert in the left subtree
            root.left = insert_Recursive(root.left, key);
        else if (key > root.val)    //insert in the right subtree
            root.right = insert_Recursive(root.right, key);
        // return pointer
        return root;
    }
    List<Integer> binaryTree = new ArrayList<>();
    public void deepest(Node root, int n){
        if (binaryTree.size() == n) {
            binaryTree.add(root.val);
        } else {
            binaryTree.set(n, binaryTree.get(n) + root.val);
        }
        if (null != root.left) {
            deepest(root.left, n + 1);
        }
        if (root.right != null) {
            deepest(root.right, n + 1);
        }
    }

    public int Sum (Node root){
        deepest(root, 0);
        return binaryTree.get(binaryTree.size() - 1);
    }
    public void prinTheSum() {
        Sum(root);
    }

}
class Node {
    int val;
    Node left;
    Node right;

    Node() {
    }

    Node(int val) {
        this.val = val;
    }

    Node(int val, Node left, Node right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
