import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.concurrent.ForkJoinPool;

public class Main {

    //private static String path = "C:\\Users\\admin\\Downloads";

    public static void main(String[] args) {
        String path = "";
        long minSize = 1024 * 1024; //перевод Мб в байты

        if (args.length == 2) {
            path = args[0];
            minSize = minSize * Long.parseLong(args[1]);
        } else {
            System.out.println("Input two arguments: ... FileName.jar <path> <minSize>");
        }

        Storage storage = new Storage();

        SearchFilesRecursiveAction searchFilesRecursiveAction = new SearchFilesRecursiveAction(path, minSize);
        ForkJoinPool fjp = new ForkJoinPool();
        fjp.invoke(searchFilesRecursiveAction);

        for (String key : storage.descendingSort().keySet()) {
            long size = storage.descendingSort().get(key) / 1048576; //Mb
            String file = key;

            if (size > 1000) {
                double value = (double) size / 1024;
                BigDecimal result = new BigDecimal(value);
                result = result.setScale(1, RoundingMode.DOWN);
                String result1 = result.toString().replace('.', ',');

                System.out.println(result1 + " Gb " + file);
            } else {
                System.out.println(size + " Mb " + file);
            }
        }
    }
}
