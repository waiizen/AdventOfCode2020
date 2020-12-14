package Day8;

import Utils.Lecture;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day8 {

    public static void main(String args[]) throws Exception {

        /* problem part */

        // PART 2
        
        List<String> bootCode = loadData("./Day8/input.txt");
        Day8.GameConsole gameConsole = new Day8.GameConsole(bootCode);
        gameConsole.findFault();
        System.out.println(gameConsole.accumulator);

        // PART 1

        /* reading data part */
        //ArrayList<String> input;
        //input = Lecture.lectureString("./Day8/input.txt");


        /*
        ArrayList<String> operation = new ArrayList<>();
        ArrayList<Integer> value = new ArrayList<>();
        ArrayList<Boolean> used = new ArrayList<>();
        String[] parts;
        boolean alreadyPassed = false;
        int x = 0;
        int accumulator=0;

        for(int i = 0 ; i < input.toArray().length ; i++ ){
            //System.out.println(input.get(i));
            parts = input.get(i).split(" ");
            operation.add(parts[0]);
            value.add(Integer.parseInt(parts[1]));
            used.add(false);
        }

        while(!alreadyPassed){
            if(used.get(x)==false){
                used.set(x, true);
                if(operation.get(x).equals("acc")){
                    accumulator += value.get(x);
                }
                if(operation.get(x).equals("jmp")){
                    if(x + value.get(x) < operation.toArray().length) x += value.get(x);
                } else {
                    if(x + 1 < operation.toArray().length)x++;
                }

            }else{
                alreadyPassed = true;
            }
        }
        System.out.println(accumulator);

         */
    }

    public static class GameConsole{
        private List<String> bootcode;

        private int accumulator = 0;
        private GameConsole(List<String> bootCode){
            this.bootcode = bootCode;
        }

        private boolean infiniteCheck(){
            String[] tracker = new String[bootcode.size()];
            int position = 0;
            String[] split;
            while (position != tracker.length){
                if ( tracker[position]==null ){
                    tracker[position] = bootcode.get(position);
                    split = bootcode.get(position).split(" ");
                    switch (split[0]){
                        case "nop":
                            position++;
                            break;
                        case "acc":
                            accumulator += Integer.parseInt(split[1]);
                            position++;
                            break;
                        case "jmp":
                            position += Integer.parseInt(split[1]);
                            break;
                    }
                } else {
                    return false;
                }
            }
            return true;
        }

        private void findFault(){
            String[] split;

            for (int i = 0; i < bootcode.size(); i++){
                accumulator = 0;
                split = bootcode.get(i).split(" ");
                if (split[0].equals("nop")){
                    bootcode.set(i,"jmp "+Integer.parseInt(split[1]));
                    if (infiniteCheck()){ break; }
                    bootcode.set(i,"nop "+Integer.parseInt(split[1]));
                } else if (split[0].equals("jmp")){
                    bootcode.set(i, "nop " + Integer.parseInt(split[1]));
                    if (infiniteCheck()){ break; }
                    bootcode.set(i,"jmp "+Integer.parseInt(split[1]));
                }
            }
        }
    }

    private static List<String> loadData(String file) throws Exception{
        List<String> output = new ArrayList<>();

        File myFile = new File(file);
        Scanner scanner = new Scanner(myFile);
        while (scanner.hasNext()) {
            output.add(scanner.nextLine());
        }
        scanner.close();
        return output;
    }
}
