package utils;

import java.util.Scanner;

public class InputHandler {
    Scanner scanner;

    public InputHandler() {
        this.scanner = new Scanner(System.in);
    }

    public String getStringInput(String Promet){
        System.out.println(Promet);
        return scanner.nextLine();
    }

    public int getIntgerinput(String Promet){
        System.err.println(Promet);
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid Number!");
            return 0;
        }
    }

    public void close(){
        scanner.close();
    }
}
