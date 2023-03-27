import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Phonebook {
    private ArrayList<Contact> contacts = new ArrayList<Contact>();
    
    public static void main(String[] args) {
        Phonebook test = new Phonebook();
        test.addContact(new Contact("Sherry", "Facebook", "sherrygold"));
        test.addContact(new Contact("Dylan", "Snap", "@d_oaktree"));
        test.addContact(new Contact("Kevin", "phone", "12312312"));
        test.addContact(new Contact("Bob", "phone", "12312312"));
        test.addContact(new Contact("Alex", "Tweeeter", "@alexxx"));
        test.printPhonebook();
    }

    public void addContact(Contact contact) {
        contacts.add(contact);
        sort(contacts);
    }

    public static void sort(ArrayList<Contact> list) {
        Collections.sort(list, new ContactNameComparator());
    }

    public void printPhonebook() {
        for (Contact contact : contacts) {
            System.out.println(contact.getName());
        }
    }
}

class ContactNameComparator implements Comparator<Contact> {
    public int compare(Contact c1, Contact c2) {
        return c1.getName().compareTo(c2.getName());
    }
}