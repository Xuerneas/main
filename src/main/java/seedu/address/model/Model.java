package seedu.address.model;

import java.nio.file.Path;
import java.util.function.Predicate;

import javafx.collections.ObservableList;
import seedu.address.commons.core.GuiSettings;
import seedu.address.model.commands.CommandObject;
import seedu.address.model.earnings.Earnings;
import seedu.address.model.person.Person;
import seedu.address.model.reminder.Reminder;
import seedu.address.model.task.Task;

/**
 * The API of the Model component.
 */
public interface Model {
    /** {@code Predicate} that always evaluate to true */
    Predicate<Person> PREDICATE_SHOW_ALL_PERSONS = unused -> true;

    /** {@code Predicate} that always evaluate to true */
    Predicate<Earnings> PREDICATE_SHOW_ALL_EARNINGS = unused -> true;

    /** {@code Predicate} that always evaluate to true */
    Predicate<CommandObject> PREDICATE_SHOW_ALL_COMMANDS = unused -> true;

    Predicate<Task> PREDICATE_SHOW_ALL_TASKS = unused -> true;


    /**
     * Replaces user prefs data with the data in {@code userPrefs}.
     */
    void setUserPrefs(ReadOnlyUserPrefs userPrefs);

    /**
     * Returns the user prefs.
     */
    ReadOnlyUserPrefs getUserPrefs();

    /**
     * Returns the user prefs' GUI settings.
     */
    GuiSettings getGuiSettings();

    /**
     * Sets the user prefs' GUI settings.
     */
    void setGuiSettings(GuiSettings guiSettings);

    /**
     * Returns the user prefs' address book file path.
     */
    Path getAddressBookFilePath();

    /**
     * Sets the user prefs' address book file path.
     */
    void setAddressBookFilePath(Path addressBookFilePath);

    /**
     * Replaces address book data with the data in {@code addressBook}.
     */
    void setAddressBook(ReadOnlyAddressBook addressBook);

    /** Returns the AddressBook */
    ReadOnlyAddressBook getAddressBook();

    /**
     * Returns true if a person with the same identity as {@code person} exists in the address book.
     */
    boolean hasPerson(Person person);

    /**
     * Deletes the given person.
     * The person must exist in the address book.
     */
    void deletePerson(Person target);

    /**
     * Adds the given person.
     * {@code person} must not already exist in the address book.
     */
    void addPerson(Person person);

    /**
     * Replaces the given person {@code target} with {@code editedPerson}.
     * {@code target} must exist in the address book.
     * The person identity of {@code editedPerson} must not be the same as another existing person in the address book.
     */
    void setPerson(Person target, Person editedPerson);

    /** Returns an unmodifiable view of the filtered person list */
    ObservableList<Person> getFilteredPersonList();

    /**
     * Updates the filter of the filtered person list to filter by the given {@code predicate}.
     * @throws NullPointerException if {@code predicate} is null.
     */
    void updateFilteredPersonList(Predicate<Person> predicate);

    /**
     * Returns true if a command with the same identity as {@code command} exists in the address book.
     */
    boolean hasCommand(CommandObject command);

    /**
     * Deletes the given command.
     * The command must exist in the address book.
     */
    void deleteCommand(CommandObject target);

    /**
     * Adds the given command.
     * {@code command} must not already exist in the address book.
     */
    void addCommand(CommandObject command);

    /**
     * Replaces the given command {@code target} with {@code editedCommands}.
     * {@code target} must exist in the address book.
     * The command identity of {@code editedCommands} must not be the same as
     * another existing command in the address book.
     */
    void setCommands(CommandObject target, CommandObject editedCommands);

    /** Returns an unmodifiable view of the filtered command list */
    ObservableList<CommandObject> getFilteredCommandsList();

    /**
     * Updates the filter of the filtered command list to filter by the given {@code predicate}.
     * @throws NullPointerException if {@code predicate} is null.
     */
    void updateFilteredCommandsList(Predicate<CommandObject> predicate);

    /**
     * Adds the given earnings.
     * {@code earnings} must not already exist in the address book.
     */
    void addEarnings(Earnings earnings);

    void deleteEarnings(Earnings earnings);

    boolean hasEarnings(Earnings earnings);
    /**
     * Replaces the given person {@code target} with {@code editedPerson}.
     * {@code target} must exist in the address book.
     * The person identity of {@code editedPerson} must not be the same as another existing person in the address book.
     */
    void setEarnings(Earnings target, Earnings editedEarnings);

    /** Returns an unmodifiable view of the filtered person list */
    ObservableList<Earnings> getFilteredEarningsList();

    /** Returns an unmodifiable view of the filtered person list */
    ObservableList<Reminder> getFilteredReminderList();

    /**
     * Updates the filter of the filtered person list to filter by the given {@code predicate}.
     * @throws NullPointerException if {@code predicate} is null.
     */
    void updateFilteredEarningsList(Predicate<Earnings> predicate);


    void saveCommand(String command);

    String getSavedCommand();

    /**
     * Returns true if a task with the same identity as {@code task} exists in the address book.
     */
    boolean hasTask(Task task);

    /**
     * Deletes the given task.
     * The person must exist in the address book.
     */
    void deleteTask(Task target);

    /**
     * Adds the given task.
     * {@code task} must not already exist in the address book.
     */
    void addTask(Task task);

    /**
     * Replaces the given task {@code target} with {@code editedTask}.
     * {@code target} must exist in the address book.
     * The task identity of {@code editedTask} must not be the same as another existing task in the address book.
     */
    void setTask(Task target, Task editedTask);

    /** Returns an unmodifiable view of the filtered task list */
    ObservableList<Task> getFilteredTaskList();

    /**
     * Updates the filter of the filtered task list to filter by the given {@code predicate}.
     * @throws NullPointerException if {@code predicate} is null.
     */
    void updateFilteredTaskList(Predicate<Task> predicate);

}
