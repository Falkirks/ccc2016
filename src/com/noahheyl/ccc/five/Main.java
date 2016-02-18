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
        boolean[] state = new boolean[stateGarbage.length];
        boolean[] state2 = new boolean[stateGarbage.length];
        for(int i = 0; i < stateGarbage.length; i++){
            state[i] = stateGarbage[i].equals("1");
        }
        boolean isTwo = false;
        for(long i = 0; i < t; i++){

            if(!isTwo){
                //System.out.println("shift 2");
                state2[0] = state[state.length-1] ^ state[1];
                for(int j = 1; j < state.length-1; j++){
                    state2[j] = state[j-1] ^ state[j+1];
                }
                state2[state.length-1] = state[state.length-2] ^ state[0];
                isTwo = true;
            }
            else{
                //System.out.println("shift 1");
                state[0] = state2[state.length-1] ^ state2[1];
                for(int j = 1; j < state2.length-1; j++){
                    state[j] = state2[j-1] ^ state2[j+1];
                }
                state[state.length-1] = state2[state.length-2] ^ state2[0];
                isTwo = false;
            }

            // If I was given time to test against the website, I would have checked if this helped performance
            //
            boolean dead = true;
            for(boolean check : (isTwo ? state2 : state)){
                if(check){
                    dead = false;

                }
            }
            if(dead){
                //System.out.println("dead");
                break;
            }
            //

        }
        if(!isTwo){
            //System.out.println("print 1");
            for(boolean i : state){
                System.out.print(i ? "1" : "0");
            }
        }
        else{
            //System.out.println("print 2");
            for(boolean i : state2){
                System.out.print(i ? "1" : "0");
            }
        }

        System.out.println();
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
