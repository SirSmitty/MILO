import java.util.*;


public class UserManager {

    private Vector<Person> people;

    public UserManager(){
        people = new Vector();
    }

    public void addPerson(Person p){
        people.add(p);
    }

    public Person getPerson(int pNumber){
        return people.get(pNumber);
    }

    public int numberOfPeople(){
        return people.size();
    }
    
}
