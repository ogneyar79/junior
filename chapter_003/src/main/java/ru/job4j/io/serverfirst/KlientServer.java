package ru.job4j.io.serverfirst;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class KlientServer implements Runnable {
    String nameConectionWith;
    int port;
    String name;

    String mesegeBegin = name + " Connected  to  address" + nameConectionWith + " : " + port;

    Dialog dialog;

    public KlientServer(String nameConectionWith, int port) {
        this.nameConectionWith = nameConectionWith;
        this.port = port;
    }

    @Override
    public void run() {

        try (Socket socket = new Socket(nameConectionWith, port);
             BufferedReader consoleInputBuffReader = new BufferedReader(new InputStreamReader(System.in));
             DataInputStream serverWordFromIn = new DataInputStream(socket.getInputStream());
             DataOutputStream aswerToServerOut = new DataOutputStream(socket.getOutputStream())) {

            System.out.println("Client connected to socket.");
            aswerToServerOut.writeChars(mesegeBegin);
            aswerToServerOut.writeBytes("Hello oracle");
            System.out.println();

            while ((!socket.isOutputShutdown()) | !(dialog.isClosed())) {
                if (consoleInputBuffReader.ready()) {
                    // The Dates is, are Working
                    System.out.println("Client start writing in channel...");
                    Thread.sleep(1000);
                    String clientCommand = consoleInputBuffReader.readLine();  //
                    aswerToServerOut.writeUTF(clientCommand); // are Writng dates from console  Server's Socet
                    aswerToServerOut.flush();
                    System.out.println("Clien sent message " + clientCommand + " to server.");
                    Thread.sleep(1000);
                    if (clientCommand.equalsIgnoreCase("quit")) {
                        if (serverWordFromIn.read() > -1) {
                            System.out.println("reading...");
                            String in = serverWordFromIn.readUTF();
                            System.out.println(in);
                        }
                        break;   // after get out from cycle
                    }
// if condition of disconection is not reached We continue working
                    System.out.println("Client sent message & start waiting for data from server...");
                    Thread.sleep(2000);
                    // проверяем, что нам ответит сервер на сообщение(за предоставленное ему время в паузе он должен был успеть ответить)
                    if (serverWordFromIn.read() > -1) {
                        // If in time, take answer from server'socet сервера and save it our variable in  and out our Console
                        System.out.println("reading...");
                        String in = serverWordFromIn.readUTF();
                        System.out.println(in);
                    }
                }
            }
            System.out.println("Closing connections & channels on clentSide - DONE."); // And At The End of comunication, close our resources
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void setName(String name) {
        this.name = name;
    }
}



