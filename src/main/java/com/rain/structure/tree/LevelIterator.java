package com.rain.structure.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelIterator {
    /**
     * 实现层次遍历,并求最大和的层
     *  在写代码的时候,出现了两个错误
     *  1.关于clear(),由于直接将引用放入到ArrayList中;导致对原引用的修改会反馈到ArrayList
     *  2.对Queue不熟悉,基本的API并不熟练
     *  3.树遍历的过程中可以添加各种各样的操作;但是遍历的模板基本不变
     * @param node 根节点
     */
    public static int level(Node node) {
        if (node == null) {
            return 0;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        int start = 0;
        int end = 0;
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        while (!queue.isEmpty()) {
            List<Integer> digit = new ArrayList<Integer>();
            end = queue.size();
            while (start < end) {
                Node iterator = queue.poll();
                int data = iterator.getData();
                digit.add(data);
                if (iterator.left != null) {
                    queue.offer(iterator.left);
                }
                if (iterator.right != null) {
                    queue.offer(iterator.right);
                }
                start++;
            }
            result.add(digit);
            start = 0;
        }

        int max = 0;
        for (int i = 0; i < result.size(); i ++) {
            if (max < caculate(result.get(i))) {
                max = caculate(result.get(i));
            }
        }

        return max;
    }

    static class Node {
        private Integer data;
        private Node left;
        private Node right;

        public Node() {

        }

        public Node(Integer data, Node left, Node right) {
            super();
            this.data = data;
            this.left = left;
            this.right = right;
        }

        public Integer getData() {
            return data;
        }

        public void setData(Integer data) {
            this.data = data;
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
    }

    public static int caculate(List<Integer> list) {
        int sum = 0;
        for (int i = 0; i < list.size(); i ++) {
            sum += list.get(i);
        }
        return sum;
    }

    public static void main(String[] args) {
        Node a = new Node();
        a.setData(1);
        Node b = new Node();
        b.setData(2);
        Node c = new Node();
        c.setData(3);
        Node d = new Node();
        d.setData(4);
        Node e = new Node();
        e.setData(5);
        Node f = new Node();
        f.setData(6);

        a.setLeft(b);
        a.setRight(c);
        b.setLeft(d);
        b.setRight(e);
        c.setLeft(f);

        System.out.println(level(a));
    }
}
