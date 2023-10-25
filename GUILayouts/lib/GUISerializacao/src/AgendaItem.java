import java.io.Serializable;

public class AgendaItem implements Serializable{
  //atributos 
 String dia; 
  String hora; 
 String usuario; 
 String descricao; 
 //metodos
public AgendaItem(String dia, String hora, String usuario, String descricao) {
    this.dia = dia;
    this.hora = hora;
    this.usuario = usuario;
    this.descricao = descricao;
}
public AgendaItem(String dia2, String hora2, String descricao2) {
}
public String getDia() {
    return dia;
}
public void setDia(String dia) {
    this.dia = dia;
}
public String getHora() {
    return hora;
}
public void setHora(String hora) {
    this.hora = hora;
}
public String getUsuario() {
    return usuario;
}
public void setUsuario(String usuario) {
    this.usuario = usuario;
}
public String getDescricao() {
    return descricao;
}
public void setDescricao(String descricao) {
    this.descricao = descricao;
}

 
}