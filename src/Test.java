import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.*;

public class Test {
    private static Map<String, Product> map = new IdentityHashMap<>();
    static String cos;

    static List<String> dataReader() throws FileNotFoundException {
        String filePath = "C:\\Users\\Igor\\Desktop\\Dzawa.txt";
        File file = new File(filePath);
        Scanner scanner = new Scanner(file);
        ArrayList<String> arrayList = new ArrayList<>();
        while (scanner.hasNextLine()) {
            arrayList.add(scanner.nextLine());
        }
        return arrayList;
    }

    static void createProducts(List<String> list) {
        String[] strings;
        for (int i = 0; i < list.size(); i++) {
            strings = list.get(i).split(";");
            map.put(strings[0], new Product(strings[0], strings[1], Double.parseDouble(strings[2])));
            cos = strings[0];
        }
    }

    static void application() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj nazwe kategorii");
        String input = scanner.nextLine();
        System.out.println(map.get(input));
    }


    public static void main(String[] args) {
        try {
            createProducts(dataReader());
            System.out.println(map.containsKey(cos));
            System.out.println(cos.hashCode());
            System.out.println(map.containsKey("rtv"));
            System.out.println("rtv".hashCode());
            System.out.println(cos.equals("rtv"));
        } catch (FileNotFoundException e) {
            System.err.println("File not found");
        }
    }

}
