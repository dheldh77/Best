import Commander.Commander;

public class Application {
    public static void main(String[] args){
        Commander commander = new Commander("src\\test\\resources\\input_20_20.txt", "output");
        commander.init();
        commander.run();
    }
}
