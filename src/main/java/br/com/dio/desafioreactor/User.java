package br.com.dio.desafioreactor;

public record User(Long id,
                   String name,
                   String email,
                   String password,
                   Boolean isAdmin) {
    public User(Long id, String name, String email, String password, Boolean isAdmin) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.isAdmin = isAdmin;
    }
    public Boolean isAdmin() {
        return isAdmin;
    }
    public String getPassword() {
        return password;
    }
}
