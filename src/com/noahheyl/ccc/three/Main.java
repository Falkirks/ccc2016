//package com.noahheyl.ccc.three;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

/**
 * THIS DOESN'T WORK AT ALL
 * HAHAHHAHAHAHAHAHAHAHA
 * SOOOOOOOOOO FUNNY
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] garbageOne = sc.nextLine().split(" ");
        int n = Integer.parseInt(garbageOne[0]);
        int m = Integer.parseInt(garbageOne[1]);

        String[] garbageTwo = sc.nextLine().split(" ");
        ArrayList<Integer> pho = new ArrayList<Integer>();

        for(int i = 0; i < garbageTwo.length; i++){
            pho.add(Integer.parseInt(garbageTwo[i]));
        }

        HashMap<Integer, ArrayList<Integer>> places = new HashMap<Integer, ArrayList<Integer>>();
        for(int i = 1; i < n; i++){
            String[] garbageThree = sc.nextLine().split(" ");
            int a = Integer.parseInt(garbageThree[0]);
            int b = Integer.parseInt(garbageThree[1]);
            if(!places.containsKey(a)) places.put(a, new ArrayList<Integer>());
            places.get(a).add(b);

            if(!places.containsKey(b)) places.put(b, new ArrayList<Integer>());
            places.get(b).add(a);
        }
        ArrayList<Integer> results = new ArrayList<Integer>(n);
        for(int i = 0; i < n; i++){
            int path = findPath(places, pho, new ArrayList<Integer>(), i);
            if(path != -1) {
                results.add(path);
            }
        }
        results.sort(new IntCompare());
        System.out.println(results.get(0));


    }
    public static int findPath(HashMap<Integer, ArrayList<Integer>> places, ArrayList<Integer> targets, ArrayList<Integer> visited, int current){
        visited.add(current);
        ArrayList<Integer> list = cloneList(targets);
        list.removeAll(visited);

        if(list.isEmpty()){
            return visited.size();
        }

        ArrayList<Integer> paths = new ArrayList<Integer>();

        for(int possibleRoute : places.get(current)){
            if(!visited.contains(possibleRoute)){
                paths.add(findPath(places, targets, visited, possibleRoute));
            }
        }

        for(int possibleRoute : places.get(current)){
            if(visited.contains(possibleRoute)){
                paths.add(findPath(places, targets, visited, possibleRoute));
            }
        }

        paths.sort(new IntCompare());
        return paths.get(0);

    }
    public static ArrayList<Integer> cloneList(ArrayList<Integer> list){
        ArrayList<Integer> newList = new ArrayList<Integer>();
        for(Integer i : list){
            int newInt = i;
            newList.add(newInt);
        }
        return newList;
    }
    static public class IntCompare implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1.compareTo(o2);
        }
    }

}

