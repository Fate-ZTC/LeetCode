package com.lqkj.demo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @ClassName Solution
 * @Description TODO
 * @Author Administrator
 * @Date 2019/11/25 11:29
 * @Version 1.0
 **/
public class Solution {
    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        /*String test = "abcdeadefghj";
        int result = lengthOfLongestSubstring(test);
        System.out.println(result);*/

        /*String s = "LEETCODEISHIRING";
        String convert = convert(s, 2);
        System.out.println(convert);*/

        /*int reverse = reverse(964632435);
        System.out.println(reverse);*/
        int i = maxArea(new int[]{1, 1});
        System.out.println(i);
    }

    public static String convert(String s, int numRows) {
        if (numRows == 1) return s;

        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++)
            rows.add(new StringBuilder());
        int curRow = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            rows.get(curRow).append(c);
            if (curRow == 0 || curRow == numRows - 1) goingDown = !goingDown;
            curRow += goingDown ? 1 : -1;
        }

        StringBuilder ret = new StringBuilder();
        for (StringBuilder row : rows) ret.append(row);
        return ret.toString();
    }

    public static int reverse(int x) {
        String s = String.valueOf(x);
        char c = s.charAt(0);
        //对负数进行处理
        int maxValue = Integer.MAX_VALUE / 10;
        int minValue = Integer.MIN_VALUE / 10;
        if (c == '-') {
            s = s.substring(1, s.length());
        }
        Double aDouble = Double.valueOf(s);
        if (aDouble >= maxValue || aDouble <= minValue) {
            return 0;
        }
        char[] a = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            a[i] = s.charAt(s.length() -1 - i);
        }
        return Integer.valueOf(c == '-' ? String.valueOf(c) + String.valueOf(a) :String.valueOf(a));

        /*int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;*/
    }


    public static int maxArea(int[] height) {
        if (height == null || height.length == 1) {
            return 0;
        }
        int x = 0;
        int y = height.length - 1;
        int maxArea = 0;
        //假设最大面积为
        maxArea = Math.min(height[0], height[height.length - 1]) * (y - x);
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int i1 = Math.min(height[i], height[j]) * (j - i);
                if (maxArea < i1) {
                    maxArea = i1;
                }
            }
        }
        return maxArea;
    }
}
