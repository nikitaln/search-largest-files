import java.io.File;
import java.util.List;

public class Main {

    private static String path = "C:\\nikita_folder\\test";
    public static void main(String[] args) {

        System.out.println("Программа для поиска самых больших файлов. by nikita_ln");

        File file = new File(path);

        if (!file.isDirectory()) {
            System.out.println("Папка не сушествует");
        } else {

            File[] dirFiles = file.listFiles();

            for (int i = 0; i < dirFiles.length; i++) {

                System.out.println(dirFiles[i].length());
            }

        }


    }
}
