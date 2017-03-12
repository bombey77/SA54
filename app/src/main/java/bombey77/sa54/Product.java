package bombey77.sa54;

/**
 * Created by Ромашка on 12.03.2017.
 */

public class Product {

    private String name;
    private int price;
    private int image;
    boolean box;

    Product(final String describe, final int price, final int image, final boolean box) {
        this.name = describe;
        this.price = price;
        this.image = image;
        this.box = box;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getImage() {
        return image;
    }

    public void setBox(boolean box) {
        this.box = box;
    }
}
