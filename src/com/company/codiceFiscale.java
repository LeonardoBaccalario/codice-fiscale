package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class codiceFiscale {

    //attributi
    private String cognome;
    private String nome;
    private String comune;
    private int giorno;
    private int mese;
    private int anno;
    private String sesso;

    //costruttori
    public codiceFiscale(){}

    //setter
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setComune(String comune) {
        this.comune = comune;
    }

    public void setGiorno(int giorno) {
        this.giorno = giorno;
    }

    public void setMese(int mese) {
        this.mese = mese;
    }

    public void setAnno(int anno) {
        this.anno = anno;
    }

    public void setSesso(String sesso) {
        this.sesso = sesso;
    }

    //metodi

    public String calcoloCog() {
        String cog = "";
        cognome = cognome.toUpperCase().replaceAll(" ","");

        for (int i = 0; i < cognome.length(); i++) {
            if (cog.length() != 3 && cognome.charAt(i) != 'A' && cognome.charAt(i) != 'E' && cognome.charAt(i) != 'I' && cognome.charAt(i) != 'O' && cognome.charAt(i) != 'U') {
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

        if (cog.length() != 3) {
            do {
                cog += 'X';
            } while (cog.length() != 3);
        }

        return cog;
    }

    public String calcoloNome() {
        String nom = "";
        nome = nome.toUpperCase();

        for (int i = 0; i < nome.length(); i++) {
            if (nom.length() != 4 && nome.charAt(i) != 'A' && nome.charAt(i) != 'E' && nome.charAt(i) != 'I' && nome.charAt(i) != 'O' && nome.charAt(i) != 'U') {
                nom += nome.charAt(i);
            }
        }

        if (nom.length() == 4) {
            nom = nom.substring(0, 1) + nom.substring(1 + 1);
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

        if (nom.length() != 3) {
            do {
                nom += 'X';
            } while (nom.length() != 3);
        }

        return nom;
    }

    public String codiceCatastale() throws IOException {

        String cod="", string="";

        comune=comune.toUpperCase().replaceAll(" ","");

        FileReader fr=new FileReader("listaCodici.txt");
        BufferedReader br=new BufferedReader(fr);

        while((cod=br.readLine())!=null){
            String[] part=cod.split(";");
            String part0=part[0].replaceAll(" ","");
            if(part0.equals(comune)){
                string=part[1];
            }
        }
        fr.close();
        return string;
    }

    public String data(){
        String dataFinale="";
        String a=Integer.toString(anno).substring(2,4);

        if(sesso.toUpperCase().equals("F")){
            giorno+=40;
        }
        String g=Integer.toString(giorno);
        if(g.length()==1){
            g="0"+g;
        }


        String m="";
        switch(mese) {
            case 1: m="A";
                break;
            case 2: m="B";
                break;
            case 3: m="C";
                break;
            case 4: m="D";
                break;
            case 5: m="E";
                break;
            case 6: m="H";
                break;
            case 7: m="L";
                break;
            case 8: m="M";
                break;
            case 9: m="P";
                break;
            case 10: m="R";
                break;
            case 11: m="S";
                break;
            case 12: m="T";
                break;
        }

        return a+m+g;
    }

    public String controllo(String risFinale) throws IOException {

        int c=0, i=0, j=1;
        String control="", x="";

        char[] codFis=risFinale.toCharArray();

        FileReader fr=new FileReader("conversioneDispari.txt");
        BufferedReader br=new BufferedReader(fr);
        while ((x = br.readLine()) != null && i<codFis.length) {
            String[] p = x.split(";");
            if (p[0].equals(Character.toString(codFis[i]))) {
                c += Integer.parseInt(p[1]);
                i+=2;
                fr.close();
                fr=new FileReader("conversioneDispari.txt");
                br=new BufferedReader(fr);
            }
        }
        fr.close();

        FileReader fr1=new FileReader("conversionePari.txt");
        BufferedReader br1=new BufferedReader(fr1);
        while((x=br1.readLine())!=null && j<codFis.length){
            String[] p1=x.split(";");
            if(p1[0].equals(Character.toString(codFis[j]))){
                j+=2;
                c+=Integer.parseInt(p1[1]);
                fr1.close();
                fr1=new FileReader("conversionePari.txt");
                br1=new BufferedReader(fr1);
            }
        }
        fr1.close();

        c%=26;

        fr=new FileReader("conversionePari.txt");
        br=new BufferedReader(fr);
        while((x=br.readLine())!=null){
            String[] parte=x.split(";");
            if(parte[1].equals(Integer.toString(c))){
                fr.close();
                return control=parte[0];
            }
        }
        return "";
    }
}
