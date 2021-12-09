public class U1 extends Rocket{

    private final int costDollars = 100000000;
    private final int weightKgs = 10000;
    private final int maxWeightWithCargoKgs = 18000;
    private int maxCargoWeightKgs = maxWeightWithCargoKgs-weightKgs;

    private double chanceOfLaunch;
    private double chanceOfLand;
    //Chance of launch explosion = 5% * (cargo carried / cargo limit)
    //Chance of landing crash = 1% * (cargo carried / cargo limit)

    @Override
    public boolean land() {
        // methods to calculate the corresponding chance of exploding and return either true or false based on
        // a random number using the probability equation for each.
        return true;
    }


    @Override
    public boolean launch() {
        // methods to calculate the corresponding chance of exploding and return either true or false based on
        // a random number using the probability equation for each.
        return true;
    }

    U1() {
        setCostDollars(costDollars);
        setMaxWeightWithCargoKgs(maxWeightWithCargoKgs);
        setWeightKgs(weightKgs);
        setMaxCargoWeightKgs(maxCargoWeightKgs);
    }
}
