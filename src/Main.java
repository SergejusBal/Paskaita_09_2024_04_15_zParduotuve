import java.sql.SQLOutput;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


        ///////////////////////////////////////////////
        //////// Parduotuve

        System.out.println();
        System.out.println("Parduotuve");
        System.out.println();


        Parduotuve parduotuve = new Parduotuve();
        Zaislas barbe = new Lele("Barbe", "Barbie", 3,129.99, Sukuosenos.IlgosKasos);
        Zaislas lego = new Konstruktorius("Star Wars Millennium", "Lego",3,199.99,50);
        Zaislas kenas = new Lele("Kenas", "Barbie", 3,129.99, Sukuosenos.Trumpi);

        parduotuve.idetiZaisla(barbe);
        parduotuve.idetiZaisla(lego);
        parduotuve.idetiZaisla(kenas);

        while(true) {
            System.out.println("Ar norite prideti zaisla i parduotuve? (T/N)");
            if(!parduotuve.atsakymas()) break;
            parduotuve.idetiZaisla();
        }

//        while(true){
//            System.out.println("Ar pirkti (T/N)");
//            if(!parduotuve.atsakymas()) break;
//            parduotuve.idetiZailaIKrepseli();
//        }
//        System.out.println("Suma: " + parduotuve.skaiciotiKrepsialioSuma() + "Eur");

        while(true) {
            parduotuve.atidarytiParduotuveUI();
            System.out.println("Ar testi? (T/N)");
            if(!parduotuve.atsakymas()) break;
        }
    }
}