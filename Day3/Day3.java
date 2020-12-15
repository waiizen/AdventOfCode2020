package Day3;

import Utils.Lecture;

import java.util.ArrayList;

public class Day3 {
    public static void main(String args[]){

        ArrayList<String> input;
        input = Lecture.lectureString("./src/Day3/input.txt");
        ArrayList<String> input2;
        input2=input;

        // PART 2

        int x = 0;
        int y = 0;
        int tree = 0;
        int snow = 0;
        int result=0;
        boolean end=false;

        for(int i = 0 ; i < input.size() ; i++){
            y = i;
            if(x>30) x = x-31;
            if(input.get(y).charAt(x) == '#') tree++;
            if(input.get(y).charAt(x) == '.') snow++;
            x += 1;
        }
        System.out.println("tree="+tree+" snow="+snow+" total="+(tree+snow));
        result=tree;
        tree=snow=x=y=0;

        for(int i = 0 ; i < input.size() ; i++){
            y = i;
            if(x>30) x = x-31;
            if(input.get(y).charAt(x) == '#') tree++;
            if(input.get(y).charAt(x) == '.') snow++;
            x += 3;
        }
        System.out.println("tree="+tree+" snow="+snow+" total="+(tree+snow));
        result = result*tree;
        tree=snow=x=y=0;

        for(int i = 0 ; i < input.size() ; i++){
            y = i;
            if(x>30) x = x-31;
            if(input.get(y).charAt(x) == '#') tree++;
            if(input.get(y).charAt(x) == '.') snow++;
            x += 5;
        }
        System.out.println("tree="+tree+" snow="+snow+" total="+(tree+snow));
        result = result*tree;
        tree=snow=x=y=0;

        for(int i = 0 ; i < input.size() ; i++){
            y = i;
            if(x>30) x = x-31;
            if(input.get(y).charAt(x) == '#') tree++;
            if(input.get(y).charAt(x) == '.') snow++;
            x += 7;
        }
        System.out.println("tree="+tree+" snow="+snow+" total="+(tree+snow));
        result = result*tree;
        tree=snow=x=y=0;

        y=0;
        x=0;
        while(!end){
            x++;
            if(x>30) x = x-31;
            if(y+2 < input.size()){
                y++;
                y++;

                if(input.get(y).charAt(x) == '#') tree++;
                if(input.get(y).charAt(x) == '.') snow++;
            } else {
                end=true;
            }
        }
        System.out.println("tree="+tree+" snow="+snow+" total="+(tree+snow));
        result = result*tree;
        System.out.println("result="+result);


        // PART 1
        /*
        int x = 0;
        int y = 0;
        int right = 3;
        int tree = 0;
        int snow = 0;

        for(int i = 0 ; i < input.size() ; i++){
            y = i;

            if(x>30) x = x-31;

            if(input.get(y).charAt(x) == '#') tree++;
            if(input.get(y).charAt(x) == '.') snow++;

            x += right;
        }

        System.out.println("tree="+tree+" snow="+snow);
        */

    }
}
