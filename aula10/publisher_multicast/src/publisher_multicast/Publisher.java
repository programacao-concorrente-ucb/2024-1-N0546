package publisher_multicast;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
public class Publisher extends Thread {
    private DatagramSocket socket;
    private InetAddress group;
    private byte[] buf;
    public static void main(String args[]) {
        (new Publisher()).start();
    }
    public void run() {
        try {
    		int i = 1;

        	while(true) {
                String multicastMessage = "Hello world! " + i;
                i++;
                socket = new DatagramSocket();
                group = InetAddress.getByName("230.2.2.2");
                buf = multicastMessage.getBytes();
                DatagramPacket packet
                    = new DatagramPacket(buf, buf.length, group, 4446);
                socket.send(packet);
                socket.close();
                Thread.sleep(3000);
        	}

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
