public class Ninja extends Human {
    public Ninja(){
        super();
        this.stealth = 10;
    }
    protected int steal(Human target) {
        target.health -= this.stealth;
        this.health += this.stealth;
        System.out.println("A ninja has stolen " + this.stealth + " health from " + target);
        target.displayHealth();
        this.displayHealth();
        return target.health  + this.health;
    }
    protected int run() {
        this.health -= 10;
        System.out.println("The Ninja has lost 10 health running away.");
        this.displayHealth();
        return this.health;
    }
}

//The Ninja class should have a default stealth of 10; a method, steal, that takes health from another human by their stealth level, and a way to run away that decreases their health by 10.