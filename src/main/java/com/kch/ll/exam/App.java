package com.kch.ll.exam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class App {
    private static String mode = "prod";
    private Scanner sc;

    public App(Scanner sc) {
        this.sc = sc;
    }

    public static String getDataBaseDir() {
        return mode + "_data";
    }

    public static void setMode(String mode) {
        App.mode = mode;
    }

    public void run() {
        System.out.println("== 명언 ==");
        WiseSayingController wiseSayingController = new WiseSayingController(sc);

        outer:
        while(true) {
            System.out.print("명언) ");
            String command = sc.nextLine().trim();

            RequestParams requestParams = new RequestParams(command);
            switch (requestParams.getPath()) {
                case "테스트":
                    wiseSayingController.test();
                    break;
                case "등록":
                    wiseSayingController.write();
                    break;
                case "목록":
                    wiseSayingController.list();
                    break;
                case "삭제":
                    wiseSayingController.remove(requestParams);
                    break;
                case "수정":
                    wiseSayingController.modify(requestParams);
                    break;
                case "빌드":
                    wiseSayingController.build();
                    break;
                case "종료":
                    break outer;
            }

            
        }
    }
}
