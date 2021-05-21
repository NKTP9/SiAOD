import java.util.Scanner;

import static java.lang.System.nanoTime;

public class Search {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите строку:");
        String str = scanner.nextLine();
        System.out.println("Введите шаблон:");
        String pattern = scanner.nextLine();

        long time0 = nanoTime();
        int indexM = str.indexOf(pattern);
        long time1 = nanoTime();
        long time = time1 - time0;

        if (indexM == -1) {
            System.out.println("Шаблон " + pattern + " не найден." + "НС: " + time);
        } else {
            System.out.println("Шаблон " + pattern + " найден, его индекс: " + indexM + ". " + "НС: " + time);
        }
    }
}
