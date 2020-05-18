package concurrent.sharedresourcec;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ParseFile {

    private volatile File file;

    public synchronized void setFile(File f) {
        file = f;
    }

    public synchronized File getFile() {
        return file;
    }

    public synchronized String getContent() throws IOException {
        StringBuilder outPut = new StringBuilder();
        Files.lines(Paths.get(this.file.getAbsolutePath()), StandardCharsets.UTF_8).forEach(outPut::append);

        return outPut.toString();
    }

    public synchronized String getContentWithoutUnicode() throws IOException {
        StringBuilder outPut = new StringBuilder();
        Files.lines(Paths.get(this.file.getAbsolutePath()), StandardCharsets.UTF_8).forEach(outPut::append);

//        InputStream i = new FileInputStream(file);
//        String output = "";
//        int data;
//        while ((data = i.read()) > 0) {
//            if (data < 0x80) {
//                output += (char) data;
//            }
//        }
        byte[] buffer = outPut.toString().getBytes();
        String s = new String(buffer, StandardCharsets.UTF_8);
        return s;
    }

    public synchronized void saveContent(String content) {
        try (FileOutputStream o = new FileOutputStream(this.file)) {

            byte[] buffer = content.getBytes();
            o.write(buffer, 0, buffer.length);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}


