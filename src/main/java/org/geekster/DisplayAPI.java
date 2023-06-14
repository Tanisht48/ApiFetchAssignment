package org.geekster;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

public class DisplayAPI {
    int responseCode;
    HttpURLConnection connection;
            DisplayAPI(int responseCode,HttpURLConnection connection )
            {
                this.responseCode = responseCode;
                this.connection = connection;
            }


}
