package ru.job4j.io.serverfirst;

import org.junit.Test;

import static org.junit.Assert.*;

public class ServerMainTest {
    String nameWithConectTo = "localhost";
    ServerMain serverMain = new ServerMain(3345);
    KlientServer klientServer = new KlientServer(nameWithConectTo, 3345);
    String clientName = "First Client";
    Thread firstTreadServer = new Thread(serverMain);
    Thread secondTreadClient = new Thread(klientServer);

    @Test
    public void startServerAndClient() {
        klientServer.setName(clientName);
               serverMain.run();
        klientServer.run();

      //  firstTreadServer.start();
     //   secondTreadClient.start();

    }

}