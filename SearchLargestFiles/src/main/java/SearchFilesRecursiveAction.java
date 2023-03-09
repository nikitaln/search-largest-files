import java.io.File;
import java.util.*;
import java.util.concurrent.RecursiveAction;


public class SearchFilesRecursiveAction extends RecursiveAction {

    private String path;
    private long minSize;
    public SearchFilesRecursiveAction(String path, long minSize) {
        this.path = path;
        this.minSize = minSize;
    }

    @Override
    protected void compute() {

        Storage storage = new Storage();

        //складываем задачи
        List<SearchFilesRecursiveAction> listTasks = new ArrayList<>();

        File file = new File(path);
        //массив файлов
        File[] filesInFolder = file.listFiles();

        if (filesInFolder != null) {

            for (int i=0; i<filesInFolder.length; i++) {
                if (filesInFolder[i].isDirectory()) {
                    SearchFilesRecursiveAction task = new SearchFilesRecursiveAction(filesInFolder[i].getAbsolutePath(), minSize);
                    task.fork();
                    listTasks.add(task);
                } else {
                    if (filesInFolder[i].isFile()) {
                        //проверка размера файла
                        if (filesInFolder[i].length() > minSize) {
                            storage.addFile(filesInFolder[i].getPath(), filesInFolder[i].length());
                        }
                    }
                }
            }
        }
        for (SearchFilesRecursiveAction task : listTasks) {
            task.join();
        }
    }
}
