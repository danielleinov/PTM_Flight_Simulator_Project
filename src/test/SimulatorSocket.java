package test;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class SimulatorSocket {
    private static test.SimulatorSocket instance = null;
    public static Socket socket = null;

    private SimulatorSocket(String ip, int port) throws IOException {
        socket = new Socket(ip, port);
    }

    public synchronized static void init(String ip, int port) throws IOException {
        if (instance == null) {
            instance = new test.SimulatorSocket(ip, port);
        }
    }

    public synchronized static test.SimulatorSocket getInstance() {
        return instance;
    }

    public boolean isClosed() {
        return socket.isClosed();
    }

    public void sendString(String message) throws IOException {
        PrintWriter output = new PrintWriter(socket.getOutputStream());
        output.println(message);
        output.flush();
    }

    public void stop() {
        try {
            sendString("bye");
            socket.close();
        } catch (IOException e) {
        }
    }
}
