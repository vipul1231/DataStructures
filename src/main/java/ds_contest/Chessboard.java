package ds_contest;

import java.sql.SQLDataException;
import java.util.Scanner;

public class Chessboard {



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        for (int i=0;i<n;i++) {
            int x1 = scanner.nextInt();
            int y1 = scanner.nextInt();

            int x2 = scanner.nextInt();
            int y2 = scanner.nextInt();

            if (x1 == x2 && y1 == y2) {
                System.out.println("SECOND");
            }

            String move = null;
            switch (move) {

                case "LEFT":
                case "RIGHT":
                case "UP":
                case "DOWN":
            }

        }
        scanner.close();
    }
}

interface D {

    void run();

    class F {

    }
}

class E implements D {

    @Override
    public void run() {

    }

    public static void main(String[] args) {
        D.F obj = new D.F();
        F f = new F();
        D d = new E();

    }
}

class A {

    protected Number run()  {
        //("A");
        System.out.println("A");
        return 2;
    }

}


class B extends A {

    public Integer run() {
        System.out.println("B");
        return 1;
    }

    public void run(Number number) {
        System.out.println("number");
    }

    public void run(Integer integer) {
        System.out.println("intgeer");
    }
    public static void main(String[] args) {
        A a = new B();
        a.run();

        B b = new B();
        b.run(1);
        //output
    }
}
