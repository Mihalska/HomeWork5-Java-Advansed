package task2;

import java.lang.reflect.Member;
import java.util.Scanner;

public class Bird {
    public static void main(String[] args) {
        System.out.println("Введіть ім'я класу");
        Scanner input = new Scanner(System.in);
        String name = "java.lang."+ input.nextLine() ;
        try {
            Class <?> c = Class.forName(name);
            System.out.println(c);
            printMembers (c.getFields() );
            printMembers(c.getConstructors() );
            printMembers(c.getMethods() );
        } catch (ClassNotFoundException e) {
            System.out.println("Невідомий клас: "+ name  );
        }
    }
    private static void printMembers(Member[] members) {
        for (Member mem : members) {
            if (mem.getDeclaringClass() == Object.class) {
                continue;
            }
            String dec1 = mem.toString();
            System.out.println("  ");
            System.out.println(dec1);

        }
    }
}
