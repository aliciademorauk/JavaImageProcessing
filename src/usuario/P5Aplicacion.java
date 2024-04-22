package usuario;

import efectos.Efecto;
import efectos.EfectoEspejo;
import efectos.EfectoMarcoFoto;
import imagenes.ColorRGB;
import imagenes.ImagenRGB;
public class P5Aplicacion {

	public static void main(String[] args) {
	    ImagenRGB imagen;
	    Efecto efecto;
	    String fichero = "MicroHobby.jpg";

	    //Generación de la imagen original.
	    imagen = new ImagenRGB(fichero);
	    imagen.presentarImagen();

	    //Procesamiento con espejos - Vertical.
	    efecto = new EfectoEspejo("Imagen con Efecto Espejo", imagen, true);
	    imagen = OperarEfecto (efecto, false);

	    //Procesamiento con espejos - Horizontal.
	    //Para realizar esta operación deberá operar con la misma instancia
	    //de efecto que generó en el bloque anterior.
		((EfectoEspejo) efecto).setTipo(false);
		imagen = OperarEfecto (efecto, false);

	    // Procesamiento con espejos - Deshacer espejado total.
	    // Durante las pruebas, puede comentar esta sentencia si desea dejar
	    // la implementación del método deshacer() para el final.
		imagen = OperarEfecto (efecto, true);

	    //Establecimiento de un marco estilo foto.
		ColorRGB colorMarcoFoto = new ColorRGB(110,245,100); // Kiwi green
		//efecto = new EfectoMarco("Imagen con Marco Foto", imagen, 20, colorMarcoFoto);
		//imagen = OperarEfecto (efecto, false);

	    efecto = new EfectoMarcoFoto("Imagen con Marco Foto", imagen, colorMarcoFoto);
	    imagen = OperarEfecto (efecto, false);

	    //Guarda resultado en fichero.
		imagen.escribirImagen("MicroHobbyProcesado.jpg");
	}

	private static ImagenRGB OperarEfecto(Efecto efecto, boolean deshacer) {
	    ImagenRGB imagenResultado;

		if(!deshacer) {
			efecto.aplicar();
	    }
		else {
			efecto.deshacer();
		}
		imagenResultado = efecto.getImagen();
	    imagenResultado.presentarImagen();

	    return imagenResultado;
	}

}
