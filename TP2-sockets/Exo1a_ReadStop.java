import java.util.Scanner;

public class Exo1a_ReadStop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line;
        while (!(line = sc.nextLine()).equals("stop"))
            System.out.println(line);
        sc.close();
    }
}