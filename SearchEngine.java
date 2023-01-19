import java.io.IOException;
import java.net.URI;

class Handler1 implements URLHandler {
    // The one bit of state on the server: a number that will be manipulated by
    // various requests.
    int num = 0;

    public String handleRequest(URI url) {
        if (url.getPath().equals("/")) {
            return String.format("Kaustubh's Search Engine");
        } else if (url.getPath().equals("/add?s=pineapple")) {
            return String.format("Pineapple");
        }
        else if (url.getPath().equals("/add?s=apple")) {
            return String.format("Apple");
        }else if (url.getPath().equals("/add?s=app")) {
            return String.format("Pineapple and Apple");
        } else {
            return "404 Not Found!";
        }
    }
}

class SearchEngine {
    public static void main(String[] args) throws IOException {
        if(args.length == 0){
            System.out.println("Missing port number! Try any number between 1024 to 49151");
            return;
        }
        int port = Integer.parseInt(args[0]);
        Server.start(port, new Handler());
    }
}
    