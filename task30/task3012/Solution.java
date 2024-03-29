package com.javarush.task.task30.task3012;

/* 
Получи заданное число
*/

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.createExpression(74);
    }

    public void createExpression(int number) {
        int i = 0;
        StringBuilder result = new StringBuilder(number + " =");
        while (number > 0){
            int a = number / 3;
            int b = number % 3;
            if (b == 2){
                result = result.append( " - " + String.valueOf((int) Math.pow(3, i)));
                number = a + 1;
            } else if (b == 1){
                result = result.append( " + " + String.valueOf((int) Math.pow(3, i)));
                number = a;
            } else if (b == 0){
                number = a;
            }
            i++;
        }
        System.out.println(result);
    }
}