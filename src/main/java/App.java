public class App {

    public static void main(String[] args) {
        Output out = new Output();
        Input in = new Input();
        Controller controller = new Controller(in, out);
        controller.run();
    }
}
