import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Simulator {
    public static final int startYear = 2015;
    public static int currentYear = 2015;

    public static void main(String[] args) {
        ArrayList<String> simulationEvents = new ArrayList<String>();
        ArrayList<Human> community = new ArrayList<Human>();
        Human andrew, bethany, riley, abhijeet, ashwin, luc, kelsey, baby;

        // Initialize the humans
        community.add(new Human("Andrew", 23, "Vietnamese", "male", 0));
        community.add(new Human("Bethany", 19, "Chinese", "female", 5000));
        community.add(new Human("Riley", 23, "German", "male", 0));
        community.add(new Human("Abhijeet", 23, "Indian", "male", 0));
        community.add(new Human("Ashwin", 23, "Nepali", "male", 120000));
        community.add(new Human("Luc", 27, "Vietnamese", "male", 70000));
        community.add(new Human("Kelsey", 24, "Native American", "female", 50000));
        community.add(new Human("Narin", 25, "Thailand", "female", 0));
        community.add(new Human("Valery", 20, "Chinese", "female", 20000));
        community.add(new Human("Victoria", 20, "Vietnamese", "female", 0));
        community.add(new Human("Narin", 25, "Thailand", "female", 0));

        Random rand = new Random();
        rand.setSeed(System.currentTimeMillis());
        int year = 2015;
        while (currentYear < 2115) {
            ArrayList<Human> newChildren = new ArrayList<Human>();
            ArrayList<Human> deceased = new ArrayList<Human>();
            
            // each year you meet a friend
            Human newFriend;
            for (Human person : community) {
                // each year you spend time with someone in your community.
                // if you aren't already friends you may become friends
                newFriend = community.get(rand.nextInt(community.size()));
                simulationEvents.add(person.spendTimeWith(newFriend));
                
                // this person may pursue marrage
            
                simulationEvents.add(person.pursueMarrage());
                
                // this person may try to have kids
                simulationEvents.add(person.tryForKids(newChildren));
                
                // check to make sure the person survived another year    
                simulationEvents.add(person.checkVitals(deceased));
            }
            currentYear++;
            community.remove(deceased);
            community.addAll(newChildren);
        }

        for (String line : simulationEvents) {
            System.out.println(line);
        }
        System.out.println("The community grew from a mear 8 strangers to" + 
            " blossoming community of " + community.size() + " members!");
    }
}
