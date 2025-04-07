
package classes;


public class Servicos {
    private int idServico;
  private String nome_servico, descricao_servico;
    Double preco_servico;

    /**
     * @return the nome_servico
     */
    public String getNome_servico() {
        return nome_servico;
    }

    /**
     * @param nome_servico the nome_servico to set
     */
    public void setNome_servico(String nome_servico) {
        this.nome_servico = nome_servico;
    }

    /**
     * @return the descricao_servico
     */
    public String getDescricao_servico() {
        return descricao_servico;
    }

    /**
     * @param descricao_servico the descricao_servico to set
     */
    public void setDescricao_servico(String descricao_servico) {
        this.descricao_servico = descricao_servico;
    }

    /**
     * @return the preco_servico
     */
    public Double getPreco_servico() {
        return preco_servico;
    }

    /**
     * @param preco_servico the preco_servico to set
     */
    public void setPreco_servico(Double preco_servico) {
        this.preco_servico = preco_servico;
    }

    
    public int getIdServico() {
        return idServico;
    }

    /**
     * @param idServico the idServico to set
     */
    public void setIdServico(int idServico) {
        this.idServico = idServico;
    }
}
