package seedu.address.ui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;

import seedu.address.model.note.Notes;

/**
 * A UI component that displays information of a {@code Earnings}.
 */
public class NotesCard extends UiPart<Region> {

    private static final String FXML = "NotesListCard.fxml";

    public final Notes notes;

    @FXML
    private HBox cardPane;
    @FXML
    private Label classId;
    @FXML
    private Label id;
    @FXML
    private Label content;

    public NotesCard(Notes notes, int displayedIndex) {
        super(FXML);
        this.notes = notes;
        id.setText(displayedIndex + ". ");
        classId.setText("ClassId: " + notes.getCode().moduleCode);
        content.setText("Notes: " + notes.getContent().content);
    }

    @Override
    public boolean equals(Object other) {
        // short circuit if same object
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof NotesCard)) {
            return false;
        }

        // state check
        NotesCard card = (NotesCard) other;
        return id.getText().equals(card.id.getText())
                && notes.equals(card.notes);
    }
}