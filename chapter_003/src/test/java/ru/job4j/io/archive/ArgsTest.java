package ru.job4j.io.archive;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ArgsTest {

    Args arg;
    String[] argument;
    String path;
    String exceptionExpension;
    String outDerictoryDestination;

    @Before
    public void init() {
        path = "c:\\project\\job4j\\";
        exceptionExpension = "xml";
        outDerictoryDestination = "project.zip";
        argument = new String[]{"-d", path, "-e", exceptionExpension, "-o", outDerictoryDestination};

        arg = new Args(argument);
    }

    @Test
    public void getterArgs() {
        assertThat(arg.getDirectorySource(), is(path));
        assertThat(arg.getExceptionExpension(), is(exceptionExpension));
        assertThat(arg.getOutDerictoryDestination(), is(outDerictoryDestination));
    }
}

