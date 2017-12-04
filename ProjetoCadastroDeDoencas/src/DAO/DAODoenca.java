package DAO;

import Model.Doenca;
import Model.Sintoma;

import java.util.ArrayList;

public class DAODoenca extends Observado implements DAODoencaBridge {
    private static ArrayList<Doenca> listaDeDoencas = new ArrayList<>();

    @Override
    public void inserir(Doenca doenca) {
        listaDeDoencas.add(doenca);
        notificar(true);
    }

    @Override
    public Doenca consultar(String nome) {
        for(Doenca doe : listaDeDoencas){
            if(doe.getNome().equalsIgnoreCase(nome)){
                return doe;
            }
        }
        return null;
    }

    @Override
    public void remover(Doenca doenca) {
        for(Doenca doe: listaDeDoencas){
            if(doe.equals(doenca)){
                listaDeDoencas.remove(doe);
                break;
            }
        }
        notificar(true);
    }

    @Override
    public void alterar(Doenca antigo, Doenca novo, boolean status) {
        this.remover(antigo);
        this.inserir(novo);
        notificar(status);

    }

    @Override
    public void listar() {
        if(!listaDeDoencas.isEmpty()){
            System.out.println("********DOENÇAS********");
            for(Doenca doe : listaDeDoencas){
                System.out.println("Nome: " + doe.getNome());
                System.out.println("Pridade: "+doe.getPrioridade());
                System.out.println("Sintomas:");
                for(Sintoma sint : doe.getSintomas()){
                    System.out.println(sint.getSintoma());
                }
                System.out.println();
            }
            System.out.println();
        }
        else{
            System.out.println("Não há doenças cadastradas!");
        }

    }
    @Override
    public ArrayList<Doenca> getDoencasDAO(){
        return listaDeDoencas;
    }

}