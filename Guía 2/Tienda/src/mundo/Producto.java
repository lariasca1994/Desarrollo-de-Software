/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad Ean (Bogot� - Colombia)
 * Programa de Ingenier�a de Sistemas
 * Licenciado bajo el esquema Academic Free License version 2.1
 * <p>
 * Desarrollo de Software - Gu�a 2 - Actividad 2
 * Ejercicio: tienda
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package mundo;

/**
 * Producto de la tienda.
 */
public class Producto {

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Nombre del producto.
     */
    private String nombre;

    /**
     * Tipo del producto.
     */
    private String tipo;

    /**
     * Valor unitario del producto.
     */
    private double valorUnitario;

    /**
     * Cantidad de unidades en la bodega del producto.
     */
    private int cantidadBodega;

    /**
     * Cantidad de unidades mínima que debe haber en bodega para poder hacer un pedido.
     */
    private int cantidadMinima;

    /**
     * Cantidad de unidades vendidas del producto.
     */
    private int cantidadUnidadesVendidas;

    /**
     * Ruta de la imagen del producto.
     */
    private String rutaImagen;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea un producto con los valores dados por parámetro. <br>
     * <b> post: </b> El tipo, nombre, valor unitario, cantidad en bodega, cantidad mínima y ruta imagen fueron inicializados con los valores dado por parámetro.
     *
     * @param pTipo           Tipo del producto. pTipo != null.
     * @param pNombre         Nombre del producto. pNombre != null && pNombre != "".
     * @param pValorUnitario  Valor unitario del producto. pValorUnitario >= 0.
     * @param pCantidadBodega Cantidad inicial en la bodega. pCantidadBodega >= 0.
     * @param pCantidadMinima Cantidad mínima que debe haber en bodega. pCantidadMinima >= 0.
     * @param pRutaImagen     Ruta de la imagen del producto. pRutaImagen != null && pRutaImagen != "".
     */
    public Producto(String pTipo, String pNombre, double pValorUnitario, int pCantidadBodega, int pCantidadMinima, String pRutaImagen) {
        tipo = pTipo.toLowerCase();
        nombre = pNombre;
        valorUnitario = pValorUnitario;
        cantidadBodega = pCantidadBodega;
        cantidadMinima = pCantidadMinima;
        rutaImagen = pRutaImagen;
        cantidadUnidadesVendidas = 0;
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Retorna el nombre del producto.
     *
     * @return Nombre del producto.
     */
    public String darNombre() {
        return nombre;
    }

    /**
     * Retorna el tipo del producto.
     *
     * @return Tipo de producto.
     */
    public String darTipo() {
        return tipo.toLowerCase();
    }

    /**
     * Retorna el valor unitario del producto.
     *
     * @return Valor unitario del producto.
     */
    public double darValorUnitario() {
        return valorUnitario;
    }

    /**
     * Retorna la cantidad en bodega del producto.
     *
     * @return Cantidad en bodega del producto.
     */
    public int darCantidadBodega() {
        return cantidadBodega;
    }

    /**
     * Retorna la cantidad mínima del producto.
     *
     * @return Cantidad mínima del producto.
     */
    public int darCantidadMinima() {
        return cantidadMinima;
    }

    /**
     * Retorna la cantidad total de unidades vendidas.
     *
     * @return Cantidad de unidades vendidas.
     */
    public int darCantidadUnidadesVendidas() {
        return cantidadUnidadesVendidas;
    }

    /**
     * Retorna la ruta de la imagen del producto.
     *
     * @return Ruta de la imagen del producto.
     */
    public String darRutaImagen() {
        return rutaImagen;
    }

    /**
     * Cambia el nombre del producto.
     *
     * @param nuevoNombre
     */
    public void cambiarNombre(String nuevoNombre) {
        nombre = nuevoNombre;
    }

    /**
     * Cambia el tipo del producto
     */
    public void cambiarTipo(String nuevoTipo) {
        this.tipo = nuevoTipo.toLowerCase();
    }

    /**
     * Cambiar el valor unitario del producto
     */
    public void cambiarValorUnitario(double nuevoValorUnitario) {
        valorUnitario = nuevoValorUnitario;
    }

    /**
     * Cambiar la nueva cantidad en bodega
     */
    public void cambiarCantidadBodega(int nuevaCantidadEnBodega) {
        cantidadBodega = nuevaCantidadEnBodega;
    }

    /**
     * Cambiar la cantidad mínima en bodega del producto
     */
    public void cambiarCantidadMinima(int nuevaCantidadMinima) {
        cantidadMinima = nuevaCantidadMinima;
    }

    /**
     * Cambia la cantidad de unidades vendidas del producto
     */
    public void cambiardarCantidadUnidadesVendidas(int nuevaCantidadUnidadesVendidas) {
        cantidadUnidadesVendidas = nuevaCantidadUnidadesVendidas;
    }

    /**
     * Calcula el valor final del producto, incluyendo los impuestos.
     *
     * @return Precio de venta de una unidad incluyendo el IVA.
     */
 public double calcularPrecioFinal() {
     double iva = darIVA();
     return valorUnitario * (1 + iva / 100);
 }

    /**
     * Retorna el IVA correspondiente al producto.
     *
     * @return IVA.
     */
public double darIVA() {
    double iva = 0.0;

    if (tipo.equals("supermercado")) {
        iva = 4.0;
    } else if (tipo.equals("drogueria")) {
        iva = 12.0;
    } else if (tipo.equals("papeleria")) {
        iva = 16.0;
    }
    return iva;
    }

    /**
     * Vende la cantidad de unidades dada por parámetro. <br>
     * Es decir, disminuye la cantidad de unidades en bodega del producto.
     * Si la cantidad a vender es mayor que la cantidad en bodega se debe
     * dejar la cantidad en bodega en cero, y se debe retornar la cantidad
     * en bodega que había antes.
     * En cualquier otro caso, se disminuye la cantidad en bodega en la
     * cantidad a vender. Hay que retornar esa cantidad vendida.
     *
     * @param pCantidad Cantidad de unidades a vender. pCantidad > 0.
     * @return Cantidad que realmente fue vendida, según la disponibilidad en la bodega.
     */
    public int vender(int pCantidad) {
        int cantidadVendida;
        if (pCantidad > cantidadBodega) {
            cantidadVendida = cantidadBodega;
            cantidadBodega = 0;
        } else {
            cantidadVendida = pCantidad;
            cantidadBodega -= pCantidad;
        }
        cantidadUnidadesVendidas += cantidadVendida;
        return cantidadVendida;
    }

    /**
     * Abastece la cantidad de unidades dada por parámetro. <br>
     * <b>post: </b> Aumenta la cantidad de unidades en bodega del producto.
     *
     * @param pCantidad Cantidad de unidades para abastecer. pCantidad >= 0.
     */
    public void abastecer(int pCantidad) {
        cantidadBodega += pCantidad;
    }

    /**
     * Indica si se puede abastecer las unidades del producto.
     *
     * @return True si la cantidad en la bodega es menor que la mínima, false en caso contrario.
     */
    public boolean puedeAbastecer() {
        return cantidadBodega < cantidadMinima;
    }
}