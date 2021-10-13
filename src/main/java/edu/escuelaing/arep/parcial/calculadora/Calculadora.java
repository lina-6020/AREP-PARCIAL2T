package edu.escuelaing.arep.parcial.calculadora;

import org.json.JSONArray;
import org.json.JSONObject;

public class Calculadora {
    JSONObject myObjectJson ;
    String funcion;
    double numero;
    double respuesta;

    public Calculadora(double numero,String funcion){
        this.funcion=funcion;
        this.numero=numero;
        add(numero,funcion);
        double respuesta=0;
    }
    public double getRespuesta(){
        return respuesta;
    }



    public void add(double numero,String funcion){
        this.funcion=funcion;
        this.numero=numero;
        if(funcion.equals("asin")) {
            respuesta = Math.asin(numero);
        }else if(funcion.equals("sin")){
            respuesta=Math.tan(numero);
        }else{
            System.out.println("Operation is invalid");
        }
    }


}
