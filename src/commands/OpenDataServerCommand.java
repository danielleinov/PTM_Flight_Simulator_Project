package commands;

import client_side.FlightSimulatorClientHandler;
import interpreter.Parser;
import client_side.ClientHandler;
import server_side.MySerialServer;
import server_side.Server;

public class OpenDataServerCommand implements Command {

    @Override
    public int doCommand(String[] args) {
        int port = Integer.parseInt(args[0]);
        int timeout = Integer.parseInt(args[1]);
        ClientHandler flightClient = (ClientHandler) new FlightSimulatorClientHandler(timeout);
        Server server = new MySerialServer();
        server.start(port, flightClient);
        Parser.socketToClose = server;
        return 0;
    }
}
