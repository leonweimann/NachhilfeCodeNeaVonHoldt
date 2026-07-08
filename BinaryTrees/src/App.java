public class App {
    public static void main(String[] args) {
        Baum b = new Baum(0);

        Baum l1 = new Baum(1);
        Baum r2 = new Baum(2);
        l1.setzeRechtenTeilbaum(r2);

        Baum r1 = new Baum(3);

        b.setzeLinkenTeilbaum(l1);
        b.setzeLinkenTeilbaum(r1);

        System.out.println(b.preorder());
    }
}
