package com.alexandrestefani.gasolinaoualcool;

public class EngineCalculate {

    Boolean engine(Double pAlcohol,Double pGas){
        Boolean result = false;
        Double calculation = (pAlcohol/pGas);
        if (calculation >= 0.7){
            result = true;
        }
        return result;
    }

}
