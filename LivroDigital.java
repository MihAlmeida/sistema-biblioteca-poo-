public class LivroDigital extends Livro {
    private String formato;
    
    public LivroDigital(String titulo, String autor, String isbn, String formato) {
        super(titulo, autor, isbn);
        this.formato = formato;
    }
    
    public String getFormato() { return formato; }
    
    @Override
    public String toString() {
        return String.format("'%s' por %s - Formato: %s - %s", 
                getTitulo(), getAutor(), formato, 
                isDisponivel() ? "Disponível" : "Emprestado");
    }
}