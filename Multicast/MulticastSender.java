import java.net.*;
import java.io.*;

public class MulticastSender {
    public static void main(String[] args) {
        try {
            InetAddress ia = InetAddress.getByName(args[0]);
            int port = Integer.parseInt(args[1]);

            MulticastSocket ms = new MulticastSocket();
            ms.joinGroup(ia);

            BufferedReader stdin = new BufferedReader(
                new InputStreamReader(System.in));
            System.out.println("Tapez un message puis Entree (Ctrl+C pour quitter) :");

            String line;
            while ((line = stdin.readLine()) != null) {
                byte[] data = line.getBytes();
                ms.send(new DatagramPacket(data, data.length, ia, port));
            }
            ms.close();
        } catch (Exception e) { System.err.println(e); }
    }
}