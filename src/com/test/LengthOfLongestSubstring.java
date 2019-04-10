package com.test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * 
 * 示例 1:
 * 
 * 输入: "abcabcbb" 输出: 3 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。 示例 2:
 * 
 * 输入: "bbbbb" 输出: 1 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。 示例 3:
 * 
 * 输入: "pwwkew" 输出: 3 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。 请注意，你的答案必须是 子串
 * 的长度，"pwke" 是一个子序列，不是子串。
 * 
 * @author duanzhiwei
 *         {@link https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/}
 */
public class LengthOfLongestSubstring {
    /**
     * 方案1，滑动窗口法
     * 
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int right = 0;
        char[] chars = s.toCharArray();
        // 当前左边界与右边界之间的子串，[left,right)
        Set<Character> subChars = new HashSet<>();
        // 左边界，从左向右遍历
        for (int left = 0; left < chars.length; left++) {
            // 右边界，以上一次的右边界为起点遍历
            for (int j = right; j < chars.length; j++) {
                // 如果当前字符出现在子串中，则停止本次遍历，否则将字符加入子串
                if (subChars.contains(chars[j])) {
                    break;
                } else {
                    subChars.add(chars[j]);
                }
            }
            // 记录本次遍历的右边界位置
            right = subChars.size() + left;
            // 如果本次遍历得到的子串长度超过上一次的最大值，则记录为最大值
            if (subChars.size() > max) {
                max = subChars.size();
            }
            // 每次左边界递增前，移除最左边的字符
            subChars.remove(chars[left]);
        }
        return max;
    }

    /**
     * 方案2，优化滑动窗口法
     * 
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring2(String s) {
        int res = 0;
        int left = 0;
        // 每个字符及其在字符串中的位置映射，有重复字符则会后者覆盖前者
        Map<Character, Integer> chars = new HashMap<>();
        for (int right = 0; right < s.length(); right++) {
            // 如果 s[j] 在 [i,j) 范围内有与 j′ 重复的字符，我们不需要逐渐增加 i 。
            // 我们可以直接跳过 [i，j′] 范围内的所有元素，并将 i 变为 j′+1。
            // 这样[j'+1,j)必然是不重复的
            if (chars.containsKey(s.charAt(right))) {
                // 考虑到形如abba的场景，这里取j'+1与当前左边界的最大值
                left = Math.max(chars.get(s.charAt(right)) + 1, left);
            }
            // 每次都计算当前子串的长度
            res = Math.max(res, right - left + 1);
            // 以key=字符,value=字符所在位置的形式保存映射
            chars.put(s.charAt(right), right);
        }
        return res;
    }
}
