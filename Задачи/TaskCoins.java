import java.util.Arrays;
import java.util.Scanner;

public class TaskCoins {
    public static int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int res = 0, n = piles.length;
        for (int i = n / 3; i < n; i += 2)
            res += piles[i];
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите кол-во чисел:");
        int amount = Integer.parseInt(scanner.nextLine()); // Считываем кол-во
        if (amount > 0) {
            int[] coins = new int[amount];
            System.out.println("Введите значения:");
            for (int i = 0; i < amount; i++) {
                coins[i] = Integer.parseInt(scanner.nextLine());
                if (coins[i] < 0) {
                    System.out.println("Значения монет не могут быть отрицательными!");
                    System.exit(0);
                }
            }
            int ans = maxCoins(coins);
            System.out.println(ans);
        } else {
            System.out.println("Не может быть 0 или отрицательное кол-во монет!");
        }
    }
}


