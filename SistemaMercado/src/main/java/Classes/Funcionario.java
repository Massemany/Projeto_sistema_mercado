/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Classes;

/**
 *
 * @author Marcela
 */
public class Funcionario extends Pessoa{
    private int senha;
    private float vendido;
    private float Quantvenda;
    private int produtoVenda;


    public int getProdutoVenda() {
        return produtoVenda;
    }

    public void setProdutoVenda(int produtoVenda) {
        this.produtoVenda = produtoVenda;
    }

    public float getQuantvenda() {
        return Quantvenda;
    }

    public void setQuantvenda(float Quantvenda) {
        this.Quantvenda = Quantvenda;
    }

    public float getVendido() {
        return vendido;
    }

    public void setVendido(float vendido) {
        this.vendido = vendido;
    }
    
    
    
    public void registrar (int cpf,String nome,int telefone,int senha){
       
        this.senha = senha;
        this.cpf = cpf;
        this.nome = nome;
        this.telefone = telefone;
    }

    public int getSenha() {
        return senha;
    }

    public void setSenha(int senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Funcionario{" + ", senha=" + senha + ", vendido=" + vendido + '}';
    }
}
