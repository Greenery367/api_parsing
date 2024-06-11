package ch01.ToDos;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class A {

    public static void main(String[] args) {
        String urlString = "https://jsonplaceholder.typicode.com/todos/2";

        try {
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();

            conn.setRequestMethod("GET");

            int responseCode = conn.getResponseCode();
            System.out.println("HTTP CODE : " + responseCode);

            BufferedReader brIn = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            String inputLine;
            StringBuffer responseBuffer = new StringBuffer();
            while( (inputLine = brIn.readLine()) != null ) {
                responseBuffer.append(inputLine);
            }
            brIn.close();
            System.out.println(responseBuffer);
            Gson gson1 = new GsonBuilder().setPrettyPrinting().create();
            Todo todoObject = gson1.fromJson(responseBuffer.toString(), Todo.class);
            System.out.println(todoObject.getId());


        } catch (Exception e) {
        }


    }
}