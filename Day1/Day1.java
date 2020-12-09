import java.io.File;
import java.util.ArrayList;

public class Day1 {
    public static void main(String args[]){
        /* get data from input file */
        ArrayList<Integer> input = new ArrayList<>();
        input = Lecture.lecture("./src/input.txt");

        /* start */

        // PART 2

        int sumRes = 0;
        int y = 0;
        while(sumRes != 2020) {
            for(int i = y+1 ; i < input.toArray().length ; i++){
                for(int j = i+1 ; j < input.toArray().length ; j++){
                    if(input.get(y)+input.get(i)+input.get(j) == 2020){
                        System.out.println(input.get(y) + " " + input.get(i) + " " + input.get(j));
                        System.out.println(input.get(y) * input.get(i) * input.get(j));
                        break;
                    }
                }
            }
            y++;
        }

        // PART 1
        /*
        int sumRes = 0;
        int y = 0;
        while(sumRes != 2020) {
            for(int i = y+1 ; i < input.toArray().length ; i++){
                if(input.get(y)+input.get(i) == 2020){
                    sumRes = 2020;
                    System.out.println(input.get(y) + " " + input.get(i));
                    System.out.println(input.get(y) * input.get(i));
                    break;
                }
            }
            y++;
        }
        */
    }
}
