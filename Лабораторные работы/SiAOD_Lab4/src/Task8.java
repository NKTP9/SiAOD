import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Task8 {
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        PrintWriter writer = new PrintWriter("D:\\input\\output8.txt", "UTF-8");
        Stack<String> list = new Stack<>();
        try (Scanner scan = new Scanner(new File("D:\\input\\input8.txt"))) {
            while (scan.hasNextLine()) {
                list.push(scan.nextLine());
            }
            while(!list.empty()) {
                String out = list.pop();
                writer.println(out);
            }
            System.out.println("Выполнено!");
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
