import java.net.*;
import java.io.*;
import java.util.*;

public class ChatServer {
    static List<PrintWriter> clients = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(1027);
        System.out.println("Serveur chat démarré - port 1027");
        while (true)
            new Thread(new ClientHandler(ss.accept())).start();
    }

    static synchronized void broadcast(String msg, PrintWriter moi) {
        for (PrintWriter pw : clients)
            if (pw != moi) pw.println(msg);
    }
    static synchronized void add(PrintWriter pw)    { clients.add(pw); }
    static synchronized void remove(PrintWriter pw) { clients.remove(pw); }
}

class ClientHandler implements Runnable {
    Socket s;
    ClientHandler(Socket s) { this.s = s; }
    public void run() {
        PrintWriter pw = null;
        try {
            BufferedReader br = new BufferedReader(
                new InputStreamReader(s.getInputStream()));
            pw = new PrintWriter(s.getOutputStream(), true);
            ChatServer.add(pw);
            String line;
            while ((line = br.readLine()) != null)
                ChatServer.broadcast(line, pw);
        } catch (Exception e) { System.out.println("Client déconnecté"); }
        finally {
            if (pw != null) ChatServer.remove(pw);
            try { s.close(); } catch (Exception ignore) {}
        }
    }
}