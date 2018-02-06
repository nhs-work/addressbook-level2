package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's block number in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Block {

    public static final String EXAMPLE = "Block 123c";
    public static final String MESSAGE_BLOCK_CONSTRAINTS = "Block addresses can be in any format";
    public static final String BLOCK_VALIDATION_REGEX = ".+";

    public final String value;
    private boolean isPrivate;

    /**
     * Validates given address.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Block(String block, boolean isPrivate) throws IllegalValueException {
        String trimmedBLock = block.trim();
        if (!isValidAddress(trimmedBLock)) {
            throw new IllegalValueException(MESSAGE_BLOCK_CONSTRAINTS);
        }
        this.value = trimmedBLock;
        this.isPrivate = isPrivate;
    }

    /**
     * Returns true if a given string is a valid person address.
     */
    public static boolean isValidAddress(String test) {
        return test.matches(BLOCK_VALIDATION_REGEX);
    }
}