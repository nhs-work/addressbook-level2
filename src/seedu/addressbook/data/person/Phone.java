package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's phone number in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValid(String)}
 */
public class Phone extends Contact{

    public static final String EXAMPLE = "123456789";

    static {
        messageContactConstraints = "Person phone numbers should only contain numbers";
        contactValidationRegex =   "\\d+";
    }

    /**
     * Validates given contact detail.
     *
     * @param contact
     * @param isPrivate
     * @throws IllegalValueException if given contact detail string is invalid.
     */
    public Phone(String contact, boolean isPrivate) throws IllegalValueException {
        super(contact, isPrivate);
    }
}
