package hibernate;

import org.junit.Before;
import org.junit.Test;

public class ContactRepositoryIntegrationTest {
    private ContactRepository contactRepository;

    @Before
    public void cleanRepository() {
        contactRepository = new ContactRepository();
        contactRepository.clean();
    }

    @Test
    public void shouldSaveContactsToRepository() {
        //Delete this comment line and write your test here
    }

    private Contact createContact(String firstName, String lastName) {
        Contact contact = new Contact();
        contact.setFirstName(firstName);
        contact.setLastName(lastName);
        return contact;
    }
}
