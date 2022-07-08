package com.kch.ll.exam;

import java.io.FileInputStream;
import java.util.Scanner;

public class App {
    public void run() {
        System.out.println("== 명언 SSG ==");
        int i = 0;
        Scanner sc = new Scanner(System.in);
        outer:
        while (true) {
            System.out.printf("명령) ");
            String cmd = sc.nextLine().trim();

            switch (cmd) {
                case "등록":
                    System.out.print("명언 : ");
                    String wiseSaying = sc.nextLine().trim();
                    System.out.print("명언 : ");
                    String author = sc.nextLine().trim();
                    System.out.println(++i + "번 명언이 등록되었습니다.");
                    break;
                case "삭제":
                    break;
                case "목록":
                    break;
                case "종료":
                    break outer;
            }
        }

        sc.close();
    }
}