package org.geekster;


import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class Jokes {

    URL url = null;
   private HttpURLConnection connection;
   private int responseCode;



//getting the url path

    void connectionBuilder(String urlString)throws IOException{
        try {
        url = new URL(urlString);
    }catch(MalformedURLException e) {
        System.out.println("problem in connection");
    }
    //connection
    try {
        connection = (HttpURLConnection) url.openConnection(); //typecasting
        responseCode = connection.getResponseCode();//the response that we get
    } catch(Exception e) {
        System.out.println("Connection problem");
    }


    }
    void Display() throws IOException {
        if (responseCode == 200) {
            BufferedReader input = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder apiData = new StringBuilder();
            String readline;

            while ((readline = input.readLine()) != null) {
                apiData.append(readline);

            }

            try {
                input.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            //Printing the data as json
            JSONObject jsonAPIResponse = new JSONObject(apiData.toString());
            System.out.println("icon_url: "+jsonAPIResponse.get("icon_url"));
            System.out.println("updated_at: "+jsonAPIResponse.get("updated_at"));
            System.out.println("created_at: "+jsonAPIResponse.get("created_at"));
            System.out.println("id: "+jsonAPIResponse.get("id"));
            System.out.println("value: "+jsonAPIResponse.get("value"));
            System.out.println("url: "+jsonAPIResponse.get("url"));


        } else
            System.out.println("API call could not be made");
    }

}
/*{"icon_url":"https://assets.chucknorris.host/img/avatar/chuck-norris.png",
"updated_at":"2020-01-05 13:42:25.352697","created_at":"2020-01-05 13:42:25.352697","categories":[],
"id":"ao-Te_oiTA-SxSjR3zLE9g","value":"when Chuck Norris
plays the Wii he uses the t.v remote.","url":"https://api.chucknorris.io/jokes/ao-Te_oiTA-SxSjR3zLE9g"}*/