package Controller;

import DAO.DAODoenca;
import DAO.DAODoencaBridge;
import Model.Doenca;

import java.util.ArrayList;

public class ControllerDoenca {
	
    private DAODoencaBridge daoDoenca;

    public ControllerDoenca(){
        this.daoDoenca = DAODoencaFactory.getInstance();
    }

    public void inserirDoenca(Doenca doenca){
        daoDoenca.inserir(doenca);
    }

    public void removerDoenca(Doenca doenca){
        daoDoenca.remover(doenca);
    }

    public Doenca consultarDoenca(String nome){
        return daoDoenca.consultar(nome);
    }

    public void listarDoenca(){
        daoDoenca.listar();
    }

    public void alterarDoenca(Doenca antigo, Doenca novo, boolean status){
        daoDoenca.alterar(antigo, novo, status);
    }

    public ArrayList<Doenca> getDoencas(){
        return daoDoenca.getDoencasDAO();
    }
}
