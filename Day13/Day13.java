package Day13;

import Utils.Lecture;
import javafx.beans.binding.IntegerBinding;

import java.util.ArrayList;

public class Day13 {

    public static void main(String args[]) {

        /* reading data part */

        ArrayList<String> input;
        input = Lecture.lectureString("./src/Day13/input.txt");

        /* problem part */

        // PART 1

        int first = Integer.parseInt(input.get(0));
        ArrayList<Integer> busList = new ArrayList<>();
        ArrayList<Integer> busTime = new ArrayList<>();
        String[] subparts;
        int busTmp=0;
        int min=0;

        subparts = input.get(1).split(",");

        for(int i = 0 ; i < subparts.length ; i++) if(!subparts[i].equals("x")) busList.add(Integer.parseInt(subparts[i]));

        for(int i = 0 ; i < busList.toArray().length ; i++) {
            int x = 0;
            while(first >= busTmp){
                busTmp = busList.get(i) * x;
                x++;
            }
            busTime.add(busTmp);
            busTmp=0;
        }

        for(int i = 0 ; i < busTime.toArray().length ; i++) System.out.println(busTime.get(i));

        min = busTime.get(0);
        busTmp=0;
        for(int i = 1 ; i < busTime.toArray().length ; i++) {
            if(busTime.get(i) < min) {
                min = busTime.get(i);
                busTmp = i;
            }
        }
        System.out.println("busTime="+min+" ecart="+(min-first)+" bus="+busList.get(busTmp)+" answer="+(busList.get(busTmp)*(min-first)));

    }
}
