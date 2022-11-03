public class Preset extends License {
    private String presetName;

    public Preset(Product[] products, Plan plan, String presetName) {
        super(products, plan);
        this.presetName = presetName;
    }

    //also broken; I think it's something to do with the weirdness of calling a superclass toString() method for a subclass which is missing some instance variables - idrk
    public String toString() {
        return super.toString();
    }
}
