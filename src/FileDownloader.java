import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

public class FileDownloader implements Runnable {
    private String fileUrl;
    private String savePath;

    public FileDownloader(String fileUrl, String savePath) {
        this.fileUrl = fileUrl;
        this.savePath = savePath;
    }

    @Override
    public void run() {
        try {
            downloadFile(fileUrl, savePath);
            System.out.println("Downloaded: " + fileUrl);
        } catch (IOException e) {
            System.out.println("Failed to download: " + fileUrl);
            e.printStackTrace();
        }
    }

    private void downloadFile(String fileUrl, String savePath) throws IOException {
        URL url = new URL(fileUrl);
        try (BufferedInputStream in = new BufferedInputStream(url.openStream());
             FileOutputStream fileOutputStream = new FileOutputStream(savePath)) {
            byte[] dataBuffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
                fileOutputStream.write(dataBuffer, 0, bytesRead);
            }
        }
    }

    public static void main(String[] args) {
        String file1Url = "https://www.rbb.com.np/uploads/files/career/1635584347Level%205,%20IT%20(Open).pdf";
        String file1SavePath = "1635584347Level%205,%20IT%20(Open).pdf";
        String file2Url = "https://www.rbb.com.np/uploads/files/career/1635584119Level%206,%20IT%20(Open).pdf.pdf";
        String file2SavePath = "1635584119Level%206,%20IT%20(Open).pdf.pdf";

        // Create threads for each file download
        Thread thread1 = new Thread(new FileDownloader(file1Url, file1SavePath));
        Thread thread2 = new Thread(new FileDownloader(file2Url, file2SavePath));

        // Start the threads
        thread1.start();
        thread2.start();
    }
}
