package View;

import Controller.ControllerSintoma;
import Model.Sintoma;

import java.util.Scanner;

public class ViewSintoma {
    public void menuSintomas(){
        Scanner leitor = new Scanner(System.in);
        int opcao;

        do{
            System.out.println("1- Cadastrar Sintoma\n2- Consultar Sintoma\n3- Remover Sintoma\n4- Alterar Sintoma\n5- Listar\n0- Voltar\nDigite a opção: ");
            opcao = leitor.nextInt();
            switch(opcao){
                case 1:
                    this.inserirSintoma();
                    break;
                case 2:
                    this.consultarSintoma();
                    break;
                case 3:
                    this.removerSintoma();
                    break;
                case 4:
                    this.alterarSintoma();
                    break;
                case 5:
                    this.listarSintomas();
                    break;
                case 0:
                    break;
            }
        }while(opcao !=0);

    }

    private void inserirSintoma(){
        Scanner leitor = new Scanner(System.in);
        ControllerSintoma controller = new ControllerSintoma ();
        String nome;
        Sintoma sintoma;

        System.out.println("Digite o nome do Sintoma: ");
        nome = leitor.nextLine();

        sintoma = controller.consultarSintoma(nome);
        if(sintoma == null){
            sintoma = new Sintoma(nome);
            controller.inserirSintoma(sintoma);
            System.out.println("Sintoma cadastrado com sucesso!");
        }else{
            System.out.println("Sintoma já está cadastrado");
        }
    }

    private void consultarSintoma(){
        Scanner leitor = new Scanner(System.in);
        ControllerSintoma controller = new ControllerSintoma();
        String nome;

        System.out.println("Digite o nome do sintoma que deseja buscar: ");
        nome = leitor.nextLine();

        Sintoma sintoma = controller.consultarSintoma(nome);

        if(sintoma!=null){
            System.out.println("O sintoma está cadastrado!");
        }else{
            System.out.println("O sintoma não está cadastrado!");
        }
    }

    private void alterarSintoma(){
        Scanner leitor = new Scanner(System.in);
        String nome;
        ControllerSintoma controller = new ControllerSintoma();
        Sintoma antigo, novo;
        System.out.println("Digite o sintoma que deseja alterar: ");
        nome = leitor.nextLine();
        antigo = controller.consultarSintoma(nome);
        novo = antigo;
        if(antigo != null){
            System.out.println("Digite o novo sintoma: ");
            nome = leitor.nextLine();
            antigo.setSintoma(nome);
            controller.alterarSintoma(antigo, novo);
            System.out.println("Sintoma alterado com sucesso!");
        }
        else{
            System.out.println("Sintoma inexistente!");
        }

    }

    private void removerSintoma(){
        Scanner leitor = new Scanner(System.in);
        String nome;
        ControllerSintoma controller = new ControllerSintoma();

        System.out.println("Digite o nome do sintoma que deseja remover: ");
        nome = leitor.nextLine();

        Sintoma sintoma = controller.consultarSintoma(nome);

        if(sintoma !=null){
            controller.removerSintoma(sintoma);
            System.out.println("Sintoma removido com sucesso!");
        }else{
            System.out.println("O Sintoma não está cadastrado");
        }
    }

    private void listarSintomas(){
        ControllerSintoma controller = new ControllerSintoma();

        controller.listarSintomas();
    }
}
