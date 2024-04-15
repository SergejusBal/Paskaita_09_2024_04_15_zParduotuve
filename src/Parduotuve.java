import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Parduotuve {

    private ArrayList<Zaislas> zaisluSarasas;
    private ArrayList<Zaislas> paimtuZaisluSararas;
    private Scanner scanner;
    private Random random;

    public Parduotuve(){
        zaisluSarasas = new ArrayList<>();
        paimtuZaisluSararas = new ArrayList<>();
        Random random = new Random();
        scanner = new Scanner(System.in);
    }

    public void setZaisluSarasas(ArrayList<Zaislas> zaisluSarasas) {
        this.zaisluSarasas = zaisluSarasas;
    }

    public ArrayList<Zaislas> getZaisluSarasas() {
        return zaisluSarasas;
    }

    public void idetiZaisla(){
        Zaislas zaislas = gautiZaisloTipa();
        zaislas.setPavadinimas(gautiPavadinima());
        zaislas.setGamintojas(gautiPamintoja());
        zaislas.setAmziausRiba(gautiMinAmziu());
        zaislas.setKaina(gautiKaina());
        zaisluSarasas.add(zaislas);
    }

    public void idetiZaisla(Zaislas zaislas){
        zaisluSarasas.add(zaislas);
    }

    public void isimtiZaila(){
        String pavadinimas = gautiPavadinima();
        for(int index = 0; index <zaisluSarasas.size(); index++ ){
            if (zaisluSarasas.get(index).getPavadinimas().equals(pavadinimas)) {
                zaisluSarasas.remove(index);
                System.out.println(pavadinimas + " yra isimtas");
            }
            else{
                System.out.println("Tokio Zaislo nera");
            }
        }
    }

    public void idetiZailaIKrepseli(){
        if (zaisluSarasas.size() == 0) {
            System.out.println("Zaislu parduotuveje nera");
            return;
        }

        String pavadinimas = gautiPavadinima();
        Zaislas zaislas = null;
        for(int index = 0; index < zaisluSarasas.size(); index++ ){
            if (zaisluSarasas.get(index).getPavadinimas().equals(pavadinimas)) {
                zaislas = zaisluSarasas.remove(index);
                paimtuZaisluSararas.add(zaislas);
                break;
            }

        }
        if(zaislas==null) System.out.println("Tokio Zaislo nera");
    }

    public double skaiciotiKrepsialioSuma(){
        double kaina = 0;
        for (Zaislas z : paimtuZaisluSararas) kaina += z.getKaina();
        return kaina;
    }

    private String nuskaityti(){
        String verte = null;
        try {
            verte = scanner.nextLine();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return verte;
    }

    private Zaislas gautiZaisloTipa(){
        Zaislas zaislas = null;
        int tipas = -1;
        System.out.println("Iveskite Zaislo tipa: 1 Lele, 2 Konstruktorius");

        try {
            tipas = Integer.parseInt(nuskaityti());
        } catch (NumberFormatException e) {
            System.out.println("Ivyko Klaida, bandykite dar karta");
            return gautiZaisloTipa();
        }
        switch (tipas) {
            case 1:
                zaislas = new Lele();
                ((Lele) zaislas).setSukuosenos(gautiSukuosena());;
                break;
            case 2:
                zaislas = new Konstruktorius();
                ((Konstruktorius) zaislas).setDetaliuKiekis(gautiDetaliuKieki());
                break;
            default:
                System.out.println("Tokio zaislo nera");
                return gautiZaisloTipa();
        }
        return zaislas;
    }

    private int gautiDetaliuKieki(){
        int i;
        System.out.println("Iveskite detaliu kieki: ");
        try {
            i = Integer.parseInt(nuskaityti());
        } catch (NumberFormatException e) {
            System.out.println("Ivyko Klaida, bandykite dar karta");
            return gautiDetaliuKieki();
        }
        return i;
    }

    private Sukuosenos gautiSukuosena(){
      int i = -1;
      System.out.println("Iveskite sukuosenos nr: \n" +
              "Uodega 0, Apvalus 1, IlgosKasos 2, Trumpas 3, SoninisPakrastys 4, IlgosBangos 5, PusiauAukstyn 6, Garbanoti 7");
        try {
            i = Integer.parseInt(nuskaityti());
        } catch (NumberFormatException e) {
            System.out.println("Ivyko Klaida, bandykite dar karta");
            return gautiSukuosena();
        }
        if(i > Sukuosenos.values().length){
            System.out.println("Ivyko Klaida, bandykite dar karta");
            return gautiSukuosena();
        }
        return Sukuosenos.values()[i];
    }

    private String gautiPavadinima(){
        System.out.println("Iveskite zaislo pavadinima");
        return nuskaityti();
    }

    private String gautiPamintoja(){
        System.out.println("Iveskite gamintojo pavadinima");
        return nuskaityti();
    }

    private int gautiMinAmziu(){
        int i;
        System.out.println("Iveskite minimalu amziu: ");
        try {
            i = Integer.parseInt(nuskaityti());
        } catch (NumberFormatException e) {
            System.out.println("Ivyko Klaida, bandykite dar karta");
            return gautiMinAmziu();
        }
        return i;
    }

    private double gautiKaina(){
        double i;
        System.out.println("Iveskite Kaina: ");
        try {
            i = Double.parseDouble(nuskaityti());
        } catch (NumberFormatException e) {
            System.out.println("Ivyko Klaida, bandykite dar karta");
            return gautiKaina();
        }
        return i;
    }

    public void atidarytiParduotuveUI() {
        System.out.println("Ar norite prideti zaisla i krepseli (1), ar norite skaicioti kaina (2)?");
        int tipas = -1;
        try {
            tipas = Integer.parseInt(nuskaityti());
        } catch (NumberFormatException e) {
            System.out.println("Ivyko Klaida, bandykite dar karta");
            atidarytiParduotuveUI();
            return;
        }
        switch (tipas) {
            case 1:
                idetiZailaIKrepseli();
                break;
            case 2:
                System.out.println(skaiciotiKrepsialioSuma());
                break;
            default:
                System.out.println("Tokios komandos nera.");
                atidarytiParduotuveUI();
                break;

        }
    }

    public boolean atsakymas() {
        while(true) {
            String scVerte = scanner.nextLine();
            if(scVerte.toUpperCase().equals("T")) return true;
            else if (scVerte.toUpperCase().equals("N")) return false;
        }
    }


}
