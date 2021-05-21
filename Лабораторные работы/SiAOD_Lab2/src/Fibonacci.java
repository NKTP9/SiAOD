
import java.util.Arrays;
import java.util.Scanner;

class Fibonacci {

    // Сервисная функция для поиска минимума из двух элементов
    public static int min(int x, int y) {
        return Math.min(x, y);
    }

    /*
    Возвращает индекс x, если присутствует, иначе возвращает -1
    */

    public static int fibMonaccianSearch(int arr[], int x, int n) {

        /*Инициализировать числа Фибоначчи */
        int fibMMm2 = 0; // (м-2) -ый номер Фибоначчи
        int fibMMm1 = 1; // (m-1) '-ый номер Фибоначчи
        int fibM = fibMMm2 + fibMMm1; // м Фибоначчи

        /*fibM собирается хранить самые маленькие Число Фибоначчи, большее или равное n */
        while (fibM < n) {
            fibMMm2 = fibMMm1;
            fibMMm1 = fibM;
            fibM = fibMMm2 + fibMMm1;
        }

        // Отмечает удаленный диапазон спереди
        int offset = -1;

        /*
        Пока есть элементы для проверки. Обратите внимание, что мы сравниваем arr[fibMm2] с x. Когда fibM становится 1, fibMm2 становится 0
        */

        while (fibM > 1) {

            // Проверяем, является ли fibMm2 действительным местоположением
            int i = min(offset + fibMMm2, n - 1);

            /*Если х больше значения в индекс fibMm2, вырезать массив подмассива от смещения до i */
            if (arr[i] < x) {
                fibM = fibMMm1;
                fibMMm1 = fibMMm2;
                fibMMm2 = fibM - fibMMm1;
                offset = i;
            }

            /*Если х больше, чем значение в индексе fibMm2, вырезать подрешетку после i + 1 */
            else if (arr[i] > x) {
                fibM = fibMMm2;
                fibMMm1 = fibMMm1 - fibMMm2;
                fibMMm2 = fibM - fibMMm1;
            }
            //элемент найден. индекс возврата
            else return i + 1;
        }

        /* сравнение последнего элемента с x */
        if (fibMMm1 == 1 && arr[offset + 1] == x)
            return offset + 1;

        /* элемент не найден. возврат -1 */
        return -1;

    }

    // код драйвера
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
                for(int i = 0; i < kolvo; i++) {
                    
                    System.out.println("Введите число для заполнения массива:");
                    arr[i] = scanner.nextInt();
                }
                System.out.println("Введите число для поиска");
                x = scanner.nextInt();
                System.out.print("Found at index: " + fibMonaccianSearch(arr, x, kolvo));
                break;
            case 'Г':
                int array[] = {10, 22, 35, 40, 45, 50, 80, 82, 85, 90, 100};
                System.out.println("Был сформирован массив: " + Arrays.toString(array));
                System.out.println("Введите число для поиска");
                x = scanner.nextInt();
                System.out.print("Found at index: " + fibMonaccianSearch(array, x, array.length));
                break;
        }
    }
}
