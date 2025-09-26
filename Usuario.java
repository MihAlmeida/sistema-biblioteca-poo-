import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String nome;
    private int id;
    private List<Livro> livrosEmprestados;
    
    public Usuario(String nome, int id) {
        this.nome = nome;
        this.id = id;
        this.livrosEmprestados = new ArrayList<>();
    }
    
    public String getNome() { return nome; }
    public int getId() { return id; }
    public List<Livro> getLivrosEmprestados() { return livrosEmprestados; }
    
    public boolean emprestarLivro(Livro livro) {
        if (livro.isDisponivel()) {
            livro.setDisponivel(false);
            livrosEmprestados.add(livro);
            return true;
        }
        return false;
    }
    
    public boolean devolverLivro(Livro livro) {
        if (livrosEmprestados.contains(livro)) {
            livro.setDisponivel(true);
            livrosEmprestados.remove(livro);
            return true;
        }
        return false;
    }
}