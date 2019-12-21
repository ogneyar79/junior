package ru.job4j.io.serverfirst;

import java.io.*;
import java.net.Socket;
import java.util.Map;

/**
 * Class for imatation simple server's Bot work
 */
public class ServerMain {

    /**
     * Field for sever's port.
     */
    int port;

    /**
     * Field Socket for imitation Socket for getting call back from client
     */
    Socket sockerImitator;

    /**
     * Field for object for manage With dialog, getting phrase and stopping.
     */
    Dialog dialog;


    /**
     * creator of object our class for imitation
     *
     * @param sockerImitator Socket.
     * @param dialog         Dialog
     */
    public ServerMain(Socket sockerImitator, Dialog dialog) {
        this.sockerImitator = sockerImitator;
        this.dialog = dialog;
    }

    /**
     * simple creator of object our class.
     *
     * @param port Int.
     */
    public ServerMain(int port) {
        this.port = port;
    }


    /**
     * Procedure that break dialog and connection with client.
     */
    public void finishTalk() {
        this.dialog.closeDialog();
    }

    /**
     * Function that return answer for ask client.
     *
     * @param ask String.
     * @return String result.
     */
    public String selectAnswers(String ask) {
        Map<String, String> frasesMap = dialog.getWordBase().getAnswersByPattern();
        String answer = frasesMap.getOrDefault(ask, this.dialog.getRandomString());

        return answer;
    }

    /**
     * Procedure for begin of work of server.
     */
    public void startServer() {
        System.out.println(" Server have been started");
        try (PrintWriter out = new PrintWriter(this.sockerImitator.getOutputStream());
             BufferedReader in = new BufferedReader(new InputStreamReader(this.sockerImitator.getInputStream()))) {

            String clientWord;
            while ((!this.sockerImitator.isClosed()) || (!dialog.isClosed())) {

                System.out.println("Server reading from channel");
                if ((clientWord = in.readLine()) != null) {

                    if (clientWord.equalsIgnoreCase(dialog.getSpecialWords().get(0))) {
                        System.out.println("Client initialize connections suicide ...");
                        out.write("Server reply - " + clientWord + " - OK");
                        out.flush();
                        this.finishTalk();
                        break;
                    }
                    // после получения данных считывает их
                    System.out.println("READ from client message - " + clientWord);   // и выводит в консоль

                    System.out.println("Server try writing to channel");
                    String serverWord = this.selectAnswers(clientWord);
                    out.println("Server reply - " + serverWord + " - OK");  //  - go on our work of server send answer back to client
                    System.out.println("Server Wrote message to client.");
                    out.flush();
                }
            }
            System.out.println("Client disconnected" + "Closing connections & channels."); // at first close sockerImitator's chanel
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    public Dialog getDialog() {
        return dialog;
    }
}



