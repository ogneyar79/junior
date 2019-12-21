package ru.job4j.io.serverfirst;

import com.google.common.base.Joiner;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Map;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ServerMainTest {
    private static final String LN = System.getProperty("line.separator");
    ServerMain serverMain;

    Dialog dialog;
    ArrayList<String> specialWords;
    WordBase base;

    @Before
    public void setUp() throws Exception {
        base = new WordBase();
        specialWords = new ArrayList<>();
        dialog = new Dialog(base);

    }

    @Test
    public void checkDialog() {
        assertThat(dialog.getSpecialWords().size(), is(2));
    }

    @Test
    public void startServe() throws IOException {

        String clientWord = "Stop";
        Socket sockerImitator = mock(Socket.class);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ByteArrayInputStream in = new ByteArrayInputStream(clientWord.getBytes());

        when(sockerImitator.getInputStream()).thenReturn(in);
        when(sockerImitator.getOutputStream()).thenReturn(out);
        serverMain = new ServerMain(sockerImitator, dialog);
        serverMain.startServer();
        assertThat(out.toString(), is("Server reply - " + clientWord + " - OK"));
    }

    @Test
    public void startServerAnotherWord() throws IOException {
        String clientWord = "Stop";
        String serverAnswer = "Здравствуйте, рад Вас видеть.";
        Socket sockerImitator = mock(Socket.class);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ByteArrayInputStream in = new ByteArrayInputStream(Joiner.on(LN).join("hello",
                "Stop").getBytes());

        when(sockerImitator.getInputStream()).thenReturn(in);
        when(sockerImitator.getOutputStream()).thenReturn(out);
        serverMain = new ServerMain(sockerImitator, dialog);
        serverMain.startServer();
        assertThat(out.toString(), is(Joiner.on(LN).join("Server reply - " + serverAnswer + " - OK", "Server reply - " + clientWord + " - OK")));
    }

    @Test
    public void checkSelectWord() {
        String ask = " You aren't usual";
        Socket sockerImitator = mock(Socket.class);
        serverMain = new ServerMain(sockerImitator, dialog);
        Map<String, String> map = serverMain.getDialog().getWordBase().getAnswersByPattern();
        String firstAnswer = serverMain.selectAnswers(ask);
        String secondAnswer = serverMain.selectAnswers(ask);
        System.out.println(firstAnswer);
        System.out.println(secondAnswer);
        assertThat(dialog.getSpecialWords().size(), is(2));
        assertThat(firstAnswer.equals(secondAnswer), is(false));

    }
}