package server_side;

import client_side.ClientHandler;

public interface Server
{

    void start(int port, ClientHandler c);
    void stop();

}
