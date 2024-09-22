package br.com.dio.desafioreactor;
import java.util.List;
import reactor.core.publisher.Flux;

public class Question1 {

    /*
    Recebe uma lista de longs, incrementa 1 nos valores e retorna um flux dos resultados

    public Flux<Long> inc(final List<Long> numbers){}*/
    public static void main(String[] args) {
        List<Long>numbers = List.of(1L,2L,2L,4L,5L); // Lista de longs
        Question1 incrementer = new Question1(); // Cria uma instancia da classe
        Flux<Long> incrementedFlux = incrementer.inc(numbers);
        incrementedFlux.subscribe(result -> System.out.println(result));


    }
    public Flux<Long>inc(final List<Long>numbers){
        return Flux.fromIterable(numbers) // Cria um Flux a partir da lista
                .map(number ->number+1); // Incrementa 1 em cada número

}
}