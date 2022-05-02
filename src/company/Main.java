package company;


import java.io.File;

public class Main {


    public static void main(String[] args) {

        Version version = new Version();


        final String url = version.getVerInfo();
        if (url == null){
            System.exit(1);
        }

        final File output = new File("C:\\Users\\"+System.getProperty("user.name")+"\\Desktop\\javaupdate"+version.getNewver()+".jar");
        Download download = new Download(url,output);
        download.run();
    }

}
