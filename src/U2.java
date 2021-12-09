public class U2 extends Rocket {

    private int costDollars = 120000000;
    private int weightKgs = 18000;
    private int maxWeightWithCargoKgs = 29000;
    private int maxCargoWeightKgs = maxWeightWithCargoKgs-weightKgs;

    private double chanceOfLaunch;
    private double chanceOfLand;
    //  Chance of launch explosion = 4% * (cargo carried / cargo limit)
    //  Chance of landing crash = 8% * (cargo carried / cargo limit)

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
    U2() {
        setCostDollars(costDollars);
        setMaxWeightWithCargoKgs(maxWeightWithCargoKgs);
        setWeightKgs(weightKgs);
        setMaxCargoWeightKgs(maxCargoWeightKgs);
    }


}
