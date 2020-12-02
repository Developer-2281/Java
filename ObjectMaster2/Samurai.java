public class Samurai extends Human {
    static int samuraiNum = 0;

    public Samurai(){
        super();
        this.health = 200;
        samuraiNum += 1;   
    }
    protected int deathBlow(Human target) {
        target.health = 0;
        this.health = this.health /2;
        System.out.println("A samurai has dealt a deathblow to " + target + " at a cost of half his life");
        target.displayHealth();
        this.displayHealth();
        return target.health + this.health;
    }
    protected int meditate() {
        this.health += this.health /2;
        System.out.println("A samurai has regained half his current life meditating");
        this.displayHealth();
        return this.health;
    }
    public int howMany() {
        System.out.println("There is " + samuraiNum + " samurai currently instanced");
        return samuraiNum;
        }
}

// conflicting instructions for Samurai class concerning meditate()

// Samurai: Set a default health of 200

// Samurai: Add a method deathBlow(Human) that kills the other human, but reduces the Samurai's health by half

// Samurai: Add a method meditate() that heals the Samurai for half of their current health.

// Samurai: Add a method howMany() that returns the total current number of Samurai.

// The Samurai class should have a default health of 200; a method called deathBlow that attacks an object and decreases its health to 0, but also halves the Samurai's health; a method called meditate which heals the Samurai back to full health; and a method called howMany that returns the current number of Samurai.