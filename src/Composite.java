import java.util.ArrayList;
import java.util.List;

// Componenta comuna
interface ProductComponent {
    String getName();
    double getPrice();
    void showDetails(String indent);
}

class SingleProduct implements ProductComponent {
    private String name;
    private double price;

    public SingleProduct(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String getName() { return name; }

    @Override
    public double getPrice() { return price; }

    @Override
    public void showDetails(String indent) {
        System.out.println(indent + "- " + name + ": " + price + " RON");
    }
}

class ProductBundle implements ProductComponent {
    private String bundleName;
    private List<ProductComponent> components = new ArrayList<>();

    public ProductBundle(String bundleName) {
        this.bundleName = bundleName;
    }

    public void add(ProductComponent component) {
        components.add(component);
    }

    public void remove(ProductComponent component) {
        components.remove(component);
    }

    @Override
    public String getName() { return bundleName; }

    @Override
    public double getPrice() {
        double total = 0;
        for (ProductComponent c : components) {
            total += c.getPrice();
        }
        return total;
    }

    @Override
    public void showDetails(String indent) {
        System.out.println(indent + "[" + bundleName + "] - " + getPrice() + " RON total");
        for (ProductComponent c : components) {
            c.showDetails(indent + "  ");
        }
    }
}

public class Composite {
    public static void main(String[] args) {
        SingleProduct phone = new SingleProduct("Samsung S24", 4500);
        SingleProduct husa  = new SingleProduct("Husa Samsung", 120);
        SingleProduct folie = new SingleProduct("Folie sticla", 50);

        ProductBundle phoneBundle = new ProductBundle("Pachet Telefon Complet");
        phoneBundle.add(phone);
        phoneBundle.add(husa);
        phoneBundle.add(folie);

        SingleProduct laptop  = new SingleProduct("Laptop Dell", 5200);
        SingleProduct mouse   = new SingleProduct("Mouse wireless", 180);

        ProductBundle laptopBundle = new ProductBundle("Pachet Laptop");
        laptopBundle.add(laptop);
        laptopBundle.add(mouse);

        ProductBundle cosTotal = new ProductBundle("Cos de cumparaturi");
        cosTotal.add(phoneBundle);
        cosTotal.add(laptopBundle);

        cosTotal.showDetails("");
        System.out.println("\nTotal de plata: " + cosTotal.getPrice() + " RON");
    }
}