package com.javarush.task.task22.task2207;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 
Обращенные слова
*/

public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = bufferedReader.readLine();
        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));

        Set<String> set = new HashSet<>();
        while (fileReader.ready()) {
            String[] words = fileReader.readLine().split(" ");
            for (String word : words) {
                StringBuilder sb = new StringBuilder(word);
                sb.reverse();
                String reversWord = sb.toString();

                if (set.contains(reversWord)) {
                    set.remove(reversWord);
                    Pair pair = new Pair();
                    pair.first = word;
                    pair.second = reversWord;

                    result.add(pair);
                } else set.add(word);
            }
        }
    }

    public static class Pair {
        String first;
        String second;



        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return first == null && second == null ? "" :
                    first == null ? second :
                            second == null ? first :
                                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
