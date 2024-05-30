package com.example.widely_known.utils;

public class StringUtils {
    public static String formattedVariable(String old_str){
        StringBuilder builder = new StringBuilder();
        boolean flag = false;
        if (old_str.contains("_")) {
            for (char c : old_str.toCharArray()) {
                if (c=='_') {
                    flag=true;
                }else if (flag){
                    System.out.println(c);
                    c =(char)((int)c +32);
                    builder.append(c);
                }else {
                    builder.append(c);
                }
            }
        }else
            for (char c : old_str.toCharArray()) {

                if ( ((int)c)>64 && 91> ((int)c)) {
                    builder.append("_").append((char) (c + 32));
                }else {
                    builder.append(c);
                }
            }
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(formattedVariable("bookId"));
    }
}

