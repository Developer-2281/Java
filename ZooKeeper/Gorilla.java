public class Gorilla extends Mammal {
    public Gorilla(){
        super();
    }
    public void throwSomething() {
        energyLevel -= 5;
        System.out.println("A Gorilla threw a banana at you");
        displayEnergy();
    }

    public void eatBananas() {
        energyLevel +=10;
        System.out.println("The Gorilla happily has regained his energy eating Bananas");
        displayEnergy();
    }

    public void climb() {
        energyLevel -= 10;
        System.out.println("The Gorilla has climbed a tree and tired himself");
        displayEnergy();
    }
}