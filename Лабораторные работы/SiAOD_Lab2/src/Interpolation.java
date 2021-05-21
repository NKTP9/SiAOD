import java.util.Arrays;
import java.util.Scanner;

public class Interpolation {
    public static void main(String[] args) {
        int x;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Вы хотите ввести числа, или вставить готовый массив? Напишите 'В' для ввода чисел или 'Г' для вставки готового массива:");
        String s = scanner.nextLine();
        int ch = s.charAt(0);
        switch (ch) {
            case 'В':
                System.out.println("Введите размер массива:");
                int kolvo = scanner.nextInt();
                int arr[] = new int[kolvo];
                for (int i = 0; i < kolvo; i++) {
                    System.out.println("Введите число для заполнения массива:");
                    arr[i] = scanner.nextInt();
                }
                System.out.println("Введите число для поиска");
                x = scanner.nextInt();
                System.out.print("Found at index: " + interpolationSearch(arr, x));
                break;
            case 'Г':
                int array[] = {10, 22, 35, 40, 45, 50, 80, 82, 85, 90, 100};
                System.out.println("Был сформирован массив: " + Arrays.toString(array));
                System.out.println("Введите число для поиска");
                x = scanner.nextInt();
                System.out.print("Found at index: " + interpolationSearch(array, x));
                break;
        }
    }

    public static int interpolationSearch(int[] integers, int elementToSearch) {
        int startIndex = 0;
        int lastIndex = (integers.length - 1);

        while ((startIndex <= lastIndex) && (elementToSearch >= integers[startIndex]) &&
                (elementToSearch <= integers[lastIndex])) {
            int pos = startIndex + (((lastIndex - startIndex) /
                    (integers[lastIndex] - integers[startIndex])) *
                    (elementToSearch - integers[startIndex]));

            if (integers[pos] == elementToSearch)
                return pos + 1;

            if (integers[pos] < elementToSearch)
                startIndex = pos + 1;

            else
                lastIndex = pos - 1;
        }
        return -1;
    }
}
