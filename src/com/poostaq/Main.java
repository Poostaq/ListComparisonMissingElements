package com.poostaq;

import com.sun.deploy.util.SystemUtils;

import java.lang.String;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args)
    {
        //Zadanko 1
        List<String> firstList = Arrays.asList("aaa", "bbb", "ccc", "xxx");
        List<String> secondList = Arrays.asList("bbb","ccc","ddd", "yyy");
        compareLists(firstList, secondList);

        //Zadanko 2
        String task2String = "aaa,bbb,ccc,ddd,aaa,bbb,ccc,www,ddd,aaa,ccc,bbb,aaa,ccc,bbb,aaa";
        List<String> listToPrint = stringToList(task2String);
        for(String string : listToPrint){
            System.out.print(string + " ");
        }
        System.out.print("\n");

        //Zadanko 3
        HashMap<String, Integer> MapTask3 = new HashMap<>();
        MapTask3.put("A", 0);
        MapTask3.put("B", 0);
        MapTask3.put("C", 0);
        MapTask3.put("D", 0);
        MapTask3.put("E", 1);
        MapTask3.put("F", 1);
        MapTask3.put("G", 1);
        MapTask3.put("H", 2);
        MapTask3.put("I", 2);
        String[] results = processMap(MapTask3);
        System.out.print(results[0] + " \n" + results[1]);
    }

    private static void compareLists(List<String> list1, List<String> list2)
    {
        String list2missing = list1.stream()
                .filter(s -> !list2.contains(s))
                .collect(Collectors.joining(", "));
        String list1missing = list2.stream()
                .filter(s -> !list1.contains(s))
                .collect(Collectors.joining(", "));
        System.out.format("W liscie 1 brakuje wartosci %s z listy 2, a w liscie 2 brakuje wartosci %s z listy 1. \n", list1missing, list2missing);
    }

    private static List<String> stringToList(String baseString)
    {
        //nie wiem gdzie lambdę tu zrobić :P
        return Arrays.stream(baseString.split(",")).collect(Collectors.toList());
    }

    private static String[] processMap(Map<String, Integer> processedMap)
    {
        String[] result = {"",""};
        processedMap.values().stream().distinct().forEach(v ->
        {
            result[0] += v.toString() + ";";
            long count = processedMap.values().stream().filter(s -> s.equals(v)).count();
            if (count > 1)
                //result[1] += "(" + v + ":" + count + ") ";   ###OLD CODE###
                result[1] += String.format("(%d:%d),",v, count);
        });
        return result;
    }
}
