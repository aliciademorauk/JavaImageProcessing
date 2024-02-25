package efectos;

import imagenes.ColorRGB;
import imagenes.ImagenRGB;

public class EfectoMarco extends Efecto {
    private int anchoMarco;
    private ColorRGB colorMarco;

    public EfectoMarco (String nombre, ImagenRGB imagen, int ancho, ColorRGB color) {
        super(nombre, imagen);
        this.colorMarco = color;
        // I added this method below to avoid code duplication in constructor and setAnchura method
        if (isAnchuraValid(ancho)) {
            this.anchoMarco = ancho;
        }
        else {
            this.anchoMarco = 0;
        }
    }

    public boolean isAnchuraValid(int ancho) {
        return ancho <= Math.min((imagenActual.getAlto() / 2),(imagenActual.getAlto() / 2));
    }
    public void setAnchura(int ancho) {
        if (isAnchuraValid(ancho)) {
            this.anchoMarco = ancho;
        }
        else {
            this.anchoMarco = 0;
        }
    }
    public int getAnchura() {return anchoMarco;}
    public void setColor (ColorRGB color) {this.colorMarco = color;}
    public ColorRGB getColor () {return this.colorMarco;}

    @Override
    public void aplicar () {
        int altoImagen = imagenActual.getAlto();
        int anchoImagen = imagenActual.getAncho();

        //Paint the entire part of the top rows that are covered by anchoMarco (the anchoImagen part (x) where y <= anchoMarco)
        for (int y = 0; y < anchoMarco; y++) {
            for (int x = 0; x < anchoImagen; x++) {
                imagenActual.setPixel(y,x,colorMarco);
            }
        }

        //Paint the entire part of the bottom rows that are covered by anchoMarco (the anchoImagen part (x) where y <= anchoMarco)
        for (int y = altoImagen - anchoMarco + 1; y < altoImagen; y++) {
            for (int x = 0; x < anchoImagen; x++) {
                imagenActual.setPixel(y,x,colorMarco);
            }
        }

        //Paint the sides excluding the corners that have already been painted
        for (int y = anchoMarco + 1; y < altoImagen - anchoMarco; y++) {

            //Left-hand side
            for (int x = 0; x < anchoImagen; x++) {
                imagenActual.setPixel(y,x,colorMarco);
            }

            //Right-hand side
            for (int x = anchoImagen - anchoMarco; x < anchoImagen; x++) {
                imagenActual.setPixel(y,x,colorMarco);
            }
        }
    }
}
