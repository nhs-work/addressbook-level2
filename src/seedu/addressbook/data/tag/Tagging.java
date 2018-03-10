package seedu.addressbook.data.tag;

import seedu.addressbook.data.person.Person;
import seedu.addressbook.ui.TextUi;

import java.util.ArrayList;

/**
 * Represents the association between a person and a tag in the address book.
 * Is only concerned with modifications of tags, not the initial tags associated with a person on creation.
 * Class is not implemented by addressbook as tag modification commands are not yet implemented.
 */

public class Tagging {

    private ArrayList<Person> personList;
    private ArrayList<Tag> tagList;
    private ArrayList<String> action;
    private TextUi ui;

    public Tagging(){
        personList = new ArrayList<Person>();
        tagList  = new ArrayList<Tag>();
        action = new ArrayList<String>();
        this.ui = new TextUi();
    }

    /**
     * Includes the tag modification into the list.
     * Will be called during execution of tag addition command(not yet implemented).
     */
    private void addTag (Person person, Tag tag){
        personList.add(person);
        tagList.add(tag);
        action.add("added");
    }

    /**
     * Includes the tag modification into the list.
     * Will be called during execution of tag deletion command(not yet implemented).
     */
    private void removeTag (Person person, Tag tag){
        personList.add(person);
        tagList.add(tag);
        action.add("deleted");
    }

    /**
     * Displays history of tag modification during this session.
     * Will be called when exiting addressbook(not yet implemented).
     */
    private void displayModifiedTags(){
        StringBuilder displayMessage = new StringBuilder();
        if(personList.size() == 0){
            displayMessage.append("No tags were modified");
        }
        else{
            for(int i = 0; i < personList.size(); i++){
                displayMessage.append(personList.get(i).getName());
                displayMessage.append(action.get(i));
                displayMessage.append(tagList.get(i).toString());
                displayMessage.append("\n");
            }
        }
        ui.showToUser(displayMessage.toString().trim());
    }
}
