package com.company;

import java.io.IOException;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner tastiera = new Scanner(System.in);
        codiceFiscale cod1 = new codiceFiscale();

        System.out.println("inserire nome");
        cod1.setNome(tastiera.nextLine());

        System.out.println("inserire cognome");
        cod1.setCognome(tastiera.nextLine());

        System.out.println("Inserire sesso (M o F)");
        cod1.setSesso(tastiera.nextLine());

        System.out.println("inserire comune di nascita");
        cod1.setComune(tastiera.nextLine());

        System.out.println("inserire giorno di nascita");
        cod1.setGiorno(tastiera.nextInt());

        System.out.println("inserire mese di nascita");
        cod1.setMese(tastiera.nextInt());

        System.out.println("inserire anno di nascita");
        cod1.setAnno(tastiera.nextInt());

        String risFinale=cod1.calcoloCog()+cod1.calcoloNome()+cod1.data()+cod1.codiceCatastale();

        System.out.println("Il codice fiscale è "+cod1.calcoloCog()+cod1.calcoloNome()+cod1.data()+cod1.codiceCatastale()+cod1.controllo(risFinale));
    }
}
