import java.net.*;

public class MulticastReceiver {
    public static void main(String[] args) {
        try {
            byte[] buffer = new byte[1024];
            InetAddress ia = InetAddress.getByName(args[0]);
            int port = Integer.parseInt(args[1]);

            MulticastSocket ms = new MulticastSocket(port);
            ms.setReuseAddress(true);
            ms.joinGroup(ia);
            System.out.println("Groupe rejoint : " + ia + ":" + port);

            while (true) {
                DatagramPacket dp = new DatagramPacket(buffer, buffer.length);
                ms.receive(dp);
                System.out.println("Recu de " + dp.getAddress()
                    + " : " + new String(dp.getData(), 0, dp.getLength()));
            }
        } catch (Exception e) { System.err.println(e); }
    }
}