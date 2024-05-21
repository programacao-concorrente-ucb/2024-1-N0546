package receiver_multicast;


import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class Receiver extends Thread {
    protected MulticastSocket socket = null;
    protected byte[] buf = new byte[256];
    public static void main(String args[]) {
        (new Receiver()).start();
    }
    public void run() {
        try {
            socket = new MulticastSocket(4446);
            InetAddress group = InetAddress.getByName("230.2.2.2");
            socket.joinGroup(group);
            while (true) {
                DatagramPacket packet = new DatagramPacket(buf, buf.length);
                System.out.println("aguardando msg");
                socket.receive(packet);
                String received = new String(
                    packet.getData(), 0, packet.getLength());
                System.out.println("recebida msg:" + received);
                if ("end".equals(received)) {
                    break;
                }
            }
            socket.leaveGroup(group);
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
