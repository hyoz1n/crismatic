package Clases;

import java.util.Arrays;
import java.util.Objects;

public class Insumos {

    private int id;
    private String[] insumos = {"CPU", "GPU", "Mouse", "Teclado", "Mousepad", "Audifonos"};
    private int[] precios = {200000, 300000, 30000, 17000, 12000, 50000};

    public Insumos()
    {

    }

    public Insumos(int id, String[] insumos, int[] precios) {
        this.id = id;
        this.insumos = insumos;
        this.precios = precios;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String[] getInsumos() {
        return insumos;
    }

    public void setInsumos(String[] insumos) {
        this.insumos = insumos;
    }

    public int[] getPrecios() {
        return precios;
    }

    public void setPrecios(int[] precios) {
        this.precios = precios;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Insumos insumos1 = (Insumos) o;
        return id == insumos1.id && Arrays.equals(insumos, insumos1.insumos) && Arrays.equals(precios, insumos1.precios);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id);
        result = 31 * result + Arrays.hashCode(insumos);
        result = 31 * result + Arrays.hashCode(precios);
        return result;
    }

    public int anadirAdicional(int precio, int adicional)
    {
        return precio + adicional;
    }
}
