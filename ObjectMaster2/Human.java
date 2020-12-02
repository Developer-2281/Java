public class Human {
    protected String name;  // protected class allows inheritance, inheritance of class variables and constructors
    protected int strength;
    protected int intelligence;
    protected int stealth;
    protected int health;

    //constructors
    public Human(String name) {
    this.name = name;
    this.strength = 3;
    this.intelligence = 3;
    this.stealth = 3;
    this.health = 100;
    }

    public Human() {
    this.name = null;
    this.strength = 3;
    this.intelligence = 3;
    this.stealth = 3;
    this.health = 100;
    }

    // methods
    public int displayHealth() {
        System.out.println(Human.this + " Health is at: "+ health); // Human.this returns the class of human
        return health;
    }
    
    public int attack(Human target) {
        target.health -= this.strength;// Whoever called the function their stats are accessible with .this
        System.out.println(target + " Has been attacked for " + this.strength + " damage");
        target.displayHealth();
        return target.health;
    }
}