package com.company;

public class codiceFiscale {

    //attributi
    private String cognome;
    private String nome;

    //costruttori
    public codiceFiscale(String cognome, String nome) {
        this.cognome = cognome;
        this.nome = nome;
    }

    //setter
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    //getter
    public String getCognome() {
        return cognome;
    }

    public String getNome() {
        return nome;
    }

    public String calcoloCog(){
        String cog= "";
        cognome = cognome.toUpperCase();

        for (int i=0; i<cognome.length(); i++){
            if (cog.length()!= 3 && cognome.charAt(i) != 'A' && cognome.charAt(i) != 'E' && cognome.charAt(i) != 'I' && cognome.charAt(i) != 'O' && cognome.charAt(i) != 'U') {
                cog += cognome.charAt(i);
            }
        }

        if (cog.length() != 3) {
            for (int i = 0; i < cognome.length(); i++) {
                if (cog.length() != 3) {
                    if (cognome.charAt(i) == 'A' || cognome.charAt(i) == 'E' || cognome.charAt(i) == 'I' || cognome.charAt(i) == 'O' || cognome.charAt(i) == 'U') {
                        cog += cognome.charAt(i);
                    }
                }
            }
        }

        if (cog.length() != 3){
            do {
                cog += 'X';
            }while (cog.length()!=3);
        }

        return cog;
    }

    public String calcoloNome(){
        String nom= "";
        nome = nome.toUpperCase();

        for (int i=0; i<nome.length(); i++){
            if (nom.length()!= 4 && nome.charAt(i) != 'A' && nome.charAt(i) != 'E' && nome.charAt(i) != 'I' && nome.charAt(i) != 'O' && nome.charAt(i) != 'U') {
                nom += nome.charAt(i);
            }
        }

        if (nom.length()==4){
            nom = nom.substring(0,1) + nom.substring(1+1);
        }

        if (nom.length() != 3) {
            for (int i = 0; i < nome.length(); i++) {
                if (nom.length() != 3) {
                    if (nome.charAt(i) == 'A' || nome.charAt(i) == 'E' || nome.charAt(i) == 'I' || nome.charAt(i) == 'O' || nome.charAt(i) == 'U') {
                        nom += nome.charAt(i);
                    }
                }
            }
        }

        if (nom.length() != 3){
            do {
                nom += 'X';
            }while (nom.length()!=3);
        }

        return nom;
    }
}
