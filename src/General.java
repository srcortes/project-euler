import java.util.ArrayList;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;


interface Producto {
    String getNombre();
    double getPrecio();
}

class ProductoImpl implements Producto {
    private String nombre;
    private double precio;

    public ProductoImpl(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public double getPrecio() {
        return precio;
    }
}

class ProductDomain{

    private String nombre;
    private List<Producto> productos = new ArrayList<>();

    public void addProducto(Producto producto){
        productos.add(producto);
    }

    public Map<String, Double> getProductoMap(){
        return productos.stream().collect(Collectors.toMap(Producto::getNombre, Producto::getPrecio));
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }
}

public class General {

    public static void algo(Producto producto){
        ProductDomain productDomain = new ProductDomain();
        productDomain.addProducto(producto);
        productDomain.setNombre(productDomain.getNombre());
        System.out.println(productDomain.getProductoMap());
    }

    public static void main(String[] args) {
        ProductoImpl producto = new ProductoImpl("Producto 1", 100.0);
        algo(producto);




    }

}
