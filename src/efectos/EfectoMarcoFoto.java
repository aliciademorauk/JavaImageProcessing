package efectos;

import imagenes.ColorRGB;
import imagenes.ImagenRGB;

public class EfectoMarcoFoto extends EfectoMarco {

    final private int anchoMarcoExterior = 10;
    final private int anchoMarcoBlanco = 6;
    final private int anchoMarcoInterior = 4;
    private final ColorRGB colorBlanco = new ColorRGB(255,255,255);

    public EfectoMarcoFoto(String nombre, ImagenRGB imagen, ColorRGB color) {
        super(nombre, imagen, 0, color);
    }

    @Override
    public void aplicar() {

        ColorRGB colorCorrecto = super.getColor();

        // Interior frame
        setAnchura(anchoMarcoExterior + anchoMarcoBlanco + anchoMarcoInterior);
        super.aplicar();

        // White frame
        setAnchura(anchoMarcoExterior + anchoMarcoBlanco);
        setColor(colorBlanco);
        super.aplicar();

        // Exterior frame
        setAnchura(anchoMarcoExterior);
        setColor(colorCorrecto);
        super.aplicar();
    }
}
