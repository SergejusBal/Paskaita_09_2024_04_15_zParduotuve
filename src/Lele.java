public class Lele extends Zaislas {


    private Sukuosenos sukuosenos;

    public Lele(){}
    public Lele(String pavadinimas, String gamintojas, int amziausRiba, double kaina,Sukuosenos sukuosenos){
        super(pavadinimas, gamintojas, amziausRiba, kaina);
        this.sukuosenos = sukuosenos;
    }
    public Sukuosenos getSukuosenos() {
        return sukuosenos;
    }

    public void setSukuosenos(Sukuosenos sukuosenos) {
        this.sukuosenos = sukuosenos;
    }
}
