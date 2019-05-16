/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.stream.JsonReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import java.util.concurrent.Callable;

/**
 *
 * @author caspe
 */


public class FetchResourceCallable implements Callable<String>{
    String urlStr;
    
    public FetchResourceCallable(String url){
        this.urlStr = url;
    }

    @Override
    public String call() throws Exception {
       //ex.doWork();
        URL url = new URL(urlStr);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("Accept", "application/json;charset=UTF-8");
        con.setRequestProperty("User-Agent", "server");
        JsonReader reader = new JsonReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
        String jsonStr = null;
        if (reader.hasNext()) {
            jsonStr += reader.nextString();
        }
        reader.close();
        System.out.println(jsonStr);
        return jsonStr;
       
    }
    public static void main(String[] args) throws Exception {
        String str = new FetchResourceCallable("https://dueinator.dk/jwtbackend/api/car/all").call();
        System.out.println(str);
    }
}