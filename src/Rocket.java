public class Rocket implements SpaceShip {

    private int costDollars;
    private int weightKgs;
    private int maxWeightWithCargoKgs;
    private int currentWeightKgs;
    private int maxCargoWeightKgs;


    @Override
    public boolean launch() {
        // launch and land methods in the Rocket class should always return true. When U1 and U2 classes extend
        // the Rocket class they will override these methods to return true or false based on the actual
        // probability of each type.
        return true;
    }

    @Override
    public boolean land() {
        // launch and land methods in the Rocket class should always return true. When U1 and U2 classes
        // extend the Rocket class they will override these methods to return true or false based on the
        // actual probability of each type.
        return true;
    }

    @Override
    public boolean canCarry(Item item) {
        // should be implemented here and will not need to be overridden in the U1 and U2 classes
        if ( maxCargoWeightKgs >= (currentWeightKgs + item.getWeight())) {
            return true;
        }
        else {
            System.out.println("Max loaded with item: " + item.getName());
            return false;
        }

    }

    @Override
    public void carry(Item item) {
        // should be implemented here and will not need to be overridden in the U1 and U2 classes
        System.out.println("Item added to load: " + item.getName() + " with weight: " + item.getWeight());
        currentWeightKgs += item.getWeight();
    }

    public void setMaxWeightWithCargoKgs(int maxWeightWithCargoKgs) {
        this.maxWeightWithCargoKgs = maxWeightWithCargoKgs;
    }

    public void setCostDollars(int costDollars) {
        this.costDollars = costDollars;
    }

    public int getWeightKgs() {
        return weightKgs;
    }

    public void setWeightKgs(int weightKgs) {
        this.weightKgs = weightKgs;
    }

    public int getCostDollars() {
        return costDollars;
    }

    public int getMaxWeightWithCargoKgs() {
        return maxWeightWithCargoKgs;
    }

    public int getCurrentWeightKgs() {
        return currentWeightKgs;
    }

    public void setCurrentWeightKgs(int currentWeightKgs) {
        this.currentWeightKgs = currentWeightKgs;
    }

    public int getMaxCargoWeightKgs() {
        return maxCargoWeightKgs;
    }

    public void setMaxCargoWeightKgs(int maxCargoWeightKgs) {
        this.maxCargoWeightKgs = maxCargoWeightKgs;
    }
}
