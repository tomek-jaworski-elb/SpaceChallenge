public class U2 extends Rocket {

    private int costDollars = 120000000;
    private int weightKgs = 18000;
    private int maxWeightWithCargoKgs = 29000;
    private int maxCargoWeightKgs = maxWeightWithCargoKgs - weightKgs;

    private double chanceOfLaunch;
    private double chanceOfLand;
    //  Chance of launch explosion = 4% * (cargo carried / cargo limit)
    //  Chance of landing crash = 8% * (cargo carried / cargo limit)

    @Override
    public boolean land() {
        // methods to calculate the corresponding chance of exploding and return either true or false based on
        // a random number using the probability equation for each.

        chanceOfLand = 0.08 * getCurrentWeightKgs() / getMaxCargoWeightKgs();
        double randomNumber = Math.random();
        boolean result;
        if (chanceOfLand >= randomNumber) {
            //           System.out.println("U1 land OK!");

            result = true;
        }
        else {
//            System.out.println("U1 land OK!");

            result = false;
        }
        return true;
    }

    @Override
    public boolean launch() {
        // methods to calculate the corresponding chance of exploding and return either true or false based on
        // a random number using the probability equation for each.
        chanceOfLaunch = 0.04 * getCurrentWeightKgs() / getMaxCargoWeightKgs();
        double randomNumber = Math.random();
        boolean result;
        if (chanceOfLaunch >= randomNumber) {
            //           System.out.println("U1 launch OK!");
            result = false;
        }
        else {
            //           System.out.println("U1 launch FAIL!");
            result = true;
        }

        return result;
    }

    U2() {
        setCostDollars(costDollars);
        setMaxWeightWithCargoKgs(maxWeightWithCargoKgs);
        setWeightKgs(weightKgs);
        setMaxCargoWeightKgs(maxCargoWeightKgs);
    }

    @Override
    public int getCostDollars() {
        return costDollars;
    }

}
