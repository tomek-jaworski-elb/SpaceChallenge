public class Rocket extends SpaceShip {
    public boolean launch() {
        // methods in the Rocket class should always return true. When U1 and U2 classes extend the Rocket class
        // they will override these methods to return true or false based on the actual probability of each type.
        return true;
    }
    public boolean land() {
        // methods in the Rocket class should always return true. When U1 and U2 classes extend the Rocket class
        // they will override these methods to return true or false based on the actual probability of each type.
        return true;
    }

//    @Override
    public boolean canCarry(Item item) {
        // should be implemented here and will not need to be overridden in the U1 and U2 classes
        return super.canCarry(item);
    }

//    @Override
    public void carry(Item item) {
        // should be implemented here and will not need to be overridden in the U1 and U2 classes
        super.carry(item);
    }
}
