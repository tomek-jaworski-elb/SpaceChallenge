public class U1 extends Rocket {

    private final int costDollars = 100000000;
    private final int weightKgs = 10000;
    private final int maxWeightWithCargoKgs = 18000;

    //Chance of launch explosion = 5% * (cargo carried / cargo limit)
    //Chance of landing crash = 1% * (cargo carried / cargo limit)

    @Override
    public boolean land() {
        // methods to calculate the corresponding chance of exploding and return either true or false based on
        // a random number using the probability equation for each.

        double chanceOfLand = 0.01 * getCurrentWeightKgs() / getMaxCargoWeightKgs();
        double randomNumber = Math.random();
        return !(chanceOfLand >= randomNumber);
    }


    @Override
    public boolean launch() {
        // methods to calculate the corresponding chance of exploding and return either true or false based on
        // a random number using the probability equation for each.
        double chanceOfLaunch = 0.05 * getCurrentWeightKgs() / getMaxCargoWeightKgs();
        double randomNumber = Math.random();
        return !(chanceOfLaunch >= randomNumber);
    }

    U1() {
        setCostDollars(costDollars);
        setMaxWeightWithCargoKgs(maxWeightWithCargoKgs);
        setWeightKgs(weightKgs);
        int maxCargoWeightKgs = maxWeightWithCargoKgs - weightKgs;
        setMaxCargoWeightKgs(maxCargoWeightKgs);
    }


    @Override
    public int getCostDollars() {
        return costDollars;
    }
}
