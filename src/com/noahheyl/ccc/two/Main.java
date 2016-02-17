//package com.noahheyl.ccc.two;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean questionOne = (sc.nextInt() == 1);
        int n = sc.nextInt();
        sc.nextLine();
        String[] cityOneString = sc.nextLine().split(" ");
        ArrayList<Integer> cityOne = new ArrayList<Integer>();
        for(String str : cityOneString){
            cityOne.add(Integer.parseInt(str));
        }

        String[] cityTwoString = sc.nextLine().split(" ");
        ArrayList<Integer> cityTwo = new ArrayList<Integer>();
        for(String str : cityTwoString){
            cityTwo.add(Integer.parseInt(str));
        }

        cityOne.sort(new IntCompare());
        cityTwo.sort(new IntCompare());

        int speed = 0;
        if(questionOne){
            for(int i = 0; i < n; i++){
                speed += Math.max(cityOne.get(i), cityTwo.get(i));
            }
        }
        else{
            for(int i = 0; i < n; i++){
                speed += Math.max(cityOne.get(i), cityTwo.get(n - 1 - i));
            }
        }
        System.out.println(speed);
    }
    static public class IntCompare implements Comparator<Integer>{
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1.compareTo(o2);
        }
    }
}
