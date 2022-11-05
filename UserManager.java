import java.util.*;

public class UserManager {

    private Vector<Person> people;
    private Vector<String> names;

    public UserManager() {
        people = new Vector();
        names = new Vector();
    }

    public void addPerson(Person p) {
        people.add(p);
        names.add(p.getName());
    }

    public Person getPerson(int pNumber) {
        return people.get(pNumber);
    }

    public Vector<Person> getPeople() {
        return people;
    }

    public Vector<String> getPeopleNames() {
        return names;
    }

    public int numberOfPeople() {
        return people.size();
    }

}
