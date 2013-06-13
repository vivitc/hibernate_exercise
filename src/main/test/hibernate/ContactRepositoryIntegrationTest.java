package hibernate;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ContactRepositoryIntegrationTest {
    private ContactRepository contactRepository;

    @Before
    public void setUp() {
        contactRepository = new ContactRepository();
        contactRepository.clean();
        contactRepository.save(createContact("Robert", "James"));
        contactRepository.save(createContact("Joe", "Smith"));
    }

    @Test
    public void shouldSaveContactsToRepository() {
        List<Contact> savedContacts = contactRepository.findAll();
        assertThat(savedContacts.size(), is(2));
    }

    @Test
    public void shouldUpdateContact(){
        List<Contact> contacts = contactRepository.findAll();

        Contact contact = contacts.get(0);
        contact.setFirstName("Manuelito");
        contactRepository.update(contact);

        Contact actual = contactRepository.findAll().get(0);
        System.out.print(actual);
        assertThat(actual, is(contact));
    }

    private Contact createContact(String firstName, String lastName) {
        Contact contact = new Contact();
        contact.setFirstName(firstName);
        contact.setLastName(lastName);
        return contact;
    }
}
