package com.javarush.task.task22.task2209;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/* 
Составить цепочку слов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = bufferedReader.readLine();
        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
        String[] words;
        while (fileReader.ready()){
            words = fileReader.readLine().split(" ");
        }

        StringBuilder result = getLine();
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {
        int lastIndex;
        String lastLiteral;
        for (String word: words){
           for (String word2 : words){
               if (word.charAt(word.length()-1) == word2.charAt(0));

           }
        }
        return null;
    }
}
