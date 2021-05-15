package com.epoint.wxszsjh.function_learn;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CompanyProcess1 {
    //假设我们有一个名字列表，其中一些条目由单个字符构成。现在的任务是，将除去单字符条目之外的列表内容，放在一个逗号分隔的字符串里返回，
    // 且每个名字的首字母都要大写
    //思路 1、出去单字符的内容；2、首字母大写拼装返回
    public String cleanNames(List<String> listOfNames) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < listOfNames.size(); i++) {
            if (listOfNames.get(i).length() > 1) {
                result.append(upFirst(listOfNames.get(i)) + ",");
            }
        }

        return result.substring(0, result.length() - 1).toString();
    }

    private String upFirst(String s) {
        return s.substring(0, 1).toUpperCase() + s.substring(1, s.length());
    }

    public String cleanNames2(List<String> listOfNames) {
        if (listOfNames == null) {
            return null;
        } else {
            return listOfNames.stream()
                    .filter(name -> name.length() > 1)
                    .map(name -> upFirst(name))
                    .collect(Collectors.joining(","));
        }
    }

    public String cleanNames3(List<String> listOfNames) {
        if (listOfNames == null) return null;
        return listOfNames.parallelStream()
                .filter(name -> name.length() > 1)
                .map(name -> upFirst(name))
                .collect(Collectors.joining(","));

    }

    public static void main(String[] args) {
        CompanyProcess1 cp1 = new CompanyProcess1();
        List<String> nameList = new ArrayList() {
            {
                add("ads");
                add("a");
                add("fdsf");
                add("s");
            }
        };
       /* long begin = System.currentTimeMillis();
        System.out.println(cp1.cleanNames2(nameList));
        long end = System.currentTimeMillis();
        System.out.println(end - begin);*/
        /*Optional res = nameList.stream().reduce((acc, item) -> {
            System.out.println("acc : " + acc);
            acc += item;
            System.out.println("item: " + item);
            System.out.println("acc+ : " + acc);
            System.out.println("--------");
            return acc;
        });
        System.out.println(res);*/
        Stream.of(1,2,3).map(s->{System.out.println(++s);return s++;}).forEach(System.out::println);
    }
}
