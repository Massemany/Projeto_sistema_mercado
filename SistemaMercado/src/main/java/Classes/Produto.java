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
public class Produto {
   private String nome,descricao;
   private int codigo;
   private float valor;
   private float quantidade;
   private float quantidadevendida;

    public float getQuantidadevendida() {
        return quantidadevendida;
    }

    public void setQuantidadevendida(float quantidadevendida) {
        this.quantidadevendida = quantidadevendida;
    }

    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public float getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(float quantidade) {
        this.quantidade = quantidade;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    
    public void registrarProduto(String nome,String descricao,int codigo,float quantidade,float valor){
        this.nome = nome;
        this.descricao = descricao;
        this.codigo = codigo;
        this.quantidade = quantidade;
        this.valor =valor;
    }
}
