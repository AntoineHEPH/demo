package condorcet.be.demo1.model;

public class Creator {
    private String name;
    private int subs;

    public Creator(String name, int subs) {
        this.name = name;
        this.subs = subs;
    }

    public String getName() {
        return name;
    }

    public int getSubs() {
        return subs;
    }
}
