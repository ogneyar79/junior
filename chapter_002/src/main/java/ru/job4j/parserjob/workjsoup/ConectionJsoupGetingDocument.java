package ru.job4j.parserjob.workjsoup;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.IOException;

@FunctionalInterface
public interface ConectionJsoupGetingDocument<T> {




    Document conectHtmlRepresentationAndGetDocument(T object) throws IOException;


//    /**
//     * Function conection to our site.
//     *
//     * @return Document object for parsing.
//     */
//    Document connectToPageAndGetDocument(String url) throws IOException {
//        return Jsoup.connect(url).get();
//    }
//
//    /**
//     * Function transform  html file at Document object.
//     *
//     * @return Document object for parsing.
//     */
//     Document conectToFileAndGetDocument(String fileNameHtml) throws IOException {
//        String path = getClass().getResource(fileNameHtml).getPath();
//        return Jsoup.parse(new File(path), "windows-1251");
//    }

}
