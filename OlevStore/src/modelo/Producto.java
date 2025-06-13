package modelo;

public class Producto {

    private String nombre;
    private double precio;
    private String rutaImagen;

    public Producto(String nombre, double precio, String rutaImagen) {
        this.nombre = nombre;
        this.precio = precio;
        this.rutaImagen = rutaImagen;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public String getRutaImagen() {
        return rutaImagen;
    }

    @Override
    public String toString() {
        return nombre + ";" + precio + ";" + rutaImagen;
    }

    public static Producto fromString(String linea) {
        String[] partes = linea.split(";");
        if (partes.length != 3) {
            return null;
        }
        return new Producto(partes[0], Double.parseDouble(partes[1]), partes[2]);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Producto producto = (Producto) obj;
        return nombre != null && nombre.equalsIgnoreCase(producto.nombre);
    }

    @Override
    public int hashCode() {
        return nombre != null ? nombre.toLowerCase().hashCode() : 0;
    }
}
