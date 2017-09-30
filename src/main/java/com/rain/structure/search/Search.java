package com.rain.structure.search;

public class Search {
    /**
     * 无需判断数组是否越界,哨兵减少了代码的编写量
     *  传统的for循环需要写一定的代码
     * */
    public static <T> boolean sequenceSearch(T[] t, T target) {
        if (t == null) {
            return false;
        }
        t[0] = target;
        int i;
        for (i = t.length - 1;t[i] != target;i --);
        return i == 0 ? false : true;
    }
    
    /**
     * 折半查找
     * */
    public static boolean binarySearch(Integer[] t, Integer target) {
        if (t == null) {
            return false;
        }
        int low = 0;
        int high = t.length - 1;
        int mid = (low + high) / 2;
        while (low <= high) {
            if (t[mid].compareTo(target) == 0) {
                return true;
            }
            if (t[mid].compareTo(target) > 0) {
                high = mid - 1;
            }
            if (t[mid].compareTo(target) < 0) {
                low = mid + 1;
            }
            mid = (low + high) / 2;
        }
        return false;
    }
    
    public static void main(String[] args) {
        System.out.println(binarySearch(new Integer[]{1, 2, 3, 4, 5, 6, 6, 7, 10}, 11));
    }
}
