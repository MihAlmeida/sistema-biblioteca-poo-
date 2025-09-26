import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private List<Livro> livros;
    private List<Usuario> usuarios;
    
    public Biblioteca() {
        this.livros = new ArrayList<>();
        this.usuarios = new ArrayList<>();
        inicializarDados();
    }
    
    public void adicionarLivro(Livro livro) {
        livros.add(livro);
        System.out.println("Livro adicionado: " + livro.getTitulo());
    }
    
    public void cadastrarUsuario(Usuario usuario) {
        usuarios.add(usuario);
        System.out.println("Usuário cadastrado: " + usuario.getNome());
    }
    
    public Livro buscarLivro(String titulo) {
        for (Livro livro : livros) {
            if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                return livro;
            }
        }
        return null;
    }
    
    public Usuario buscarUsuario(int id) {
        for (Usuario usuario : usuarios) {
            if (usuario.getId() == id) {
                return usuario;
            }
        }
        return null;
    }
    
    public void listarLivros() {
        System.out.println("\n=== LIVROS NA BIBLIOTECA ===");
        if (livros.isEmpty()) {
            System.out.println("Nenhum livro cadastrado.");
        } else {
            for (Livro livro : livros) {
                System.out.println(livro);
            }
        }
    }
    
    public void listarUsuarios() {
        System.out.println("\n=== USUÁRIOS CADASTRADOS ===");
        for (Usuario usuario : usuarios) {
            System.out.println(usuario.getNome() + " (ID: " + usuario.getId() + ")");
        }
    }
    
    private void inicializarDados() {
        // Dados iniciais para teste
        adicionarLivro(new Livro("Dom Casmurro", "Machado de Assis", "001"));
        adicionarLivro(new Livro("1984", "George Orwell", "002"));
        cadastrarUsuario(new Usuario("João Silva", 1));
        cadastrarUsuario(new Usuario("Maria Santos", 2));
    }
}