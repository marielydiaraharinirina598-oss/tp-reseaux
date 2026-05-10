import java.net.*;
import java.util.Scanner;

public class UDPClient {
    public static void main(String[] args) throws Exception {
        DatagramSocket ds = new DatagramSocket();
        InetAddress ia = InetAddress.getByName("localhost");
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            byte[] data = sc.nextLine().getBytes();
            ds.send(new DatagramPacket(data, data.length, ia, 9876));
        }
        ds.close();
    }
}