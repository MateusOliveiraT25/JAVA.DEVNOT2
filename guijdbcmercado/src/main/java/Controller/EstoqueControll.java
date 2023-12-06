package Controller;

import java.sql.SQLException;
import java.util.List;
import Model.Estoque;
import Model.Produto;
import Controller.ProdutoDAO;

public class EstoqueControll {
    private Estoque estoque;
    private ProdutoDAO produtoDAO; // Adicione um campo para o ProdutoDAO

    public EstoqueControll() {
        this.estoque = new Estoque();
        this.produtoDAO = new ProdutoDAO(); // Inicialize o ProdutoDAO
    }

    /**
     * Adiciona um novo produto ao estoque e atualiza o banco de dados.
     *
     * @param codigoBarra Código de barras do produto.
     * @param nome        Nome do produto.
     * @param quantidade  Quantidade do produto.
     * @param preco       Preço do produto.
     */
    public void adicionarProduto(String codigoBarra, String nome, int quantidade, double preco) {
        try {
            // Cria um novo produto
            Produto novoProduto = new Produto(codigoBarra, nome, quantidade, preco);

            // Adiciona o produto ao estoque
            estoque.adicionarProduto(novoProduto);
            System.out.println("Produto adicionado com sucesso!");

            // Atualiza a tabela do banco de dados
            atualizarTabelaBancoDados();
        } catch (IllegalArgumentException e) {
            System.err.println("Erro ao adicionar produto: " + e.getMessage());
        }
    }

    /**
     * Remove um produto do estoque e atualiza o banco de dados.
     *
     * @param produto Produto a ser removido.
     */
    public void removerProduto(Produto produto) {
        try {
            // Remove o produto do estoque
            estoque.removerProduto(produto);
            System.out.println("Produto removido com sucesso!");

            // Atualiza a tabela do banco de dados
            atualizarTabelaBancoDados();
        } catch (IllegalArgumentException e) {
            System.err.println("Erro ao remover produto: " + e.getMessage());
        }
    }

    /**
     * Lista todos os produtos do estoque.
     *
     * @return Lista de produtos no estoque.
     */
    public List<Produto> listarProdutosDoBanco() {
        try {
            return produtoDAO.listarTodos();
        } catch (Exception e) {
            System.err.println("Erro ao listar produtos do banco de dados: " + e.getMessage());
            return null;
        }
    }
    

    /**
     * Atualiza a tabela do banco de dados com os produtos do estoque.
     */
    private void atualizarTabelaBancoDados() {
        // Obtém a lista de produtos do estoque
        List<Produto> produtos = estoque.listarProdutos();

        // Atualiza a tabela no banco de dados
        produtoDAO.atualizarTabelaBancoDados(produtos);
    }
}
