package efectos;

import imagenes.ImagenRGB;

public abstract class Efecto {
    private String nombre;
    private ImagenRGB imagenOriginal;
    protected ImagenRGB imagenActual;

    public Efecto(String nombre, ImagenRGB imagen) {
        this.nombre = nombre;
        this.imagenActual = new ImagenRGB(imagen);
        this.imagenOriginal = new ImagenRGB(imagen);
    }

    public String getNombre() {return nombre;}
    public ImagenRGB getImagen() {return imagenActual;}
    public abstract void aplicar();
    public void deshacer(){imagenActual = new ImagenRGB(imagenOriginal);}
}
