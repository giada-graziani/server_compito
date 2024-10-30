package com.example;

import java.util.ArrayList;

public class Username {
    ArrayList array = new ArrayList<String>();

    public Username(){
        this.array = new ArrayList<String>();
    }

    public String aggiungi(String username){
        if(array.contains(username)){
            return "no";
        }
            array.add(username);
            return "si";
    }
}
