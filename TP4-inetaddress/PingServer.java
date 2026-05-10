import java.net.*;
import java.io.*;
import java.time.LocalTime;

public class PingServer {
    public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(1027);
        System.out.println("PingServer actif - port 1027");
        while (true) {
            Socket s = ss.accept();
            PrintWriter pw = new PrintWriter(s.getOutputStream(), true);
            pw.println("OK " + LocalTime.now());
            s.close();
        }
    }
}