import java.util.*;

public class Storage {
    static Map<String, Long> mapFiles = new Hashtable<>();

    public void addFile(String file, long fileSize) {
        mapFiles.put(file, fileSize);
    }

    public void printAllFiles() {
        for (String key : mapFiles.keySet()) {
            System.out.println(key + " " + mapFiles.get(key));
        }
    }

    public Map<String, Long> descendingSort() {

        // 1. Convert Map to List of Map
        List<Map.Entry<String, Long>> list =
                new LinkedList<Map.Entry<String, Long>>(mapFiles.entrySet());

        // 2. Sort list with Collections.sort(), provide a custom Comparator
        //    Try switch the o1 o2 position for a different order
        Collections.sort(list, new Comparator<Map.Entry<String, Long>>() {
            public int compare(Map.Entry<String, Long> o1,
                               Map.Entry<String, Long> o2) {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });

        // 3. Loop the sorted list and put it into a new insertion order Map LinkedHashMap
        Map<String, Long> sortedMap = new LinkedHashMap<String, Long>();
        for (Map.Entry<String, Long> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        /*
        //classic iterator example
        for (Iterator<Map.Entry<String, Integer>> it = list.iterator(); it.hasNext(); ) {
            Map.Entry<String, Integer> entry = it.next();
            sortedMap.put(entry.getKey(), entry.getValue());
        }*/

        return sortedMap;
    }
}
