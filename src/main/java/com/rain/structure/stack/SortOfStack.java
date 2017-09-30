package com.rain.structure.stack;

import java.util.Scanner;
import java.util.Stack;

/**
 * 使用辅助栈对栈排序(从打大小或者从小到大)
 * */
public class SortOfStack {
    private Stack<Integer> source;
    private Stack<Integer> consititue;
    
    public SortOfStack() {
        source = new Stack<Integer>();
        consititue = new Stack<Integer>();
    }
    
    public void push(Integer data) {
        source.push(data);
    }
    
    /**
     * 栈排序,时间复杂度相对而言较高
     * */
    public void sort() {
        while (!source.isEmpty()) {
            Integer top = source.pop();
            if (consititue.isEmpty()) {
                consititue.push(top);
            } else {
                if (top.compareTo(consititue.peek()) >= 0) {
                    consititue.push(top);
                } else {
                    while (!consititue.isEmpty()) {
                        source.push(consititue.pop());
                    }
                    consititue.push(top);
                }
            }
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        SortOfStack sortOfStack = new SortOfStack();
        int n = scanner.nextInt();
        for (int i = 0;i < n;i ++) {
            sortOfStack.push(scanner.nextInt());
        }
        
        sortOfStack.sort();
        System.out.println(sortOfStack.consititue);
        
        scanner.close();
    }
}