/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

/**
 *
 * @author geral
 */
public class Cliente extends Pessoa {
    private String endereco;
    private String telefone;
    private int idade;
    private int idCliente;
    

    public int getidade(){
        return idade;
    }

    public int getidcliente() {
        return idCliente;
    }

    public String getendereco() {
        return endereco;
    }

    public void setendereco(String endereco) {
        this.endereco = endereco;
    }

    public String gettelefone() {
        return telefone;
    }

    public void settelefone(String telefone) {
        this.telefone = telefone;
    } 
    public void setidade(int idade){
        this.idade= idade ;
    }
    public void setidcliente(int idcliente) {
        this.idCliente=idcliente;
    }


}
