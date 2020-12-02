public class Test {
    public static void main(String args[]) {
        Human human1 = new Human();
        Wizard wizard1 = new Wizard();
        Ninja ninja1 = new Ninja();

        ninja1.displayHealth();
        Samurai samurai1 = new Samurai();
        wizard1.attack(samurai1);
    }
}