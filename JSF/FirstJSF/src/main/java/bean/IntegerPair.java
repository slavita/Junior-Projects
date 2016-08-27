package bean;

public class IntegerPair {
    private int fst;
    private int snd;

    public IntegerPair() {
    }

    public IntegerPair(int fst, int snd) {
        this.fst = fst;
        this.snd = snd;
    }

    public int getFst() {
        return fst;
    }

    public void setFst(int fst) {
        this.fst = fst;
    }

    public int getSnd() {
        return snd;
    }

    public void setSnd(int snd) {
        this.snd = snd;
    }
}