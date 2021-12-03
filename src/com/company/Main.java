package com.company;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner tastiera = new Scanner(System.in);
        codiceFiscale cod1 = new codiceFiscale("", "");

        System.out.println("inserire cognome");
        String cognome= tastiera.next();
        cod1.setCognome(cognome);
        System.out.println(cod1.calcoloCog());

        System.out.println("inserire nome");
        String nome= tastiera.next();
        cod1.setNome(nome);
        System.out.println(cod1.calcoloNome());
    }
}
