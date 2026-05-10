import java.net.*;
import java.io.*;
import java.util.Scanner;

public class NetworkScanner {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print("Adresse de depart (ex: 192.168.1.1) : ");
        String base = sc.nextLine();
        String prefix = base.substring(0, base.lastIndexOf('.') + 1);
        int start = Integer.parseInt(base.substring(base.lastIndexOf('.') + 1));

        for (int i = start; i < start + 25; i++) {
            String host = prefix + i;
            try {
                Socket s = new Socket();
                s.connect(new InetSocketAddress(host, 1027), 500);
                BufferedReader br = new BufferedReader(
                    new InputStreamReader(s.getInputStream()));
                System.out.println(host + " [ACTIF] -> " + br.readLine());
                s.close();
            } catch (Exception e) {
                System.out.println(host + " [inactif]");
            }
        }
    }
}