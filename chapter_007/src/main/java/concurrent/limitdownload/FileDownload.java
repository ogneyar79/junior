package concurrent.limitdownload;

import java.io.BufferedInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class FileDownload implements Runnable {

    private final int speedDefined;
    private final String url;
    private final String fileName;
    private long timeFlag;

    public FileDownload(int speedDefined, String url, String fileName) {
        this.speedDefined = speedDefined;
        this.url = url;
        this.fileName = fileName;
    }

    /**
     * Function that return True every Second(count secunds).
     * @return result boolean.
     */
    public boolean checkTime() {
        boolean result = false;
        long currentTime = System.currentTimeMillis();
        while (currentTime == timeFlag + 1000) {
            this.timeFlag = currentTime;
            result = true;
            return result;
        }
        return result;
    }

    @Override
    public void run() {
        try (BufferedInputStream in = new BufferedInputStream(new URL(url).openStream());
             FileOutputStream fileOutputStream = new FileOutputStream(fileName)) {

            byte[] dataBuffer = new byte[1024];
            int bytesRead;

            long startTime = System.currentTimeMillis();
            long actualTime = 0L;
            long timeDefined;
            while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {

                timeDefined = (bytesRead / speedDefined) * 1000;
                if (actualTime < timeDefined) {
                    Thread.sleep(timeDefined-actualTime);
                }
                fileOutputStream.write(dataBuffer, 0, bytesRead);


            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
