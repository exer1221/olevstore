package modelo;

import java.util.ArrayList;
import java.util.List;

public class Deseos {

    private List<Producto> productos;

    public Deseos() {
        productos = new ArrayList<>();
    }

    public void agregarProducto(Producto p) {
        productos.add(p);
    }

    public void eliminarProducto(Producto p) {
        productos.remove(p);
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public boolean contieneProducto(Producto p) {
        return productos.contains(p);
    }

    public boolean estaVacio() {
        return productos.isEmpty();
    }

    public void vaciar() {
        productos.clear();
    }
}
