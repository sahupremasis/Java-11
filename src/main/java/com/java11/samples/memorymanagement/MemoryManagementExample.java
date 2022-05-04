package com.java11.samples.memorymanagement;

import java.util.ArrayList;
import java.util.List;

public class MemoryManagementExample {

    public static void main(String[] args) {
        memoryLeakTest();
    }

    private static void memoryLeakTest() {
        System.out.println("memoryLeakTest");
        List<String> list = new ArrayList<>();
        try {
            int i = 0;
            while (true) {
                list.add("Hello World! " + i++);
            }
        } finally {
            System.out.println("finally " + list.size());
        }
    }

}
