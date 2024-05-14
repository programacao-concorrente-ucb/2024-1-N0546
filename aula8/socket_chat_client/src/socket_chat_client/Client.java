package socket_chat_client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import java.io.*;
import java.net.*;

public class Client {
    private static final String SERVER_ADDRESS = "10.130.34.106";
    private static final int SERVER_PORT = 5000;

    public static void main(String[] args) throws ClassNotFoundException {
        try {
            Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
            ObjectInputStream in =   new ObjectInputStream(socket.getInputStream());

            ObjectOutputStream out =
                    new ObjectOutputStream(socket.getOutputStream());
            BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Connected to the server.");

            System.out.print("Enter your username: ");
            String username = stdIn.readLine();
            System.out.println("username: " + username);
            out.writeObject(username);
            out.flush();

            Thread readerThread = new Thread(() -> {
                try {
                    String serverMessage;
                    while ((serverMessage = (String) in.readObject()) != null) {
                        System.out.println(serverMessage);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            });
            readerThread.start();
            
            String inputLine;
            while ((inputLine = stdIn.readLine()) != null) {
                out.writeObject(inputLine + "\n");
                out.flush();

                
            }

            in.close();
            out.close();
            stdIn.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
