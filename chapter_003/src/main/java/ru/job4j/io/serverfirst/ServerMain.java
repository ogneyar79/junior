package ru.job4j.io.serverfirst;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class ServerMain implements Runnable {

    int port;

    Socket fromClient;

    Dialog dialog;

    public ServerMain(int port) {
        this.port = port;
    }

    public void finishTalk() {
        this.dialog.closeDialog();
    }

    public String selectAnswers(String ask) {
        Map<String, String> frasesMap = dialog.getWordBase().getAnswersByPattern();
        String answer = frasesMap.get(ask);
        if (answer != null) {
            return answer;
        } else {
            answer = dialog.getRandomString();
        }
        return answer;
    }

    @Override
    public void run() {
        try (ServerSocket server = new ServerSocket(this.port)) {
            System.out.println(" Server have been started");
            Socket fromClient = server.accept(); // setting at waiting  for conecton to socet by name fromClient именем on Server side
//   server associate connecting client with this.socket
            System.out.print("Connection accepted.");
            // initialize channel for communication at server'socket.
            DataOutputStream out = new DataOutputStream(fromClient.getOutputStream()); // chanel recording to socket.
            System.out.println("DataOutputStream  created");

            DataInputStream in = new DataInputStream(fromClient.getInputStream()); // chanel reading from socket client.
            System.out.println("DataInputStream created");

            String clientWord;
// begin dialog with conected Client While socket does not closed
            while ((!fromClient.isClosed()) || (!dialog.isClosed())) {
                System.out.println("Server reading from channel");
                clientWord = in.readUTF();  // server await at chanel of reading (inputstream) getting message from client
                // после получения данных считывает их
                System.out.println("READ from client message - " + clientWord);   // и выводит в консоль
                System.out.println("Server try writing to channel");
//  - go on our work of server send answer back to client
                String serverWord = this.selectAnswers(clientWord);

                out.writeUTF("Server reply - " + serverWord + " - OK");
                System.out.println("Server Wrote message to client.");
                out.flush();
                if (clientWord.equalsIgnoreCase(dialog.getSpecialWords().get(0))) {
                    System.out.println("Client initialize connections suicide ...");
                    out.writeUTF("Server reply - " + clientWord + " - OK");
                    out.flush();
                    Thread.sleep(3000);
                    this.finishTalk();
                    break;
                }
            }
            // if condition - true turn connection of
            System.out.println("Client disconnected");
            System.out.println("Closing connections & channels.");     // at first close socket's chanel
            in.close();
            out.close();

            // then close socket of communication on server's side!
            fromClient.close();
        } catch (IOException e1) {
            e1.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}



