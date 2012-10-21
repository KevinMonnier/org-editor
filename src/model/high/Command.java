package model.high;

public interface Command {
	
	/**
	 * @param str the textual command.
	 * @return true if the sequence is interpretable by this command
	 */
	public boolean match(CharSequence str);

	/**
	 * @param str the textual command.
	 */
	public void execute(CharSequence str);
	
}
