package Day10;

import Utils.Lecture;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Day10 {

    private static void part2(int[] input) {
        final long[] sums = new long[input[input.length - 1] + 1];
        sums[0] = 1;
        for (int i = 0; i < input.length; i++) {
            long x = input[i] >= 3 ? sums[input[i] - 3] : 0;
            long y = input[i] >= 2 ? sums[input[i] - 2] : 0;
            long z = input[i] >= 1 ? sums[input[i] - 1] : 0;
            sums[input[i]] = x + y + z;
        }

        System.out.println(sums[sums.length - 1]);
    }

    public static void main(String args[]) {

        /* reading data part */

        ArrayList<Integer> input;
        ArrayList<Integer> inputTest;
        input = Lecture.lectureInt("./src/Day10/input.txt");
        inputTest = input;

        /* problem part */

        // PART 2

        final int[] list = new int[input.size()];
        for (int i = 0; i < list.length; i++) {
            list[i] = input.get(i);
        }

        Arrays.sort(list);
        part2(list);


        // PART 1

        /*
        int currentJolts = 0;
        int tmpJolts=0;
        int currentDifference = 0;
        int nbOne=0;
        int nbTwo=0;
        int nbThree=0;
        boolean end = false;

        Collections.sort(inputTest);
        for(int counter : inputTest) System.out.println(counter);

        while(!end){
            tmpJolts=currentJolts;
            for(int i = 0 ; i < input.toArray().length ; i++){
                if(input.get(i) > currentJolts && Math.abs(currentJolts-input.get(i))==3){
                    if(currentDifference != 2 && currentDifference != 1){
                        currentDifference = 3;
                    }
                }
                if(input.get(i) > currentJolts && Math.abs(currentJolts-input.get(i))==2){
                    if(currentDifference != 1){
                        currentDifference = 2;
                    }
                }
                if(input.get(i) > currentJolts && Math.abs(currentJolts-input.get(i))==1){
                    currentDifference = 1;
                }
            }
            switch(currentDifference){
                case 1:
                    currentJolts += 1;
                    nbOne++;
                    break;
                case 2:
                    currentJolts += 2;
                    nbTwo++;
                    break;
                case 3:
                    currentJolts += 3;
                    nbThree++;
                    break;
            }
            currentDifference=0;
            if(tmpJolts==currentJolts) end=true;
        }
        System.out.println("1="+nbOne+" 2="+nbTwo+" 3="+nbThree+"+1 1*3="+(nbOne*(nbThree+1)));

         */
    }

}
