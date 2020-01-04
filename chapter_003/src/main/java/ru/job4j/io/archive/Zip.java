package ru.job4j.io.archive;

import ru.job4j.io.Search;

import java.io.*;
import java.net.URI;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {


    public Zip(Args argument) {
        this.argument = argument;
    }

    Args argument;

    // need use seekBy iner another method pack

    /**
     * Function of looking for a list of files withOut expansion inner  method we use private method filesAll() returning files from catalog without folder
     *
     * @param root      String The way to catalog
     * @param exception String expansion file with this we need to except.
     * @return result is List files is found as result.
     */
    public List<File> seekBy(String root, String exception) {
        List<File> result = new Search().filesWithOutExpansion(root, exception);
        return result;
    }

    /**
     * Procedure for coverting List files to other Zip Catalog
     *
     * @param source  List files, which we going to convert Zip catalog
     * @param targetZ Catalog Zip where we convert our Files.
     */
    public void pack(List<File> source, File targetZ) throws IOException {
        FileOutputStream fileZip = new FileOutputStream(targetZ);
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(fileZip))) {
            for (File fileSources : source) {
                zip.putNextEntry(new ZipEntry(fileSources.getPath()));
                byte[] bytes;
                bytes = Files.readAllBytes(fileSources.toPath());
                zip.write(bytes);
                zip.closeEntry();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void packZip(String sourceDir, String zipFile) throws Exception {
        // Cоздание объекта ZipOutputStream из FileOutputStream
        FileOutputStream fileOutputStream = new FileOutputStream(zipFile);
        ZipOutputStream zipOutputStream = new ZipOutputStream(fileOutputStream);

        // Создание объекта File object архивируемой директории
        File fileSource = new File(sourceDir);

        addDirectory(zipOutputStream, fileSource);

        // Закрываем ZipOutputStream
        zipOutputStream.close();

        System.out.println("Zip файл создан!");
    }

    private void addDirectory(ZipOutputStream zipOutputStream, File fileSource) throws IOException {
        // File[] files = fileSource.listFiles();
        System.out.println("Добавление директории <" + fileSource.getName() + ">");
        for (File file : fileSource.listFiles()) {
            // Если file является директорией, то рекурсивно вызываем метод addDirectory
            if (file.isDirectory()) {
                addDirectory(zipOutputStream, file);
                continue;
            }
            System.out.println("Добавление файла <" + file.getName() + ">");

            zipOutputStream.putNextEntry(new ZipEntry(file.getPath()));
            byte[] bytes;
            bytes = Files.readAllBytes(file.toPath());
            zipOutputStream.write(bytes);
            zipOutputStream.closeEntry();
        }
    }


    public static void packDirectoryToZip(File directory, File zipFile) throws IOException {
        URI base = directory.toURI();
        Deque<File> queue = new LinkedList<>();
        queue.push(directory);
        OutputStream out = new FileOutputStream(zipFile);
        Closeable res = out;

        try {
            ZipOutputStream zipOutputStream = new ZipOutputStream(out);
            res = zipOutputStream;
            while (!queue.isEmpty()) {
                directory = queue.pop();
                for (File child : directory.listFiles()) {
                    String name = base.relativize(child.toURI()).getPath();
                    if (child.isDirectory()) {
                        queue.push(child);
                        name = name.endsWith("/") ? name : name + "/";
                        zipOutputStream.putNextEntry(new ZipEntry(name));
                    } else {
                        zipOutputStream.putNextEntry(new ZipEntry(name));
                        byte[] buffer = Files.readAllBytes(child.toPath());
                        zipOutputStream.write(buffer);
                    }
                    zipOutputStream.closeEntry();
                }
            }
        } finally {
            res.close();
        }
    }


    public static void main(String[] args) {
        String path = (System.getProperty("java.io.tmpdir") + File.separator + "/testcase2");
        System.out.println(path);
    }

}
