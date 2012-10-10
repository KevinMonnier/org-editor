package model.high;

public interface Command {
	public boolean match(CharSequence str);

	public boolean execute(CharSequence str);
}
