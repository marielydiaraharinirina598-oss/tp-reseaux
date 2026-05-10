import java.util.Scanner;
import java.io.*;

public class Exo1b_FileCopy {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print("Fichier source : "); String in  = sc.nextLine();
        System.out.print("Fichier dest   : "); String out = sc.nextLine();
        BufferedReader br = new BufferedReader(new FileReader(in));
        PrintStream    ps = new PrintStream(new FileOutputStream(out));
        String line;
        while ((line = br.readLine()) != null) ps.println(line);
        br.close(); ps.close();
        System.out.println("Copie terminee.");
    }
}