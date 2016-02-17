//package com.noahheyl.ccc.four;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String[] garbage = sc.nextLine().split(" ");
        ArrayList<Integer> balls = new ArrayList<Integer>();
        for(int i = 0; i < garbage.length; i++){
            balls.add(Integer.parseInt(garbage[i]));
        }
        System.out.println(findBestPossibleMove(balls));

    }
    static public int findBestPossibleMove(ArrayList<Integer> balls){
        ArrayList<Integer> results = new ArrayList<Integer>();
        for(int i = 0; i < balls.size(); i++){
            //System.out.println(i);
            if(i-2 > 0 && balls.get(i-2).equals(balls.get(i))){
                //System.out.println("-2 >>");
                ArrayList<Integer> clone = cloneList(balls);
                clone.set(i, balls.get(i) + balls.get(i-1) + balls.get(i-2));
                clone.remove(i-1);
                clone.remove(i-1); //We have shifted left
                results.add(findBestPossibleMove(clone));
            }
            if(i-1 > 0 && balls.get(i-1).equals(balls.get(i))){
                //System.out.println("-1 >>");
                ArrayList<Integer> clone = cloneList(balls);
                clone.set(i, balls.get(i) + balls.get(i-1));
                clone.remove(i-1);
                results.add(findBestPossibleMove(clone));
            }
            if(i+1 < balls.size() && balls.get(i+1).equals(balls.get(i))){
                //System.out.println("+1 >>");
                ArrayList<Integer> clone = cloneList(balls);
                clone.set(i, balls.get(i) + balls.get(i+1));
                clone.remove(i+1);
                results.add(findBestPossibleMove(clone));
            }
            if(i+2 < balls.size() && balls.get(i+2).equals(balls.get(i))){
                //System.out.println("+2 >>");
                ArrayList<Integer> clone = cloneList(balls);
                clone.set(i, balls.get(i) + balls.get(i+2) + balls.get(i+1));
                clone.remove(i+2);
                clone.remove(i+1);
                results.add(findBestPossibleMove(clone));
            }
        }
        if(results.size() == 0){
            balls.sort(new IntCompare());
            return balls.get(balls.size()-1);
        }
        results.sort(new IntCompare());
        return results.get(results.size()-1);
    }
    public static Integer[] moveWillBecome(int index, ArrayList<Integer> balls){
        Integer[] out = new Integer[]{-1, -1, -1, -1};
        if(index - 2 > 0 && balls.get(index-2).equals(balls.get(index))){
            out[0] = balls.get(index) + balls.get(index-1) + balls.get(index-2);
        }
        if(index - 1 > 0 && balls.get(index-1).equals(balls.get(index))){
            out[1] = balls.get(index) + balls.get(index-1);
        }
        if(index + 1 < balls.size() && balls.get(index+1).equals(balls.get(index))){
            out[2] = balls.get(index) + balls.get(index+1);
        }
        if(index + 2 < balls.size() && balls.get(index+2).equals(balls.get(index))){
            out[3] = balls.get(index) + balls.get(index+1) + balls.get(index+2);
        }
        return out;
    }
    static public class IntCompare implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1.compareTo(o2);
        }
    }
    public static ArrayList<Integer> cloneList(ArrayList<Integer> list){
        ArrayList<Integer> newList = new ArrayList<Integer>();
        for(Integer i : list){
            int newInt = i;
            newList.add(newInt);
        }
        return newList;
    }
}
