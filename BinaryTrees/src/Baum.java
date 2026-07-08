import java.util.ArrayList;

public class Baum {
    private Integer inhalt;
    private Baum vaterKnoten;
    private Baum linkerTeilbaum;
    private Baum rechterTeilbaum;

    public Baum(int inhalt) {
        setzeInhalt(inhalt);
    }

    public void setzeInhalt(int inhalt) {
        this.inhalt = inhalt;
    }

    public Integer inhalt() {
        return inhalt;
    }

    public void setzeLinkenTeilbaum(Baum linkerTeilbaum) {
        linkerTeilbaum.vaterKnoten = this;
        this.linkerTeilbaum = linkerTeilbaum;
    }

    public Baum linkerTeilbaum() {
        return linkerTeilbaum;
    }

    public void setzeRechtenTeilbaum(Baum rechterTeilbaum) {
        rechterTeilbaum.vaterKnoten = this;
        this.rechterTeilbaum = rechterTeilbaum;
    }

    public Baum rechterTeilbaum() {
        return rechterTeilbaum;
    }

    public boolean istWurzel() {
        return vaterKnoten == null;
    }

    public ArrayList<Integer> preorder() {
        ArrayList<Integer> list = new ArrayList<>();

        list.add(inhalt);
        if (linkerTeilbaum != null)
            list.addAll(linkerTeilbaum.preorder());
        if (rechterTeilbaum != null)
            list.addAll(rechterTeilbaum.preorder());

        return list;
    }
}
