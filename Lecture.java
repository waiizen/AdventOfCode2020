import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Lecture {
    public static ArrayList<Integer> lecture(String nom){
        ArrayList<Integer> list = new ArrayList<>();
        try {
            File myObj = new File(nom);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                int data = Integer.parseInt(myReader.nextLine());
                //System.out.println(data);
                list.add(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return list;
    }
}
