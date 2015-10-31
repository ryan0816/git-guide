package life;

import java.util.LinkedList;
import java.util.Random;

public class Human {
  public String name;
  private int age;
  private static int startYear;
  private static int currentYear;
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
  public Human (String name, int age, String ethnicity, String gender, boolean employed, int salary) {
      this.name = name;
      startYear = currentYear = 2015;
      this.age = age;
      this.ethnicity = ethnicity;
      this.gender = gender;
      spouse = null;
      children = new LinkedList<Human>();
      friends = new LinkedList<Human>();
      Random rnd = new Random();
      rnd.setSeed(System.currentTimeMillis());
  }
  
  public Human (String name, int age, String ethnicity, String gender, boolean employed, int salary, long seed) {
      this(name, age, ethnicity, gender, employed, salary);
      rand.setSeed(seed);
  }
  
  /**
   * increase the year by 1
   */
  public static void newYear() {
      currentYear++;
  }
  
  public static int getYear() {
      return currentYear;
  }
  
  public int getAge() {
      return currentYear - startYear + age;
  }
  public void introduce() {
      System.out.println("Hi, my name is " + name + " and I'm " + age + " years old");
  }

  public void marry (Human toWed) {
      System.out.print(name + " asked " + toWed.name + " to marry ");
      System.out.println(gender.equals("male") ? "him" : "her");
      if (spouse == null && toWed.spouse == null) {
          spouse = toWed;
          toWed.spouse = this;
          System.out.println("Marriage accepted");
      } else {
          System.out.println("Someone already has a spouse");
      }
  }
  
  public void divorce () {
      if (spouse != null) {
          System.out.println(name + " and " + spouse.name + " divorced");
          spouse.spouse = null;
          spouse = null;
      } else {
          System.out.println(name + " isn't even married");
      }
  }

  public void giveBirth (Human child) {
      if (!gender.equals("female")) {
          System.out.println(name + " has to be a female");
          return;
      }
      if (spouse == null) {
          System.out.println(name + " needs to be married to give birth");
          return;
      }
      if (!spouse.gender.equals("male")) {
          System.out.println(name + " can only give birth if her spouse is a male");
          return;
      }
      
      System.out.println(name + " and " + spouse.name + " gave birth to a baby named " + child.name);
      children.add(child);
  }

  public void getJob (int money) {
      if (employed != true) {
          employed = true;
          salary = money;
          System.out.println(name + " found a job that is paying " + (gender.equals("male") ? "him" : "her") + " " + salary + " per year");
      } else {
          System.out.println(name + " already has a job");
      }
  }

  public void leaveJob () {
      if (employed == true) {
          employed = false;
          salary = 0;
          System.out.println(name + " has left " + (gender.equals("male") ? "his" : "her") + " job");
      } else {
          System.out.println(name + " does not have a job " + (gender.equals("male") ? "he" : "she") + " can leave");
      }
  }

  public static void main(String[] args) {
        public static void main(String[] args) {
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
        while (Human.getYear() < 2115) {
            // each year you meet a friend
            Human newFriend;
            for (Human person : comunity) {
                // each year you spend time with someone in your community.
                // if you aren't already friends you may become friends
                newFriend = comunity.get(rand.nextInt(comunity.size()));
                person.makeNewFriend(newFriend);
                
                // if the person is married they may try to have a kid
                person.
                if (person.isMarried()) {
                    person.hasChild();
                }
            }
            Human.newYear();
        }
    }
  }

}
