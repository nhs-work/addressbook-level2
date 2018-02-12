package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValid(String)}
 */
public class Address extends Contact {

    public static final String EXAMPLE = "123, some street";

    /**
     * Validates given contact detail.
     *
     * @param contact
     * @param isPrivate
     * @throws IllegalValueException if given contact detail string is invalid.
     */
    public Address(String contact, boolean isPrivate) throws IllegalValueException {
        super(contact, isPrivate, "Person addresses can be in any format", ".+");
    }
}
