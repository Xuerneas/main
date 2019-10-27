package seedu.address.ui;

import java.util.Comparator;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import seedu.address.model.reminder.Reminder;

/**
 * A UI component that displays information of a {@code Earnings}.
 */
public class ReminderCard extends UiPart<Region> {

    private static final String FXML = "ReminderListCard.fxml";

    public final Reminder reminders;

    @FXML
    private HBox cardPane;
    @FXML
    private Label description;
    @FXML
    private Label id;
    @FXML
    private Label date;
    @FXML
    private FlowPane times;

    public ReminderCard(Reminder reminders, int displayedIndex) {
        super(FXML);
        this.reminders = reminders;
        id.setText(displayedIndex + ". ");
        description.setText(reminders.getDescription().toString());
        //date.setText(reminders.getDate().dateNum);
        //amount.setText(reminders.getAmount().amount);
        reminders.getTime().stream()
                .sorted(Comparator.comparing(reminderTime -> reminderTime.fullTime))
                .forEach(reminderTime -> times.getChildren().add(new Label(reminderTime.fullTime)));
    }

    @Override
    public boolean equals(Object other) {
        // short circuit if same object
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof ReminderCard)) {
            return false;
        }

        // state check
        ReminderCard card = (ReminderCard) other;
        return id.getText().equals(card.id.getText())
                && reminders.equals(card.reminders);
    }
}
