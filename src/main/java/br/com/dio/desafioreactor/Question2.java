package br.com.dio.desafioreactor;

import reactor.core.publisher.Mono;

import java.util.List;

public class Question2 {

    public static void main(String[] args) {
        // Criando a lista de usuários
        List<User> users = List.of(
                new User(1L, "Alice", "alice@example.com", "password123", true),
                new User(2L, "Bob", "bob@example.com", "password456", false),
                new User(3L, "Charlie", "charlie@example.com", "password789", true),
                new User(4L, "David", "david@example.com", "password321", false)
        );

        // Criando uma instância de Question2 e contando administradores
        Question2 counter = new Question2();
        Mono<Long> adminCount = counter.countAdmins(users);

        // Exibindo o resultado
        adminCount.subscribe(count -> System.out.println("Número de administradores: " + count));
    }

    public Mono<Long> countAdmins(final List<User> users) {
        long adminCount = users.stream()
                .filter(User::isAdmin)
                .count();
        return Mono.just(adminCount);
    }
}

// Classe User
/*class User {
    private String name;
    private boolean admin;

    public User(String name, boolean admin) {
        this.name = name;
        this.admin = admin;
    }

    public boolean isAdmin() {
        return admin;
    }
}*/