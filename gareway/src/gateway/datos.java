/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gateway;

import Datos.CRUD;
import Datos.DAOsensor;
import Datos.DAOsensores;
import Dominio.sensor;
import Dominio.sensoresDatos;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author DELL
 */
public class datos {
    public static void main(String[] args) throws InterruptedException, IOException{
      
        CRUD datos= new DAOsensores();        
        datos c= new datos();
        
    
     for(int i=0; i<10;i++){
       
       sensor sen = c.randomSensor();
       float tem = c.randomTemperatura();
       float hum = c.randomhumedad();
       Date f = new Date();
       sensoresDatos sensores= new sensoresDatos(f,sen,tem,hum);
       System.out.println(sensores.toString());
       
       TimeUnit.SECONDS.sleep(20);
     }
    
     
     
    }
    
    
    public sensor randomSensor(){
        sensor s = null;
        CRUD sen= new DAOsensor();
        ArrayList<sensor> sev= sen.obtener();
         Random rnd= new Random();
         
         int numero= (int) Math.floor(rnd.nextFloat()*sev.size());
         s = sev.get(numero);
        return s;
    }
    
    public float randomTemperatura(){
        float tem = 0.0f;
        Random rnd= new Random();
        tem = rnd.nextFloat()*40+20;
        return tem;
    }
    
    public float randomhumedad(){
        float hum= 0.0f;
        Random rnd= new Random();
        hum = rnd.nextFloat()*100;
        
    
    return hum;
    } 
}
