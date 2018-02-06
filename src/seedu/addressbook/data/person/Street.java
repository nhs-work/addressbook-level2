package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's block number in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Street {

    public static final String EXAMPLE = "Hougang Street 55";
    public static final String MESSAGE_STREET_CONSTRAINTS = "Street can be in any format";
    public static final String STREET_VALIDATION_REGEX = ".+";

    public final String value;
    private boolean isPrivate;

    /**
     * Validates given address.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Street(String street, boolean isPrivate) throws IllegalValueException {
        String trimmedStreet = street.trim();
        if (!isValidAddress(trimmedStreet)) {
            throw new IllegalValueException(MESSAGE_STREET_CONSTRAINTS);
        }
        this.value = trimmedStreet;
        this.isPrivate = isPrivate;
    }

    /**
     * Returns true if a given string is a valid person address.
     */
    public static boolean isValidAddress(String test) {
        return test.matches(STREET_VALIDATION_REGEX);
    }
}