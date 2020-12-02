public class Bat extends Mammal {
    public Bat(){
        super();
        this.energyLevel = 300;
    }
    public void fly() {
        energyLevel -= 50;
        System.out.println("Woosh!!! The Giant Bat has taken to the Air");
        displayEnergy();
    }

    public void eatHumans() {
        energyLevel +=25;
        System.out.println("Arghhhh!!! The Giant Bat has just eaten a human");
        displayEnergy();
    }

    public void attackTown() {
        energyLevel -= 100;
        System.out.println("Crackle, pop, crumble!! The Giant Bat like a dragon attacked and burned the town");
        displayEnergy();
    }
}