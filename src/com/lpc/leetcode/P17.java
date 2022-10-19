package com.lpc.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Letter Combinations of a Phone Number
 *
 * @author byu_rself
 * @date 2022/5/23 18:17
 */
public class P17 {

    @Test
    public void solution() {
        String digits = "23";
        List<String> list = letterCombinations(digits);
        list.forEach(System.out::println);
    }

    List<String> list;

    public List<String> letterCombinations(String digits) {
        Map<Character, String> map = new HashMap<>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        list = new ArrayList<>();
        if (digits.equals("")) return list;
        backtrack(map, digits, 0, new StringBuilder());
        return list;
    }

    private void backtrack(Map<Character, String> map, String digits, int index, StringBuilder builder) {
        if (index == digits.length()) list.add(builder.toString());
        else {
            String s = map.get(digits.charAt(index));
            for (int i = 0; i < s.length(); i++) {
                backtrack(map, digits, index + 1, builder.append(s.charAt(i)));
                builder.deleteCharAt(index);
            }
        }
    }

    public List<String> letterCombinations1(String digits) {
        List<String> combinations = new ArrayList<String>();
        if (digits.length() == 0) {
            return combinations;
        }
        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        backtrack1(combinations, phoneMap, digits, 0, new StringBuffer());
        return combinations;
    }

    private void backtrack1(List<String> combinations, Map<Character, String> phoneMap, String digits,
                            int index, StringBuffer combination) {
        if (index == digits.length()) {
            combinations.add(combination.toString());
        } else {
            char digit = digits.charAt(index);
            String letters = phoneMap.get(digit);
            int lettersCount = letters.length();
            for (int i = 0; i < lettersCount; i++) {
                combination.append(letters.charAt(i));
                backtrack1(combinations, phoneMap, digits, index + 1, combination);
                combination.deleteCharAt(index);
            }
        }
    }
}
