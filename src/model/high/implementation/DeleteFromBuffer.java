package model.high.implementation;

import model.high.command.Command;
import model.low.buffer.Buffer;

public class DeleteFromBuffer implements Command{

	private Buffer buffer;
	
	public DeleteFromBuffer(Buffer buffer) {
		super();
		this.buffer = buffer;
	}
	
	@Override
	public boolean match(CharSequence str) {
		return str.equals(EditCommands.DELETE_FROM_BUFFER);
	}

	@Override
	public void execute(CharSequence str) {
		if(!this.match(str))
			throw new CommandException("this function does not match " + str);
		
		if(!this.buffer.empty())
			this.buffer.pop();		
	}

}
