package com.poostaq;

import java.lang.String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args)
    {
        List<String> listaPierwsza = Arrays.asList("aaa", "bbb", "ccc", "xxx");
        List<String> listaDruga = Arrays.asList("bbb","ccc","ddd", "yyy");
        compareLists(listaPierwsza, listaDruga);
        String task2String = "aaa,bbb,ccc,ddd,aaa,bbb,ccc,www,ddd,aaa,ccc,bbb,aaa,ccc,bbb,aaa";
        List<String> listToPrint = stringToList(task2String);
        for(String string : listToPrint){
            System.out.print(string + " ");
        }
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
}
