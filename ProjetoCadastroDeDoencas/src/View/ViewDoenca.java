package View;

import Controller.ControllerDoenca;
import Controller.ControllerSintoma;
import Model.Doenca;
import Model.Sintoma;

import java.util.ArrayList;
import java.util.Scanner;

public class ViewDoenca {

    public void menuDoenca(){
        Scanner leitor = new Scanner(System.in);
        int op;

        do{
            System.out.println("1- Cadastrar Doença\n2- Consultar Doença\n3- Remover Doença\n4- Alterar Doença\n5- Listar Doenças\n0- Voltar\nDigite a opção: ");
            op = leitor.nextInt();

            switch(op){
                case 1:
                    this.inserirDoenca();
                    break;
                case 2:
                    this.consultarDoenca();
                    break;
                case 3:
                    this.removerDoenca();
                    break;

                case 4:
                    this.alterarDoenca();
                    break;
                case 5:
                    this.listarDoenca();
                    break;
                default:
                    break;
            }
        }while(op!=0);
    }

    private void inserirDoenca(){
        Scanner leitor = new Scanner(System.in);
        ControllerDoenca controller = new ControllerDoenca();
        System.out.println("Nome da doença: ");
        String nome = leitor.next();
        System.out.println("Prioridade da doença: ");
        int p = leitor.nextInt();
        ArrayList<Sintoma> listaDeSintomas;

        listaDeSintomas = this.cadastrarSintomas();
        if(!listaDeSintomas.isEmpty()) {
            Doenca doenca = new Doenca(nome, p, listaDeSintomas);
            controller.inserirDoenca(doenca);
            System.out.println("Doença cadastrada com sucesso!");
        }
        else if(listaDeSintomas == null) {
            System.out.println("Não há sintomas cadastrados!");

        }else{
            System.out.println("Uma doença não pode ser cadastrada sem sintomas");
        }

    }

    private ArrayList<Sintoma> cadastrarSintomas() {
        ArrayList<Sintoma> sintomas = new ArrayList<>();
        ControllerSintoma controller = new ControllerSintoma();
        Sintoma sint;
        int op;
        if (controller.isSintomasExists()) {
            do {
                Scanner leitor = new Scanner(System.in);
                Scanner scanCompleto = new Scanner(System.in);
                controller.listarSintomas();
                System.out.println("Digite um sintoma baseado na lista acima: ");
                String nome = scanCompleto.nextLine();

                sint = controller.consultarSintoma(nome);

                if (sint != null) {
                    if (!isSintomaCadastrado(sint, sintomas)) {
                        sintomas.add(sint);
                    } else {
                        System.out.println("Você já cadastrou esse sintoma!");
                    }

                } else {
                    System.out.println("Sintoma não cadastrado!");
                }
                do {
                    System.out.println("Deseja cadastrar mais um sintoma?(1-sim 0-não) ");
                    op = leitor.nextInt();
                } while (op != 1 && op != 0);


            } while (op != 0);

            return sintomas;
        } else {
            return null;
        }
    }

    private void consultarDoenca(){
        Scanner leitor = new Scanner(System.in);
        ControllerDoenca controller = new ControllerDoenca();
        String nome;
        Doenca doenca;

        System.out.println("Digite o nome da doença que deseja buscar: ");
        nome = leitor.next();

        doenca = controller.consultarDoenca(nome);

        if(doenca != null){
            System.out.println("Nome: "+ doenca.getNome());
            System.out.println("Prioridade: " +doenca.getPrioridade());
            System.out.println("Sintomas: ");
            for(Sintoma sint : doenca.getSintomas()){
                System.out.print(" "+ sint.getSintoma());
                System.out.println();
            }
        }
        else{
            System.out.println("Doença inexistente!");
        }
    }

    private void removerDoenca(){
        ControllerDoenca controller = new ControllerDoenca();
        Scanner leitor = new Scanner(System.in);
        String nome;

        System.out.println("Digite o nome da doença que deseja remover: ");
        nome = leitor.next();

        Doenca doenca = controller.consultarDoenca(nome);

        if(doenca != null){
            controller.removerDoenca(doenca);
            System.out.println("Doença removida com sucesso!");
        }else{
            System.out.println("A doença não está cadastrada");
        }
    }

    private void alterarDoenca(){
        Scanner leitor = new Scanner(System.in);
        Scanner scanCompleto = new Scanner(System.in);
        ControllerDoenca controller = new ControllerDoenca();
        String nome;
        Doenca antigo, novo;
        int flag = 0;

        System.out.println("Digite o nome da doença que deseja alterar: ");
        nome = scanCompleto.nextLine();

        antigo = controller.consultarDoenca(nome);
        novo = antigo;
        if(antigo != null){
            int op;
            do{
                System.out.println("1- Nome\n2- Prioridade\n3- Sintomas\n0- Sair\nDigite a opção: ");
                op = leitor.nextInt();

                switch(op){
                    case 1:
                        System.out.println("Digite o nodo nome da Doença: ");
                        novo.setNome(scanCompleto.nextLine());
                        flag = 1;
                        break;
                    case 2:
                        System.out.println("Digite a nova prioridade da doença: ");
                        novo.setPrioridade(leitor.nextInt());
                        flag = 1;
                        break;
                    case 3:
                        ArrayList<Sintoma> s;
                        s = this.cadastrarSintomas();
                        if(s!=null){
                            novo.setSintomasDaDoenca(s);
                            System.out.println("Doenca alterada com sucesso!");

                        }else{
                            System.out.println("Não é permitido uma doença sem sintomas");
                        }
                        flag = 1;
                        break;
                    default:
                        break;
                }
            }while(op!=0);
            if(flag == 1) {
                controller.alterarDoenca(antigo, novo, true);
            }

        }
        else{
            System.out.println("Doença inexistente!");
        }
    }

    private void listarDoenca(){
        ControllerDoenca controller = new ControllerDoenca();

        controller.listarDoenca();
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