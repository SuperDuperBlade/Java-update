package company;

import javax.swing.*;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;


public class Download implements Runnable {
   final private String link;
   final private File output;
    public Download(String link, File output) {
        this.link = link;
        this.output = output;
    }

    public void run() {

        try {
            URL url = new URL(link);
            HttpURLConnection http = (HttpURLConnection) url.openConnection();
            BufferedInputStream in =(new BufferedInputStream(http.getInputStream()));

            int result = JOptionPane.showConfirmDialog(null, "A update is available, would you like to download version 1.3 ");
            if (result == 0) {
                FileOutputStream fout = new FileOutputStream(this.output);
                BufferedOutputStream bout = new BufferedOutputStream(fout, 1000);
                bout.close();
                in.close();
            } else {
                System.exit(0);
            }


        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
