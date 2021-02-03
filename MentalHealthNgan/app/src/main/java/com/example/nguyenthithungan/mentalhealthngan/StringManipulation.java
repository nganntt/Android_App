package com.example.nguyenthithungan.mentalhealthngan;

public class StringManipulation {
    public static String expandUser(String username){
        return username.replace(".", " ");
    }
    public static String condenseUsername(String username){
        return username.replace(" ", ".");
    }
}
