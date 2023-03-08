import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ForkJoinPool;

public class Main {

    private static String path = "C:\\Users\\admin\\Downloads";
    public static void main(String[] args) {

        Storage storage = new Storage();

        SearchFilesRecursiveAction searchFilesRecursiveAction = new SearchFilesRecursiveAction(path);
        ForkJoinPool fjp = new ForkJoinPool();
        fjp.invoke(searchFilesRecursiveAction);

        for (String key : storage.descendingSort().keySet()) {
            System.out.println(key + " " + storage.descendingSort().get(key));
        }
    }
}
