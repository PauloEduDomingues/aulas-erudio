package br.com.edu.paramsexceptions.treatments;


import br.com.edu.paramsexceptions.exceptions.UnsupportedMathOperationException;

public class NumberTreatments {

    public Double convertToDouble(String numberString) throws Exception{
        if(isNumeric(numberString)){
            return Double.parseDouble(numberString);
        }
        throw new UnsupportedMathOperationException("Please set a number value");
    }

    public boolean isNumeric(String numberString){
        return numberString.matches("[-+]?[0-9]*(\\.[0-9]+)?");
    }
}
