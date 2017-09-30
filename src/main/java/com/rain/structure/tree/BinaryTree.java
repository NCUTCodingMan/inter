package com.rain.structure.tree;

public class BinaryTree {
    private Node root;
    
    private class Node {
        private int data;
        private Node left;
        private Node right;
        public Node(int data) {           
            this.data = data;
        }
    }
}