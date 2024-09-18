package queueANDstack;


import org.junit.Test;

import java.util.Scanner;

public class QueueAndStackTest {


    public static void main(String[] args) {
        QueueAndStack qs = new QueueAndStack();
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个字符串：");
        String str = sc.nextLine();
        System.out.println(qs.isValid(str));
    }

    @Test
    public void isValid() {
    }

    @Test
    public void calculate() {
        QueueAndStack qs = new QueueAndStack();
       // System.out.println(qs.calculate("3+2*2"));
        System.out.println(qs.calculate(" 3/2 "));
    }
}