/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

/**
 *
 * @author informatica
 */
public class Rest {

    public static void main(String[] args) {
        while(true)
        {
            System.out.println("inserire il numero del metodo che vuoi utilizzare");
            System.out.println("1)GET");
            System.out.println("2)POST");
            System.out.println("3)DELETE");
            System.out.println("4)GET per id");
            System.out.println("5)PUT");
            Scanner scan = new Scanner(System.in);
            String s1 = scan.next();
            int s = Integer.parseInt(s1);
            //GET normle
            if(s == 1)
            {
                try {

                    URL url = new URL("http://localhost:8080/api/tutorial/1.0/employees");
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.setRequestMethod("GET");
                    conn.setRequestProperty("Accept", "application/json");

                    if (conn.getResponseCode() != 200) {
                            throw new RuntimeException("Failed : HTTP error code : "
                                            + conn.getResponseCode());
                    }

                    BufferedReader br = new BufferedReader(new InputStreamReader(
                            (conn.getInputStream())));

                    String output;
                    System.out.println("Output from Server .... \n");
                    while ((output = br.readLine()) != null) {
                            System.out.println(output);
                    }

                    conn.disconnect();

                } 
                catch (MalformedURLException e) {

                      e.printStackTrace();

                } catch (IOException e) {

                      e.printStackTrace();

                }
            }
            else if(s == 2)
            {
                try {
                    URL url = new URL("http://localhost:8080/api/tutorial/1.0/employees");
                          HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                          conn.setDoOutput(true);
                          conn.setRequestMethod("POST");
                          conn.setRequestProperty("Content-Type", "application/json");


                          System.out.println("inserire l'id nuovo");
                    String id = scan.next();
                    System.out.println("inserire il nome nuovo");
                    String nome = scan.next();
                    System.out.println("inserire il cognome nuovo");
                    String cognome = scan.next();
                    System.out.println("inserire l'email nuovo");
                    String email = scan.next();
                    System.out.println("inserire il nuovo numero di telefono");
                    String telefono = scan.next();

                    String input = "{\n" +
                                    "  \"employeeId\": "+Integer.parseInt(id)+",\n" +
                                    "  \"firstName\": \""+nome+"\",\n" +
                                    "  \"lastName\": \""+cognome+"\",\n" +
                                    "  \"email\": \""+email+"\",\n" +
                                    "  \"phone\": \""+telefono+"\"\n" +
                                    "}";



                    OutputStream os = conn.getOutputStream();
                    os.write(input.getBytes());
                    os.flush();

                    if (conn.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
                            throw new RuntimeException("Failed : HTTP error code : "
                                    + conn.getResponseCode());
                    }


                    conn.disconnect();
                    

                } 
                catch (MalformedURLException e) {

                      e.printStackTrace();

                } catch (IOException e) {

                      e.printStackTrace();

               }
            }
            else if(s == 3)
            {
                 try {
                    System.out.println("inserire l'id da cancellare");
                    String id = scan.next();
                    URL url = new URL("http://localhost:8080/api/tutorial/1.0/employees/" + id);
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.setRequestMethod("DELETE");
                    conn.setRequestProperty("Accept", "application/json");

                    if (conn.getResponseCode() != 200) {
                            throw new RuntimeException("Failed : HTTP error code : "
                                            + conn.getResponseCode());
                    }

                    BufferedReader br = new BufferedReader(new InputStreamReader(
                            (conn.getInputStream())));
                    conn.disconnect();

                } 
                catch (MalformedURLException e) {

                      e.printStackTrace();

                } catch (IOException e) {

                      e.printStackTrace();

                }
            }
            else if(s == 4)
            {
                try {
                    
                    System.out.println("inserire l'id del lavoratore");
                    String id = scan.next();
                    URL url = new URL("http://localhost:8080/api/tutorial/1.0/employees/" + id);
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.setRequestMethod("GET");
                    conn.setRequestProperty("Accept", "application/json");

                    if (conn.getResponseCode() != 200) {
                            throw new RuntimeException("Failed : HTTP error code : "
                                            + conn.getResponseCode());
                    }

                    BufferedReader br = new BufferedReader(new InputStreamReader(
                            (conn.getInputStream())));

                    String output;
                    System.out.println("Output from Server .... \n");
                    while ((output = br.readLine()) != null) {
                            System.out.println(output);
                    }

                    conn.disconnect();

                    } 
                catch (MalformedURLException e) {

                      e.printStackTrace();

                } catch (IOException e) {

                      e.printStackTrace();

                }
               
            }
            else if(s == 5)
            {
                try {
                    System.out.println("inserire l'id che vuoi cambiare");
                    String cc = scan.next();
                    URL url = new URL("http://localhost:8080/api/tutorial/1.0/employees/" + cc);
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.setDoOutput(true);
                    conn.setRequestMethod("PUT");
                    conn.setRequestProperty("Content-Type", "application/json");


                    System.out.println("inserire l'id nuovo");
                    String id = scan.next();
                    System.out.println("inserire il nome nuovo");
                    String nome = scan.next();
                    System.out.println("inserire il cognome nuovo");
                    String cognome = scan.next();
                    System.out.println("inserire l'email nuovo");
                    String email = scan.next();
                    System.out.println("inserire il nuovo numero di telefono");
                    String telefono = scan.next();

                    String input = "{\n" +
                                    "  \"employeeId\": "+Integer.parseInt(id)+",\n" +
                                    "  \"firstName\": \""+nome+"\",\n" +
                                    "  \"lastName\": \""+cognome+"\",\n" +
                                    "  \"email\": \""+email+"\",\n" +
                                    "  \"phone\": \""+telefono+"\"\n" +
                                    "}";



                    OutputStream os = conn.getOutputStream();
                    os.write(input.getBytes());
                    os.flush();

                    if (conn.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
                            throw new RuntimeException("Failed : HTTP error code : "
                                    + conn.getResponseCode());
                    }


                    conn.disconnect();
                    

                } 
                catch (MalformedURLException e) {

                      e.printStackTrace();

                } catch (IOException e) {

                      e.printStackTrace();

               }
            }
        }
    }
    
}
