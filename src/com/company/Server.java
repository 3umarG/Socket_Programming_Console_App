package com.company;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        ServerSocket serverSocket;
        Socket socket;
        DataInputStream dataInputStream;
        DataOutputStream dataOutputStream;

        try {
            // The port should be above 1023
            // The Port will be the same in the client socket
            serverSocket = new ServerSocket(2023);

            socket = serverSocket.accept();

            // DataInputStream : The link between server to user to accept message ...
            dataInputStream = new DataInputStream(socket.getInputStream());

            // DataOutputStream : The link between user to Server to send message ...
            dataOutputStream = new DataOutputStream(socket.getOutputStream());

            // Send Message from Server to Client for READY !!
            dataOutputStream.writeUTF("Server is Ready ...");

            // Accept the message and print it
            String clientMess = dataInputStream.readUTF();
            System.out.println("Client Message : " + clientMess);

            // Close all Resources ...
            dataInputStream.close();
            dataOutputStream.close();
            socket.close();
            serverSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
