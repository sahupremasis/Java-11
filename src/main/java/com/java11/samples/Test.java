package com.java11.samples;

import java.util.OptionalInt;

public class Test {

   static class MyException extends Exception{}

    public static void main(String[] args) throws Exception {
      Boolean bool =  Boolean.valueOf(null);
        System.out.println(bool);
    }



}
