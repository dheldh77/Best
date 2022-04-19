import Commander.Commander;

import java.io.IOException;

public class Application {
    public static void main(String[] args) throws IOException {
        Commander commander = new Commander(args[0], args[1]);
        commander.init();
        commander.run();
    }
}
