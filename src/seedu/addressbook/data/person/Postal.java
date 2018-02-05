package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's block number in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Postal {

    public static final String EXAMPLE = "123456";
    public static final String MESSAGE_POSTAL_CONSTRAINTS = "Postal code can only be numeric";
    public static final String POSTAL_VALIDATION_REGEX = "[0123456789]+";

    public final String value;

    /**
     * Validates given address.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Postal(String postal, boolean isPrivate) throws IllegalValueException {
        String trimmedPostal = postal.trim();
        if (!isValidAddress(trimmedPostal)) {
            throw new IllegalValueException(MESSAGE_POSTAL_CONSTRAINTS);
        }
        this.value = trimmedPostal;
    }

    /**
     * Returns true if a given string is a valid person address.
     */
    public static boolean isValidAddress(String test) {
        return test.matches(POSTAL_VALIDATION_REGEX);
    }
}