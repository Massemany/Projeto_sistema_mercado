/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Classes;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Marcela
 */
public class Mercado {
    private List<Funcionario> funcionarios;
    private List<Cliente> clientes;
    private List<Produto> produtos;
    private float totArreacado = 0;
    private float totVendas,totVendasCliente;
    private int totVendaPorCliente,totVendaClientePorCliente;
    
    public Mercado() {
        this.funcionarios = new ArrayList<>();
        this.clientes = new ArrayList<>();
        this.produtos = new ArrayList<>();
    }

    public int getTotVendaPorCliente() {
        return totVendaPorCliente;
    }

    public void setTotVendaPorCliente(int totVendaPorCliente) {
        this.totVendaPorCliente = totVendaPorCliente;
    }

    public int getTotVendaClientePorCliente() {
        return totVendaClientePorCliente;
    }

    public void setTotVendaClientePorCliente(int totVendaClientePorCliente) {
        this.totVendaClientePorCliente = totVendaClientePorCliente;
    }

    public float getTotArreacado() {
        return totArreacado;
    }

    public void setTotArreacado(float totArreacado) {
        this.totArreacado = totArreacado;
    }

    public float getTotVendas() {
        return totVendas;
    }

    public void setTotVendas(float totVendas) {
        this.totVendas = totVendas;
    }

    public float getTotVendasCliente() {
        return totVendasCliente;
    }

    public void setTotVendasCliente(float totVendasCliente) {
        this.totVendasCliente = totVendasCliente;
    }

 

    public void cadastrarFuncionario(Funcionario funcionario) {
        funcionarios.add(funcionario);
    }

    public void removerFuncionario(Funcionario funcionario) {
        funcionarios.remove(funcionario);
    }

    public void cadastrarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public void removerCliente(Cliente cliente) {
        clientes.remove(cliente);
    }

    public void cadastrarProduto(Produto produto) {
        produtos.add(produto);
    }

    public void removerProduto(Produto produto) {
        produtos.remove(produto);
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public static boolean verificar(Cliente cliente, Mercado mercado) {
        for (Cliente clientefor : mercado.getClientes()) {
            if (cliente.getCpf() == clientefor.getCpf()  ) {
                return true;
            }
        }
        for (Funcionario funcionariofor : mercado.getFuncionarios()) {
            if (cliente.getCpf()==funcionariofor.getCpf()  ) {
                return true;
            }
        }
        return false;
    }

    public static boolean verificar(Funcionario funcionario, Mercado mercado) {
        for (Funcionario funcionariofor : mercado.getFuncionarios()) {
            if (funcionario.getCpf()==funcionariofor.getCpf()) {
                return true;
            }
        }
        for (Cliente clientefor : mercado.getClientes()) {
            if (funcionario.getCpf()==clientefor.getCpf()  ) {
                return true;
            }
        }
        return false;
    }

    public static boolean verificar(Produto produto, Mercado mercado) {
        for (Produto produtofor : mercado.getProdutos()) {
            if (produto.getCodigo() == produtofor.getCodigo() ) {
                return true;
            }
        }
        return false;
    }

    public static Cliente consultarCliente(int cpf, Mercado mercado) {
        for (int i = 0; i < mercado.getClientes().size(); i++) {
            Cliente cliente = mercado.getClientes().get(i);
            if (cliente.getCpf() == cpf) {
                return cliente;
            }
        }
        return null;

    }
    
     public static Funcionario consultarFuncionario(int cpf, Mercado mercado) {
        for (int i = 0; i < mercado.getFuncionarios().size(); i++) {
            Funcionario funcionario = mercado.getFuncionarios().get(i);
            if (funcionario.getCpf()==cpf) {
                return funcionario;
            }
        }
        return null;

    }
     
     public static boolean confirmacaoFuncionario(Funcionario funcionario, Mercado mercado){
          for (Funcionario funcionariofor : mercado.getFuncionarios()) {
            if (funcionario.getCpf() == funcionariofor.getCpf() && funcionario.getSenha()==funcionariofor.getSenha()) {
                return true;
            }
        }
          return false;
     }
     
     public static Produto consultarProduto(int codigo, Mercado mercado) {
        for (int i = 0; i < mercado.getProdutos().size(); i++) {
            Produto produto = mercado.getProdutos().get(i);
            if (produto.getCodigo() ==codigo ) {
                return produto;
            }
        }
        return null;

    }
    
    

    public static void alterarCliente(int cpf, Mercado mercado, Cliente alteracao) {
        for (int i = 0; i < mercado.getClientes().size(); i++) {
            if (mercado.getClientes().get(i).getCpf() == cpf ) {
                mercado.getClientes().set(i, alteracao);
                break;
            }
        }
    }
      public static void alterarFuncionario(int cpf, Mercado mercado, Funcionario alteracao) {
        for (int i = 0; i < mercado.getFuncionarios().size(); i++) {
            if (mercado.getFuncionarios().get(i).getCpf() ==cpf) {
                mercado.getFuncionarios().set(i, alteracao);
                break;
            }
        }
    }
      
        public static void alterarProduto(int codigo, Mercado mercado, Produto alteracao) {
        for (int i = 0; i < mercado.getProdutos().size(); i++) {
            if (mercado.getProdutos().get(i).getCodigo() ==codigo) {
                mercado.getProdutos().set(i, alteracao);
                break;
            }
        }
    }
    
    public static void removerCliente(int cpf,Mercado mercado){
        for (int i = 0; i < mercado.getClientes().size(); i++) {
            if (mercado.getClientes().get(i).getCpf() ==cpf) {
                mercado.getClientes().remove(i);
                break;
            }
        }
    }
    
    public static void removerFuncionario(int cpf,Mercado mercado){
        for (int i = 0; i < mercado.getFuncionarios().size(); i++) {
            if (mercado.getFuncionarios().get(i).getCpf() ==cpf) {
                mercado.getFuncionarios().remove(i);
                break;
            }
        }
    }
    public static void removerProduto(int codigo,Mercado mercado){
        for (int i = 0; i < mercado.getProdutos().size(); i++) {
            if (mercado.getProdutos().get(i).getCodigo()==codigo) {
                mercado.getProdutos().remove(i);
                break;
            }
        }
    }
    
    public static String maiorProdutoVendido(Mercado mercado){
        Produto maior = null;
        float maiorVendido =0;
        for(Produto produto : mercado.getProdutos()){
            if(produto.getQuantidadevendida() > maiorVendido){
                maiorVendido = produto.getQuantidadevendida();
                maior = produto;
            }
        }
        if(maior!=null){
        return maior.getNome();
        }else{
            return "Nenhum";
        }
    }
    
    public static String maiorVendaFuncionario(Mercado mercado){
        Funcionario maior = null;
        float maiorVendido = 0;
        for(Funcionario funcionario : mercado.getFuncionarios()){
            if(funcionario.getVendido() > maiorVendido){
                maiorVendido = funcionario.getVendido();
                maior = funcionario;
            }
        }
        if(maior!=null){
        return maior.getNome();
        }else{
            return "Nenhum";
        }
    }

}
