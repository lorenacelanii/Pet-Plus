/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

import java.time.LocalDate;

/**
 *
 * @author geral
 */
public class Pessoa {
    private String nome;
    private String cpf;
    private int anoNascimento;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getAnoNascimento() {
        return anoNascimento;
    }

    public void setAnoNascimento(int anoNascimento) {
        this.anoNascimento = anoNascimento;
    }
    
   
    
    public static boolean VerificarIdade(int anoNascimento) {
        int anoAtual = LocalDate.now().getYear();
        
        int idade = anoAtual - anoNascimento;
        
        return (idade >= 18 && idade<=120);
    }
    
    public static int [] TratarCPF(String cpf){
        
        String[] lista;
        int[] numeros = new int[11];
        
        String cpfT = cpf.replaceAll("\\.", "");
        cpfT = cpfT.replaceAll("-", "");
        lista = cpfT.split("(?!^)");

        for (int i = 0; i < lista.length; i++) {
            try {
                numeros[i]= Integer.parseInt(lista[i]);
            } catch (Exception e) {
            }     
        }
        return numeros;
    }
    
    public static boolean ValidarCPF(String cpf){
         int[]numeros = TratarCPF(cpf);
         int soma = 0;
         int soma1 = 0;
         
         
         
        if(    cpf.equals("111.111.111-11")
            || cpf.equals("222.222.222-22")
            || cpf.equals("333.333.333-33")
            || cpf.equals("444.444.444-44")
            || cpf.equals("555.555.555-55")
            || cpf.equals("666.666.666-66")
            || cpf.equals("777.777.777-77")
            || cpf.equals("888.888.888-88")
            || cpf.equals("999.999.999-99")
            || cpf.length()!=14
                ){
             return false;
        }
        else{
                
            for (int i = 0; i < 9; i++) {
                    soma += numeros[i]*(10-i);
            }
            int primeiroDigito =(soma*10)%11;

            for (int i = 0; i < 10; i++) {
                   soma1 += numeros[i]*(11-i);
            }

            int segundoDigito= soma1*10%11;

            if((primeiroDigito == numeros[9]) && (segundoDigito == numeros[10])){        
                return true;
    
            }   

        }
    return false;
    }
}

