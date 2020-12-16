package project1;

public class Product {

    private final String name;
    private final long upc14;

    public String getName() {
        return name;
    }

    public long getCode() {
        return upc14;
    }

    public Product(long upc14, String name) {
        this.upc14 = upc14;
        this.name = name;
    }
}
