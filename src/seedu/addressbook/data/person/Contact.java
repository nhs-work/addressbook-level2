package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's contact details in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValid(String)}
 */
public class Contact {

    public static final String MESSAGE_CONTACT_CONSTRAINTS = "This message is to be overwritten in the child class";
    public static final String CONTACT_VALIDATION_REGEX = ".+"; //This validation regex is to be overwritten in the child class

    public final String value;
    private boolean isPrivate;

    /**
     * Validates given contact detail.
     *
     * @throws IllegalValueException if given contact detail string is invalid.
     */
    public Contact(String contact, boolean isPrivate) throws IllegalValueException {

        String trimmedContact = contact.trim();
        this.isPrivate = isPrivate;
        if (!isValid(trimmedContact)) {
            throw new IllegalValueException(MESSAGE_CONTACT_CONSTRAINTS);
        }
        this.value = trimmedContact;
    }

    /**
     * Returns true if a given string is a valid person address.
     */
    public static boolean isValid(String test) {
        return test.matches(CONTACT_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Contact // instanceof handles nulls
                && this.value.equals(((Contact) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}
