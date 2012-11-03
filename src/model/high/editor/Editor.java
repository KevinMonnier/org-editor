package model.high.editor;

import model.high.command.Command;
import model.low.cursor.Cursor;
import model.low.document.Document;
import model.low.document.HasSubSection;
import model.low.document.Line;
import model.low.document.Text;

// The editor represents the Client in the Vistor pattern where the cursor is the visitor and the document is the element
public interface Editor {

	/**
	 * @return the document edited by the editor
	 */
	public Document getDocument();

	/**
	 * @return The cursor for the current document
	 */
	public Cursor getCursor();

	/**
	 * @return the section where the cursor is.
	 */
	public HasSubSection getSelectedItem();

	/**
	 * @return The line number where the cursor is in the selected Text.
	 */
	public int getSelectedLineNb();

	public Line getSelectedLine();

	/**
	 * @return The index of the cursor in the line.
	 */
	public int getSelectedCharacterNb();

	/**
	 * Add a new Command in the editor. The user will then be able to call this
	 * command.
	 * 
	 * @param c
	 *            the command to add.
	 */
	public void addCommand(Command c);

	/**
	 * Execute the textual command.
	 * 
	 * @param c
	 *            the command.
	 */
	public void executeCommand(String c);

	/**
	 * Load the given document.
	 * 
	 * @param filePath
	 *            path to the document.
	 */
	public void loadDocument(CharSequence filePath);

	/**
	 * @return the character which starts every command.
	 */
	public char getCommandChar();

	public void moveCursor(int down, int right);

	/**
	 * Create a String to display the document.
	 * 
	 * @return string to display.
	 */
	public String print();

	/**
	 * Create a new line where the cursor currently is.
	 */
	public void newLine();

	/**
	 * Insert a character where the cursor currently is
	 * 
	 * @param c
	 *            the character to insert.
	 */
	public void insertChar(char c);
}
