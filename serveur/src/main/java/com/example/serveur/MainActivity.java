package com.example.serveur;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MainActivity extends AppCompatActivity {

    private String serverIP;
    private int serverPort;



    public void init(){
        serverIP="10.0.2.15";
        serverPort=8080;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        ServerThread serverThread = new ServerThread();
        serverThread.start();
    }

    class ServerThread extends Thread {
        private ServerSocket serverSocket;

        @Override
        public void run() {
            try {
                serverSocket = new ServerSocket(serverPort);

                while (true) {
                    final Socket clientSocket = serverSocket.accept();

                    // Get the input and output streams from the socket
                    InputStream in = clientSocket.getInputStream();
                    OutputStream out = clientSocket.getOutputStream();

                    // Create a reader and writer for the streams
                    BufferedReader bf = new BufferedReader(new InputStreamReader(in));
                    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
                    // Read the login credentials from the client

                    int number = Integer.parseInt(bf.readLine());
                    int prix = Integer.parseInt(bf.readLine());
                    Calcul c = new Calcul();

                    int estimation =c.estimate(number,prix);

                    bw.write(String.valueOf(estimation));

                    // Close the streams and socket
                    bw.close();
                    bf.close();
                    out.close();
                    in.close();
                    clientSocket.close();



                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
