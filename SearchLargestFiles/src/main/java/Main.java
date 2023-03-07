import java.io.File;
import java.util.List;

public class Main {

    private static String path = "C:\\nikita_folder\\test";
    public static void main(String[] args) {

        System.out.println("Программа для поиска самых больших файлов. by nikita_ln");
        System.out.println();

        searchLargestFiles(path);

    }
    public static void searchLargestFiles(String path) {

        File file = new File(path);

        if (!file.isDirectory()) {
            System.out.println("Папка не сушествует");
        } else {

            String[] dirFilesName = file.list();

            for (int i = 0; i < dirFilesName.length; i++) {

                File file1 = new File(path + File.separator + dirFilesName[i]);

                if (file1.isFile()) {
                    System.out.println("название файла: " + file1.getName() + ", размер: " + file1.length() + " байт");
                    System.out.println("\tпуть к файлу: " + file1.getPath());
                    System.out.println();
                } else {
                    searchLargestFiles(path + File.separator + dirFilesName[i]);
                }
            }
        }
    }
}
