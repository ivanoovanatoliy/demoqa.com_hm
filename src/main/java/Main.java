package ru.ibs;

import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args) {
        // Задание 0
        int firstInt = 9;
        int secondInt = 4;
        System.out.println(firstInt+secondInt);
        System.out.println(firstInt-secondInt);
        System.out.println(firstInt*secondInt);
        System.out.println(firstInt/secondInt);

        //Задание 1
        double firstDouble = 2.1;
        System.out.println(firstInt-firstDouble);
        System.out.println(firstInt*firstDouble);

        //Задание 2
        System.out.println(firstInt > secondInt);
        System.out.println(firstDouble < secondInt);
        System.out.println(firstInt >= firstDouble);
        System.out.println(firstDouble <= 3);

        //Задание 4
        int maxInt = Integer.MAX_VALUE;
        int minInt = Integer.MIN_VALUE;
        double maxDouble = Double.MAX_VALUE;
        double minDouble = Double.MIN_VALUE;

        System.out.println(maxInt + 1);
        System.out.println(minInt - 1);
        System.out.println(maxDouble + 10);
        System.out.println(minDouble - 10);

    }
}