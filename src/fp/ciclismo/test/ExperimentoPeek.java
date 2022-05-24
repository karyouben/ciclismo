package fp.ciclismo.test;

import java.util.Arrays;
import java.util.List;

public class ExperimentoPeek {

	public static void main(String[] args) {
		List<String> lista=Arrays.asList("Java","C","Python","Ruby","ADA","COBOL");
		lista.stream()
		.peek(c->System.out.println("orig:<"+c+">"))
		.filter(cadena->cadena.length()>3)
		.peek(c->System.out.println("filtre:<"+c+">"))
		.map((cadena)->cadena.toUpperCase())
		.peek(c->System.out.println("map:<"+c+">"))
		.forEach(System.out::println);
		

	}

}
