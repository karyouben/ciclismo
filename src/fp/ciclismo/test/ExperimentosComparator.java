package fp.ciclismo.test;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

import fp.ciclismo.EstadisticasCarrera;
import fp.ciclismo.FactoriaCiclismo;
import fp.ciclismo.Ganador;

public class ExperimentosComparator {

	public static void main(String[] args) {
		EstadisticasCarrera est = FactoriaCiclismo.creaEstadisticas2006_16();
		List<Ganador> ganadores = est.getGanadores();
	//	mostrarGanadores(ganadores);

		Comparator<Ganador> c = Comparator.comparing(Ganador::nacionalidad)
				                          .thenComparing(Ganador::anyo);
		Collections.sort(ganadores,c);
	//	mostrarGanadores(ganadores);

		Comparator<Ganador> c2 = Comparator.comparing(Ganador::nacionalidad)
				                           .thenComparing(Ganador::anyo);
		                                   
        Collections.sort(ganadores,c2);
    //    mostrarGanadores(ganadores);
        
		Comparator<Ganador> cAnyoInt = Comparator.comparing(Ganador::anyo)
                		                         .reversed();
		Comparator<Ganador> c3 = Comparator.comparing(Ganador::nacionalidad)
                                           .thenComparing(cAnyoInt);
                
        Collections.sort(ganadores,c3);
    //    mostrarGanadores(ganadores);
        
        Comparator<Ganador> c4 = Comparator.comparing(Ganador::nacionalidad);
        SortedSet<Ganador>  ss = new TreeSet<Ganador>(c4);
        mostrarGanadores(ss);
        
        Comparator<Ganador> c5 = Comparator.comparing(Ganador::kmRecorridos);
        Ganador g  = Collections.max(ganadores,c5);
        mostrarGanadores2(g);
	}

	private static void mostrarGanadores(Collection<Ganador> ganadores) {
		for(Ganador g: ganadores) {
			System.out.println(g);
		}
	}
		private static void mostrarGanadores2(Ganador g2) {
			for(Ganador g: g2) {
				System.out.println(g);
			}
		

		
	}

}
