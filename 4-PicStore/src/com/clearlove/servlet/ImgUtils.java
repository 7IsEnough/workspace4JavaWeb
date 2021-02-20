package com.clearlove.servlet;

import java.util.ArrayList;
import java.util.List;

/**
 * @author promise
 * @date 2020/12/27 - 14:41
 */
public class ImgUtils {

    // 保存所有的图片路径
    private static List<String> paths = new ArrayList<String>();

    public static void addImgPath(String path) {
        paths.add(path);
    }

    public static List<String> getAllPath() {
        return paths;
    }
}
