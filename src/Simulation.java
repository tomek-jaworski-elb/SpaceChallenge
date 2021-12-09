import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.PatternSyntaxException;

public class Simulation {

    File f1 = new File("phase-1.txt");
    File f2 = new File("phase-2.txt");

    Simulation() {

        // class that is responsible for reading item data and filling up the rockets.
        ArrayList<Item> allItemsPhase1 = loadItem(1);
        ArrayList<Item> allItemsPhase2 = loadItem(2);
        System.out.println("------------ Rocket U1 loading Phase 1 ----------");
        ArrayList<Rocket> rocketU1Ph1 = loadU1(allItemsPhase1);
        System.out.println("------------ Rocket U1 loading Phase 2 ----------");
        ArrayList<Rocket> rocketU1Ph2 = loadU1(allItemsPhase2);
        System.out.println("-------------------------------------------------");

        double costsU1p1 = runSimulation(rocketU1Ph1);
        double costsU1p2 = runSimulation(rocketU1Ph2);
        //       System.out.println("Budget for U1: $" + (long) costsU1);

        System.out.println("\n" + "------------ Rocket U2 loading Phase 1 ----------");
        ArrayList<Rocket> rocketU2Ph1 = loadU2(allItemsPhase1);
        System.out.println("------------ Rocket U2 loading Phase 1 ----------");
        ArrayList<Rocket> rocketU2Ph2 = loadU2(allItemsPhase2);
        System.out.println("------------------------------------------------");

        double costsU2p1 = runSimulation(rocketU2Ph1);
        double costsU2p2 = runSimulation(rocketU2Ph2);

        System.out.println("Budget for U1: $" + (long) (costsU1p1 + costsU1p2) + " (" + (long) costsU1p1
                + ", " + (long) costsU1p2 + ")");
        System.out.println("Budget for U2: $" + (long) (costsU2p1 + costsU2p2) + " (" + (long) costsU2p1
                + ", " + (long) costsU2p2 + ")");
    }

    private ArrayList<Item> loadItem(int phase) {
        // this method loads all items from a text file and returns an ArrayList of Items:
        //Each line in the text file consists of the item name followed by = then its weigh in kg. For example:
        //habitat=100000
        //colony=50000
        //food=50000
        //loadItems should read the text file line by line and create an Item object for each and then add
        // it to an ArrayList of Items. The method should then return that ArrayList.
        Scanner scanner;
        ArrayList<Item> all_Items = new ArrayList<>();

        try {
            if (phase == 1) {
                scanner = new Scanner(f1);
            } else {
                scanner = new Scanner(f2);
            }
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] s = line.split("=");
                if (s.length == 2) {
                    Item item = new Item();
                    item.setName(s[0]);
                    item.setWeight(Integer.parseInt(s[1]));
                    all_Items.add(item);
                } else {
                    System.out.println("Wrong file format!");
                }
            }
        } catch (FileNotFoundException exception) {
            exception.printStackTrace();
        } catch (PatternSyntaxException exception) {
            exception.printStackTrace();
        }

        return all_Items;
    }

    public ArrayList<Rocket> loadU1(ArrayList<Item> itemsU1) {
        // this method takes the ArrayList of Items returned from loadItems and starts creating U1 rockets.
        // It first tries to fill up 1 rocket with as many items as possible before creating a new rocket object
        // and filling that one until all items are loaded. The method then returns the ArrayList of those U1
        // rockets that are fully loaded.
        System.out.println(itemsU1.size());
        ArrayList<Rocket> rocketArrayList = new ArrayList<>();
        Rocket rocket = new U1();
        for (Item i : itemsU1) {
            if (rocket.canCarry(i)) {
                rocket.carry(i);
                System.out.println("CurrentWeight: " + rocket.getCurrentWeightKgs());
            } else {
                rocketArrayList.add(rocket);
                rocket = new U1();
                System.out.println("New rocket added!");
                rocket.carry(i);
            }

            System.out.println("Number of U1: " + (rocketArrayList.size() + 1)
                    + ", rocket cargo weight: " + rocket.getCurrentWeightKgs());
        }

        return rocketArrayList;
    }

    public ArrayList<Rocket> loadU2(ArrayList<Item> itemsU2) {
        // this method also takes the ArrayList of Items and starts creating U2 rockets and filling them with
        // those items the same way as with U1 until all items are loaded. The method then returns the ArrayList of
        // those U2 rockets that are fully loaded.
        System.out.println(itemsU2.size());
        ArrayList<Rocket> rocketArrayList = new ArrayList<>();
        Rocket rocket = new U2();
        for (Item i : itemsU2) {
            if (rocket.canCarry(i)) {
                rocket.carry(i);
                System.out.println("CurrentWeight: " + rocket.getCurrentWeightKgs());
            } else {
                rocketArrayList.add(rocket);
                rocket = new U1();
                System.out.println("New rocket added!");
                rocket.carry(i);
            }

            System.out.println("Number of U2: " + (rocketArrayList.size() + 1)
                    + ", rocket cargo weight: " + rocket.getCurrentWeightKgs());
        }
        return rocketArrayList;
    }

    public double runSimulation(ArrayList<Rocket> rocketsLists) {
        //this method takes an ArrayList of Rockets and calls launch and land methods for each of the rockets
        // in the ArrayList. Every time a rocket explodes or crashes (i.e if launch or land return false) it
        // will have to send that rocket again. All while keeping track of the total budget required to send
        // each rocket safely to Mars. runSimulation then returns the total budget required to send all rockets
        // (including the crashed ones).

        double rocketsCosts = 0;

        for (Rocket rocket : rocketsLists) {
            boolean launchOK = rocket.launch();
            boolean landOK = rocket.land();
            rocketsCosts += rocket.getCostDollars();

            if (landOK && launchOK) {
                System.out.println("Expedition succed!");

            } else {
                System.out.println("Expedition failed!");
                rocketsCosts += rocket.getCostDollars();
            }

        }
        System.out.println("Cost of Rockets: $" + (long) rocketsCosts);

        return rocketsCosts;
    }
}
