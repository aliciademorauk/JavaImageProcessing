package efectos;

import imagenes.ColorRGB;
import imagenes.ImagenRGB;

public class EfectoEspejo extends Efecto {
    private boolean tipo;

    public EfectoEspejo(String nombre, ImagenRGB imagen, boolean tipo) {
        super(nombre, imagen);
        this.tipo = tipo;
    }
    public void setTipo (boolean tipo) {this.tipo = tipo;}

    @Override
    public void aplicar () {
        int altoImagen = imagenActual.getAlto();
        int anchoImagen = imagenActual.getAncho();

        // If tipo is true, perform vertical mirror effect
        if (this.tipo) {
            for (int y = 0; y <= altoImagen; y++) {
                for (int x = 0; x <= anchoImagen; x++) {
                    int symmetricalXValueForReplacement = anchoImagen - x - 1;
                    ColorRGB correspondingColourReplacement = imagenActual.getPixel(y, symmetricalXValueForReplacement);
                    imagenActual.setPixel(y,x,correspondingColourReplacement);
                }
            }
        }

        // If tipo is false, perform horizontal mirror effect
        else {
            for (int y = 0; y <= altoImagen; y++) {
                for (int x = 0; x <= anchoImagen; x++) {
                    int symmetricalYValueForReplacement = anchoImagen - y - 1;
                    ColorRGB correspondingColourReplacement = imagenActual.getPixel(symmetricalYValueForReplacement, x);
                    imagenActual.setPixel(y,x,correspondingColourReplacement);
                }
            }
        }
    }
}
