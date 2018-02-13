package seedu.addressbook.commands;

import org.junit.Test;
import seedu.addressbook.data.AddressBook;
import seedu.addressbook.data.exception.IllegalValueException;
import seedu.addressbook.data.person.ReadOnlyPerson;
import seedu.addressbook.util.TypicalPersons;
import seedu.addressbook.util.UnsortedTypicalPersons;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class SortCommandTest {

    private final AddressBook addressBook = new UnsortedTypicalPersons().getUnsortedTypicalAddressBook();
    private final UnsortedTypicalPersons td = new UnsortedTypicalPersons();

    @Test
    public void execute() throws IllegalValueException {
        //should sort in lexicographic order
        assertSortCommandBehavior(Arrays.asList(td.amy, td.bill, td.candy, td.dan));
    }

    /**
     * Executes the find command for the given keywords and verifies
     * the result matches the persons in the expectedPersonList exactly.
     */
    private void assertSortCommandBehavior(List<ReadOnlyPerson> expectedPersonList) {
        SortCommand command = createSortCommand();
        CommandResult result = command.execute();
        assertEquals(Command.getMessageForPersonListShownSummary(expectedPersonList), result.feedbackToUser);
    }

    private SortCommand createSortCommand() {
        SortCommand command = new SortCommand();
        command.setData(addressBook, Collections.emptyList());
        return command;
    }

}
