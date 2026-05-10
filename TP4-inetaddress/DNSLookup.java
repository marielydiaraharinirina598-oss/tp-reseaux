import java.net.*;
import java.util.Scanner;

public class DNSLookup {
    public static void main(String[] args) throws Exception {
        System.out.println("Machine locale : " + InetAddress.getLocalHost());
        Scanner sc = new Scanner(System.in);
        System.out.println("Entrez un nom (stop pour quitter) :");
        String name;
        while (!(name = sc.nextLine()).equals("stop")) {
            try {
                InetAddress ia = InetAddress.getByName(name);
                System.out.println(name + " -> " + ia.getHostAddress());
            } catch (UnknownHostException e) {
                System.out.println(name + " : hote inconnu");
            }
        }
    }
}