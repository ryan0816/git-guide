import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Human {
    private final double AGE_PROBABILTY = 0.5;
    private final double ETHNICITY_PROBABILITY = 0.20;
    public String name;
    private int age;
    public int health;
    public String ethnicity;
    public String gender;
    public Human spouse;
    public LinkedList<Human> children;
    public LinkedList<Human> friends;
    private Random rand;
    public boolean employed;
    public int salary;

    /**
     * Initialize the instance variables for a human
     */
    public Human(String name, int age, String ethnicity, String gender, boolean employed, int salary) {
        this.name = name;
        this.age = age;
        this.ethnicity = ethnicity;
        this.gender = gender;
        spouse = null;
        this.health = 1;
        children = new LinkedList<Human>();
        friends = new LinkedList<Human>();
        rand = new Random();
        rand.setSeed(System.currentTimeMillis());
    }

    public Human(String name, int age, String ethnicity, String gender, boolean employed, int salary, long seed) {
        this(name, age, ethnicity, gender, employed, salary);
        rand.setSeed(seed);
    }

    public int getAge() {
        return Simulator.currentYear - Simulator.startYear + age;
    }

    public String introduce() {
        return "Hi, my name is " + name + " and I'm " + age + " years old";
    }

    public String marry(Human toWed) {
        String ret = new String();
        ret += name + " asked " + toWed.name + " to marry " + (gender.equals("male") ? "him\n" : "her\n");
        if (spouse == null && toWed.spouse == null) {
            spouse = toWed;
            toWed.spouse = this;
            ret += "Marriage accepted";
        } else {
            ret += "Someone already has a spouse";
        }
        
        return ret;
    }

    public String divorce() {
        if (spouse != null) {
            String ret;
            ret =  name + " and " + spouse.name + " divorced";
            spouse.spouse = null;
            spouse = null;
            return ret;
        } else {
            return name + " isn't even married";
        }
    }

    public String giveBirth(Human child) {
        if (!gender.equals("female")) {
            return name + " has to be a female";
        }
        if (spouse == null) {
            return name + " needs to be married to give birth";
        }
        if (!spouse.gender.equals("male")) {
            return name + " can only give birth if her spouse is a male";
        }

        children.add(child);
        return name + " and " + spouse.name + " gave birth to a baby named " + child.name;
    }

    public String getJob(int money) {
        if (employed != true) {
            employed = true;
            salary = money;
            return name + " found a job that is paying " + (gender.equals("male") ? "him" : "her") + " "
                    + salary + " per year";
        } else {
            return name + " already has a job";
        }
    }

    public void leaveJob() {
        if (employed == true) {
            employed = false;
            salary = 0;
            System.out.println(name + " has left " + (gender.equals("male") ? "his" : "her") + " job");
        } else {
            System.out.println(
                    name + " does not have a job " + (gender.equals("male") ? "he" : "she") + " can leave");
        }
    }

    private int ageDiff(int otherAge) {
        return otherAge >= this.age ? otherAge - this.age : this.age - otherAge;
    }
    
    public String makeNewFriend(Human newFriend) {
        double chanceOfBeingFriends = 0.75;
        // for every year you differ in age you decrease your chances of being friends by 10%
        int ageDiff = ageDiff(newFriend.age);
        chanceOfBeingFriends -= AGE_PROBABILTY*ageDiff;
        
        // if you are a different ethnicity you decrease your changce of being friends by 30%
        int sameNationality = this.ethnicity.equals(newFriend.ethnicity) ? 0 : 1;
        chanceOfBeingFriends -= ETHNICITY_PROBABILITY * sameNationality;
        
        if (rand.nextDouble() <= chanceOfBeingFriends) {
            
        }
        
        return "Not yet supported";
    }
    
    public String pursueMarried() {
        return "Not yet supported";
    }
    
    public String tryForKids(ArrayList<Human> newChildren) {
        return "Not yet supported";
    }
    
    public String checkVitals(ArrayList<Human> deceased) {
        if (age < 30) {
            health++;
        } else {
            health--;
        }
        if (health < 0) {
            deceased.add(this);
        }
        return "Not yet supported";
    }
    
}