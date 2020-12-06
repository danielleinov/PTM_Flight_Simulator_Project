package commands;

import interpreter.Parser;
import expression.ShuntingYard;

public class AssignCommand implements Command {

    @Override
    public int doCommand(String[] args) {
        if (args[2].equals("bind")) {
            String varName = args[0];
            String boundTo = args[3];
            Parser.bindsTable.put(varName, boundTo);
        } else {
            StringBuilder exp = new StringBuilder();
            for (int i = 2; i < args.length; i++) {
                exp.append(args[i]);
            }
            double result = ShuntingYard.calc(exp.toString());
            String val = Double.toString(result);
            String key = args[0];
            Parser.symbolTable.put(key, val);
            Parser.updateBindings(key, val);
        }
        return 0;
    }
}
