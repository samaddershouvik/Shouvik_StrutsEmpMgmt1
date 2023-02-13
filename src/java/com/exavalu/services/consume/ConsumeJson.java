/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.exavalu.services.consume;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import org.json.JSONObject;



/**
 *
 * @author Admin
 */
public class ConsumeJson {

    public String fun() throws IOException {
        String result = "SUCCESS";
        stream("https://jsonplaceholder.typicode.com/todos");
        return result;
    }

    public static void stream(String url) throws IOException {
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        // optional default is GET
        con.setRequestMethod("GET");
        //add request header
        con.setRequestProperty("Accept", "application/json");
        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        int c = 0;
//        ArrayList dataList = new ArrayList<>();
        while ((inputLine = in.readLine()) != null) {
            if (inputLine.contains("}")) {
                c++;
                response.append("}");
                System.out.println(response);
                JSONObject myResponse = new JSONObject(response.toString().substring(1));
                System.out.println("result after Reading JSON Response");
                int userId=myResponse.getInt("userId");
                int id=myResponse.getInt("id");
                String title=myResponse.getString("title");
                boolean completed=myResponse.getBoolean("completed");
                boolean res=ConsumeJsonDb.insertData(userId,id,title,completed);
                System.out.println(res);
                System.out.println("statusMessage- "+myResponse.getInt("userId"));
                System.out.println("ipAddress- "+myResponse.getInt("id"));
                System.out.println("countryCode- "+myResponse.getString("title"));
                System.out.println("countryName- "+myResponse.getBoolean("completed"));
                response = new StringBuffer();
            } else {
                response.append(inputLine);
            }
        }
        in.close();
    }
}
