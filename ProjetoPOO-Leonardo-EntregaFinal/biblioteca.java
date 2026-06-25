import java.util.Scanner;

class Usuario {
    protected String nome;
    protected String cpf;

    public Usuario(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public void mostrarDados() {
        System.out.println("Nome: " + nome);
        System.out.println("CPF: " + cpf);
    }
}

class Cliente extends Usuario {
    private String email;
    private String endereco;

    public Cliente(String nome, String cpf, String email, String endereco) {
        super(nome, cpf);
        this.email = email;
        this.endereco = endereco;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void mostrarDados() {
        System.out.println("---- CLIENTE ----");
        super.mostrarDados();
        System.out.println("Email: " + email);
        System.out.println("Endereço: " + endereco);
    }
}

class Funcionario extends Usuario {
    private String email;
    private int codigo;

    public Funcionario(String nome, String cpf, String email, int codigo) {
        super(nome, cpf);
        this.email = email;
        this.codigo = codigo;
    }

    public void mostrarDados() {
        System.out.println("---- FUNCIONÁRIO ----");
        super.mostrarDados();
        System.out.println("Email: " + email);
        System.out.println("Código: " + codigo);
    }
}

class Item {
    protected String titulo;
    protected String autor;
    protected double preco;

    public Item(String titulo, String autor, double preco) {
        this.titulo = titulo;
        this.autor = autor;
        this.preco = preco;
    }

    public void mostrarDados() {
        System.out.println("Título: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("Preço: R$ " + preco);
    }
}

class Livro extends Item {
    private int numeroPaginas;
    private String categoria;

    public Livro(String titulo, String autor, double preco,
        int numeroPaginas, String categoria) {
        super(titulo, autor, preco);
        this.numeroPaginas = numeroPaginas;
        this.categoria = categoria;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void mostrarDados() {
        System.out.println("---- LIVRO ----");
        super.mostrarDados();
        System.out.println("Páginas: " + numeroPaginas);
        System.out.println("Categoria: " + categoria);
    }
}

public class biblioteca {

