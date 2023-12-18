import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    static boolean continueExecution = true;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {


        while (continueExecution) {
            //Task roster
            int numberOfTask = taskRoaster();
            switch (numberOfTask) {
                case 1: {
                    task1();
                    break;
                }
                case 2: {
                    task2(1, 10);
                    break;
                }
                case 3: {
                    task3(10, "forward", '-');
                }
                case 4: {
                    System.out.println(task4(1, 2, 3, 4));
                    break;
                }
                case 5: {
                    System.out.println(task5(1, 10));
                    break;
                }
                case 6: {
                    System.out.println(task6(3));
                    break;
                }
                case 7: {
                    System.out.println(task7(123321));
                    break;
                }
                default:
                    System.out.println("\nВыберите задание!");
                    break;
            }
            nextTaskQuestion();
        }


    }

    public static int taskRoaster() {
        System.out.print("Выберите задание для проверки: ");
        return scanner.nextInt();
    }

    public static void nextTaskQuestion() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Хотите проверить другую задачу?  Да/Нет: ");
        String choice = scanner.nextLine();
        if (choice.equalsIgnoreCase("да") || choice.equalsIgnoreCase("yes")) {
            continueExecution = true;
        } else if (choice.equalsIgnoreCase("нет") || choice.equalsIgnoreCase("no")) {
            scanner.close();
            continueExecution = false;
        }
    }

    public static void task1() {
        //Напишите метод, который отображает на экран форматированный текст, указанный ниже
        //“Someone’s sitting in the shade today
        //because someone planted a tree a long time ago.”
        //Warren Buffet

        String text = "\"Someone's siting in the shade today \n because someone planted a tree a long time ago.\" \n Warren Buffet";
        System.out.println(text);
    }


    public static void task2(int firstNum, int secondNum) {
        //Напишите метод, который принимает два числа в каче-
        //стве параметра и отображает все четные числа между ними.
        for (int i = firstNum; i < secondNum; i++) {
            System.out.print(i + ", ");
        }
        System.out.println();
    }

    public static void task3(int range, String direction, char symbol) {
        //Напишите метод, который отображает горизонтальную или вертикальную линию из некоторого символа.
        //Метод принимает в качестве параметра: длину линии,
        //направление, символ
        if (Objects.equals(direction, "forward")) {
            for (int i = 0; i < range; i++) {
                System.out.print(symbol);
            }
        }
        if (Objects.equals(direction, "down")) {
            for (int i = 0; i < range; i++) {
                System.out.println(symbol);
            }
        }
    }

    public static int task4(int num1, int num2, int num3, int num4) {
        //Напишите метод, который возвращает максимальное
        //из четырёх чисел.Числа передаются в качестве параметров
        int[] numsArr = {num1, num2, num3, num4};
        Arrays.sort(numsArr);
        return numsArr[numsArr.length - 1];
    }

    public static int task5(int startRange, int endRange) {
        //Напишите метод, который возвращает сумму чисел
        //в указанном диапазоне. Границы диапазона передаются
        //в качестве параметров.

        int result = 0;

        for (int i = startRange + 1; i < endRange; i++) {
            result += i;
        }
        return result;
    }

    public static boolean task6(int numberToCheck) {
        //Напишитеметод, который проверяет является ли число
        //простым. Число передаётся в качестве параметра. Если
        //число простое нужно вернуть из метода true, иначе false.

        if (numberToCheck <= 1) {
            return false; // Числа меньше или равные 1 не являются простыми
        }

        // Проверяем деление на числа от 2 до квадратного корня из числа
        for (int i = 2; i <= Math.sqrt(numberToCheck); i++) {
            if (numberToCheck % i == 0) {
                return false; // Если число делится нацело, оно не является простым
            }
        }
        return true;
    }
    public static boolean task7(int numberToCheck) {
        //Напишите метод, который проверяет является ли
        //шестизначное число «счастливым». Число передаётся
        //в качестве параметра. Если число счастливое, нужно вер-
        //нуть из метода true, иначе false

        int slow = numberToCheck;
        int fast = numberToCheck;

        do {
            slow = digitSquareSum(slow);
            fast = digitSquareSum(digitSquareSum(fast));
        } while (slow != fast);

        return slow == 1;
    }

    public static int digitSquareSum (int n) {
        int sum = 0;

        while (n > 0) {
            int digit = n % 10;//последняя цифра числа
            sum += digit * digit;
            n /=10; //уменьшение числа на один разряд
        }

        return sum;
    }
}