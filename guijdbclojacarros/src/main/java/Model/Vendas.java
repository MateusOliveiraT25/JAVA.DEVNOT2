package Model;

public class Vendas {
    private String data;
    private String carro;
    private String cliente;
    private String carrosQuant;
    private String valorTotal;
    public Vendas(String data, String carro, String cliente, String carrosQuant, String valorTotal) {
        this.data = data;
        this.carro = carro;
        this.cliente = cliente;
        this.carrosQuant = carrosQuant;
        this.valorTotal = valorTotal;
    }
    public String getData() {
        return data;
    }
    public void setData(String data) {
        this.data = data;
    }
    public String getCarro() {
        return carro;
    }
    public void setCarro(String carro) {
        this.carro = carro;
    }
    public String getCliente() {
        return cliente;
    }
    public void setCliente(String cliente) {
        this.cliente = cliente;
    }
    public String getCarrosQuant() {
        return carrosQuant;
    }
    public void setCarrosQuant(String carrosQuant) {
        this.carrosQuant = carrosQuant;
    }
    public String getValorTotal() {
        return valorTotal;
    }
    public void setValorTotal(String valorTotal) {
        this.valorTotal = valorTotal;
    }
    
}
