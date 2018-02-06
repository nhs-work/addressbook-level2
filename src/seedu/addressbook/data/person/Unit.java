package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's block number in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Unit {

    public static final String EXAMPLE = "#55-55";
    public static final String MESSAGE_UNIT_CONSTRAINTS = "Unit number must be numeric or - or # only";
    public static final String UNIT_VALIDATION_REGEX = "[0123456789#-]+";

    public final String value;

    /**
     * Validates given address.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Unit(String unit, boolean isPrivate) throws IllegalValueException {
        String trimmedUnit = unit.trim();
        if (!isValidAddress(trimmedUnit)) {
            throw new IllegalValueException(MESSAGE_UNIT_CONSTRAINTS);
        }
        this.value = trimmedUnit;
    }

    /**
     * Returns true if a given string is a valid person address.
     */
    public static boolean isValidAddress(String test) {
        return test.matches(UNIT_VALIDATION_REGEX);
    }
}