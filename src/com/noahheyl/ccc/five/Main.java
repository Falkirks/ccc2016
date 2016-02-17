//package com.noahheyl.ccc.five;


import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] garbage = sc.nextLine().split(" ");
        int n = Integer.parseInt(garbage[0]);
        long t = Long.parseLong(garbage[1]);
        String[] stateGarbage = sc.nextLine().split("");
        ArrayList<Boolean> state = new ArrayList<Boolean>(stateGarbage.length);
        for(int i = 0; i < stateGarbage.length; i++){
            state.add(stateGarbage[i].equals("1"));
        }

        for(int i = 0; i < t; i++){
            ArrayList<Boolean> newState = new ArrayList<Boolean>(state.size());
            newState.add(state.get(state.size() - 1) ^ state.get(1));
            for(int j = 1; j < state.size()-1; j++){
                newState.add(state.get(j-1) ^ state.get(j+1));
            }
            newState.add(state.get(state.size()-2) ^ state.get(0));

            state = newState;
            // If I was given time to test against the website, I would have checked if this helped performance
            //
            boolean dead = true;
            for(boolean check : newState){
                if(check){
                    dead = false;
                }
            }
            if(dead) break;
            //

        }
        String buffer = "";
        for(boolean i : state){
            buffer += (i ? "1" : "0");
        }
        System.out.println(buffer);
    }
    public static ArrayList<Boolean> cloneList(ArrayList<Boolean> list){
        ArrayList<Boolean> newList = new ArrayList<Boolean>();
        for(Boolean i : list){
            boolean newBool = i;
            newList.add(newBool);
        }
        return newList;
    }
}
