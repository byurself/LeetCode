package com.lpc.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * TinyURL的加密与解密
 *
 * @author byu_rself
 * @date 2023/7/5 9:43
 */
public class P535 {

    String s = "1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    int k = 6;
    Map<String, String> originToTinyMap = new HashMap<>(), tinyToOriginMap = new HashMap<>();
    Random random = new Random();
    String prefix = "https://byurself.github.io/";

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        while (!originToTinyMap.containsKey(longUrl)) {
            char[] cs = new char[k];
            for (int i = 0; i < k; ++i) {
                cs[i] = s.charAt(random.nextInt(s.length()));
            }
            String cur = prefix + String.valueOf(cs);
            // 已经存在，重新生成
            if (tinyToOriginMap.containsKey(cur)) continue;
            originToTinyMap.put(longUrl, cur); // 保证相同的 longUrl 多次调用，确保 encode 服务的 幂等性
            tinyToOriginMap.put(cur, longUrl);
        }
        System.out.println(originToTinyMap.get(longUrl));
        return originToTinyMap.get(longUrl);
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return tinyToOriginMap.get(shortUrl);
    }
}
