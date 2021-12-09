import javax.lang.model.util.ElementScanner6;
import java.beans.PropertyEditorSupport;

public class U1 extends Rocket {

    private final int costDollars = 100000000;
    private final int weightKgs = 10000;
    private final int maxWeightWithCargoKgs = 18000;
    private int maxCargoWeightKgs = maxWeightWithCargoKgs - weightKgs;

    private double chanceOfLaunch;
    private double chanceOfLand;
    //Chance of launch explosion = 5% * (cargo carried / cargo limit)
    //Chance of landing crash = 1% * (cargo carried / cargo limit)

    @Override
    public boolean land() {
        // methods to calculate the corresponding chance of exploding and return either true or false based on
        // a random number using the probability equation for each.

        chanceOfLand = 0.01 * getCurrentWeightKgs() / getMaxCargoWeightKgs();
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
        chanceOfLaunch = 0.05 * getCurrentWeightKgs() / getMaxCargoWeightKgs();
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

    U1() {
        setCostDollars(costDollars);
        setMaxWeightWithCargoKgs(maxWeightWithCargoKgs);
        setWeightKgs(weightKgs);
        setMaxCargoWeightKgs(maxCargoWeightKgs);
    }

    public double getChanceOfLand() {
        return chanceOfLand;
    }

    public double getChanceOfLaunch() {
        return chanceOfLaunch;
    }

    @Override
    public int getCostDollars() {
        return costDollars;
    }
}
