package ru.job4j.io.serverfirst;

import java.io.*;
import java.net.Socket;

public class KlientServer {

    //  String nameConectionWith;

    /**
     * Field for sever's port .
     */
    int port;

    //   String mesegeBegin = name + " Connected  to  address" + nameConectionWith + " : " + port;

//    public KlientServer(String nameConectionWith, int port) {
//        this.nameConectionWith = nameConectionWith;
//        this.port = port;
//    }

    /**
     * Field for imitation work of Socket.
     */
    Socket sockerImitator;

    /**
     * Field for imitation console input.
     */
    BufferedReader console;

    /**
     * creator of object our class for imitation
     *
     * @param socket  Socket.
     * @param console BufferedReader
     */
    public KlientServer(Socket socket, BufferedReader console) {
        this.sockerImitator = socket;
        this.console = console;

    }

    public BufferedReader getConsole() {
        return console;
    }

    /**
     * Procedure for begin of work of client.
     *
     * @param console BufferedReader.
     */
    public void run(BufferedReader console) {
        try (BufferedReader consoleInputBuffReader = this.console;
             BufferedReader serverWordFromIn = new BufferedReader(new InputStreamReader(this.sockerImitator.getInputStream()));
             PrintWriter aswerForServerOut = new PrintWriter(this.sockerImitator.getOutputStream())) {

            //      aswerForServerOut.write(mesegeBegin);
            aswerForServerOut.write("Hello oracle" + System.lineSeparator());
            while (!sockerImitator.isOutputShutdown()) {
                if (consoleInputBuffReader.ready()) {
                    // The Dates is, are Working
                    System.out.println("Client start writing in channel...");
                    String clientCommand = consoleInputBuffReader.readLine();  //
                    aswerForServerOut.write(clientCommand); // are Writng dates from console  Server's Socet

                    System.out.println("Clien sent message " + clientCommand + " to server.");

                    String writerOfSerfer;
                    if (clientCommand.equalsIgnoreCase("quit")) {
                        if ((writerOfSerfer = serverWordFromIn.readLine()) != null) {
                            System.out.println("reading..." + writerOfSerfer);
                                                    }
                        break;   // after get out from cycle
                    }
// if condition of disconection is not reached We continue working
                    System.out.println("Client sent message & start waiting for data from server...");
                    // проверяем, что нам ответит сервер на сообщение(за предоставленное ему время в паузе он должен был успеть ответить)
                    if ((writerOfSerfer = serverWordFromIn.readLine()) != null) {
                        // If in time, take answer from server'socet сервера and save it our variable in  and out our Console
                        System.out.println("reading..." + writerOfSerfer);
                    }
                }
            }
            System.out.println("Closing connections & channels on clentSide - DONE."); // And At The End of comunication, close our resources
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}



