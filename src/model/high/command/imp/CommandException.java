package model.high.command.imp;

public class CommandException extends RuntimeException {

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
