package com.loca.addressbook.remoteregistry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;

/**
 * Created by Loca on 2016-12-20.
 */
public class CatalogueClient {

    private String host;
    private int port;

    private Socket socket = null;
    private PrintWriter writer = null;
    private BufferedReader reader = null;


    public CatalogueClient(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void connect(){

        try{socket = new Socket(host, port);
            writer = new PrintWriter(socket.getOutputStream());
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        }catch (ConnectException e) {
            System.err.println("Kan inte ansluta till serverporten: '" + port + "' på adressen: '" + host + "'");
        } catch (UnknownHostException e) {
            System.err.println("Kan inte kontakta servern med adressen: '" + host + "' Okänd host!");
        } catch (Exception e) {
            System.err.println("Ett fel uppstod under anslutning till servern");
        }
    }

    public  void sendRequest(String  request){
        writer.println(request);
        writer.flush();
    }

    public String waitForResponse(){
        try {
            for (String line = reader.readLine(); !line.equals(""); line = reader.readLine()) {
                return line;
            }
            disconnect();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void disconnect(){
        writer.println("exit");
        writer.flush();
        writer.close();
    }
}
