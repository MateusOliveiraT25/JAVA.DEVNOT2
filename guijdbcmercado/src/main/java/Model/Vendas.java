package Model;

public class Vendas {
    private Clientes cliente;
    private Carros carro;
    private double valorVenda;

    public Vendas(Clientes cliente, Carros carro, double valorVenda) {
        this.cliente = cliente;
        this.carro = carro;
        this.valorVenda = valorVenda;
    }

    public Clientes getCliente() {
        return cliente;
    }

    public Carros getCarro() {
        return carro;
    }

    public double getValorVenda() {
        return valorVenda;
    }
}
