public class Test {
    public static void main(String args[]) {
        Human human1 = new Human();
        Wizard wizard1 = new Wizard();
        Ninja ninja1 = new Ninja();
        Samurai samurai1 = new Samurai();
    
        ninja1.displayHealth();
        wizard1.attack(samurai1);
        wizard1.heal(wizard1);
        wizard1.fireball(samurai1);
        ninja1.steal(samurai1);
        ninja1.run();
        samurai1.displayHealth();
        ninja1.attack(samurai1);
        samurai1.deathBlow(ninja1);
        samurai1.meditate();
        samurai1.howMany();
        wizard1.fireball(samurai1);
        wizard1.fireball(samurai1);
        wizard1.fireball(samurai1);
        wizard1.fireball(samurai1);
        wizard1.fireball(samurai1);
    }
}