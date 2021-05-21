import java.io.*;

public class Task2 {
    private final static char[] DEK = {'a', 'b', 'g', 'u', 'i', 'o', 'e', 't', 'n', 's', 'h', 'v', 'c', 'y'};

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(new File("D:\\input\\input2.txt")));
        BufferedWriter writer = new BufferedWriter(new FileWriter(new File("D:\\input\\output2.txt")));

        int i;
        while ((i = reader.read()) != -1) {
            char ch = (char) i;
            writer.append(switchLetter(ch));
            writer.flush();
        }
        reader.close();
        writer.close();
    }

    private static char switchLetter(char ch) {
        char outchar = '0';
        for (int i = 2; i < DEK.length; i++) {
            char c = DEK[i];
            if (c == ch) {
                outchar = DEK[i - 2];
                break;
            }
        }
        if (outchar == '0')
            outchar = ch;
        return outchar;
    }
}