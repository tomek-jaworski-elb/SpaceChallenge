public interface SpaceShip {
    boolean launch();
        //indicating if the launch was successful or if the rocket has crashed.

    boolean land();
        // based on the success of the landing.

    boolean canCarry(Item item) ;
        // a method that takes an Item as an argument and returns true if the rocket can carry
        // such item or false if it will exceed the weight limit.

    void carry(Item item);
        //a method that also takes an Item object and updates the current weight of the rocket.


}
