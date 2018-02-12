package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's email in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValid(String)}
 */
public class Email extends Contact{

    public static final String EXAMPLE = "valid@e.mail";

    /**
     * Validates given contact detail.
     *
     * @param contact
     * @param isPrivate
     * @throws IllegalValueException if given contact detail string is invalid.
     */
    public Email(String contact, boolean isPrivate) throws IllegalValueException {
        super(contact, isPrivate, "Person emails should be 2 alphanumeric/period strings separated by '@'", "[\\w\\.]+@[\\w\\.]+");
    }
}
