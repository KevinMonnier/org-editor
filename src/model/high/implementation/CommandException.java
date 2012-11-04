package model.high.implementation;

public class CommandException extends RuntimeException {

	private static final long serialVersionUID = 7441070828291625870L;

	public CommandException() {
		super();
	}

	public CommandException(String arg0, Throwable arg1, boolean arg2,
			boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public CommandException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public CommandException(String arg0) {
		super(arg0);
	}

	public CommandException(Throwable arg0) {
		super(arg0);
	}

}
