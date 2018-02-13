package seedu.addressbook.util;

import seedu.addressbook.data.AddressBook;
import seedu.addressbook.data.exception.IllegalValueException;
import seedu.addressbook.data.person.*;
import seedu.addressbook.data.tag.Tag;
import seedu.addressbook.data.tag.UniqueTagList;

/**
 * Class to generate typical test persons
 */
public class UnsortedTypicalPersons {

    public Person dan, bill, amy, candy;

    public UnsortedTypicalPersons() {
        try {
            dan = new Person(new Name("Dan Smith"), new Phone("1234556", true), new Email("ss@tt.com", true),
                    new Address("NUS", true), new UniqueTagList(new Tag("Test")));
            bill = new Person(new Name("Bill Clint"), new Phone("92229222", false), new Email("bc@gmail.com", false),
                    new Address("2 Clementi Road", true), new UniqueTagList());
            amy = new Person(new Name("Amy Buck"), new Phone("91119111", false), new Email("ab@gmail.com", false),
                    new Address("1 Clementi Road", false), new UniqueTagList());
            candy = new Person(new Name("Candy Destiny"), new Phone("93339333", true),
                    new Email("cd@gmail.com", false), new Address("3 Clementi Road", true), new UniqueTagList());
        } catch (IllegalValueException e) {
            e.printStackTrace();
            assert false : "not possible";
        }
    }

    private void loadAddressBookWithSampleData(AddressBook ab) {
        try {
            for (Person p : this.getUnsortedTypicalPersons()) {
                ab.addPerson(new Person(p));
            }
        } catch (IllegalValueException e) {
            assert false : "not possible";
        }
    }

    public Person[] getUnsortedTypicalPersons() {
        return new Person[]{dan, bill, amy, candy};
    }

    public AddressBook getUnsortedTypicalAddressBook() {
        AddressBook ab = new AddressBook();
        loadAddressBookWithSampleData(ab);
        return ab;
    }

}
