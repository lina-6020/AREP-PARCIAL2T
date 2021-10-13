package edu.escuelaing.arep.parcial.spark;



import static spark.Spark.*;
import java.io.IOException;

import edu.escuelaing.arep.parcial.calculadora.Calculadora;
import edu.escuelaing.arep.parcial.calculadora.Convertir;
import org.json.JSONObject;
import spark.Request;
import spark.Response;
public class Spark {
    public static void main(String[] args){
        port(getPort());
        port(getPort());
        get("/asin", (request, response) -> {
            Convertir convert = new Convertir();
            Calculadora calculator =  new Calculadora(Double.parseDouble(request.queryParams("value")),"asin");

            return convert.stringToJSON("asin",Double.parseDouble(request.queryParams("value")),calculator.getRespuesta());
        });
        get("/sin", (request, response) -> {
            Convertir convert = new Convertir();
            Calculadora calculator =  new Calculadora(Double.parseDouble(request.queryParams("value")),"sin");
            return convert.stringToJSON("sin",Double.parseDouble(request.queryParams("value")),calculator.getRespuesta());
            // System.out.println(convert.stringToJSON(calculator.getResultOperation()));
        });
    }
    /**      * @return the port 4567      */
    public static int getPort(){
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }

}
