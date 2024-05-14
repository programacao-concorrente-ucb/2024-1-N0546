package socket_chat_server;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;

class ClientHandler extends Thread {
    private Socket clientSocket;
    //private BufferedReader in;
    private ObjectOutputStream out;
    private ObjectInputStream in;
           

    public ClientHandler(Socket socket) {
        this.clientSocket = socket;
    }

    public void run() {
        try {
            //in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        	out =
                    new ObjectOutputStream(clientSocket.getOutputStream());
            in = new ObjectInputStream(clientSocket.getInputStream());
            String username = (String) in.readObject();
            System.out.println(username + " joined chat");
            Server.broadcast(username + " entrou pro chat!", this);
            BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));

            String inputLine;
            while ((inputLine = (String) in.readObject()) != null) {
            	System.out.println("mensagem recebida:" + inputLine);
                Server.broadcast(username + ": " + inputLine, this);
            }

            in.close();
            out.close();
            clientSocket.close();
            Server.getClients().remove(this);
            Server.broadcast(username + " has left the chat.", this);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    public void sendMessage(String message) throws IOException {
        out.writeObject(message);
    }
}