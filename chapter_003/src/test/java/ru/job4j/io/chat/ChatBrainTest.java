package ru.job4j.io.chat;

import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.util.List;
import java.util.Scanner;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ChatBrainTest {
    File rootCatalog;
    String path;
    File textForAnswer;
    ChatBrain chatBrain;

    @Before
    public void setUp() throws Exception {
        path = (System.getProperty("java.io.tmpdir") + File.separator + "/testcaseFirst");
        rootCatalog = new File(path);
        rootCatalog.mkdir();
        textForAnswer = new File(rootCatalog, "Text.txt");
        textForAnswer.createNewFile();
        chatBrain = new ChatBrain();

        FileWriter writer = new FileWriter(textForAnswer);
        // writing to file
        writer.write("Все получится,\n Ты псих\n Досвидания\n Раз познакомиться\n и Меня зовут Роберт\n   Ты уверен?\n Я так не думаю\n Красавчик\n Что случилось?\n Система дала сбой\n Всё хорошо\n А смысл?\n  Я Я занят\n  Как здорово\n");
        writer.flush();
        writer.close();

    }

//    @Test
//    public void testingWhritingToFile() throws IOException {
//        FileWriter writer = new FileWriter(textForAnswer);
//         writing to file
//        writer.write("Все получится,\n Ты псих\n Досвидания\n Раз познакомиться\n и Меня зовут Роберт\n   Ты уверен?\n Я так не думаю\n Красавчик\n Что случилось?\n Система дала сбой\n Всё хорошо\n А смысл?\n  Я Я занят\n  Как здорово\n");
//        writer.flush();
//        writer.close();
//
//         Создание объекта FileReader
//        FileReader fr = new FileReader(textForAnswer);
//        char[] a = new char[700];   // Количество символов, которое будем считывать
//        fr.read(a);   // Чтение содержимого в массив
//
//        for (char c : a)
//            System.out.print(c);   // Вывод символов один за другими
//        fr.close();
//    }

    @Test
    public void writingToArray() throws IOException {
        List<String> arrayList;
        arrayList = chatBrain.fillInArray(textForAnswer);
        System.out.println(arrayList.size());
        System.out.println(arrayList.get(0));

        assertThat(arrayList, is(chatBrain.getBasePhreases()));
        assertThat(arrayList.get(0), is(chatBrain.getBasePhreases().get(0)));
    }

    @Test
    public void randomString() throws IOException {
        chatBrain.fillInArray(textForAnswer);
        String randomString = chatBrain.sendMassage();
        System.out.println(randomString);
        String randomStringTwo = chatBrain.sendMassage();
        System.out.println(randomStringTwo);
        assertThat(!(randomString.equals(randomStringTwo)), is(true));
    }

    // I can't check input at console by unitTest.
    @Test
    public void readConsole() {
        String input = "Hello";
        InputStream stdin = System.in;
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Scanner scanner = new Scanner(System.in);
        String result = scanner.nextLine();
        System.out.println(result);
        assertEquals(input, result);

        System.setIn(stdin);
        scanner.close();
    }

    @Test
    public void checkCommandMustToBeAsResultInt() {
        String command = "Stop";
        int stop = chatBrain.checkCommand(command);
        assertThat(stop, is(0));
        String commandNothing = " Labuda";
        int nothing = chatBrain.checkCommand(commandNothing);
        assertThat(nothing, is(3));
    }
    @Test
    public void CheckWorkChatWithDialogAtInfinity() throws IOException {
        chatBrain.fillInArray(textForAnswer);
        String firstCommand = "Begin Test";
        String command = firstCommand;
        String personWord = "My name Alex";
        String personWordSecond = "Stop";
        String conandContinue = "Continue";

        while (!(chatBrain.checkCommand(command) == chatBrain.FINISHWORK)) {
            System.out.println(" Your Question");
            command = personWord;                     // getMassageFromChatPerson();
            if (chatBrain.checkCommand(command) == chatBrain.USUALCONTINUER) {
                System.out.println(command);
                String answer = chatBrain.sendMassage();
                System.out.println(answer);
                command = personWordSecond;
            }
            if (chatBrain.checkCommand(command) == chatBrain.STOP) {
                System.out.println(command);
                // log;
                while (!(chatBrain.checkCommand(command) == chatBrain.GOON)) {
                    command = " Are you Sure?";     // getMassageFromChatPerson()
                    System.out.println(command);
                    command = "Why?";  // getMassageFromChatPerson()
                    System.out.println(command);
                    command = "Continue";   // getMassageFromChatPerson()
                    if (chatBrain.checkCommand(command) == chatBrain.FINISHWORK) {
                        return;
                    }
                }
            }
            String aa = chatBrain.sendMassage();
            System.out.println(aa);
            command = "Finish";
        }
    }

    @Test
    public void CheckWorkChatWithCommandFinis() throws IOException {
        chatBrain.fillInArray(textForAnswer);
        String firstCommand = "Begin Test";
        String command = firstCommand;
        String personWord = "My name Alex";
        String finishCommand = "Finish";
        while (!(chatBrain.checkCommand(command) == chatBrain.FINISHWORK)) {
            System.out.println(" Your Question");
            command = personWord;
            if (chatBrain.checkCommand(command) == chatBrain.USUALCONTINUER) {
                System.out.println(command);
                String answer = chatBrain.sendMassage();
                System.out.println(answer);
            }
            System.out.println(" write command Finish");
            command = finishCommand;
        }
        System.out.println("Cycle successfully has terminated after command " + command);
    }
}