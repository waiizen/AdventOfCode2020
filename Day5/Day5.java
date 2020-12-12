package Day5;

import Utils.Lecture;

import java.util.ArrayList;

public class Day5 {
    public static void main(String args[]){

        /* reading data part */
        ArrayList<String> input;
        input = Lecture.lectureString("./Day5/input.txt");

        /* problem part */

        // PART 2
        int place=0;
        int row=0;
        int column=0;
        int lHalfR = 0;
        int uHalfR=127;
        int lHalfC = 0;
        int uHalfC=7;
        int temp=0;
        int result=0;
        ArrayList<Integer> placeList = new ArrayList<Integer>();
        boolean exist=false;
        int placeTemp=0;

        // pour chaque billet
        for(int i = 0 ; i < input.toArray().length ; i++){
            //System.out.println(input.get(i));

            // placement colonne
            for(int j = 0 ; j < 6 ; j++){
                if(input.get(i).charAt(j)=='F'){
                    temp = (uHalfR-lHalfR)/2;
                    uHalfR = uHalfR-(temp+1);
                } else {
                    temp = (uHalfR-lHalfR)/2;
                    lHalfR = lHalfR+(temp+1);
                }
            }
            if(input.get(i).charAt(6)=='F'){
                row=lHalfR;
            } else {
                row=uHalfR;
            }
            //System.out.println("row="+row);

            // placement ligne
            for(int j = 7 ; j < 9 ; j++){
                if(input.get(i).charAt(j)=='L'){
                    temp = (uHalfC-lHalfC)/2;
                    uHalfC = uHalfC-(temp+1);
                } else {
                    temp = (uHalfC-lHalfC)/2;
                    lHalfC = lHalfC+(temp+1);
                }
            }
            if(input.get(i).charAt(9)=='L'){
                column=lHalfC;
            } else {
                column=uHalfC;
            }
            //System.out.println("column="+column);

            place=row*8+column;
            //System.out.println("place="+place);

            placeList.add(place);

            lHalfR=lHalfC=temp=place=0;
            uHalfR=127;
            uHalfC=7;
        }

        // pour chaque place
        for(int i = 0 ; i < placeList.toArray().length ; i++){
            for(int j = i+1  ; j < placeList.toArray().length ; j++){
                if(placeList.get(i)+2 == placeList.get(j)){
                    for(int k = 0 ; k < placeList.toArray().length ; k++){
                        if(placeList.get(i)+1 == placeList.get(k)){
                            exist=true;
                        }
                    }
                    if(exist==false){
                        System.out.println(placeList.get(i)+1);
                    }
                    exist=false;
                }
            }
            for(int j = i+1  ; j < placeList.toArray().length ; j++){
                if(placeList.get(i)-2 == placeList.get(j)){
                    for(int k = 0 ; k < placeList.toArray().length ; k++){
                        if(placeList.get(i)-1 == placeList.get(k)){
                            exist=true;
                        }
                    }
                    if(exist==false){
                        System.out.println(placeList.get(i)-1);
                    }
                    exist=false;
                }
            }
        }



        // PART 1
        /*
        int place=0;
        int row=0;
        int column=0;
        int lHalfR = 0;
        int uHalfR=127;
        int lHalfC = 0;
        int uHalfC=7;
        int temp=0;
        int highest=0;

        // pour chaque billet
        for(int i = 0 ; i < input.toArray().length ; i++){
            //System.out.println(input.get(i));

            // placement colonne
            for(int j = 0 ; j < 6 ; j++){
                if(input.get(i).charAt(j)=='F'){
                    temp = (uHalfR-lHalfR)/2;
                    uHalfR = uHalfR-(temp+1);
                } else {
                    temp = (uHalfR-lHalfR)/2;
                    lHalfR = lHalfR+(temp+1);
                }
            }
            if(input.get(i).charAt(6)=='F'){
                row=lHalfR;
            } else {
                row=uHalfR;
            }
            //System.out.println("row="+row);

            // placement ligne
            for(int j = 7 ; j < 9 ; j++){
                if(input.get(i).charAt(j)=='L'){
                    temp = (uHalfC-lHalfC)/2;
                    uHalfC = uHalfC-(temp+1);
                } else {
                    temp = (uHalfC-lHalfC)/2;
                    lHalfC = lHalfC+(temp+1);
                }
            }
            if(input.get(i).charAt(9)=='L'){
                column=lHalfC;
            } else {
                column=uHalfC;
            }
            //System.out.println("column="+column);

            place=row*8+column;
            //System.out.println("place="+place);

            if(place>highest) highest=place;

            lHalfR=lHalfC=temp=place=0;
            uHalfR=127;
            uHalfC=7;
        }
        System.out.println(highest);

         */
    }
}
