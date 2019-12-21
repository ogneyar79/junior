package ru.job4j.io.serverfirst;

import com.google.common.base.Joiner;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class KlientServerTest {

    private static final String LN = System.getProperty("line.separator");

    ArrayList<String> specialWords;
    WordBase base;

    @Before
    public void setUp() throws Exception {
        base = new WordBase();
        specialWords = new ArrayList<>();
    }

    @Test
    public void testRun() throws IOException {

        System.setIn(new ByteArrayInputStream("Quit".getBytes()));
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Socket sockerImitator = mock(Socket.class);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ByteArrayInputStream wordServer = new ByteArrayInputStream("Do it".getBytes());
        when(sockerImitator.getInputStream()).thenReturn(wordServer);
        when(sockerImitator.getOutputStream()).thenReturn(out);
        KlientServer klientServer = new KlientServer(sockerImitator, reader);
        klientServer.run(klientServer.getConsole());
        assertThat(out.toString(), is(Joiner.on(LN).join("Hello oracle", "Quit")));
    }
}