package test;

import interpreter.Parser;

public class MyInterpreter {

	public static int interpret(String[] lines) {
		Parser parser = Parser.getInstance();
		return parser.parseScript(lines);
	}
}
