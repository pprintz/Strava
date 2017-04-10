package com.company;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static class Swipe{
        public int x1;
        public int x2;
        public int y1;
        public int y2;
    }
    public static void main(String[] args) throws IOException {
        Scanner s  = new Scanner(System.in);
        ArrayList<Swipe> swipes = new ArrayList<>();
        int numberOfSwipes = Integer.parseInt(s.nextLine());
        for ( int i = 0 ; i < numberOfSwipes; i++){
            String[] array = s.nextLine().split(" ");
            swipes.add(new Swipe()
            {
                {
                    x1 = Integer.parseInt(array[0]);
                    x2 = Integer.parseInt(array[1]);
                    y1 = Integer.parseInt(array[2]);
                    y2 = Integer.parseInt(array[3]);
                }
            });
        }
        int size = swipes.size();
        for(int j = 0 ; j < size; j ++){
            Swipe xD = swipes.get(j);
            }
        }

    }
}
