package model.high.command;

public interface Command {

	/**
	 * This method checks if the given string is interpretable by this command.
	 * 
	 * @param str
	 *            the textual command.
	 * @return true if the sequence is interpretable by this command
	 */
	public boolean match(CharSequence str);

	/**
	 * Execute the given command as a string.
	 * 
	 * @param str
	 *            the textual command.
	 */
	public void execute(CharSequence str);

}
