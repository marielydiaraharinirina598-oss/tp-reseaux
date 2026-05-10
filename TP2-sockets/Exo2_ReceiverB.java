import java.net.*;
import java.io.*;

public class Exo2_ReceiverB {
    public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(1027);
        System.out.println("B en attente sur le port 1027...");
        Socket s = ss.accept();
        BufferedReader br = new BufferedReader(
            new InputStreamReader(s.getInputStream()));
        String line;
        while ((line = br.readLine()) != null && !line.equals("stop"))
            System.out.println("[B reçoit] " + line);
        System.out.println("Connexion fermée.");
        s.close(); ss.close();
    }
}