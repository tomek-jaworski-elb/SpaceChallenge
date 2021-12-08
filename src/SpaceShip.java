public class SpaceShip {
    public boolean launch() {
        //indicating if the launch was successful or if the rocket has crashed.
        return false;
    }

    public boolean land() {
        // based on the success of the landing.
        return false;
    }

    public boolean canCarry(Item item) {
        // a method that takes an Item as an argument and returns true if the rocket can carry
        // such item or false if it will exceed the weight limit.
        return false;
    }

    public void carry(Item item) {
        //a method that also takes an Item object and updates the current weight of the rocket.

    }
}
