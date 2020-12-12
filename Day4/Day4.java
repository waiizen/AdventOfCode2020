package Day4;

import Utils.Lecture;

import java.util.ArrayList;

public class Day4 {
    public static void main(String args[]){

        /* reading data part */
        ArrayList<String> input;
        input = Lecture.lectureString("./Day4/input.txt");

        /* problem part */

        // PART 2

        boolean byr, iyr, eyr, hgt, hcl, ecl, pid, cid;
        byr=iyr=eyr=hgt=hcl=ecl=pid=cid=false;
        String parts[];
        String subparts[];
        String subsubparts[];
        int result = 0;
        boolean valid = true;

        // pour chaque ligne du fichier
        for(int i = 0 ; i < input.toArray().length ; i++){

            // pour un meme passeport
            while(!input.get(i).trim().isEmpty()){
                // on découpe la ligne pour récuperer les champs
                parts = input.get(i).split(" ");
                for(int j = 0 ; j < parts.length ; j++){
                    subparts = parts[j].split(":");
                    if(subparts[0].equals("byr")){
                        if(1920 <= Integer.parseInt(subparts[1]) && Integer.parseInt(subparts[1]) <= 2002){byr=true;}
                    }else if(subparts[0].equals("iyr")){
                        if(2010 <= Integer.parseInt(subparts[1]) && Integer.parseInt(subparts[1]) <= 2020){iyr=true;}
                    }else if(subparts[0].equals("eyr")){
                        if(2020 <= Integer.parseInt(subparts[1]) && Integer.parseInt(subparts[1]) <= 2030){eyr=true;}
                    }else if(subparts[0].equals("hgt")){
                        if(subparts[1].charAt(subparts[1].length()-2)=='c'&&subparts[1].charAt(subparts[1].length()-1)=='m'){
                            subsubparts=subparts[1].split("c");
                            if(150 <= Integer.parseInt(subsubparts[0]) && Integer.parseInt(subsubparts[0]) <= 193){
                                hgt=true;
                            }
                        } else if(subparts[1].charAt(subparts[1].length()-2)=='i'&&subparts[1].charAt(subparts[1].length()-1)=='n'){
                            subsubparts=subparts[1].split("i");
                            if(59 <= Integer.parseInt(subsubparts[0]) && Integer.parseInt(subsubparts[0]) <= 76){
                                hgt=true;
                            }
                        }
                    }else if(subparts[0].equals("hcl")){
                        if(subparts[1].charAt(0)=='#'){
                            for(int k = 1 ; k < subparts[1].length() ; k++){
                                if(!((Character.isLetter(subparts[1].charAt(k)) && 'a' <= subparts[1].charAt(k) && subparts[1].charAt(k) <= 'f') || (Character.isDigit(subparts[1].charAt(k)) && '0' <= subparts[1].charAt(k) && subparts[1].charAt(k) <= '9')) ) {
                                    valid=false;
                                }
                            }
                        } else{
                            valid=false;
                        }
                        if(valid==true) hcl=true;
                        valid=true;
                    }else if(subparts[0].equals("ecl")){
                        if(subparts[1].equals("amb") || subparts[1].equals("blu") || subparts[1].equals("brn")
                                || subparts[1].equals("gry") || subparts[1].equals("grn") || subparts[1].equals("hzl")
                                || subparts[1].equals("oth")) ecl=true;
                    }else if(subparts[0].equals("pid")){
                        if(subparts[1].length() == 9) pid=true;
                    }
                }

                if(i+1 >= input.toArray().length) break;
                i++;
            }
            if(byr==true&&iyr==true&&eyr==true&&hgt==true&&hcl==true&&ecl==true&&pid==true){
                result++;
            }else{
            };
            byr=iyr=eyr=hgt=hcl=ecl=pid=cid=false;
        }
        System.out.println(result);


        // PART 1
        /*
        boolean byr, iyr, eyr, hgt, hcl, ecl, pid, cid;
        byr=iyr=eyr=hgt=hcl=ecl=pid=cid=false;
        String parts[];
        String subparts[];
        int result = 0;

        // pour chaque ligne du fichier
        for(int i = 0 ; i < input.toArray().length ; i++){

            // pour un meme passeport
            while(!input.get(i).trim().isEmpty()){

                // on découpe la ligne pour récuperer les champs
                parts = input.get(i).split(":");

                System.out.println(parts[0]);
                if(parts[0].equals("byr")){byr=true;}
                else if(parts[0].equals("iyr")){iyr=true;}
                else if(parts[0].equals("eyr")){eyr=true;}
                else if(parts[0].equals("hgt")){hgt=true;}
                else if(parts[0].equals("hcl")){ hcl=true;}
                else if(parts[0].equals("ecl")){ ecl=true;}
                else if(parts[0].equals("pid")){ pid=true;}
                else if(parts[0].equals("cid")){cid=true;}

                if(parts.length > 1){
                    for(int j = 1 ; j < parts.length-1 ; j++){
                        subparts = parts[j].split(" ");

                        if(subparts[1].equals("byr")){byr=true;}
                        else if(subparts[1].equals("iyr")){iyr=true;}
                        else if(subparts[1].equals("eyr")){eyr=true;}
                        else if(subparts[1].equals("hgt")){hgt=true;}
                        else if(subparts[1].equals("hcl")){ hcl=true;}
                        else if(subparts[1].equals("ecl")){ ecl=true;}
                        else if(subparts[1].equals("pid")){ pid=true;}
                        else if(subparts[1].equals("cid")){cid=true;}

                        System.out.println(subparts[1]);
                    }
                }

                if(i+1 >= input.toArray().length) break;
                i++;
            }
            if(byr==true&&iyr==true&&eyr==true&&hgt==true&&hcl==true&&ecl==true&&pid==true){
                result++;
                System.out.println("==ok");
            }else{
                System.out.println("==no ok");
            };
            byr=iyr=eyr=hgt=hcl=ecl=pid=cid=false;
            System.out.println(" ");
        }
        System.out.println("result="+result);

         */

    }
}
