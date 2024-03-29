package com.javarush.task.task22.task2202;

/* 
Найти подстроку
*/

public class Solution {
    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
    }

    public static String getPartOfString(String string) throws TooShortStringException {
       try {
           String[] splitString = string.split(" ");
           String word = splitString[4];
           int wordEnd = string.indexOf(word) + word.length();
           return string.substring(string.indexOf(" ")+1,wordEnd);
       }
       catch (Exception e){
           throw  new TooShortStringException();
       }
    }

    public static class TooShortStringException extends RuntimeException {
    }
}
