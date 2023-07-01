public class Admin extends Usuario{

    private String tipo;


    public Admin(String username, String password) {
        super(username, password);
        this.tipo = "admin";
    }

    @Override
    public String getTipo() {
        return tipo;
    }

}
