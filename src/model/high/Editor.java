package model.high;

import model.low.document.Section;
import model.low.document.Text;

public interface Editor {
	
	/**
	 * @return the section where the cursor is.
	 */
	public Section getSelectedSection();
	
	/**
	 * @return the Text where the cursor is.
	 */
	public Text getSelectedText();
	
	/**
	 * @return The line number where the cursor is in the selected Text.
	 */
	public int getSelectedLineNb();
	
	/**
	 * @return The index of the cursor in the line.
	 */
	public int getSelectedCharacterNb();
	
	/**
	 * Add a new Command in the editor. The user will then be able to call this command.
	 * @param c the command to add.
	 */
	public void addCommand(Command c);
	
	/**
	 * Execute the textual command.
	 * @param c the command.
	 */
	public void executeCommand(String c);
	
	/**
	 * Load the given document.
	 * @param filePath path to the document.
	 */
	public void loadDocument(CharSequence filePath);
}
