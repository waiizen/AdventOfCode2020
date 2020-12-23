package Day12;

import Utils.Lecture;

import java.util.ArrayList;

public class Day12 {

    public static void main(String args[]) {

        /* reading data part */

        ArrayList<String> input;
        input = Lecture.lectureString("./src/Day12/input.txt");

        /* problem part */

        // PART 2

        String direction[] = {"E", "S", "W", "N"};
        String dir="";
        int val=0;
        String currentDir[] = {"E","N"};
        // hori, verti
        int waypoint[]={10,1};
        int ship[]={0,0};

        for(int i = 0  ; i < input.toArray().length ; i++){
            dir=input.get(i).substring(0,1);
            val=Integer.parseInt(input.get(i).substring(1));
            System.out.println("dir="+dir + " val=" +val+ " ["+currentDir[0]+","+currentDir[1]+"] way0="+waypoint[0]+" way1="+waypoint[1]+" ship0="+ship[0]+" ship1="+ship[1]);
            switch(dir){
                case "N":
                    waypoint[1] += val;
                    break;
                case "S":
                    waypoint[1] -= val;
                    break;
                case "E":
                    waypoint[0] += val;
                    break;
                case "W":
                    waypoint[0] -= val;
                    break;
                case "L":
                    currentDir[0] = direction[changeDirection(currentDir[0], val/90, "L")-1];
                    currentDir[1] = direction[changeDirection(currentDir[1], val/90, "L")-1];
                    break;
                case "R":
                    currentDir[0] = direction[changeDirection(currentDir[0], val/90, "R")-1];
                    currentDir[1] = direction[changeDirection(currentDir[1], val/90, "R")-1];
                    break;
                case "F":
                    switch(currentDir[0]){
                        case "N":
                            ship[1] = ship[1] + (val*waypoint[0]);
                            break;
                        case "S":
                            ship[1] = ship[1] - (val*waypoint[0]);
                            break;
                        case "E":
                            ship[0] = ship[0] + (val*waypoint[0]);
                            break;
                        case "W":
                            ship[0] = ship[0] - (val*waypoint[0]);
                            break;
                    }
                    switch(currentDir[1]){
                        case "N":
                            ship[1] = ship[1] + (val*waypoint[1]);
                            break;
                        case "S":
                            ship[1] = ship[1] - (val*waypoint[1]);
                            break;
                        case "E":
                            ship[0] = ship[0] + (val*waypoint[1]);
                            break;
                        case "W":
                            ship[0] = ship[0] - (val*waypoint[1]);
                            break;
                    }
                    break;
            }
            System.out.println("dir="+dir + " val=" +val+ " ["+currentDir[0]+","+currentDir[1]+"] way0="+waypoint[0]+" way1="+waypoint[1]+" ship0="+ship[0]+" ship1="+ship[1]);
            System.out.println(("----"));
        }
        System.out.println((Math.abs(ship[0])+Math.abs(ship[1])));

        // PART 1
        /*
        // 0 = E, 1 = S, 2 = W, 3 = N
        String direction[] = {"E", "S", "W", "N"};
        String dir="";
        int val=0;
        int hori=0;
        int verti=0;
        String currentDir = "E";

        for(int i = 0  ; i < input.toArray().length ; i++){
            dir=input.get(i).substring(0,1);
            val=Integer.parseInt(input.get(i).substring(1));
            //System.out.println(dir + " " +val+ " "+currentDir+" "+hori+" "+verti);
            switch(dir){
                case "N":
                    verti += val;
                    break;
                case "S":
                    verti -= val;
                    break;
                case "E":
                    hori += val;
                    break;
                case "W":
                    hori -= val;
                    break;
                case "L":
                    currentDir = direction[changeDirection(currentDir, val/90, "L")-1];
                    break;
                case "R":
                    currentDir = direction[changeDirection(currentDir, val/90, "R")-1];
                    break;
                case "F":
                    switch(currentDir){
                        case "N":
                            verti += val;
                            break;
                        case "S":
                            verti -= val;
                            break;
                        case "E":
                            hori += val;
                            break;
                        case "W":
                            hori -= val;
                            break;
                    }
                    break;
            }
            //System.out.println(dir + " " +val+ " "+currentDir+" "+hori+" "+verti);
            //System.out.println(("----"));
        }
        System.out.println("hori="+hori+" verti="+verti+" sum="+(Math.abs(hori)+Math.abs(verti)));

         */

    }

    public static int changeDirection(String current, int val, String dir){
        if(val>4) val = val-4;
        if(dir=="L"){
            if(current=="E" && val==1) return 4;
            if(current=="E" && val==2) return 3;
            if(current=="E" && val==3) return 2;
            if(current=="E" && val==4) return 1;

            if(current=="S" && val==1) return 1;
            if(current=="S" && val==2) return 4;
            if(current=="S" && val==3) return 3;
            if(current=="S" && val==4) return 2;

            if(current=="W" && val==1) return 2;
            if(current=="W" && val==2) return 1;
            if(current=="W" && val==3) return 4;
            if(current=="W" && val==4) return 3;

            if(current=="N" && val==1) return 3;
            if(current=="N" && val==2) return 2;
            if(current=="N" && val==3) return 1;
            if(current=="N" && val==4) return 4;
        } else {
            if(current=="E" && val==1) return 2;
            if(current=="E" && val==2) return 3;
            if(current=="E" && val==3) return 4;
            if(current=="E" && val==4) return 1;

            if(current=="S" && val==1) return 3;
            if(current=="S" && val==2) return 4;
            if(current=="S" && val==3) return 1;
            if(current=="S" && val==4) return 2;

            if(current=="W" && val==1) return 4;
            if(current=="W" && val==2) return 1;
            if(current=="W" && val==3) return 2;
            if(current=="W" && val==4) return 3;

            if(current=="N" && val==1) return 1;
            if(current=="N" && val==2) return 2;
            if(current=="N" && val==3) return 3;
            if(current=="N" && val==4) return 4;
        }
        return -999;
    }

}
