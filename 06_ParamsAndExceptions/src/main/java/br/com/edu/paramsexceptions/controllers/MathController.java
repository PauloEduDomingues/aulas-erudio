package br.com.edu.paramsexceptions.controllers;

import br.com.edu.paramsexceptions.treatments.NumberTreatments;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static java.lang.Math.sqrt;

@RestController()
@RequestMapping("/math")
public class MathController {
    private NumberTreatments numberTreatments = new NumberTreatments();

    @GetMapping("/sum/{numberOne}/{numberTwo}")
    public Double sumNumbers(@PathVariable String numberOne, @PathVariable String numberTwo) throws Exception{
        if (numberOne.isBlank() || numberTwo.isBlank()) {
            throw new Exception();
        }
        return numberTreatments.convertToDouble(numberOne) + numberTreatments.convertToDouble(numberTwo);
    }

    @GetMapping("/subtraction/{numberOne}/{numberTwo}")
    public Double subtractionNumbers(@PathVariable String numberOne, @PathVariable String numberTwo) throws Exception{
        if (numberOne.isBlank() || numberTwo.isBlank()) {
            throw new Exception();
        }
        return numberTreatments.convertToDouble(numberOne) - numberTreatments.convertToDouble(numberTwo);
    }

    @GetMapping("/division/{numberOne}/{numberTwo}")
    public Double divisionNumbers(@PathVariable String numberOne, @PathVariable String numberTwo) throws Exception{
        if (numberOne.isBlank() || numberTwo.isBlank()) {
            throw new Exception();
        }
        return numberTreatments.convertToDouble(numberOne) / numberTreatments.convertToDouble(numberTwo);
    }

    @GetMapping("/average/{numberOne}/{numberTwo}")
    public Double averageNumbers(@PathVariable String numberOne, @PathVariable String numberTwo) throws Exception{
        if (numberOne.isBlank() || numberTwo.isBlank()) {
            throw new Exception();
        }
        return (numberTreatments.convertToDouble(numberOne) + numberTreatments.convertToDouble(numberTwo)) / 2;
    }

    @GetMapping("/squareroot/{numberOne}/{numberTwo}")
    public Double squarerootNumbers(@PathVariable String numberOne, @PathVariable String numberTwo) throws Exception{
        if (numberOne.isBlank() || numberTwo.isBlank()) {
            throw new Exception();
        }
        return Math.sqrt(numberTreatments.convertToDouble(numberOne) + numberTreatments.convertToDouble(numberTwo));
    }




//    private Double convertToDouble(String strNumber) throws Exception{
//        String number = strNumber.replaceAll(",", ".");
//        if(isNumeric(number)){
//            return Double.parseDouble(number);
//        }else{throw new UnsupportedMathOperationException ("Please set numeric numbers");}
//
//    }
//
//    private boolean isNumeric(String number){
//        return number.matches("[-+]?[0-9]*(\\.[0-9]+)?");
//    }

}
