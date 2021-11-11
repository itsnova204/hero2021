import java.io.IOException;

public class Application {
    public static void main(String[] args) {


        try {
           Game.run();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}