package com.lpc.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 删除子文件夹
 *
 * @author byu_rself
 * @date 2023/2/8 14:17
 */
public class P1233 {

    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);
        List<String> list = new ArrayList<>();
        list.add(folder[0]);
        for (int i = 1; i < folder.length; i++) {
            StringBuilder builder = new StringBuilder(list.get(list.size() - 1)).append("/");
            if (!folder[i].startsWith(builder.toString())) list.add(folder[i]);
        }
        return list;
    }
}
