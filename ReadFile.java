package project1;

import java.io.*;
import java.util.*;

public class ReadFile {

//    // TODO: Implement as LinkedHashMap
//    private static Map<Long,String> readFromCSV() {
//        Map<Long,String> map = new LinkedHashMap<>();
//        try {
//            BufferedReader reader = new BufferedReader(new FileReader("Grocery_UPC_Database.csv"));
//            reader.readLine();
//            String line = reader.readLine();
//            while (line != null) {
//                String[] attributes = line.split(",");
//                for(int i = 1; i < attributes.length; i++) {
//                    map.put(Long.parseLong(attributes[1]), attributes[4]);
//                }
//                line = reader.readLine();
//            }
//            reader.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return map;
//    }
//
//    private static void createFile(Map<Long,String> map) {
//        PrintWriter out = null;
//        try {
//            out = new PrintWriter("output.txt");
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//        for (Map.Entry<Long,String> entry : map.entrySet()) {
//            assert out != null;
//            out.println(entry.getValue());
//        }
//        assert out != null;
//        out.close();
//    }
//
//    public static void main(String[] args) {
//        Map<Long,String> map = readFromCSV();
//        List<Long> keyList = new ArrayList<>(map.keySet());
//        createFile(map);
//    }

    /**
     *  Linked List Method
     */
    private static List<Product> readFile() {
        List<Product> products = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("Grocery_UPC_Database.csv"));

            // Move past the title
            reader.readLine();

            String line = reader.readLine();

            // Start reading from second line till EOF, split each string at ","
            while (line != null) {
                String[] attributes = line.split(",");
                Product attribute = getAttributes(attributes);
                products.add(attribute);
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return products;
    }

    private static Product getAttributes(String[] attributes) {

        // Get 14-digit UPC code located after the first ","
        long code = Long.parseLong(attributes[1]);

        // Get name located after the fourth ","
        String name = attributes[4];

        return new Product(code, name);
    }

    // Parse the data into new file after sorting
    private static void parse(List<Product> products) {
        PrintWriter output = null;
        try {
            output = new PrintWriter("project1_sorted.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // For each products, assert the text output stream is not null, print line.
        for (Product p : products) {
            assert output != null;
            output.println(p.getCode() + "," + p.getName());
        }
        assert output != null;
        output.close();
    }

    // Read input, ask for sorting method and solve
    public static void main(String[] args) {

        List<Product> products = readFile();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Quick sort: q");
        System.out.println("Heap sort: h");
        System.out.println("Radix sort: r");
        System.out.println("Sorting method: ");
        String input = scanner.nextLine();

        if (input.equalsIgnoreCase("q")) {
            QuickSort q = new QuickSort();
            q.quickSort(products);
//            long sum = 0;
//            for (int i = 0; i < 500; i++) {
//                long startTime = System.nanoTime();
//                QuickSort q = new QuickSort();
//                q.quickSort(products);
//                long endTime = System.nanoTime();
//                long duration = (endTime - startTime);
//                sum = sum + duration;
//            }
//            System.out.println(sum / 500);
        } else if (input.equalsIgnoreCase("h")) {
            HeapSort h = new HeapSort();
            h.heapSort(products);
//            long sum = 0;
//            for (int i = 0; i < 500; i++) {
//                long startTime = System.nanoTime();
//                HeapSort h = new HeapSort();
//                h.heapSort(products);
//                long endTime = System.nanoTime();
//                long duration = (endTime - startTime);
//                sum = sum + duration;
//            }
//            System.out.println(sum / 500);
        } else if (input.equalsIgnoreCase("r")) {
            RadixSort r = new RadixSort();
            products = Arrays.asList(r.radixSort(products));
//            long sum = 0;
//            for (int i = 0; i < 500; i++) {
//                long startTime = System.nanoTime();
//                RadixSort r = new RadixSort();
//                products = Arrays.asList(r.radixSort(products));
//                long endTime = System.nanoTime();
//                long duration = (endTime - startTime);
//                sum = sum + duration;
//            }
//            System.out.println(sum / 500);
        } else {
            System.out.println("Unrecognized command.");
            System.exit(1);
        }
        parse(products);
    }
}