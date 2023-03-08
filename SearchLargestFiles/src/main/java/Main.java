import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ForkJoinPool;

public class Main {

    //private static String path = "C:\\Users\\admin\\Downloads";
    public static void main(String[] args) {
        String path = "";
        long minSize = 0;

        if (args.length == 2) {
            path = args[0];
            minSize = minSize + Long.parseLong(args[1]);
        } else {
            System.out.println("Введите параметры: ... FileName.jar <path> <minSize>");
        }

        Storage storage = new Storage();

        SearchFilesRecursiveAction searchFilesRecursiveAction = new SearchFilesRecursiveAction(path, minSize);
        ForkJoinPool fjp = new ForkJoinPool();
        fjp.invoke(searchFilesRecursiveAction);

        for (String key : storage.descendingSort().keySet()) {
            System.out.println(key + " " + storage.descendingSort().get(key));
        }
    }
}
