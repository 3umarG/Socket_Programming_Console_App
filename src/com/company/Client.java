package com.company;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            // Socket with localhost and the same port in server ...
            Socket socket = new Socket("localhost", 2023);

            // DataInputStream to Read Data from Server ...
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());

            // DataOutputStream to Write Data to Server ...
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

            // Accept Ready Message from Server :
            System.out.println(dataInputStream.readUTF());

            // Write Message and send it to server ...
            Scanner scanner = new Scanner(System.in);
            System.out.print("Please Enter Your Message : ");
            String clientMess = scanner.nextLine();
            dataOutputStream.writeUTF(clientMess);

            // Close our Resources ...
            dataOutputStream.close();
            dataInputStream.close();
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
