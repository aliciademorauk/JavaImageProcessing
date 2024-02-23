package efectos;

import imagenes.ImagenRGB;

public abstract class Efecto {
    public String nombre;
    public ImagenRGB imagenOriginal;
    protected ImagenRGB imagenActual;

    public Efecto(String nombre, ImagenRGB imagen) {
        this.nombre = nombre;
        this.imagenActual = imagen;
    }

    public String getNombre() {return nombre;}
    public ImagenRGB getImagen() {return imagenActual;}
    public abstract void aplicar();
    public void deshacer(){this.imagenActual = imagenOriginal;}
    public abstract void aplicar(boolean tipo);
}
