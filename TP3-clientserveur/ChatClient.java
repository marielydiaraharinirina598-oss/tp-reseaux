import java.net.*;
import java.io.*;
import java.util.Scanner;

public class ChatClient {
    public static void main(String[] args) throws Exception {
        String host = args.length > 0 ? args[0] : "localhost";
        Socket s = new Socket(host, 1027);
        BufferedReader netIn = new BufferedReader(
            new InputStreamReader(s.getInputStream()));
        PrintWriter netOut = new PrintWriter(s.getOutputStream(), true);

        new Thread(() -> {
            try {
                String line;
                while ((line = netIn.readLine()) != null)
                    System.out.println("[Reçu] " + line);
            } catch (Exception e) {}
        }).start();

        Scanner sc = new Scanner(System.in);
        System.out.println("Connecté au chat. Tapez vos messages :");
        while (sc.hasNextLine()) netOut.println(sc.nextLine());
        s.close();
    }
}