package password.manager.sandbox;

import java.util.Scanner;

class LoopsExample {

    public static void main(String[] args) {
//        foo();

        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            System.out.println(line);
        }
    }

    public static void foo() {
        ILOOP:
        for (int i = 0; i < 10; i++) {
            JLOOP:
            for (int j = 0; j < 10; j++) {
                if (j == 2) {
                    continue;
                }
                if (j == 4) {
                    continue JLOOP;
                }
                if (j == 8) {
                    continue ILOOP;
                }
                System.out.println(i + " " + j);
            }
        }
    }
}
