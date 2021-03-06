package model.high.command.imp;

public class CommandNotFoundException extends RuntimeException {

	public CommandNotFoundException() {
		super();
	}

	public CommandNotFoundException(String arg0, Throwable arg1, boolean arg2,
			boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public CommandNotFoundException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public CommandNotFoundException(String arg0) {
		super("no match found for command " + arg0);
	}

	public CommandNotFoundException(Throwable arg0) {
		super(arg0);
	}

}