    public static boolean campoVazio(String texto) {
        return texto == null || texto.trim().isEmpty();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Usuario[] usuarios = new Usuario[100];
        Livro[] livros = new Livro[100];

        int qtdUsuarios = 0;
        int qtdLivros = 0;

        int opcao;

        do {

            System.out.println("======= BIBLIOTECA ========");
            System.out.println("1 - Cadastro de Cliente");
            System.out.println("2 - Área do Funcionário");
            System.out.println("3 - Catálogo");
            System.out.println("4 - Buscar Livro por Título");
            System.out.println("0 - Sair");

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {

                case 1:

                    System.out.print("Nome: ");
                    String nome = sc.nextLine();

                    System.out.print("CPF: ");
                    String cpf = sc.nextLine();

                    System.out.print("Email: ");
                    String email = sc.nextLine();

                    System.out.print("Endereço: ");
                    String endereco = sc.nextLine();

                    if (campoVazio(nome) || campoVazio(cpf) ||
                            campoVazio(email) || campoVazio(endereco)) {
                        System.out.println("---------------------------------------------------------");
                        System.out.println("Erro: nenhum campo pode ficar em branco.");
                    } else {

                        usuarios[qtdUsuarios++] =
                                new Cliente(nome, cpf, email, endereco);

                        System.out.println("Cadastro concluído com sucesso");
                    }

                    break;

                case 2:

                    System.out.println(
                            "AVISO: Senha da área de funcionários = 1234");

                    System.out.print("Digite a senha: ");
                    String senha = sc.nextLine();

                    if (!senha.equals("1234")) {
                        System.out.println("Senha incorreta");
                        break;
                    }

                    int opFunc;

                    do {

                        System.out.println("======= FUNCIONÁRIOS =======");
                        System.out.println("1 - Cadastro de funcionário");
                        System.out.println("2 - Cadastrar livros");
                        System.out.println("3 - Mostrar clientes");
                        System.out.println("4 - Consultar cliente por CPF");
                        System.out.println("5 - Consultar livro por título");
                        System.out.println("6 - Alterar preço de livro");
                        System.out.println("7 - Filtrar livros por categoria");
                        System.out.println("8 - Filtrar livros por faixa de preço");
                        System.out.println("0 - Voltar");

                        opFunc = sc.nextInt();
                        sc.nextLine();

                        switch (opFunc) {

                            case 1:

                                System.out.print("Nome: ");
                                String nomeF = sc.nextLine();

                                System.out.print("CPF: ");
                                String cpfF = sc.nextLine();

                                System.out.print("Email: ");
                                String emailF = sc.nextLine();

                                System.out.print("Código: ");
                                String codigoStr = sc.nextLine();

                                if (campoVazio(nomeF) || campoVazio(cpfF) ||
                                        campoVazio(emailF) || campoVazio(codigoStr)) {
                                    
                                    System.out.println("---------------------------------------------------------");
                                    System.out.println("Erro: nenhum campo pode ficar em branco.");
                                } else {

                                    int codigo = Integer.parseInt(codigoStr);

                                    usuarios[qtdUsuarios++] =
                                            new Funcionario(nomeF, cpfF, emailF, codigo);

                                    System.out.println("Funcionário cadastrado");
                                }

                                break;

                            case 2:
                                    System.out.print("Título: ");
                                    String titulo = sc.nextLine();

                                    System.out.print("Autor: ");
                                    String autor = sc.nextLine();

                                    System.out.print("Preço: ");
                                    String precoStr = sc.nextLine();

                                    System.out.print("Número de páginas: ");
                                    String paginasStr = sc.nextLine();

                                    System.out.print("Categoria: ");
                                    String categoria = sc.nextLine();

                                    if (campoVazio(titulo) || campoVazio(autor) ||
                                            campoVazio(precoStr) || campoVazio(paginasStr) ||
                                            campoVazio(categoria)) {
                                        
                                        System.out.println("---------------------------------------------------------");
                                        System.out.println("Erro: nenhum campo pode ficar em branco.");
                                    } else {

                                        try {

                                            double preco = Double.parseDouble(precoStr);
                                            int paginas = Integer.parseInt(paginasStr);

                                            livros[qtdLivros++] =
                                                    new Livro(titulo, autor, preco,
                                                            paginas, categoria);

                                            System.out.println("Livro cadastrado");

                                        } catch (NumberFormatException e) {

                                            System.out.println("---------------------------------------------------------");
                                            System.out.println("Erro: preço e número de páginas devem ser numéricos.");
                                        }
                                    }

                                break;

                            case 3:

                                System.out.println("===== CLIENTES CADASTRADOS =====");

                                for (int i = 0; i < qtdUsuarios; i++) {
                                    if (usuarios[i] instanceof Cliente) {
                                        usuarios[i].mostrarDados();
                                        System.out.println();
                                    }
                                }

                                break;

                            case 4:

                                System.out.print("Digite o CPF do cliente: ");
                                String cpfBusca = sc.nextLine();

                                boolean clienteEncontrado = false;

                                for (int i = 0; i < qtdUsuarios; i++) {

                                    if (usuarios[i] instanceof Cliente &&
                                            usuarios[i].cpf.equals(cpfBusca)) {

                                        usuarios[i].mostrarDados();
                                        clienteEncontrado = true;
                                    }
                                }

                                if (!clienteEncontrado) {
                                    System.out.println("Cliente não encontrado");
                                }

                                break;

                            case 5:

                                System.out.print("Digite o título do livro: ");
                                String tituloBusca = sc.nextLine();

                                boolean livroEncontrado = false;

                                for (int i = 0; i < qtdLivros; i++) {

                                    if (livros[i].titulo
                                            .equalsIgnoreCase(tituloBusca)) {

                                        livros[i].mostrarDados();
                                        livroEncontrado = true;
                                    }
                                }

                                if (!livroEncontrado) {
                                    System.out.println("Livro não encontrado");
                                }

                                break;

                            case 6:
                                System.out.print("Título do livro: ");
                                String tituloAlt = sc.nextLine();

                                if (campoVazio(tituloAlt)) {
                                    System.out.println("---------------------------------------------------------");
                                    System.out.println("Erro: o título não pode ficar em branco.");
                                    break;
                                }

                                boolean precoAlterado = false;

                                for (int i = 0; i < qtdLivros; i++) {

                                    if (livros[i].titulo.equalsIgnoreCase(tituloAlt)) {

                                        System.out.print("Novo preço: ");
                                        String novoPrecoStr = sc.nextLine();

                                        if (campoVazio(novoPrecoStr)) {
                                            System.out.println("---------------------------------------------------------");
                                            System.out.println("Erro: o preço não pode ficar em branco.");

                                        } else {

                                            try {

                                                double novoPreco =
                                                        Double.parseDouble(novoPrecoStr);

                                                livros[i].setPreco(novoPreco);

                                                System.out.println("Preço atualizado");
                                                precoAlterado = true;

                                            } catch (NumberFormatException e) {
                                                System.out.println("---------------------------------------------------------");
                                                System.out.println("Erro: o preço deve ser numérico.");
                                            }
                                        }

                                        break;
                                    }
                                }

                                if (!precoAlterado) {
                                    System.out.println("Livro não encontrado");
                                }

                                break;

                            case 7:

                                System.out.print("Categoria desejada: ");
                                String categoriaBusca = sc.nextLine();

                                boolean categoriaEncontrada = false;

                                for (int i = 0; i < qtdLivros; i++) {

                                    if (livros[i].getCategoria()
                                            .equalsIgnoreCase(categoriaBusca)) {

                                        livros[i].mostrarDados();
                                        System.out.println();
                                        categoriaEncontrada = true;
                                    }
                                }

                                if (!categoriaEncontrada) {
                                    System.out.println("Nenhum livro encontrado");
                                }

                                break;

                            case 8:

                                System.out.print("Preço mínimo: ");
                                double min = sc.nextDouble();

                                System.out.print("Preço máximo: ");
                                double max = sc.nextDouble();
                                sc.nextLine();

                                boolean faixaEncontrada = false;

                                for (int i = 0; i < qtdLivros; i++) {

                                    if (livros[i].preco >= min
                                            && livros[i].preco <= max) {

                                        livros[i].mostrarDados();
                                        System.out.println();
                                        faixaEncontrada = true;
                                    }
                                }

                                if (!faixaEncontrada) {
                                    System.out.println("Nenhum livro encontrado.");
                                }

                                break;

                            case 0:
                                System.out.println("Retornando...");
                                break;

                            default:
                                System.out.println("Opção inválida");
                        }

                    } while (opFunc != 0);

                    break;

                case 3:

                    System.out.println("======= CATÁLOGO =======");

                    if (qtdLivros == 0) {
                        System.out.println("Nenhum livro cadastrado");
                    }

                    for (int i = 0; i < qtdLivros; i++) {
                        livros[i].mostrarDados();
                        System.out.println();
                    }

                    break;

                case 4:

                        System.out.print("Digite o título do livro: ");
                        String tituloBuscaUsuario = sc.nextLine();

                        boolean encontrado = false;

                        for (int i = 0; i < qtdLivros; i++) {

                            if (livros[i].titulo.equalsIgnoreCase(tituloBuscaUsuario)) {

                                System.out.println("Livro encontrado:");
                                livros[i].mostrarDados();

                                encontrado = true;
                            }
                        }

                        if (!encontrado) {
                            System.out.println("Livro não encontrado.");
                        }

                        break;

                case 0:

                    System.out.println("Sistema encerrado");
                    break;

                default:

                    System.out.println("Opção inválida");
            }

        } while (opcao != 0);

        sc.close();
    }
}