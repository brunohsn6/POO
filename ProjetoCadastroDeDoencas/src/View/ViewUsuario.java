package View;

import Controller.ControllerSintoma;
import Controller.ControllerUsuario;
import Model.Sintoma;
import Model.Usuario;

import java.util.ArrayList;
import java.util.Scanner;

public class ViewUsuario {

    public void menuUsuario(){
        int opcao;
        Scanner entrada = new Scanner(System.in);
        atualizarPrognosticos();
        do{
            System.out.println("1- Cadastrar Usuario\n2- Consultar Usuario\n3- Remover Usuario\n4- Alterar Usuario\n5- Listar usuários\n0- Voltar\nDigite a opção: ");
            opcao = entrada.nextInt();
            switch(opcao){
                case 1:
                    this.inserirUsuario();
                    break;
                case 2:
                    this.consultarUsuario();
                    break;
                case 3:
                    this.removerUsuario();
                    break;
                case 4:
                    this.alterarUsuario();
                    break;
                case 5:
                    this.listarUsuarios();
                default:
                    break;
            }
        }while(opcao != 0);

    }

    private void atualizarPrognosticos() {
        ControllerUsuario controller = new ControllerUsuario();
        controller.atualizarDados();
    }

    private void listarUsuarios() {
        ControllerUsuario controller = new ControllerUsuario();
        controller.listar();
    }

    private void inserirUsuario(){
        Scanner scanner = new Scanner(System.in);
        Scanner scanCompleto = new Scanner(System.in);
        Usuario usuario;
        ControllerUsuario  controller = new ControllerUsuario();


        System.out.println("Nome: ");
        String nome = scanner.nextLine();
        System.out.println("Idade: ");
        int idade = scanner.nextInt();
        System.out.println("Endereço: ");
        String endereco = scanCompleto.nextLine();
        ArrayList<Sintoma> sintomas = cadastrarSintomas();
        if(sintomas != null){
            usuario = new Usuario(nome, idade, endereco);
            usuario.setSintomas(sintomas);
            usuario.defineDoenca();
            controller.inserirUsuario(usuario);
            System.out.println("Usuario cadastrado com sucesso!");
        }
        else{
            System.out.println("Não há sintomas cadastrados!");
        }


    }

    private void consultarUsuario(){
        Scanner scanner = new Scanner(System.in);
        ControllerUsuario  controller = new ControllerUsuario();
        String nome;

        System.out.println("Digite o nome do usuario que deseja procurar: ");
        nome = scanner.nextLine();
        Usuario usu = controller.consultarUsuario(nome);

        if(usu != null){
            System.out.println("Nome:  "+ usu.getNome());
            System.out.println("Idade: "+usu.getIdade());
            System.out.println("Endereço: "+ usu.getEndereco());
            System.out.println("Prognostico: " +usu.getNomeDoenca());
        }
        else{
            System.out.println("Este usuario não está cadastrado!");
        }

    }

    private void removerUsuario(){
        Scanner scanner = new Scanner(System.in);
        ControllerUsuario  controller = new ControllerUsuario();
        String nome;

        System.out.println("Digite o nome do usuario que deseja remover: ");
        nome = scanner.nextLine();
        Usuario usu = controller.consultarUsuario(nome);
        if(usu!=null){
            controller.removerUsuario(usu);
            System.out.println("Usuário removido com sucesso!");
        }
        else{
            System.out.println("Este usuário não está cadastrado!");
        }
    }

    private void alterarUsuario(){
        Scanner leitor = new Scanner(System.in);
        Scanner scanCompleto = new Scanner(System.in);
        String nome;
        ControllerUsuario controller = new ControllerUsuario();
        int op;
        Usuario usu, novoUsuario;

        System.out.println("Digite o nome do usuario que você deseja alterar: ");
        nome = scanCompleto.nextLine();
        usu = controller.consultarUsuario(nome);
        novoUsuario = usu;
        if(usu!=null){
            do{
                System.out.println("1- Nome\n2- Idade\n3- Edereço\n4- sintomas\n0- Sair\nDeseja alterar:");
                op = leitor.nextInt();

                switch(op){
                    case 1:
                        System.out.println("Digite o novo nome: ");
                        novoUsuario.setNome(scanCompleto.nextLine());
                        break;
                    case 2:
                        System.out.println("Digite a nova idade: ");
                        novoUsuario.setIdade(leitor.nextInt());
                        break;
                    case 3:
                        System.out.println("Digite o novo endereço: ");
                        novoUsuario.setEndereco(scanCompleto.nextLine());
                        break;
                    case 4:
                        ArrayList<Sintoma> sintomas = cadastrarSintomas();
                        if(sintomas == null){
                            System.out.println("Não há sintomas cadastrados!");
                        }
                        else{
                            novoUsuario.setSintomas(sintomas);
                        }

                        break;
                    case 0:
                        break;
                }
            }while(op != 0);
            controller.alterarUsuario(usu, novoUsuario);
            System.out.println("Cadastro alterado com sucesso!");
        }
        else{
            System.out.println("Este usuário não está cadastrado!");
        }
    }

    private ArrayList<Sintoma> cadastrarSintomas() {
        ControllerSintoma controller = new ControllerSintoma();
        ArrayList<Sintoma> sintomas = new ArrayList<>();
        int op;
        if (controller.isSintomasExists()) {
            do {
                Scanner leitor = new Scanner(System.in);
                Scanner scanCompleto = new Scanner(System.in);
                controller.listarSintomas();
                System.out.println("Digite o seu sintoma baseado na lista de sintomas: ");
                String nome = scanCompleto.nextLine();

                Sintoma sin = controller.consultarSintoma(nome);

                if (sin != null) {
                    if (!isSintomaCadastrado(sin, sintomas)) {
                        sintomas.add(sin);
                    } else {
                        System.out.println("Você já cadastrou esse sintoma!");
                    }

                } else {
                    System.out.println("Sintoma inexistente!");
                }
                do {
                    System.out.println("Deseja adicionar outro sintoma?(1-sim/0-não) ");
                    op = leitor.nextInt();
                }while(op != 0 && op != 1);

            } while (op != 0);

            return sintomas;
        } else {
            return null;
        }
    }


    private boolean isSintomaCadastrado(Sintoma sin, ArrayList<Sintoma> sintomas) {
        for(Sintoma s : sintomas){
            if(sin.getSintoma().equalsIgnoreCase(s.getSintoma())) {
                return true;
            }
        }
        return false;

    }
}
