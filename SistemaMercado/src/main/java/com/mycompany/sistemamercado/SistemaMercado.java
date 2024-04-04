/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sistemamercado;
import Classes.Cliente;
import Classes.Funcionario;
import Classes.Mercado;
import Classes.Produto;
import java.util.Scanner;

/**
 *
 * @author Marcela
 */
public class SistemaMercado {

    /**
     * @param args the command line arguments
     */
   public static void main(String[] args) {
        Mercado mercado = new Mercado();

        Scanner scan = new Scanner(System.in);
        
        int escolha = 0;
        do {
            System.out.println("\nM E N U");
            System.out.println("[1] Cliente");
            System.out.println("[2] Funcionário");
            System.out.println("[3] Produtos ");
            System.out.println("[4] Vendas");
            System.out.println("[5] Relatório");
            System.out.println("[6] Finalizar");

            escolha = scan.nextInt();

            if (escolha == 1) {
                System.out.println("\nCLIENTE");
                System.out.println("[1] Cadastrar");
                System.out.println("[2] Consultar dados");
                System.out.println("[3] Alterar ou excluir dados");
                int clienteEscolha = scan.nextInt();

                if (clienteEscolha == 1) {
                    Cliente cliente = new Cliente();
                    System.out.println("Digite o CPF:");
                    cliente.setCpf(scan.nextInt());

                    System.out.println("Digite o telefone:");
                    cliente.setTelefone(scan.nextInt());

                    scan.nextLine();
                    System.out.println("Digite o nome do cliente:");
                    cliente.setNome(scan.nextLine());
                    boolean cpfExistente = Mercado.verificar(cliente, mercado);
                    
                    System.out.println("\nCliente cadastrado com sucesso!\n");
                    if (cpfExistente == false) {
                        mercado.cadastrarCliente(cliente);
                    } else {
                        System.out.println("\nCPF já existente. Não é possível cadastrar o cliente.");
                    }

                } else if (clienteEscolha == 2) {
                    System.out.println("Digite o CPF do cliente que deseja consultar:");
                    Cliente cliente = Mercado.consultarCliente(scan.nextInt(), mercado);

                    if (cliente != null) {
                        System.out.println("\nCPF: " + cliente.getCpf());
                        System.out.println("Nome: " + cliente.getNome());
                        System.out.println("Telefone: " + cliente.getTelefone());
                    } else {
                        System.out.println("\nCPF não encontrado");
                    }

                } else if (clienteEscolha == 3) {
                    System.out.println("[1] Alterar dados");
                    System.out.println("[2] Excluir dados");
                    clienteEscolha = scan.nextInt();

                    if (clienteEscolha == 1) {
                        System.out.println("Digite o CPF que deseja alterar:");
                        int cpf = scan.nextInt();

                        Cliente cliente = Mercado.consultarCliente(cpf, mercado);

                        if (cliente != null) {
                            Cliente alteracao = new Cliente();
                            System.out.println("\nALTERAR");
                            System.out.println("Digite o CPF:");
                            alteracao.setCpf(scan.nextInt());

                            System.out.println("Digite o telefone:");
                            alteracao.setTelefone(scan.nextInt());

                            scan.nextLine();
                            System.out.println("Digite o nome do cliente:");
                            alteracao.setNome(scan.nextLine());

                            if (alteracao.getCpf() == cpf) {
                                Mercado.alterarCliente(cpf, mercado, alteracao);

                            } else {
                                cliente = Mercado.consultarCliente(alteracao.getCpf(), mercado);

                                if (cliente != null) {
                                    System.out.println("\nCPF ja existente.");

                                } else {
                                    Mercado.alterarCliente(cpf, mercado, alteracao);
                                }
                            }

                        } else {
                            System.out.println("\nCPF não encontrado.");
                        }

                    } else if (clienteEscolha == 2) {
                        System.out.println("Digite o CPF que deseja remover:");
                        int cpf = scan.nextInt();
                        Cliente cliente = Mercado.consultarCliente(cpf, mercado);
                        System.out.println("\nCadastro de cliente excluido!\n");
                        if (cliente != null) {
                            Mercado.removerCliente(cpf, mercado);
                        } else {
                            System.out.println("\nCPF não encontrado.");
                        }
                    }
                }
            } else if (escolha == 2) {
                System.out.println("\nFUNCIONARIO");
                System.out.println("[1] Cadastrar");
                System.out.println("[2] Consultar dados");
                System.out.println("[3] Alterar ou excluir dados");
                int funcionarioEscolha = scan.nextInt();

                if (funcionarioEscolha == 1) {
                    Funcionario funcionario = new Funcionario();
                    System.out.println("Digite o CPF:");
                    funcionario.setCpf(scan.nextInt());

                    System.out.println("Digite o telefone:");
                    funcionario.setTelefone(scan.nextInt());

                    scan.nextLine();
                    System.out.println("Digite o nome do funcionario:");
                    funcionario.setNome(scan.nextLine());

                    System.out.println("Digite a senha:");
                    funcionario.setSenha(scan.nextInt());
                    boolean cpfExistente = Mercado.verificar(funcionario, mercado);
                    
                    System.out.println("\nFuncionário cadastrado com sucesso!\n");
                    if (cpfExistente == false) {
                        mercado.cadastrarFuncionario(funcionario);
                    } else {
                        System.out.println("\nCPF já existente. Não é possível cadastrar o Funcionário.");
                    }

                } else if (funcionarioEscolha == 2) {
                    System.out.println("Digite o CPF do funcionário você deseja consultar:");
                    Funcionario funcionario = Mercado.consultarFuncionario(scan.nextInt(), mercado);
                    if (funcionario != null) {
                        System.out.println("\nCPF: " + funcionario.getCpf());
                        System.out.println("Nome: " + funcionario.getNome());
                        System.out.println("Telefone: " + funcionario.getTelefone());
                     
                        System.out.println("Senha: " + funcionario.getSenha());
                    } else {
                        System.out.println("\nCPF não encontrado.");
                    }
                } else if (funcionarioEscolha == 3) {
                    System.out.println("[1] Alterar");
                    System.out.println("[2] Excluir");
                    funcionarioEscolha = scan.nextInt();
                    if (funcionarioEscolha == 1) {
                        System.out.println("Digite o CPF que deseja alterar:");
                        int cpf = scan.nextInt();
                        Funcionario funcionario = Mercado.consultarFuncionario(cpf, mercado);
                        if (funcionario != null) {
                            Funcionario alteracao = new Funcionario();
                            System.out.println("Digite o CPF: ");
                            alteracao.setCpf(scan.nextInt());

                            System.out.println("Digite o telefone: ");
                            alteracao.setTelefone(scan.nextInt());

                            scan.nextLine();
                            System.out.println("Digite o nome: ");
                            alteracao.setNome(scan.nextLine());


                            System.out.println("Determine uma senha:");
                            alteracao.setSenha(scan.nextInt());
                            
                            alteracao.setQuantvenda(funcionario.getQuantvenda());
                            alteracao.setVendido(funcionario.getVendido());

                            if (alteracao.getCpf() == cpf) {
                                Mercado.alterarFuncionario(cpf, mercado, alteracao);

                            } else {
                                funcionario = Mercado.consultarFuncionario(alteracao.getCpf(), mercado);

                                if (funcionario != null) {
                                    System.out.println("\nCPF ja existente.");

                                } else {
                                    Mercado.alterarFuncionario(cpf, mercado, alteracao);
                                }
                            }

                        } else {
                            System.out.println("\nCPF não encontrado.");
                        }

                    } else if (funcionarioEscolha == 2) {
                        System.out.println("Digite o CPF que deseja remover:");
                        scan.nextLine();
                        int cpf = scan.nextInt();
                        Funcionario funcionario = Mercado.consultarFuncionario(cpf, mercado);
                        System.out.println("\nCadastro de funcionário excluído!");
                        if (funcionario != null) {
                            Mercado.removerFuncionario(cpf, mercado);
                        } else {
                            System.out.println("\nCPF não encontrado.");
                        }
                    }
                }
            } else if (escolha == 3) {
                System.out.println("\nPRODUTO");
                System.out.println("[1] cadastrar");
                System.out.println("[2] consultar dados");
                System.out.println("[3] alterar ou excluir dados");
                int produtoEscolha = scan.nextInt();

                if (produtoEscolha == 1) {
                    Produto produto = new Produto();
                    System.out.println("Código:");
                    produto.setCodigo(scan.nextInt());

                    System.out.println("Valor:");
                    produto.setValor(scan.nextInt());

                    System.out.println("Quantidade:");
                    produto.setQuantidade(scan.nextFloat());

                    scan.nextLine();
                    System.out.println("Nome:");
                    produto.setNome(scan.nextLine());

                    System.out.println("Descrição do produto:");
                    produto.setDescricao(scan.nextLine());
                    boolean codigoExistente = Mercado.verificar(produto, mercado);

                    if (codigoExistente == false) {
                        mercado.cadastrarProduto(produto);
                    } else {
                        System.out.println("\nCódigo já cadastrado.");
                    }

                } else if (produtoEscolha == 2) {
                    System.out.println("Digite o código do produto que deseja consultar:");
                    Produto produto = Mercado.consultarProduto(scan.nextInt(), mercado);
                    if (produto != null) {
                        System.out.println("\nNome: " + produto.getNome());
                        System.out.println("Codigo: " + produto.getCodigo());
                        System.out.println("Quantidade: " + produto.getQuantidade());
                        System.out.println("Valor: " + produto.getValor());
                        System.out.println("Descrição: " + produto.getDescricao());
                    } else {
                        System.out.println("\nCódigo não encontrado.");
                    }
                } else if (produtoEscolha == 3) {
                    System.out.println("[1] Alterar");
                    System.out.println("[2] Excluir");
                    produtoEscolha = scan.nextInt();
                    if (produtoEscolha == 1) {
                        System.out.println("Digite o código do produto que deseja alterar:");
                        int codigo = scan.nextInt();
                        Produto produto = Mercado.consultarProduto(codigo, mercado);
                        if (produto != null) {
                            Produto alteracao = new Produto();
                            System.out.println("\nAlterando");
                            System.out.println("Código:");
                            alteracao.setCodigo(scan.nextInt());

                            System.out.println("Valor:");
                            alteracao.setValor(scan.nextInt());

                            System.out.println("Quantidade:");
                            alteracao.setQuantidade(scan.nextFloat());

                            scan.nextLine();
                            System.out.println("Nome:");
                            alteracao.setNome(scan.nextLine());

                            System.out.println("Descrição:");
                            alteracao.setDescricao(scan.nextLine());
                            
                            alteracao.setQuantidadevendida(produto.getQuantidadevendida());

                            if (alteracao.getCodigo() == codigo) {
                                Mercado.alterarProduto(codigo, mercado, alteracao);

                            } else {
                                produto = Mercado.consultarProduto(alteracao.getCodigo(), mercado);

                                if (produto != null) {
                                    System.out.println("\nCódigo ja existente.");

                                } else {
                                    Mercado.alterarProduto(codigo, mercado, alteracao);
                                }
                            }

                        } else {
                            System.out.println("\nCódigo não existente.");
                        }

                    } else if (produtoEscolha == 2) {
                        System.out.println("Digite o código do produto que deseja remover:");
                        int codigo = scan.nextInt();
                        Produto produto = Mercado.consultarProduto(codigo, mercado);
                        System.out.println("Dados do produto excluído!");
                        if (produto != null) {
                            Mercado.removerProduto(codigo, mercado);
                        } else {
                            System.out.println("\nCódigo não existente.");
                        }
                    }
                }
            } else if (escolha == 4) {
                float totValor = 0;
                float totQuant =0;
                Funcionario funcionario = new Funcionario();
                System.out.println("\nLogin");
                System.out.println("CPF do funcionário:");
                funcionario.setCpf(scan.nextInt());
                System.out.println("Senha do funcionário:");
                funcionario.setSenha(scan.nextInt());
                if (Mercado.confirmacaoFuncionario(funcionario, mercado)) {
                    int continuar;
                    do{
                    funcionario = Mercado.consultarFuncionario(funcionario.getCpf(), mercado);
                    System.out.println("--------Vendas------");
                    System.out.println("Operador: " + funcionario.getNome());
                    Produto produtocod = new Produto();
                    produtocod.setCodigo(0);
                    
                    do {
                            if (produtocod.getCodigo() !=-1) {
                                System.out.println("Digite o código do produto ou [-1] para finaliar venda:");
                                produtocod.setCodigo(scan.nextInt());
                            }
                            if (Mercado.verificar(produtocod, mercado)) {
                                Produto produto;
                                produto = Mercado.consultarProduto(produtocod.getCodigo(), mercado);
                                System.out.println("\nNome: " + produto.getNome());
                                System.out.println("Codigo: " + produto.getCodigo());
                                System.out.println("Quantidade: " + produto.getQuantidade());
                                System.out.println("Valor: " + produto.getValor());
                                System.out.println("Descrição do produto: " + produto.getDescricao());
                                System.out.println("\nQuantidade desejada: ");
                                totQuant = scan.nextFloat();
                                if (produto.getQuantidade() >= totQuant && totQuant > 0) {
                                    produto.setQuantidade(produto.getQuantidade() - totQuant);
                                    produto.setQuantidadevendida(totQuant);
                                    Mercado.alterarProduto(produtocod.getCodigo(), mercado, produto);
                                    mercado.setTotVendas((mercado.getTotVendas()+totQuant));
                                } else {
                                    System.out.println("\nQuantidade inválida no estoque.");
                                    totQuant = 0;
                                }
                                if (totQuant > 0) {
                                    totValor += totQuant * produto.getValor();
                                    System.out.println("Valor total: " + totValor);
                                }

                            }else if (produtocod.getCodigo() !=-1) {
                                System.out.println("\nCódigo não encontrado.");
                            }

                    } while (produtocod.getCodigo() != -1);

                    System.out.println("Deseja CPF na nota ? \n[1] sim \n[2] não");
                    int cpfnota = scan.nextInt();
                    if (cpfnota == 1) {
                        int tentativa = 0;
                        do {
                            System.out.println("Digite o CPF:");
                            scan.nextLine();
                            int Cpf = scan.nextInt();
                            if (Mercado.consultarCliente(Cpf, mercado) != null) {
                                System.out.println("\nCPF confirmado.");
                                mercado.setTotVendaClientePorCliente(mercado.getTotVendaClientePorCliente()+1);
                                if (totValor > 200) {
                                    totValor = totValor - (totValor * 5) / 100;
                                } else if (totValor > 100) {
                                    totValor = totValor - (totValor * 3) / 100;
                                } else {
                                    totValor = totValor - (totValor * 2) / 100;
                                }
                                mercado.setTotVendasCliente(mercado.getTotVendasCliente()+totQuant);
                            } else {
                                System.out.println("\nCPF não foi encontrado.");
                                System.out.println("Deseja tentar cadastrar o CPF novamente? \n[1] sim \n[2] não");
                                tentativa = scan.nextInt();

                            }
                        } while (tentativa == 1);

                    }
                    System.out.println("Valor total: " + totValor);
                    mercado.setTotArreacado(mercado.getTotArreacado()+totValor);
                    funcionario.setVendido(funcionario.getVendido()+totValor);
                    funcionario.setQuantvenda(funcionario.getQuantvenda()+1);
                    mercado.setTotVendaPorCliente(mercado.getTotVendaPorCliente()+1);
                    Mercado.alterarFuncionario(funcionario.getCpf(), mercado, funcionario);
                    float valorpago;
                    do {
                        System.out.println("Valor pago:");
                        valorpago = scan.nextFloat();

                        if (valorpago >= totValor) {
                            System.out.println("Valor de retorno (troco): R$" + (valorpago - totValor));
                            System.out.println("\nvenda finalizada com sucesso!");
                        } else {
                            System.out.println("O valor a ser pago não pode ser menor que o valor total da venda!");
                            System.out.println("Valor total: " + totValor);
                        }
                    } while (valorpago < totValor);
                        System.out.println("\nVoltar ao menu? \n[1] sim \n[2] não");
                        continuar = scan.nextInt();
                        totValor = 0;
                    }while(continuar==2);
                }
            }else if (escolha == 5){
                System.out.println("[1] Relatório geral\n[2] Relatório do funcionário:");
                int relatorio = scan.nextInt();
                if(relatorio == 1){
                    if(mercado.getTotVendas() > 0){
                    System.out.println("\nRELATÓRIO GERAL");
                    System.out.println("Total arrecadado: " + mercado.getTotArreacado());
                    System.out.println("Total de produtos vendidos: " + mercado.getTotVendas());
                    System.out.println("Produto mais vendido: " + Mercado.maiorProdutoVendido(mercado));
                    System.out.println("Funcionário que mais arrecadou: " + Mercado.maiorVendaFuncionario(mercado));
                    System.out.println("Total de vendas: " + mercado.getTotVendaPorCliente());
                    System.out.println("Total de vendas com clientes cadastrados: " + mercado.getTotVendaClientePorCliente());
                        System.out.println("");
                    }else{
                        System.out.println("\nNada foi cadastrado ainda.");
                    }
                    
                }else if(relatorio==2){
                    System.out.println("\nRELATÓRIO DO FUNCIONÁRIO");
                    System.out.println("Digite o cpf do funcionário: ");
                    int cpf = scan.nextInt();
                    
                    if(Mercado.consultarFuncionario(cpf, mercado)!= null){
                    Funcionario funcionario = Mercado.consultarFuncionario(cpf, mercado);
                    System.out.println("\nNome: " + funcionario.getNome());
                    System.out.println("Total arrecadado: " + funcionario.getVendido());
                    System.out.println("Quantidade de vendas: " + funcionario.getQuantvenda());
                    System.out.println("Porcentagem de vendas por cliente: " + (funcionario.getQuantvenda()*100/mercado.getTotVendaPorCliente()) + "%");
                    }else{
                        System.out.println("\nCPF não encontrado.");
                    }

                }
            }else if(escolha == 6){
                System.out.println("\nFim");
            }else{
                System.out.println("Opção inválida.");
            }

        } while (escolha != 6);
    }
    
}
