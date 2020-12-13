package Day6;

import Utils.Lecture;

import java.util.ArrayList;

public class Day6 {
    public static void main(String args[]){

        /* reading data part */
        ArrayList<String> input;
        input = Lecture.lectureString("./Day6/input.txt");

        /* problem part */

        // PART 2

        int result=0;
        int qAnswered=0;
        ArrayList<Character> liste = new ArrayList<>();
        boolean exist=false;
        int length=0;
        boolean firstLine=true;
        ArrayList<Character> truth = new ArrayList<>();
        Character temp;

        for(int i = 0 ; i < input.toArray().length ; i++){
            while(!input.get(i).trim().isEmpty()){

                // first line
                if(firstLine){
                    for(int j = 0 ; j < input.get(i).length() ; j++){
                        liste.add(input.get(i).charAt(j));
                    }
                    firstLine=false;
                } else { // others lines
                    for(int j = 0 ; j < input.get(i).length() ; j++){
                        length=liste.toArray().length;
                        for(int k = 0 ; k < length ; k++){
                            if(input.get(i).charAt(j) == liste.get(k)){
                                truth.add(input.get(i).charAt(j));
                            }
                        }
                        length=0;
                    }
                    liste.clear();

                    length=truth.toArray().length;
                    for(int k = 0 ; k < length ; k++){
                        liste.add(truth.get(k));
                    }
                    length=0;

                    truth.clear();
                }


                if(i+1 >= input.toArray().length) break;
                i++;
                if(input.get(i).trim().isEmpty()) firstLine=true;
            }
            qAnswered += liste.size();
            liste.clear();
        }
        System.out.println(qAnswered);

        // PART 1
        /*
        int result=0;
        int qAnswered=0;
        ArrayList<Character> liste = new ArrayList<>();
        boolean exist=false;
        int length=0;

        for(int i = 0 ; i < input.toArray().length ; i++){
            while(!input.get(i).trim().isEmpty()){
                for(int j = 0 ; j < input.get(i).length() ; j++){
                    if(liste.toArray().length == 0){
                        liste.add(input.get(i).charAt(j));
                    } else {
                        length=liste.toArray().length;
                        for(int k = 0 ; k < length ; k++){
                            if(input.get(i).charAt(j) == liste.get(k)) exist=true;
                        }
                        if(!exist) liste.add(input.get(i).charAt(j));
                        exist=false;
                        length=0;
                    }
                }

                if(i+1 >= input.toArray().length) break;
                i++;
            }
            qAnswered += liste.size();
            liste.clear();
        }
        System.out.println(qAnswered);

         */
    }
}
