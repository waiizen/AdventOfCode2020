package Day2;

import Utils.Lecture;
import java.util.ArrayList;

public class Day2 {
    public static void main(String args[]){

        /* read data part */
        ArrayList<String> input;
        input = Lecture.lectureString("./src/Day2/input.txt");

        /* problem part */

        // PART 2

        int result = 0;
        int stock = 0;
        String[] parts;
        String[] number1;
        String[] number2;

        // parts number ok
        // comparaison char et string
        for(int i = 0 ; i < input.toArray().length ; i++){
            parts = input.get(i).split(":");
            number1 = parts[0].split("-");
            number2 = number1[1].split(" ");

            if(parts[1].charAt(Integer.parseInt(number1[0])) == number2[1].charAt(0)
                    && (parts[1].charAt(Integer.parseInt(number2[0])) != number2[1].charAt(0))
                    || parts[1].charAt(Integer.parseInt(number1[0])) != number2[1].charAt(0)
                    && (parts[1].charAt(Integer.parseInt(number2[0])) == number2[1].charAt(0))){
                result ++;
            }
        }
        System.out.println(result);

        // PART 1
        /*
        int result = 0;
        int stock = 0;
        String[] parts;
        String[] number1;
        String[] number2;

        // parts number ok
        // comparaison char et string
        for(int i = 0 ; i < input.toArray().length ; i++){
            parts = input.get(i).split(":");
            number1 = parts[0].split("-");
            number2 = number1[1].split(" ");
            for(int y = 1 ; y < parts[1].length() ; y++) {
                if(parts[1].charAt(y) == number2[1].charAt(0)){
                    stock++;
                }
            }
            if(( Integer.parseInt(number1[0]) <= stock) && (stock <= Integer.parseInt(number2[0]))){
                result++;
            }
            stock = 0;
        }
        System.out.println(result);

         */
    }
}
