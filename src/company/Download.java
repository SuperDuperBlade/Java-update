package company;

import javax.swing.*;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;


public class Download implements Runnable {
   final private String link;
   private double newver;
   private File outputPath = new File(System.getProperty("user.dir")+"\\javaupdate"+this.newver+".jar");
    public Download(String link,double newversion) {
        this.link = link;
        this.newver = newversion;
    }

    public void run() {

        try {
            URL url = new URL(link);
            HttpURLConnection http = (HttpURLConnection) url.openConnection();
            BufferedInputStream in =(new BufferedInputStream(http.getInputStream()));

            int result = JOptionPane.showConfirmDialog(null, "A update is available, would you like to download version 1.3 ");
            if (result == 0) {
                FileOutputStream fout = new FileOutputStream(this.outputPath);
                BufferedOutputStream bout = new BufferedOutputStream(fout, 1000);
                byte[] buffer = new byte[1024];
                int read = 0;
                while ((read = in.read(buffer,0,1000))>=0){
                    bout.write(buffer,0,read);
                }
                JOptionPane.showMessageDialog(null,"Update was successfully completed");
                bout.close();
                in.close();
            } else {
                System.exit(0);
            }


        } catch (IOException exception) {
            System.exit(0);
        }
    }
}
