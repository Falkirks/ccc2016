//package com.noahheyl.ccc.one;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] orginal = sc.nextLine().toCharArray();
        char[] check = sc.nextLine().toCharArray();
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i = 0; i < orginal.length; i++){
            if(map.containsKey(orginal[i])){
                map.put(orginal[i], map.get(orginal[i])+1);
            }
            else{
                map.put(orginal[i], 1);
            }
        }
        int wildcards = 0;
        for(int i = 0; i < check.length; i++){
            if(check[i] == '*'){
                wildcards++;
            }
            else {
                if (map.containsKey(check[i])) {
                    if (map.get(check[i]) == 1) {
                        map.remove(check[i]);
                    } else {
                        map.put(check[i], map.get(check[i]) - 1);
                    }
                }
            }
        }
        int c = 0;
        for(Integer count : map.values()){
            c += count;
        }
        System.out.println((c == wildcards ? "A" : "N"));
    }
}
