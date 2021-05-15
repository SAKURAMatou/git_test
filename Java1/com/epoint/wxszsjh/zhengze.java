package com.epoint.wxszsjh;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author 作者:dailin
 * @version 创建时间：2020年12月15日 下午2:51:46
 * 
 */

public class zhengze
{
    public static void main(String[] args) {
        String content = "<p style=\"-webkit-tap-highlight-color: transparent;\">四、上班地址：<br /></p>"
                + "<img width=\"500\" height=\"282\" title=\"\" alt=\"\" style=\"width: 500px; height: 282px;\" />";
        String rex = "(<img.*)style=\".*\"";
        Pattern pattern = Pattern.compile(rex);
        Matcher matcher = pattern.matcher(content);
        // content = matcher.replaceAll("$1");
        // content.replaceAll(rex, "$1");
        int count = 0;
        System.out.println(matcher.groupCount());
        while (matcher.find()) {
            count++;
            System.out.println("组：" + matcher.group(count));

        }
        // System.out.println(content);
    }

}
