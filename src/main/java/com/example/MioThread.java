package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class MioThread extends Thread {
    Socket s;
    Biglietti b;
    Username u;

    public MioThread(Socket s, Biglietti b, Username u){
        this.s=s;
        this.b=b;
        this.u=u;
    }

    public void run(){
        try {
            BufferedReader in= new BufferedReader(new InputStreamReader(s.getInputStream()));
            DataOutputStream out = new DataOutputStream(s.getOutputStream());
            String scelta;
            String messaggio;
            String nBiglietti;
            int bi;
            String username;
            String presenza;
            int comprato;

            do{
                username=in.readLine();
                presenza= u.aggiungi(username);
                if(presenza.equals("no")){
                    messaggio="no";
                    out.writeBytes(messaggio+"\n");
                }
                else {
                    messaggio="si";
                    out.writeBytes(messaggio+"\n");
                    do{
                        scelta=in.readLine();
                        if(scelta.equals("1")){
                            messaggio="n";
                            bi= b.getQuant();
                            out.writeBytes(messaggio+"\n");
                            out.writeBytes(bi +"\n");
                        }
                        else if(scelta.equals("2")){
                            messaggio="buy";
                            out.writeBytes(messaggio+"\n");
                            nBiglietti=in.readLine();
                            int nBiglietti2 = Integer.parseInt(nBiglietti);
                            comprato= b.sottrazione(b, b.getQuant(), nBiglietti2);
                            if(comprato>=0){
                                messaggio="ok";
                                out.writeBytes(messaggio+"\n");
                            }
                            else{
                                messaggio="ko";
                                out.writeBytes(messaggio+"\n");
                            }
                        }
                        else if(scelta.equals("3")){
                            messaggio="quit";
                            out.writeBytes(messaggio+"\n");                            
                        }
                        else{
                            messaggio="e";
                            out.writeBytes(messaggio+"\n");
                        }
                        
                    }while(!messaggio.equals("3")); 
                }
            }while(!messaggio.equals("si"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
