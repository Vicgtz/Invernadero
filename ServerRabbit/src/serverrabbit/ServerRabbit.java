/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverrabbit;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;
import interfaces.IAccesoDatos;
import org.json.JSONObject;

/**
 *
 * @author equipo 04
 */
public class ServerRabbit {

    
    private static IAccesoDatos datos;
    
    public static void main(String[] args) throws Exception {
        
        String nombreCola = "colaNotific";
        String host = "localhost";
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare(nombreCola, false, false, false, null);
        System.out.println("Esperando por mensajes...");
        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            JSONObject objetoJson;
            String message = new String(delivery.getBody(), "UTF-8");
            System.out.println(" [x] Mensaje recibido x: ");
            objetoJson = new JSONObject(message);
            int idSensor = objetoJson.getInt("idSensor");
            float temperatura = objetoJson.getFloat("temperatura");
            float humedad = objetoJson.getFloat("humedad");
            System.out.println(idSensor +", "+temperatura+", "+humedad);
            if (datos.agregarLectura(idSensor,temperatura ,humedad )){
                System.out.println("Agregado");
            }
            else{
                System.out.println("ERROR");
            }
        };
        channel.basicConsume(nombreCola, true, deliverCallback, consumerTag -> {
        });
    }
    
}
