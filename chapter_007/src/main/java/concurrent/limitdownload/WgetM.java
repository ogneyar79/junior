package concurrent.limitdownload;

import java.io.EOFException;

public class WgetM {

    public static void main(String[] args) throws InterruptedException, EOFException {
        String fileName = "pom_tmp.xml";
        ParseArg parseArg = new ParseArg(args);
        FileDownload load = new FileDownload(parseArg.getSpeed(), parseArg.getUrl(), fileName);
        Thread threadLoad = new Thread(load);
        threadLoad.start();
        threadLoad.join();

    }

}
