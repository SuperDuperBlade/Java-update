package company;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Version {


    private final String currentver = "3.9";
private double newVersion;



    //when this method is called it will establish a connection with the website and read the data
    //if the version from the website does not equal the currentver it will retrieve the latest url and notify the user
    public String getVerInfo() {
        try {
            final URL url = new URL("https://superduperblade.github.io/yes.html");
            HttpURLConnection hurl = (HttpURLConnection) url.openConnection();
            hurl.setRequestMethod("GET");
            hurl.setRequestProperty("User-Agent", "Chrome");
            hurl.setConnectTimeout(30000);  //30 seconds

            BufferedReader webreader = new BufferedReader(new InputStreamReader(hurl.getInputStream()));
            String l = "x";


            for (byte i = 0; l != null; i++) {
                l = webreader.readLine();
                if (i == 2) {
                    l = l.replace("<p>", "");
                    l = l.replace("</p>", "");
                    this.newVersion = Double.parseDouble(l);

                    if ((l = webreader.readLine()) != currentver) {
                        l = l.replace("<p>", "");
                        return l.replace("</p>", "");

                    } else {
                        break;
                    }

                }
            }//for loop ends

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }


    public double getNewver(){
        return this.newVersion;
    }


}
