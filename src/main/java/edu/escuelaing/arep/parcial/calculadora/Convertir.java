package edu.escuelaing.arep.parcial.calculadora;


import org.json.JSONObject;

public class Convertir {
    JSONObject myObjectJson ;

    public Convertir(){
        myObjectJson = new JSONObject();
    }

    public JSONObject stringToJSON(String operacion,double input,double number){
        myObjectJson.put("operation", operacion);
        myObjectJson.put("input", input);
        myObjectJson.put("output", number);

        System.out.println(myObjectJson);
        return myObjectJson;

    }

}