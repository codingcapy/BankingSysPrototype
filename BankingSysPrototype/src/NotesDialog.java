import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NotesDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	JTextField notesField;
	JTextField profileNumberField;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		try {
//			NotesDialog dialog = new NotesDialog();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * Create the dialog.
	 */
	public NotesDialog() {
		setTitle("Notes");
		setBounds(700, 350, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new MigLayout("", "[][][][][grow][]", "[][][][][]"));
		{
			JLabel profileNumberLabel = new JLabel("Profile Number");
			contentPanel.add(profileNumberLabel, "cell 2 1,growx");
		}
		{
			profileNumberField = new JTextField();
			profileNumberField.setEnabled(false);
			contentPanel.add(profileNumberField, "cell 4 1,growx");
			profileNumberField.setColumns(10);
		}
		{
			JLabel addNotesLabel = new JLabel("Add Notes");
			contentPanel.add(addNotesLabel, "cell 2 3");
		}
		{
			notesField = new JTextField();
			contentPanel.add(notesField, "cell 4 3,growx");
			notesField.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Note newNote = new Note(profileNumberField.getText(),notesField.getText());
						Storage.notesListModel.addElement(newNote);
						Storage.notesList.add(newNote);
						JOptionPane.showMessageDialog(null, "Notes added successfully");
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
