package com.kch.ll.exam;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {
    @Test
    public void output_redirecting() {
        ByteArrayOutputStream output = TestUtil.setOutToByteArray();
        System.out.print("안녕");
        String rs = output.toString();
        TestUtil.clearSetOutToByteArray(output);
    }
    @Test
    public void input_redirecting() {
        Scanner sc = TestUtil.genScanner("안녕");

        String cmd = sc.nextLine().trim();
        assertEquals("안녕", cmd);
    }

    @Test
    public void save_in_file() {
        Util.file.mkdir(App.getDataBaseDir());
        Util.file.saveToFile(App.getDataBaseDir() + "/1.txt", "안녕");

        String body = Util.file.readFromFile(App.getDataBaseDir() + "/1.txt", "");

        assertEquals("안녕", body);
    }
}