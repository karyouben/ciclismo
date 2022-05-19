package fp.ciclismo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
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
		return ganadores.stream()
				.map(Ganador::nombre) //stream<String>
		        .distinct() //stream<String> sin repetir
		        .count(); //long
	}

	/* (non-Javadoc)
	 * @see fp.ciclismo.EstadisticasTour#hanGanadoTodosAlgunaEtapa()
	 */
	public Boolean hanGanadoTodosAlgunaEtapa(){
		return ganadores.stream()
				.allMatch(ganador ->ganador.numEtapasGanadas()>0);		
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
		return ganadores.stream() //stream<Ganador>
				.filter(g->g.nombre().equals(nombre)) // stream<Ganador>(filtrado por el nombre buscado)
				.findFirst() //optional <Ganador>
				.orElse(null);
	}

	/* (non-Javadoc)
	 * @see fp.ciclismo.EstadisticasTour#buscaGanador(java.lang.Integer)
	 */
	public Ganador buscaGanador(Integer anyo) {
		return ganadores.stream() //stream<Ganador>
				.filter(g->g.anyo().equals(anyo)) // stream<Ganador>(filtrado por el nombre buscado)
				.findFirst() //optional <Ganador> //.findAny()
				.orElse(null);
	}

	/* (non-Javadoc)
	 * @see fp.ciclismo.EstadisticasTour#calcularDistanciaTotal()
	 */
	@Override
	public Integer calculaDistanciaTotal() {
		return ganadores.stream() //stream<Ganador>
				.map(Ganador::kmRecorridos) //stream<Integer>
				//.reduce(0, (x,y)->x+y); //Elemento neutro, bynaryOperator
				.reduce(0, Integer::sum);
	}
	
	public Integer calculaDistanciaTotal_2() {
		//Stream especializados en tipos básicos
		return ganadores.stream() //stream<Ganador>
				.mapToInt(Ganador::kmRecorridos) //stream<Integer>
				//.reduce(0, (x,y)->x+y); //Elemento neutro, bynaryOperator
				.sum();
	}


	

	@Override
	public Double getMediaEtapasGanadas(String equipo) {
		return ganadores.stream() //stream<Ganador>
				.filter(ganador->ganador.equipo().equals(equipo))
				.mapToInt(Ganador::numEtapasGanadas) //stream<Integer> o IntStream
				.average()
				.orElse(0.0); //optionalDouble
	}
	/* (non-Javadoc)
	 * @see fp.ciclismo.EstadisticasTour#getDistanciaMenor()
	 */
	public Integer getKmMenorRecorrido() {
		return ganadores.stream() //Stream<Ganador>
				.min(Comparator.comparing(Ganador::kmRecorridos))
				.map(Ganador::kmRecorridos)
				.orElse(0); //Optional<Ganador>
//		        .orElseThrow(IllegalArgumentException::new);
//				.orElseThrow(()->new IllegalArgumentException("Km no encontrados"));
	 } 

	
	/* (non-Javadoc)
	 * @see fp.ciclismo.EstadisticasTour#getGanadorMasRapido()
	 */
	public String getGanadorMasRapido2() {
		Ganador g= ganadores.stream()
				.max(Comparator.comparing(Ganador::getVelocidadMedia))
				.orElse(null);
		String res= null;
		if(g!= null) {
			res=g.nombre();
		}
		return res;
	}
	
	public String getGanadorMasRapido3() {
		return ganadores.stream()
				.max(Comparator.comparing(Ganador::getVelocidadMedia))
				.map(Ganador::nombre)
				.orElse(null);
	}
	
	public String getGanadorMasRapido() {
	Optional<Ganador> opt= ganadores.stream() //stream <Ganador>
			.max(Comparator.comparing(Ganador::getVelocidadMedia));
	String res= null;
	if(opt.isPresent()) {
		res = opt.get().nombre();
	}
	return res;
  }
