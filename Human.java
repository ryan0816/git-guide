import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Human {
    public String name;
    private int age;
    public int health;
    public String ethnicity;
    public String gender;

    public Human spouse;
    public LinkedList<Human> children;
    public LinkedList<Human> friends;

    public boolean employed;
    public int salary;

    private Random rand;
    private final double AGE_PROBABILTY;
    private final double ETHNICITY_PROBABILITY;

    /**
     * Initialize the instance variables for a human
     */
    public Human(String name, int age, String ethnicity, String gender, 
            boolean employed, int salary) {
        this.name = name;
        this.age = age;
        this.health = 1;
        this.ethnicity = ethnicity;
        this.gender = gender;

        spouse = null;
        children = new LinkedList<Human>();
        friends = new LinkedList<Human>();
        
        rand = new Random();
        rand.setSeed(System.currentTimeMillis());
        AGE_PROBABILTY = 0.5;
        ETHNICITY_PROBABILITY = 0.20;
    }

    public Human(String name, int age, String ethnicity, String gender, 
            boolean employed, int salary, long seed) {
        this(name, age, ethnicity, gender, employed, salary);
        rand.setSeed(seed);
    }

    public int getAge() {
        return Simulator.currentYear - Simulator.startYear + this.age;
    }

    public String introduce() {
        return "Hi, my name is " + this.name + " and I'm " + this.age + " years old";
    }

    public String marry(Human toWed) {
        if (age < 18) {
            return this.name + " is too young to be married";
        } else if (toWed.name.equals(this.name)) {
            return this.name + "trying to marry them selves!! Unfortunatly " + 
                    this.name + " is still single";
        } else if (this.spouse == null && toWed.spouse == null) {
            this.spouse = toWed;
            toWed.spouse = this;
            return this.name + " and " + this.spouse.name + " are now married";
        } else {
            return (this.spouse != null ? this.name : toWed.name) + " is already married";
        }
    }

    public String divorce() {
        if (spouse != null) {
            String ret;
            ret =  this.name + " and " + this.spouse.name + " divorced";
            this.spouse.spouse = null;
            this.spouse = null;
            return ret;
        } else {
            return this.name + " isn't even married";
        }
    }

    public String giveBirth(Human child) {
        if (!this.gender.equals("female")) {
            return this.name + " has to be a female to give birth";
        }
        if (this.spouse == null) {
            return this.name + " needs to be married to give birth";
        }
        if (!this.spouse.gender.equals("male")) {
            return this.name + " can only give birth if her spouse is a male";
        }

        this.children.add(child);
        this.spouse.children.add(child);
        return this.name + " and " + this.spouse.name + " gave birth to a baby named " + 
                this.child.name;
    }

    public String getJob(int money) {
        if (this.employed != true) {
            this.employed = true;
            this.salary = money;
            return this.name + " found a job that is paying " + 
                    (this.gender.equals("male") ? "him" : "her") + " " + 
                    this.salary + " per year";
        } else {
            return this.name + " already has a job";
        }
    }

    public String leaveJob() {
        if (this.employed == true) {
            this.employed = false;
            this.salary = 0;
            return this.name + " has left " + 
                    (this.gender.equals("male") ? "his" : "her") + " job";
        } else {
            return this.name + " does not have a job " + 
                    (this.gender.equals("male") ? "he" : "she") + " can leave";
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
    
    public String pursueMarrage() {
        Human potentialSpouse = friends.get(rand.nextInt(friends.size())); 
        return marry(potentialSpouse);
    }
    
    private double kidsProbability() {
        return -0.0016 * this.age * this.age + 0.0754 * this.age + 0.0352;
    }

    public String tryForKids(ArrayList<Human> newChildren) {
        if (rand.nextDouble() < kidsProbability())
            return giveBirth(new Human);
    }
    
    public String checkVitals(ArrayList<Human> deceased) {
        if (this.age < 30) {
            this.health++;
        } else {
            this.health--;
        }
        if (this.health < 0) {
            deceased.add(this);
            return "Unfortunatly " + this.name + "has passed away at age " + 
                    this.age;
        } else {
            return this.name + " is healthy as ever!"; //could change based on what his health value actually is
        }
    }
    
}