package usuario;

import efectos.Efecto;
import efectos.EfectoEspejo;
import efectos.EfectoMarcoFoto;
import imagenes.ColorRGB;
import imagenes.ImagenRGB;

/**
 * Clase principal para la Práctica 5.
 * El alumno debe realizar la siguiente secuencia de operaciones:
 *   - Leer una imagen de disco y mostrarla por pantalla.
 *   - Realizar una operación de espejo vertical y mostrar el resultado por pantalla.
 *   - Realizar una ooperación de espejo horizontal y mostrar el resultado por pantalla.
 *   - Deshacer espejado total y mostrar el resultado por pantalla.
 *   - Crear un marco foto a la imagen anterior y mostrar el resultado por pantalla.
 *   - Guardar imagen procesada en disco.
 *
 * @author programaci�n II
 * @version 1.0
 */
public class P5Aplicacion {

	public static void main(String[] args) {
	    ImagenRGB imagen;
	    Efecto efecto;
	    String fichero = "src/MicroHobby.jpg";

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
		efecto.deshacer();
		imagen = efecto.getImagen();

	    //Establecimiento de un marco estilo foto.
		ColorRGB colorMarcoFoto = new ColorRGB(110,245,100); // Kiwi green
	    efecto = new EfectoMarcoFoto("Imagen con Marco Foto", imagen, colorMarcoFoto);
	    imagen = OperarEfecto (efecto, false);

	    //Guarda resultado en fichero.
		imagen.escribirImagen("MicroHobbyProcesado.jpg");
	}

	/**
	 * Este método se encarga de aplicar un procesado sobre la imagen. Devuelve la imagen
	 * resultante y la muestra por pantalla.
	 * El método permite aplicar el efecto indicado o deshacer las operaciones previamente
	 * realizadas con el mismo.
	 * Precondiciones:
	 * {@code "efecto" debe ser un objeto de clase Efecto (o derivada) válidamente creado.}
	 * 
	 * @param efecto Efecto a aplicar o deshacer.
	 * @param deshacer Con true deshace el tratamiento previamente implementado con el
	 *                 efecto; Con false aplica el efecto.
	 */
	private static ImagenRGB OperarEfecto(Efecto efecto, boolean deshacer) {
	    ImagenRGB imagenResultado;

		if(!deshacer) {
			efecto.aplicar();
	    }
		else {
			// Do I have to rewrite the efectos but in reverse?
			// Should I create a previousImage variable that keeps storing the last generated image
			// prior to the latest effect applied, and then I can return this image here as if
			// it was undoing the latest effect?
		}
		imagenResultado = efecto.getImagen();
	    imagenResultado.presentarImagen();

	    return imagenResultado;
	}

}
