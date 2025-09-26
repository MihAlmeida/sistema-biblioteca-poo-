import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        Scanner scanner = new Scanner(System.in);
        int opcao;
        
        System.out.println("🐉 BEM-VINDO AO SISTEMA DE BIBLIOTECA! 🐉");
        
        do {
            System.out.println("\n=== MENU PRINCIPAL ===");
            System.out.println("1. 📚 Listar todos os livros");
            System.out.println("2. 👥 Listar usuários");
            System.out.println("3. 📖 Emprestar livro");
            System.out.println("4. 🔄 Devolver livro");
            System.out.println("5. ➕ Adicionar novo livro");
            System.out.println("6. 👤 Adicionar novo usuário");
            System.out.println("0. ❌ Sair do sistema");
            System.out.print("Escolha uma opção: ");
            
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer
            
            switch (opcao) {
                case 1:
                    biblioteca.listarLivros();
                    break;
                    
                case 2:
                    biblioteca.listarUsuarios();
                    break;
                    
                case 3:
                    System.out.print("Digite o título do livro: ");
                    String tituloEmprestimo = scanner.nextLine();
                    System.out.print("Digite o ID do usuário: ");
                    int userId = scanner.nextInt();
                    
                    Livro livroEmprestimo = biblioteca.buscarLivro(tituloEmprestimo);
                    Usuario usuarioEmprestimo = biblioteca.buscarUsuario(userId);
                    
                    if (livroEmprestimo != null && usuarioEmprestimo != null) {
                        if (usuarioEmprestimo.emprestarLivro(livroEmprestimo)) {
                            System.out.println("✅ Livro emprestado com sucesso para " + usuarioEmprestimo.getNome());
                        } else {
                            System.out.println("❌ Livro indisponível!");
                        }
                    } else {
                        System.out.println("❌ Livro ou usuário não encontrado!");
                    }
                    break;
                    
                case 4:
                    System.out.print("Digite o título do livro para devolução: ");
                    String tituloDevolucao = scanner.nextLine();
                    System.out.print("Digite o ID do usuário: ");
                    int userDevolucao = scanner.nextInt();
                    
                    Livro livroDevolucao = biblioteca.buscarLivro(tituloDevolucao);
                    Usuario usuarioDevolucao = biblioteca.buscarUsuario(userDevolucao);
                    
                    if (livroDevolucao != null && usuarioDevolucao != null) {
                        if (usuarioDevolucao.devolverLivro(livroDevolucao)) {
                            System.out.println("✅ Livro devolvido com sucesso!");
                        } else {
                            System.out.println("❌ Este usuário não tinha este livro emprestado!");
                        }
                    } else {
                        System.out.println("❌ Livro ou usuário não encontrado!");
                    }
                    break;
                    
                case 5:
                    System.out.println("📖 Adicionar novo livro:");
                    System.out.print("Título: ");
                    String novoTitulo = scanner.nextLine();
                    System.out.print("Autor: ");
                    String novoAutor = scanner.nextLine();
                    System.out.print("ISBN: ");
                    String novoIsbn = scanner.nextLine();
                    System.out.print("É digital? (s/n): ");
                    String ehDigital = scanner.nextLine();
                    
                    if (ehDigital.equalsIgnoreCase("s")) {
                        System.out.print("Formato (PDF/EPUB): ");
                        String formato = scanner.nextLine();
                        LivroDigital livroDigital = new LivroDigital(novoTitulo, novoAutor, novoIsbn, formato);
                        biblioteca.adicionarLivro(livroDigital);
                    } else {
                        Livro livroNormal = new Livro(novoTitulo, novoAutor, novoIsbn);
                        biblioteca.adicionarLivro(livroNormal);
                    }
                    break;
                    
                case 6:
                    System.out.println("👤 Adicionar novo usuário:");
                    System.out.print("Nome: ");
                    String novoNome = scanner.nextLine();
                    System.out.print("ID (número): ");
                    int novoId = scanner.nextInt();
                    scanner.nextLine();
                    
                    Usuario novoUsuario = new Usuario(novoNome, novoId);
                    biblioteca.cadastrarUsuario(novoUsuario);
                    break;
                    
                case 0:
                    System.out.println("👋 Obrigado por usar o sistema! Até logo!");
                    break;
                    
                default:
                    System.out.println("❌ Opção inválida! Tente novamente.");
            }
            
        } while (opcao != 0);
        
        scanner.close();
    }
}