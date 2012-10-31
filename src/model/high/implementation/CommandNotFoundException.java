package model.high.implementation;

public class CommandNotFoundException extends RuntimeException {

	public CommandNotFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CommandNotFoundException(String arg0, Throwable arg1, boolean arg2,
			boolean arg3) {
		super(arg0, arg1, arg2, arg3);
		// TODO Auto-generated constructor stub
	}

	public CommandNotFoundException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	public CommandNotFoundException(String arg0) {
		super("no match found for command " + arg0);
	}

	public CommandNotFoundException(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

}
