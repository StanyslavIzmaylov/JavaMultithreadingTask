package com.javarush.task.task22.task2203;

/* 
Между табуляциями
*/

public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException {
       if (string == null){
           throw  new TooShortStringException();
       }
        String[] stringTab = string.split("\t");

       if (stringTab.length < 3){

               throw  new TooShortStringException();


       }


        return stringTab[1];
    }

    public static class TooShortStringException extends Exception {
    }

    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("\tJavaRush - лучший сервис \tобучения Java\t."));
    }
}
