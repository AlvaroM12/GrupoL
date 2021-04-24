import java.io.IOException;

import es.uma.informatica.EJB.DatosEJB;
import es.uma.informatica.Exception.DatosException;

public class prueba {

	public static void main(String[] args) throws IOException {
		DatosEJB d = new DatosEJB();
		try {
			d.exportarDatos();
		} catch (DatosException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
