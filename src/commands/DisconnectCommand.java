package commands;

import client_side.FlightSimulatorClientHandler;
import interpreter.Parser;
import test.SimulatorSocket;

public class DisconnectCommand implements Command {

    @Override
    public int doCommand(String[] array) {
        try {
            SimulatorSocket.getInstance().stop();
            FlightSimulatorClientHandler.stop = true;
            Parser.closeSocket();
            Thread.sleep(1000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
