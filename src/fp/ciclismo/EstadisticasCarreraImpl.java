package fp.ciclismo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

import fp.utiles.Checkers;
import fp.utiles.Ficheros;

public class EstadisticasCarreraImpl implements EstadisticasCarrera {

	private String nombreCarrera;
	private List<Ganador> ganadores;

	/**
	 * @param nombre Nombre de la carrera
	 */
	public EstadisticasCarreraImpl(String nombre) {
		this.nombreCarrera = nombre;
		this.ganadores = new ArrayList<Ganador>();
	}
	
	public EstadisticasCarreraImpl(String nombre, Collection<Ganador> ganadores) {
		this (nombre);
		this.ganadores = new ArrayList<Ganador>(ganadores);
	}
	
	@Override
	public String getNombreCarrera() {
		return this.nombreCarrera;
	}
	/* (non-Javadoc)
	 * @see fp.ciclismo.EstadisticasTour#getGanadores()
	 */
	public List<Ganador> getGanadores() {
		return new ArrayList<Ganador>(ganadores);
	}


	public boolean equals(Object obj) {
	boolean res = false;
		if (obj!= null && obj instanceof EstadisticasCarrera){
			EstadisticasCarrera est= (EstadisticasCarrera) obj;
			res = getNombreCarrera().equals(est.getNombreCarrera())
					&& this.ganadores.equals(est.getGanadores());
		}
	return res;
	}

	public int hashCode() {
		return getNombreCarrera().hashCode() + 31* this.ganadores.hashCode();
	}
	
	public String toString() {
		return getNombreCarrera()+" - " + this.ganadores;
	}
	/* (non-Javadoc)
	 * @see fp.ciclismo.EstadisticasTour#getGanadoresConRecorridoInferiorA(java.lang.Integer)
	 */
	public List<String> getGanadoresConRecorridoInferiorA(Integer km) {
		//TODO
		return null;
	}

	/* (non-Javadoc)
	 * @see fp.ciclismo.EstadisticasTour#getNumeroGanadores()
	 */
	
	public Long getNumeroGanadores() {
		//TODO
		return null;
	}

	/* (non-Javadoc)
	 * @see fp.ciclismo.EstadisticasTour#hanGanadoTodosAlgunaEtapa()
	 */
	public Boolean hanGanadoTodosAlgunaEtapa(){
		//TODO
		return null;		
	}
	
	/* (non-Javadoc)
	 * @see fp.ciclismo.EstadisticasCarrera#hayAlgunGanadorNacionalidad(java.lang.String)
	 */
	public Boolean hayAlgunGanadorNacionalidad(String nacionalidad) {
		//TODO
		return null;
	}
	
	/* (non-Javadoc)
	 * @see fp.ciclismo.EstadisticasTour#getEquiposGanadores()
	 */
	public Set<String> getEquiposGanadores() {
		//TODO
		return null;
	}

	/* (non-Javadoc)
	 * @see fp.ciclismo.EstadisticasTour#buscarGanador(java.lang.String)
	 */
	public Ganador buscaGanador(String nombre) {
		//TODO		
		return null;
	}

	/* (non-Javadoc)
	 * @see fp.ciclismo.EstadisticasTour#buscaGanador(java.lang.Integer)
	 */
	public Ganador buscaGanador(Integer anyo) {
		
		//TODO		
		return null;
	}

	/* (non-Javadoc)
	 * @see fp.ciclismo.EstadisticasTour#calcularDistanciaTotal()
	 */
	@Override
	public Integer calculaDistanciaTotal() {
		//TODO
		return null;
	}


	

	@Override
	public Double getMediaEtapasGanadas(String equipo) {
	
		//TODO
		return null;
	}
	/* (non-Javadoc)
	 * @see fp.ciclismo.EstadisticasTour#getDistanciaMenor()
	 */
	public Integer getKmMenorRecorrido() {
		//TODO
		return null;
	 } 

	
	/* (non-Javadoc)
	 * @see fp.ciclismo.EstadisticasTour#getGanadorMasRapido()
	 */
	public String getGanadorMasRapido() {
		//TODO
		return null;
	}

	public Map<String, List<Ganador>> getGanadoresPorNacionalidad() {
		//TODO
		return null;
	}

	public Map<String, Set<Ganador>> getGanadoresPorNacionalidad_ejemplo2() {
		//TODO
		return null;
	}
	
	public Map<String, SortedSet<Ganador>> getGanadoresPorNacionalidad_ejemplo3() {
		//TODO
		return null;
	}
	
	/* (non-Javadoc)
	 * @see fp.ciclismo.EstadisticasCarrera#cuentaGanadoresPorNacionalidad()
	 */
	public Map<String, Long> cuentaGanadoresPorNacionalidad() {
		//TODO
		return null;

	}

	/* (non-Javadoc)
	 * @see fp.ciclismo.EstadisticasCarrera#getTotalEtapasGanadasPorEquipo()
	 */
	public Map<String, Integer> getTotalEtapasGanadasPorEquipo(){
		//TODO
		return null;
	}

	public Map<String, Double> getMediaEtapasGanadasPorEquipo(){
		//TODO
		return null;
	}
	
	@Override
	public Map<String, Integer> cuentaCarrerasGanadasPorCiclista() {
		
		//TODO
		return null;
	}
	/* (non-Javadoc)
	 * @see fp.ciclismo.EstadisticasCarrera#guardaGanadoresNacionalidadConAnyos(java.lang.String, java.lang.String)
	 */
	public void guardaGanadoresNacionalidadConAnyos(String nombreFichero, String nacionalidad) {
		//TODO
	}
	

	public Map<String, Ganador> ganadorMasDiasMaillotPorNacionalidad() {
		//TODO
		return null;
	}
	
	

	
	

	/* (non-Javadoc)
	 * @see fp.ciclismo.EstadisticasCarrera#guardaGanadoresDeAnyosOrdenados(java.lang.String, java.lang.Integer, java.lang.Integer)
	 */
	public void guardaGanadoresDeAnyosOrdenados(String nombreFichero, Integer anyoInicial, Integer anyoFinal) {
		//TODO
	}

	@Override
	public String getNacionalidadMasGanadores() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
