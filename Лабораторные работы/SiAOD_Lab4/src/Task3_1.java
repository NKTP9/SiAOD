public class Task3_1 {
    // Структура для представления стека
    static class Stack {
        int capacity;
        int top;
        int[] array;
    }

    // функция для создания стека заданной емкости.
    Stack createStack(int capacity) {
        Stack stack = new Stack();
        stack.capacity = capacity;
        stack.top = -1;
        stack.array = new int[capacity];
        return stack;
    }

    // Стек заполнен, когда вершина равна last index
    boolean isFull(Stack stack) {
        return (stack.top == stack.capacity - 1);
    }

    // Стек пуст, когда вершина равна -1
    boolean isEmpty(Stack stack) {
        return (stack.top == -1);
    }

    // Функция для добавления элемента в стек. Это увеличивается сверху на 1
    void push(Stack stack, int item) {
        if (isFull(stack))
            return;
        stack.array[++stack.top] = item;
    }

    // Функция для удаления элемента из стека. Это уменьшает вершину на 1
    int pop(Stack stack) {
        if (isEmpty(stack))
            return Integer.MIN_VALUE;
        return stack.array[stack.top--];
    }

    // Функция для реализации легального движения между полюсами
    void moveDisksBetweenTwoPoles(Stack src, Stack dest, char s, char d) {
        int pole1TopDisk = pop(src);
        int pole2TopDisk = pop(dest);
        // Когда полюс 1 пуст
        if (pole1TopDisk == Integer.MIN_VALUE) {
            push(src, pole2TopDisk);
            moveDisk(d, s, pole2TopDisk);
        }
        // Когда полюс pole2 пуст
        else if (pole2TopDisk == Integer.MIN_VALUE) {
            push(dest, pole1TopDisk);
            moveDisk(s, d, pole1TopDisk);
        }
        // Когда верхний диск pole1> верхний диск pole2
        else if (pole1TopDisk > pole2TopDisk) {
            push(src, pole1TopDisk);
            push(src, pole2TopDisk);
            moveDisk(d, s, pole2TopDisk);
        }
        // Когда верхний диск pole1 <верхний диск pole2
        else {
            push(dest, pole2TopDisk);
            push(dest, pole1TopDisk);
            moveDisk(s, d, pole1TopDisk);
        }
    }

    // Функция для отображения движения дисков
    void moveDisk(char fromPeg, char toPeg, int disk) {
        System.out.println("Move the disk " + disk +
                " from " + fromPeg + " to " + toPeg);
    }

    // Функция для реализации загадки TOH
    void tohIterative(int num_of_disks, Stack
            src, Stack aux, Stack dest) {
        int i, total_num_of_moves;
        char s = '1', d = '3', a = '2';
        // Если количество дисков четное, то чередуем
        // полюс назначения и вспомогательный полюс
        if (num_of_disks % 2 == 0) {
            char temp = d;
            d = a;
            a = temp;
        }
        total_num_of_moves = (int) (Math.pow(2, num_of_disks) - 1);
        // Большие диски будут вставлены первыми
        for (i = num_of_disks; i >= 1; i--)
            push(src, i);
        for (i = 1; i <= total_num_of_moves; i++) {
            if (i % 3 == 1)
                moveDisksBetweenTwoPoles(src, dest, s, d);
            else if (i % 3 == 2)
                moveDisksBetweenTwoPoles(src, aux, s, a);
            else if (i % 3 == 0)
                moveDisksBetweenTwoPoles(aux, dest, a, d);
        }
    }

    // Программа драйвера для проверки вышеуказанных функций
    public static void main(String[] args) {
        // Ввод: количество дисков
        int num_of_disks = 3;
        Task3_1 ob = new Task3_1();
        Stack src, dest, aux;
        // Создаем три стека размером num_of_disks держать диски
        src = ob.createStack(num_of_disks);
        dest = ob.createStack(num_of_disks);
        aux = ob.createStack(num_of_disks);
        ob.tohIterative(num_of_disks, src, aux, dest);
    }
}


