package socket_server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	    public static void main(String[] args) {
	        String mensagem = "Hello world!";
	        try {
	            ServerSocket servidor = new ServerSocket(8000);
	            System.out.println("Esperando cliente se conectar...");
	            Socket socket = servidor.accept();
	            ObjectOutputStream saida =
	                new ObjectOutputStream(socket.getOutputStream());
	            ObjectInputStream entrada =
	                new ObjectInputStream(socket.getInputStream());
	            for (int i = 0; i < mensagem.length(); i++) {
	            	// enviando dados para o cliente
	                saida.writeObject(String.valueOf(mensagem.charAt(i)));
	                
	                // mensagem do cliente indicando recebimento:
	                System.out.println("Cliente avisando do recebimento: " + entrada.readObject());
	            }
	            saida.writeObject(null);
	            entrada.close();
	            saida.close();
	            socket.close();
	            servidor.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        }
	    }
	}


