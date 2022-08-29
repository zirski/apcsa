public class Salutations {
    private String name;

    public Salutations(String MyName) {
        name = MyName;
    }

    // prints various addresses and signatures, all for a given name `name`
    public void addressLetter() {
        System.out.println("Dear " + name + ",");
    }

    public void signLetter() {
        System.out.println("Sincerely, " + name);
    }

    public void addressMemo() {
        System.out.println("To whom it may concern");
    }

    public void signMemo() {
        System.out.println("Best, " + name);
    }

}

