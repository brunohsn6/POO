package DAO;

import Model.Sintoma;

import java.util.ArrayList;

public class DAOSintoma implements DAOSintomaBridge {
    private static ArrayList<Sintoma> listaDeSintoma = new ArrayList<>();

    @Override
    public void inserir(Sintoma sintoma){
        listaDeSintoma.add(sintoma);
    }

    @Override
    public void remover(Sintoma sintoma){
        for(Sintoma sint: listaDeSintoma){
            if(sint.equals(sintoma)){
                listaDeSintoma.remove(sint);
                break;
            }
        }
    }

    @Override
    public Sintoma consultar(String sintoma){
        for(Sintoma sint : listaDeSintoma){
            if(sint.getSintoma().equalsIgnoreCase(sintoma)){
                return sint;
            }
        }
        return null;
    }

    @Override
    public void listar(){
        if(!listaDeSintoma.isEmpty()){
            System.out.println();
            System.out.println("********SINTOMAS********");
            for(Sintoma sint : listaDeSintoma){
                System.out.println(sint.getSintoma());
            }
            System.out.println();
        }
        else{
            System.out.println("Não há sintomas cadastrados!");
        }

    }

    @Override
    public void alterar(Sintoma antigo, Sintoma novo){
        this.remover(antigo);
        this.inserir(novo);
    }
    @Override
    public boolean check(){
        if(listaDeSintoma.isEmpty()){
            return false;
        }
        else{
            return true;
        }
    }
}
