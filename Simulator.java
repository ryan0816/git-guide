import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Simulator {
    public static final int startYear = 2015;
    public static int currentYear = 2015;

    public static void main(String[] args) {
        ArrayList<String> simulationEvents = new ArrayList<String>();
        ArrayList<Human> comunity = new ArrayList<Human>();
        Human andrew, bethany, riley, abhijeet, ashwin, luc, kelsey, baby;

        // Initialize the humans
        comunity.add(new Human("Andrew", 23, "Vietnamese", "male", false, 0));
        comunity.add(new Human("Bethany", 19, "Chinese", "female", true, 5000));
        comunity.add(new Human("Riley", 23, "German", "male", false, 0));
        comunity.add(new Human("Abhijeet", 23, "Indian", "male", false, 0));
        comunity.add(new Human("Ashwin", 23, "Nepali", "male", true, 120000));
        comunity.add(new Human("Luc", 27, "Vietnamese", "male", true, 70000));
        comunity.add(new Human("Kelsey", 24, "Native American", "female", true, 50000));
        comunity.add(new Human("Chuwali", 0, "Nepali", "female", false, 0));
        Random rand = new Random();
        rand.setSeed(System.currentTimeMillis());
        int year = 2015;
        while (currentYear < 2115) {
            ArrayList<Human> newChildren = new ArrayList<Human>();
            ArrayList<Human> deceased = new ArrayList<Human>();
            
            // each year you meet a friend
            Human newFriend;
            for (Human person : comunity) {
                // each year you spend time with someone in your community.
                // if you aren't already friends you may become friends
                newFriend = comunity.get(rand.nextInt(comunity.size()));
                simulationEvents.add(person.makeNewFriend(newFriend));
                
                // this person may pursue marrage
                simulationEvents.add(person.pursueMarried());
                
                // this person may try to have kids
                simulationEvents.add(person.tryForKids(newChildren));
                
                // check to make sure the person survived another year    
                simulationEvents.add(person.checkVitals(deceased));
            }
            currentYear++;
            comunity.remove(deceased);
            comunity.addAll(newChildren);
        }
    }
}
