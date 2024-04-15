public class Konstruktorius extends Zaislas{
    private int detaliuKiekis;

    public Konstruktorius(){}
    public Konstruktorius(String pavadinimas, String gamintojas, int amziausRiba, double kaina,int detaliuKiekis){
        super(pavadinimas, gamintojas, amziausRiba, kaina);
        this.detaliuKiekis = detaliuKiekis;
    }

    public int getDetaliuKiekis() {
        return detaliuKiekis;
    }

    public void setDetaliuKiekis(int detaliuKiekis) {
        this.detaliuKiekis = detaliuKiekis;
    }


}
