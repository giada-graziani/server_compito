package com.example;

public class Biglietti {
    int quant;

    public Biglietti(int quant){
        this.quant=quant;
    }

    public int getQuant() {
        return quant;
    }

    public void setQuant(int quant) {
        this.quant = quant;
    }

    public int sottrazione(Biglietti b, int tot, int num){
        int comprato= tot- num;
        if(comprato>=0){
            b.setQuant(comprato);
        }
        return comprato;
        
    }
    
}
