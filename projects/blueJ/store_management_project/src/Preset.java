public class Preset extends License {
    private String presetName;

    public Preset(String presetName, Product[] products, Plan plan) {
        super();
        this.presetName = presetName;
    }

    //also broken; I think it's something to do with the weirdness of calling a superclass toString() method for a subclass which is missing some instance variables - idrk
    public String toString() {
        return presetName + "\n" + super.toString();
    }
}
