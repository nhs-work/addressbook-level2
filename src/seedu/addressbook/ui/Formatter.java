package seedu.addressbook.ui;

import seedu.addressbook.commands.CommandResult;
import seedu.addressbook.data.person.ReadOnlyPerson;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import static seedu.addressbook.common.Messages.*;

/**
 * Formats messages displayed to user.
 */
public class Formatter {

    /** A decorative prefix added to the beginning of lines printed by AddressBook */
    private static final String LINE_PREFIX = "|| ";

    /** A platform independent line separator. */
    private static final String LS = System.lineSeparator();

    private static final String DIVIDER = "===================================================";

    /** Format of indexed list item */
    private static final String MESSAGE_INDEXED_LIST_ITEM = "\t%1$d. %2$s";


    /** Offset required to convert between 1-indexing and 0-indexing.  */
    public static final int DISPLAYED_INDEX_OFFSET = 1;

    /** Format of a comment input line. Comment lines are silently consumed when reading user input. */
    private static final String COMMENT_LINE_FORMAT_REGEX = "#.*";

    public String formatUserCommand (String fullInputLine){
        return "[Command entered:" + fullInputLine + "]";
    }


    public String formatShowWelcomeMessage(String version, String storageFilePath) {
        String storageFileInfo = String.format(MESSAGE_USING_STORAGE_FILE, storageFilePath);
        return(
                DIVIDER + "\n" +
                DIVIDER + "\n" +
                MESSAGE_WELCOME + "\n" +
                version + "\n" +
                MESSAGE_PROGRAM_LAUNCH_ARGS_USAGE + "\n" +
                storageFileInfo + "\n" +
                DIVIDER);
    }

    public String formatShowGoodbyeMessage() {
        return format(MESSAGE_GOODBYE, DIVIDER, DIVIDER);
    }


    public String showInitFailedMessage() {
        return format(MESSAGE_INIT_FAILED, DIVIDER, DIVIDER);
    }

    /** Shows message(s) to the user */
    public String format(String... message) {
        String formattedString = new String();
        for (String m : message) {
            formattedString = (formattedString + "\n" + m);
        }
        return formattedString;
    }

    /**
     * Shows the result of a command execution to the user. Includes additional formatting to demarcate different
     * command execution segments.
     */
    public String showResultToUser(CommandResult result) {
        final Optional<List<? extends ReadOnlyPerson>> resultPersons = result.getRelevantPersons();
        if (resultPersons.isPresent()) {
            showPersonListView(resultPersons.get());
        }
        return format(result.feedbackToUser, DIVIDER);
    }

    /**
     * Shows a list of persons to the user, formatted as an indexed list.
     * Private contact details are hidden.
     */
    private void showPersonListView(List<? extends ReadOnlyPerson> persons) {
        final List<String> formattedPersons = new ArrayList<>();
        for (ReadOnlyPerson person : persons) {
            formattedPersons.add(person.getAsTextHidePrivate());
        }
        showToUserAsIndexedList(formattedPersons);
    }

    /** Shows a list of strings to the user, formatted as an indexed list. */
    private String showToUserAsIndexedList(List<String> list) {
        return format(getIndexedListForViewing(list));
    }

    /** Formats a list of strings as a viewable indexed list. */
    private static String getIndexedListForViewing(List<String> listItems) {
        final StringBuilder formatted = new StringBuilder();
        int displayIndex = 0 + DISPLAYED_INDEX_OFFSET;
        for (String listItem : listItems) {
            formatted.append(getIndexedListItem(displayIndex, listItem)).append("\n");
            displayIndex++;
        }
        return formatted.toString();
    }

    /**
     * Formats a string as a viewable indexed list item.
     *
     * @param visibleIndex visible index for this listing
     */
    private static String getIndexedListItem(int visibleIndex, String listItem) {
        return String.format(MESSAGE_INDEXED_LIST_ITEM, visibleIndex, listItem);
    }

}
