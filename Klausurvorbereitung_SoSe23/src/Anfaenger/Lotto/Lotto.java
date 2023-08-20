package Anfaenger.Lotto;

import java.util.TreeSet;

public class Lotto {

    public static int ziehen(){
        Integer zahl = (int) (Math.random() * 49 + 1);
        return zahl;
    }

    public static void main(String[] args){
        TreeSet<Integer> set = new TreeSet<>();
        while (set.size() <= 5){
            int index = ziehen();
            if(set.isEmpty() || index != set.last()){
                set.add(index);
            }
        }
        for (Integer i : set){
            System.out.println(i);
        }
    }
}
