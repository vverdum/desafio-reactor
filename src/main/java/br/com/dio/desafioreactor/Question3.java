package br.com.dio.desafioreactor;

import reactor.core.publisher.Mono;

import java.util.List;

public class Question3 {

    public static void main(String[] args) {
        // Criando a lista de usuários
        List<User> users = List.of(
                new User(1L, "Alice", "alice@example.com", "password123", true),
                new User(2L, "Bob", "bob@example.com", "pass", false), // Senha inválida
                new User(3L, "Charlie", "charlie@example.com", "password789", true),
                new User(4L, "David", "david@example.com", "password321", false)
        );

        Question3 validade = new Question3();
        // Verificando a validade do usuário Alice
        validade.userIsValid(users.get(0)).subscribe(
                nullValue -> System.out.println("Usuário Alice é válido."),
                error -> System.out.println("Erro: " + error.getMessage())
        );
        // Verificando a validade do usuário Bob (senha inválida)
        validade.userIsValid(users.get(1)).subscribe(
                nullValue -> System.out.println("Usuário Bob é válido."),
                error -> System.out.println("Erro: " + error.getMessage())
        );
    }
    public Mono<Void> userIsValid(final User user) {
        if (user.getPassword() != null && user.getPassword().length() > 8) {
            return Mono.empty(); // Retorna Mono<Void> sem erros
        } else {
            // Dispara uma exceção se a senha não for válida
            return Mono.error(new IllegalArgumentException("Senha inválida: deve ter mais de 8 caracteres."));
        }
    }


}
