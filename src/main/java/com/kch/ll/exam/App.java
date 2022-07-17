package com.kch.ll.exam;

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

    }
}
