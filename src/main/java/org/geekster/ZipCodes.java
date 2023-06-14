package org.geekster;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class ZipCodes {
    URL url = null;
    private HttpURLConnection connection;
    private int responseCode;



//getting the url path

    void connectionBuilder(String urlString)throws IOException {
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
            System.out.println("country: "+jsonAPIResponse.get("country"));
            System.out.println("places: "+jsonAPIResponse.get("places"));
            System.out.println("country abbreviation: "+jsonAPIResponse.get("country abbreviation"));
            System.out.println("post code: "+jsonAPIResponse.get("post code"));






        } else
            System.out.println("API call could not be made");
    }

}
/*{"country":"United States","places":[{"latitude":"25.9286","state":"Florida","state abbreviation":"FL",
"place name":"Miami","longitude":"-80.183"}],"country abbreviation":"US","post code":"33162"}
 */