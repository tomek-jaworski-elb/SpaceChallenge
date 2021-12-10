public class U2 extends Rocket {

    private final int costDollars = 120000000;
    private final int weightKgs = 18000;
    private final int maxWeightWithCargoKgs = 29000;

    //  Chance of launch explosion = 4% * (cargo carried / cargo limit)
    //  Chance of landing crash = 8% * (cargo carried / cargo limit)

    @Override
    public boolean land() {
        // methods to calculate the corresponding chance of exploding and return either true or false based on
        // a random number using the probability equation for each.

        double chanceOfLand = 0.08 * getCurrentWeightKgs() / getMaxCargoWeightKgs();
        double randomNumber = Math.random();
         return !(chanceOfLand >= randomNumber);
    }

    @Override
    public boolean launch() {
        // methods to calculate the corresponding chance of exploding and return either true or false based on
        // a random number using the probability equation for each.
        double chanceOfLaunch = 0.04 * getCurrentWeightKgs() / getMaxCargoWeightKgs();
        double randomNumber = Math.random();

        return !(chanceOfLaunch >= randomNumber);
    }

    U2() {
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
