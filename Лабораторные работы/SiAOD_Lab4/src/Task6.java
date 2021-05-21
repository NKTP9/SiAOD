import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;

public class Task6 {
    public static void main(String[] args) {
        try {
            File file = new File("D:\\input\\input5.txt");
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = String.valueOf(reader.readLine());
            Chain(line);
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }

    public static void Chain(String line) {
        Stack<Character> chain = new Stack<>();
        for(int i = 0; i < line.length(); i++) {
            if(Character.isDigit(line.charAt(i))) {
                chain.push(line.charAt(i));
            }
        }
        for(int i = 0; i < line.length(); i++) {
            if(Character.isLetter(line.charAt(i))) {
                chain.push(line.charAt(i));
            }
        }
        for(int i = 0; i < line.length(); i++) {
            if(!Character.isDigit(line.charAt(i)) && !Character.isLetter(line.charAt(i)) ) {
                chain.push(line.charAt(i));
            }
        }
        System.out.println(chain);
    }
}

