package fp.ciclismo;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author reinaqu_2
 *
 */
public interface EstadisticasCarrera {
	/**
	 * @return El nombre de la carrera
	 */
	String getNombreCarrera();

	/**
	 * @return Una lista con todos los ganadores del tour
	 */
	List<Ganador> getGanadores();

	/**
	 * @param km
	 *            Umbral de kil�metros recorrido por el ciclista en el tour
	 * @return Una lista con los nombres de los ganadores que han recorrido
	 *         menos kil�metros que los dados como par�metro
	 */
	List<String> getGanadoresConRecorridoInferiorA(Integer km);

	/**
	 * @return true si todos los ganadores han ganado alguna etapa en la edici�n
	 *         en la que ganaron el tour
	 */
	Boolean hanGanadoTodosAlgunaEtapa();

	/**
	 * @return El n�mero de ganadores distintos del tour. Si un ciclista ha
	 *         ganado el tour en varias ediciones, solo se debe contar una vez.
	 */
	Long getNumeroGanadores();

	/**
	 * @return Un conjunto con los nombres de los equipos que han ganado la
	 *         carrera.
	 */
	Set<String> getEquiposGanadores();

	/**
	 * @param nombre
	 *            Nombre del ciclista
	 * @return El primer ganador que concuerde con el nombre dado como
	 *         par�metro. Si no se encuentra ninguno, se devuelve null
	 */
	Ganador buscaGanador(String nombre);

	/**
	 * @param anyo
	 *            A�o de celebraci�n de la carrera
	 * @return El ciclista ganador de ese a�o, si es que existe. Si no se
	 *         encuentra ninguno, se devuelve null.
	 */
	Ganador buscaGanador(Integer anyo);

	/**
	 * @return La suma de los kil�metros recorridos en todas las ediciones de la
	 *         carrera.
	 */
	Integer calculaDistanciaTotal();

	/**
	 * @return El n�mero de kil�metros de la edici�n en la que se ha hecho el
	 *         recorrido m�s corto. Si no se puede calcular, devuelve cero.
	 * 
	 */
	Integer getKmMenorRecorrido();

	/**
	 * @param equipo
	 *            Nombre de un equipo.
	 * @return N�mero medio de etapas que han ganado los ciclistas que corren en
	 *         ese equipo. Si no se puede calcular, devuelve cero.
	 */
	Double getMediaEtapasGanadas(String equipo);

	/**
	 * @return El nombre del ganador que ha alcanzado una mayor velocidad media
	 *         en la edici�n en la que ha sido ganador. Si no se puede calcular
	 *         devuelve null.
	 */

	String getGanadorMasRapido();

	/**
	 * @return Map en el que las claves son las nacionalidades y los valores la
	 *         lista de ganadores de esa nacionalidad
	 */
	Map<String, List<Ganador>> getGanadoresPorNacionalidad();

	/**
	 * @return Map en el que las claves son las nacionalidades, y los valores el
	 *         n�mero de veces que un corredor de esa nacionalidad ha ganado la
	 *         carrera
	 */
	Map<String, Long> cuentaGanadoresPorNacionalidad();

	Map<String, Integer> getTotalEtapasGanadasPorEquipo();
	
	Map<String, Integer> cuentaCarrerasGanadasPorCiclista();
	Map<String, Ganador> ganadorMasDiasMaillotPorNacionalidad();

	String getNacionalidadMasGanadores();
	/**
	 * @param nacionalidad
	 *            Nacionalidad del ciclista
	 * @return Devuelve cierto si hay alg�n ganador de la nacionalidad dada como
	 *         par�metro.
	 */
	Boolean hayAlgunGanadorNacionalidad(String nacionalidad);
	
	/**
	 * @param nombreFichero
	 *    Nombre del fichero en el que se guarda la informaci�n.
 	 * @param nacionalidad Nacionalidad buscada.
 	 * Guarda en un fichero los ganadores de la carrera de la nacionalidad dada como
 	 * par�metro, con los a�os en los que ha ganado. Un ejemplo de l�nea del fichero 
 	 * generado es
 	 * Alberto Contador-> [2007, 2009]
	 */
	void guardaGanadoresNacionalidadConAnyos(String nombreFichero, String nacionalidad);
	
	/**
	 * @param nombreFichero Nombre fichero
	 * @param anyoInicial A�o inicial del intervalo. Se incluye en el resultado
	 * @param anyoFinal A�o final del intervalo. No se incluye en el resultado.
	 */
	void guardaGanadoresDeAnyosOrdenados(String nombreFichero, Integer anyoInicial, Integer anyoFinal);
	
}
