package model;

import repository.ClienteRepository;
import repository.GarcomRepository;
import repository.PratoRepository;
import repository.PedidoRepository;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static ClienteRepository clienteRepo = new ClienteRepository();
    private static GarcomRepository garcomRepo = new GarcomRepository();
    private static PratoRepository pratoRepo = new PratoRepository();
    private static PedidoRepository pedidoRepo = new PedidoRepository();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;

        do {
            System.out.println("Menu:");
            System.out.println("1. Adicionar Cliente");
            System.out.println("2. Listar Clientes");
            System.out.println("3. Adicionar Garçom");
            System.out.println("4. Listar Garçons");
            System.out.println("5. Adicionar Prato");
            System.out.println("6. Listar Pratos");
            System.out.println("7. Realizar Pedido");
            System.out.println("8. Listar Pedidos");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    adicionarCliente();
                    break;
                case 2:
                    listarClientes();
                    break;
                case 3:
                    adicionarGarcom();
                    break;
                case 4:
                    listarGarcons();
                    break;
                case 5:
                    adicionarPrato();
                    break;
                case 6:
                    listarPratos();
                    break;
                case 7:
                    realizarPedido();
                    break;
                case 8:
                    listarPedidos();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }

    private static void adicionarCliente() {
        System.out.print("Nome do Cliente: ");
        String nome = scanner.nextLine();
        System.out.print("CPF do Cliente: ");
        String cpf = scanner.nextLine();
        System.out.print("Telefone do Cliente: ");
        String telefone = scanner.nextLine();
        System.out.print("Email do Cliente: ");
        String email = scanner.nextLine();
        System.out.print("Endereço do Cliente: ");
        String endereco = scanner.nextLine();

        Cliente cliente = new Cliente(nome, cpf, telefone, email, endereco);
        clienteRepo.adicionar(cliente);
        System.out.println("Cliente adicionado com sucesso!");
    }

    private static void listarClientes() {
        List<Cliente> clientes = clienteRepo.listar();
        System.out.println("Clientes cadastrados:");

        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
            return;
        }

        for (int i = 0; i < clientes.size(); i++) {
            System.out.println((i + 1) + ". " + clientes.get(i).getNome());
        }

        System.out.print("Escolha um número para ver os detalhes do cliente (ou 0 para voltar): ");
        int escolha = scanner.nextInt();
        scanner.nextLine();

        if (escolha > 0 && escolha <= clientes.size()) {
            Cliente clienteSelecionado = clientes.get(escolha - 1);
            System.out.println("Detalhes do Cliente:");
            System.out.println("Nome: " + clienteSelecionado.getNome());
            System.out.println("CPF: " + clienteSelecionado.getCpf());
            System.out.println("Telefone: " + clienteSelecionado.getTelefone());
            System.out.println("Email: " + clienteSelecionado.getEmail());
            System.out.println("Endereço: " + clienteSelecionado.getEndereco());
        } else if (escolha == 0) {
            System.out.println("Voltando ao menu...");
        } else {
            System.out.println("Escolha inválida.");
        }
    }

    private static void adicionarGarcom() {
        System.out.print("Digite o nome do garçom: ");
        String nome = scanner.nextLine();

        System.out.print("Digite o código do garçom: ");
        String codigo = scanner.nextLine();

        System.out.print("Digite o telefone do garçom: ");
        String telefone = scanner.nextLine();

        System.out.print("Digite o email do garçom: ");
        String email = scanner.nextLine();

        Garcom novoGarcom = new Garcom(nome, codigo, telefone, email);
        garcomRepo.adicionar(novoGarcom);
        System.out.println("Garçom adicionado com sucesso!");
    }

    private static void listarGarcons() {
        List<Garcom> garcons = garcomRepo.listar();
        System.out.println("Garçons cadastrados:");

        if (garcons.isEmpty()) {
            System.out.println("Nenhum garçom cadastrado.");
            return;
        }

        for (int i = 0; i < garcons.size(); i++) {
            System.out.println((i + 1) + ". " + garcons.get(i).getNome());
        }

        System.out.print("Escolha um número para ver os detalhes do garçom (ou 0 para voltar): ");
        int escolha = scanner.nextInt();
        scanner.nextLine();

        if (escolha > 0 && escolha <= garcons.size()) {
            Garcom garcomSelecionado = garcons.get(escolha - 1);
            System.out.println("Detalhes do Garçom:");
            System.out.println("Nome: " + garcomSelecionado.getNome());
            System.out.println("ID: " + garcomSelecionado.getCodigo());
            System.out.println("Telefone: " + garcomSelecionado.getTelefone());
            System.out.println("Email: " + garcomSelecionado.getEmail());
        } else if (escolha == 0) {
            System.out.println("Voltando ao menu...");
        } else {
            System.out.println("Escolha inválida.");
        }
    }

    private static void adicionarPrato() {
        System.out.print("Nome do Prato: ");
        String nome = scanner.nextLine();
        System.out.print("Descrição do Prato: ");
        String descricao = scanner.nextLine();
        System.out.print("Preço do Prato: ");
        
        double preco;
        while (true) {
            try {
                preco = scanner.nextDouble();
                scanner.nextLine();
                break;
            } catch (Exception e) {
                System.out.println("Por favor, insira um valor numérico válido para o preço");
                scanner.nextLine();
            }
        }

        Prato prato = new Prato(nome, descricao, preco);
        pratoRepo.adicionar(prato);
        System.out.println("Prato adicionado com sucesso!");
    }

    private static void listarPratos() {
        List<Prato> pratos = pratoRepo.listar();
        System.out.println("Pratos cadastrados:");

        if (pratos.isEmpty()) {
            System.out.println("Nenhum prato cadastrado.");
            return;
        }

        for (int i = 0; i < pratos.size(); i++) {
            System.out.println((i + 1) + ". " + pratos.get(i).getNome());
        }

        System.out.print("Escolha um número para ver os detalhes do prato (ou 0 para voltar): ");
        int escolha = scanner.nextInt();
        scanner.nextLine();

        if (escolha > 0 && escolha <= pratos.size()) {
            Prato pratoSelecionado = pratos.get(escolha - 1);
            System.out.println("Detalhes do Prato:");
            System.out.println("Nome: " + pratoSelecionado.getNome());
            System.out.println("Preço: " + pratoSelecionado.getPreco());
            System.out.println("Descrição: " + pratoSelecionado.getDescricao());
        } else if (escolha == 0) {
            System.out.println("Voltando ao menu...");
        } else {
            System.out.println("Escolha inválida.");
        }
    }

    private static void realizarPedido() {
        System.out.print("Digite o código do garçom: ");
        String codigoGarcom = scanner.nextLine();

        Garcom garcom = garcomRepo.buscarPorCodigo(codigoGarcom);
        if (garcom == null) {
            System.out.println("Garçom não encontrado.");
            return;
        }

        System.out.print("Digite o CPF do cliente: ");
        String cpfCliente = scanner.nextLine();
        Cliente cliente = clienteRepo.buscarPorCpf(cpfCliente);
        if (cliente == null) {
            System.out.println("Cliente não encontrado.");
            return;
        }

        System.out.println("Pratos disponíveis:");
        listarPratos();

        System.out.print("Digite o nome do Prato que deseja pedir: ");
        String nomePrato = scanner.nextLine();
        Prato prato = pratoRepo.buscarPorNome(nomePrato);
        
        if (prato == null) {
            System.out.println("Prato não encontrado.");
            return;
        }

        Date dataPedido = new Date();
        Pedido pedido = new Pedido(cliente, garcom, prato, dataPedido);
        pedidoRepo.adicionar(pedido);
        System.out.println("Pedido realizado com sucesso!");
    }

    private static void listarPedidos() {
        List<Pedido> pedidos = pedidoRepo.listar();
        System.out.println("Pedidos realizados:");
        
        if (pedidos.isEmpty()) {
            System.out.println("Nenhum pedido realizado.");
            return;
        }

        for (Pedido pedido : pedidos) {
            System.out.println("Pedido: " + pedido);
            System.out.println("Cliente: " + pedido.getCliente().getNome());
            System.out.println("Garçom: " + pedido.getGarcom().getNome());
            System.out.println("Prato: " + pedido.getPrato().getNome());
            System.out.println("Data: " + pedido.getData());
            System.out.println("-------------------------");
        }
    }
}