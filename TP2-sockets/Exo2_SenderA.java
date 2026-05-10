import java.net.*;
import java.io.*;
import java.util.Scanner;

public class Exo2_SenderA {
    public static void main(String[] args) throws Exception {
        String host = args.length > 0 ? args[0] : "localhost";
        Socket s = new Socket(host, 1027);
        PrintWriter pw = new PrintWriter(s.getOutputStream(), true);
        Scanner sc = new Scanner(System.in);
        System.out.println("Connecté. Tapez (stop pour quitter) :");
        String line;
        while (!(line = sc.nextLine()).equals("stop"))
            pw.println(line);
        pw.println("stop");
        s.close();
    }
}