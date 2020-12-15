package Day9;

import Utils.Lecture;

import java.util.ArrayList;

public class Day9 {
    public static void main(String args[]){

        /* reading data part */

        ArrayList<Long> input;
        input = Lecture.lectureLong("./src/Day9/input.txt");

        /* problem part */

        // PART 2

        boolean found=false;
        int invalidI = 572;
        long invanlidN = 138879426;
        long sumTmp=0;
        int iFinal=0, jFinal=0;
        long min=0, max=0;

        //System.out.println(input.get(invalidI));

        for(int i = invalidI-1 ; !found ; i--){

            for(int j = i ; sumTmp <= invanlidN ; j--){
                sumTmp = sumTmp + input.get(j);
                if(sumTmp==invanlidN){
                    System.out.println("i="+i+" j="+j+" sum="+sumTmp);
                    iFinal=i;
                    jFinal=j;
                    found=true;
                    break;
                }
            }
            sumTmp=0;
        }
        min=max=input.get(jFinal);
        for(int k = jFinal ; k <= iFinal ; k++){
            if(input.get(k) > max) max=input.get(k);
            if(input.get(k) < min) min=input.get(k);
            //System.out.println("input="+input.get(k)+" i="+k);
        }
        System.out.println("min="+min+" max="+max+" total="+(max+min));

        // PART 1

        /*
        boolean sum=false;

        for(int i = 25 ; i < input.toArray().length ; i++){
            for(int j = 1 ; j < 26 ; j++){
                for(int k = j+1 ; k < 26 ; k++){
                    if(input.get(i) == input.get(i-j) + input.get(i-k)){
                        sum=true;
                    }
                }
            }
            if(!sum){
                System.out.println("input="+input.get(i)+" i="+i);
                break;
            }
            sum=false;
        }

         */

    }
}
