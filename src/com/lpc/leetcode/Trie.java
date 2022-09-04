package com.lpc.leetcode;

/**
 * 实现Trie树
 * <p>
 * 性质：
 * 1.Trie 的形状和单词的插入或删除顺序无关，也就是说对于任意给定的一组单词，Trie 的形状都是唯一的。
 * 2.查找或插入一个长度为 L 的单词，访问 next 数组的次数最多为 L+1，和 Trie 中包含多少个单词无关。
 * 3.Trie 的每个结点中都保留着一个字母表，这是很耗费空间的。如果 Trie 的高度为 n，字母表的大小为 m，最坏的情况是 Trie 中还不存在前缀相同的单词，那空间复杂度就为 O(m^n)
 *
 * @author byu_rself
 * @date 2022/9/4 20:24
 */
public class Trie {

    private Trie[] next;
    private boolean isEnd;

    public Trie() {
        next = new Trie[26];
        isEnd = false;
    }

    /**
     * 从根结点的子结点开始与 word 第一个字符进行匹配，一直匹配到前缀链上没有对应的字符，这时开始不断开辟新的结点，直到插入完 word 的
     * 最后一个字符，同时还要将最后一个结点isEnd = true;，表示它是一个单词的末尾。
     */
    public void insert(String word) {
        Trie node = this;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (node.next[c - 'a'] == null) {
                node.next[c - 'a'] = new Trie();
            }
        }
        node.isEnd = true;
    }

    /**
     * 从根结点的子结点开始，一直向下匹配即可，如果出现结点值为空就返回 false，如果匹配到了最后一个字符，那我们只需判断 node.isEnd即可。
     */
    public boolean search(String word) {
        Trie node = this;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (node.next[c - 'a'] == null) {
                return false;
            }
        }
        return node.isEnd;
    }

    /**
     * 和 search 操作类似，只是不需要判断最后一个字符结点的isEnd，因为既然能匹配到最后一个字符，那后面一定有单词是以它为前缀的。
     */
    public boolean startsWith(String prefix) {
        Trie node = this;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (node.next[c - 'a'] == null) {
                return false;
            }
        }
        return true;
    }
}
