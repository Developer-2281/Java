public class Wizard extends Human {
    public Wizard(){
        super();
        this.health = 50;
        this.intelligence = 8;
    }
    protected int heal(Human target) {
        target.health += this.intelligence;
        System.out.println("A wizard has healed " + target + " for " + this.intelligence + " health");
        target.displayHealth();
        return target.health;
    }
    protected int fireball(Human target) {
        target.health -= this.intelligence * 3;
        System.out.println("A wizard has attacked " + target + " for " + this.intelligence * 3 + " damage");
        target.displayHealth();
        return target.health;
    }
}

//The Wizard class should have a default health of 50 and intelligence of 8; a method called heal that heals whomever it was cast on for an amount equal to the wizard's intelligence; and a method called fireball that decreases the health of whichever object it attacked by 3 * the wizard's intelligence.