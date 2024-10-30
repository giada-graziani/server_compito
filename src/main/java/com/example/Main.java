package com.example;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Server partito...");
        ServerSocket s1= new ServerSocket(3000);
        Biglietti b= new Biglietti(100);
        Username u = new Username();
        do{
            Socket s= s1.accept();
            MioThread t=new MioThread(s, b, u);
            t.start();
        }while(true);
    }
}