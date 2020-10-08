import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите проверяемое число: ");
        long num = scanner.nextLong();

        System.out.println("Введите число тестов: ");
        int k = scanner.nextInt();

        Ferma ferma = new Ferma();
        System.out.println(ferma.ferma(num, k) ? "Число простое." : "Число не простое");
    }
}
