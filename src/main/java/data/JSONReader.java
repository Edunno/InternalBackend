/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import dto.CarsDTO;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONArray;

public class JSONReader {

    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    public static JSONArray readJsonArrayFromUrl(String url) throws IOException, JSONException {
        InputStream is = new URL(url).openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            JSONArray json = new JSONArray(jsonText);
            return json;
        } finally {
            is.close();
        }
    }
    
    
    public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
        InputStream is = new URL(url).openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            JSONObject json = new JSONObject(jsonText);
            return json;
        } finally {
            is.close();
        }
    }

    public ArrayList<CarsDTO> fetchAllFromDueinator(int idStart) throws IOException {
        JSONArray json = readJsonArrayFromUrl("https://dueinator.dk/jwtbackend/api/car/all");

        ArrayList<CarsDTO> carList = new ArrayList();
        int indexID = idStart;
        for (Object j : json) {
            JSONObject jobj = new JSONObject(j.toString());
            CarsDTO c = new CarsDTO();
            c.setId(indexID);
            c.setBrand(jobj.getString("manufactor"));
            c.setComments("This car is from one of our partners");
            c.setDistDriven(jobj.getInt("drivingDist"));
            c.setModel(jobj.getString("model"));
            c.setYear(String.valueOf((jobj.getInt("releaseYear"))));
            int price = jobj.getInt("price");
            if (price < 250) {
                c.setPriceClass("A");
            } else if (price < 300) {
                c.setPriceClass("B");
            } else if (price < 350) {
                c.setPriceClass("C");
            } else if (price < 400) {
                c.setPriceClass("D");
            } else {
                c.setPriceClass("E");
            }
            c.setRegno(jobj.getString("regno"));
            carList.add(c);
            indexID++;
        }
        return carList;
    }

    public CarsDTO fetchSingleFromDueinator(String regno) throws IOException {
        CarsDTO c = new CarsDTO();
        JSONObject jobj = new JSONObject(readJsonFromUrl("https://dueinator.dk/jwtbackend/api/car/"+regno));
        c.setBrand(jobj.getString("manufactor"));
        c.setComments("This car is from one of our partners");
        c.setDistDriven(jobj.getInt("drivingDist"));
        c.setModel(jobj.getString("model"));
        c.setYear(String.valueOf((jobj.getInt("releaseYear"))));
        int price = jobj.getInt("price");
        if (price < 250) {
            c.setPriceClass("A");
        } else if (price < 300) {
            c.setPriceClass("B");
        } else if (price < 350) {
            c.setPriceClass("C");
        } else if (price < 400) {
            c.setPriceClass("D");
        } else {
            c.setPriceClass("E");
        }
        c.setRegno(regno);
        return c;
    }
}
