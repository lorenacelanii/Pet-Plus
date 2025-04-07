
package classes;




public class Funcionario extends Pessoa {
    private int idFuncionario;
    private String login;
    private String senha;
    private int acessoSuperior;
    private byte [] fotoFuncionario;

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }
    
    
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getAcessoSuperior() {
        return acessoSuperior;
    }

    public void setAcessoSuperior(int acessoSuperior) {
        this.acessoSuperior = acessoSuperior;
    }
    
    public byte[] getFotoFuncionario() {
        return fotoFuncionario;
    }

    public void setFotoFuncionario(byte[] fotoFuncionario) {
        this.fotoFuncionario = fotoFuncionario;
    }
    
    
    
}
