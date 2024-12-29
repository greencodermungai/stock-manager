package com.example.backend;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.http.HttpRequest;
import java.util.Scanner;
import javax.net.ssl.HttpsURLConnection;

import org.json.JSONArray;
import org.json.JSONObject;


/*This class is going to be used to use an api to get stock price data from the internet to my database, 
this will be a very hard class for me to make*/
public class StockAPI {
    /*once this object is feed a stock symbol string it stores things like the stocks volume, and price and certain information about the stock
     * it connects to an api server using an http request scans the output from the server then returns it as a string in json format 
     */
    public StockAPI(String StockSymbole) throws IOException {
    try {
    URL urobject = new URL(("https://www.alphavantage.co/query?function=TIME_SERIES_INTRADAY&symbol=" + StockSymbole + "&interval=1min&apikey=WBW9HMYQ0S0FZ8MZ"));
    HttpsURLConnection connection = (HttpsURLConnection) urobject.openConnection();
    connection.setRequestMethod("GET");
    int responseCode = connection.getResponseCode();
        if (responseCode == HttpsURLConnection.HTTP_OK) {
        StringBuilder sb = new StringBuilder();
        try (Scanner scanner = new Scanner(connection.getInputStream())) {
            while (scanner.hasNext() ) {
                    sb.append(scanner.nextLine());
            } System.out.println(sb);
            } 
            String jsonstring = sb.toString();
            
            this.apioutput = sb;
        } else {}
    } catch (Exception e) {
        System.out.println("api call was unsuccessful");
    }
    }

    /*since this constructor has a try catch initializing the object in other classes requires a try catch witch would require 
    writing a method in another class just to make the object, to fix this i made a static method that allowed me to create a method without
    needing to implement a try catch every time i need to create an object
       */
public static StockAPI createAPIcal(String stcoksymbole) {
    try {
    StockAPI call = new StockAPI(stcoksymbole);
    return call;
    } catch (Exception e) {
    System.out.println("Exception caught during object creation: " + e.getMessage());
    }
 return null;
 }
/*gets a list of all possoble results when a costomer searches for a ticker */
public static JSONArray getStockTickers(String tickerSearch) throws IOException {
    try {
    URL urobject = new URL(("https://www.alphavantage.co/query?function=SYMBOL_SEARCH&keywords=" + tickerSearch +"&apikey=WBW9HMYQ0S0FZ8MZ"));
    HttpsURLConnection connection = (HttpsURLConnection) urobject.openConnection();
    connection.setRequestMethod("GET");
    int responseCode = connection.getResponseCode();
        if (responseCode == HttpsURLConnection.HTTP_OK) {
        StringBuilder sb = new StringBuilder();
        try (Scanner scanner = new Scanner(connection.getInputStream())) {
            while (scanner.hasNext() ) {
                sb.append(scanner.nextLine());
                }
                String jsonstring = sb.toString();
                JSONObject jsonResponse = new JSONObject(jsonstring);
                JSONArray matches = jsonResponse.getJSONArray("bestMatches");
                System.out.println(matches);
                /*matches.optstring(key, N/A) to get key value par */
                return matches;
            }
        } else {}
        return stocksearchresults;
    } catch (Exception e) {
        System.out.println("api call was unsuccessful " + e);
    }
        return stocksearchresults;


}
public StringBuilder apioutput;
public static String tickerSearch;
public static JSONArray stocksearchresults;

}
