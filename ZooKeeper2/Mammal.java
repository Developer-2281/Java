public class Mammal {
    protected String name;  // private class allows inheritance, inheritance of class variables and constructors
    protected int energyLevel;

    //constructors
    public Mammal(String name) {
    this.name = name;
    this.energyLevel = 100;
    }
    public Mammal() {
    this.name = null;
    this.energyLevel = 100;
    }
    // methods
    public int displayEnergy() {
        System.out.println("Energy level is: "+ energyLevel);
        return energyLevel;
    }
}