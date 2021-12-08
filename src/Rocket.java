public class Rocket implements SpaceShip {
    @Override
    public boolean launch() {
        // launch and land methods in the Rocket class should always return true. When U1 and U2 classes extend
        // the Rocket class they will override these methods to return true or false based on the actual
        // probability of each type.
        return false;
    }

    @Override
    public boolean land() {
        // launch and land methods in the Rocket class should always return true. When U1 and U2 classes
        // extend the Rocket class they will override these methods to return true or false based on the
        // actual probability of each type.
        return false;
    }

    @Override
    public boolean canCarry(Item item) {
        // should be implemented here and will not need to be overridden in the U1 and U2 classes
        return false;
    }

    @Override
    public void carry(Item item) {
        // should be implemented here and will not need to be overridden in the U1 and U2 classes

    }
}
