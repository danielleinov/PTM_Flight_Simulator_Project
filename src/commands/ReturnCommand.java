package commands;

import expression.ShuntingYard;

public class ReturnCommand implements Command {

    @Override
    public int doCommand(String[] args) {
        StringBuilder exp = new StringBuilder();
        for (String arg : args) {
            exp.append(arg);
        }

        return (int) ShuntingYard.calc(exp.toString());
    }
}
