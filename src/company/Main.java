package company;

public class Main {


    public static void main(String[] args) {

        Version version = new Version();


        final String url = version.getVerInfo();
        if (url == null){
            System.exit(1);
        }


        Download download = new Download(url, version.getNewer());
        download.run();
    }

}
