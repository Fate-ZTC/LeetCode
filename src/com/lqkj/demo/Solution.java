package com.lqkj.demo;

import java.util.HashSet;
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
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        /*String test = "abcdeadefghj";
        int result = lengthOfLongestSubstring(test);
        System.out.println(result);*/

        String s = "LEETCODEISHIRING";
        convert(s, 2);
    }

    public static String convert(String s, int numRows) {
        //得到字符串长度
        int length = s.length();
        char[] chars = s.toCharArray();
        //构成指定的Z需要的字符个数
        int i = 2 * numRows + (numRows - 2);
        if(length <= numRows) {
            return s;
        }
        else if(i < length) {

        }
        return null;
    }
}