//	List<String> getGanadoresConRecorridoInferiorA(Integer km):

	public Map<String, List<Ganador>> getGanadoresPorNacionalidad() {
		return ganadores.stream() //Stream<Ganador>
			   .collect(Collectors.groupingBy(Ganador::nacionalidad)); //funcion claves
	}

	public Map<String, Set<Ganador>> getGanadoresPorNacionalidad_ejemplo2() {
		return ganadores.stream() //Stream<Ganador>
			   .collect(Collectors.groupingBy(Ganador::nacionalidad,
				Collectors.toSet())); //funcion claves
	}
	
	public Map<String, SortedSet<Ganador>> getGanadoresPorNacionalidad_ejemplo3() {
		return ganadores.stream() //Stream<Ganador>
				   .collect(Collectors.groupingBy(Ganador::nacionalidad,
					Collectors.toCollection(TreeSet::new))); //funcion claves
	}
	
	/* (non-Javadoc)
	 * @see fp.ciclismo.EstadisticasCarrera#cuentaGanadoresPorNacionalidad()
	 */
	public Map<String, Long> cuentaGanadoresPorNacionalidad() {
		return ganadores.stream() //Stream<Ganador>
				   .collect(Collectors.groupingBy(Ganador::nacionalidad, //funcion claves
					Collectors.counting()));  //summingInt averagingInt maxBy(c)-->optional

	}

	/* (non-Javadoc)
	 * @see fp.ciclismo.EstadisticasCarrera#getTotalEtapasGanadasPorEquipo()
	 */
	public Map<String, Integer> getTotalEtapasGanadasPorEquipo(){
		return ganadores.stream() //Stream<Ganador>
				   .collect(Collectors.groupingBy(Ganador::equipo, //Función para las claves
					Collectors.summingInt(Ganador::numEtapasGanadas)));
	}

	public Map<String, Double> getMediaEtapasGanadasPorEquipo(){
		return ganadores.stream() //Stream<Ganador>
				   .collect(Collectors.groupingBy(Ganador::equipo, //Función para las claves
					Collectors.averagingInt(Ganador::numEtapasGanadas)));
	}
	
	@Override
	public Map<String, Integer> cuentaCarrerasGanadasPorCiclista() {
		return ganadores.stream()
				.collect(Collectors.groupingBy(Ganador::nombre,
						Collectors.collectingAndThen(Collectors.counting(), Long::intValue)));
	}
	/* (non-Javadoc)
	 * @see fp.ciclismo.EstadisticasCarrera#guardaGanadoresNacionalidadConAnyos(java.lang.String, java.lang.String)
	 */
	public void guardaGanadoresNacionalidadConAnyos(String nombreFichero, String nacionalidad) {
		Map<String,List<Integer>> m=
				ganadores.stream()
				.filter(g->g.nacionalidad().equals(nacionalidad))
				.collect(Collectors.groupingBy(Ganador::nombre,//funcion claves
						Collectors.mapping(//función antes de guardar en el map
								Ganador::anyo,// agrupar por anyo
								Collectors.toList()))); //agrupa en una lista
		Ficheros.escribeFichero("Error escribiendo en archivo", m, nombreFichero);
	}
	

@Override
public Map<String, List<Ganador>> getMasDiasMaillotPorNacionalidad(Integer n) {
	Map<String, List<Ganador>> mAux = getGanadoresPorNacionalidad();
	return mAux.entrySet().stream()
			.collect(Collectors.toMap(Map.Entry::getKey,//1. Funcion para obtener las claves
					entry->obtenerNMasDias(entry.getValue(),n)));                                 //2. Funcion para obtener el valor
	
}
	private List<Ganador> obtenerNMasDias(List<Ganador> lisGanadores, Integer n) {
		Comparator<Ganador> c= Comparator.comparing(Ganador::numDiasMaillotAmarillo).reversed();
		return lisGanadores.stream()
				.sorted(c) //Stream<Ganador> ordenado
				.limit(n)
				.collect(Collectors.toList());
}
@Override
	public Map<String, Ganador> ganadorMasDiasMaillotPorEquipo() {
	Comparator<Ganador> c= Comparator.comparing(Ganador::numDiasMaillotAmarillo);
	return ganadores.stream()
			.collect(Collectors.toMap(
					Ganador::equipo,//funcion para las claves
					ganador->ganador,//Function.identity())
					//Operador binario, para determinar que se
					//hace con los valores de las claves duplicadas
					BinaryOperator.maxBy(c)
					));
	}
    public Map<String, Ganador> ganadorMasDiasMaillotPorEquipo2() {
    Comparator<Ganador> c= Comparator.comparing(Ganador::numDiasMaillotAmarillo);
    return ganadores.stream()
    		.collect(Collectors.groupingBy(Ganador::equipo,
    				Collectors.collectingAndThen(Collectors.maxBy(c),
    					opt->opt.get()	)));//funcion para transformar tras recolectar
    //Optional::get

}




	public Map<String, Ganador> ganadorMasDiasMaillotPorNacionalidad() {
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
