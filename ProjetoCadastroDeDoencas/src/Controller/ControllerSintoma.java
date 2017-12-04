package Controller;

import DAO.DAOSintoma;
import DAO.DAOSintomaBridge;
import Model.Sintoma;

public class ControllerSintoma {
    private DAOSintomaBridge daoSintoma;

    public ControllerSintoma(){
        daoSintoma = DAOSintomaFactory.getInstance();
    }

    public void inserirSintoma(Sintoma sintoma){
        this.daoSintoma.inserir(sintoma);
    }

    public Sintoma consultarSintoma(String sintoma){
        return this.daoSintoma.consultar(sintoma);
    }

    public void removerSintoma(Sintoma sintoma){
        this.daoSintoma.remover(sintoma);
    }

    public void listarSintomas(){
        this.daoSintoma.listar();
    }

    public void alterarSintoma(Sintoma antigo, Sintoma novo){
        this.daoSintoma.alterar(antigo, novo);
    }
    public boolean isSintomasExists(){
        if(daoSintoma.check()){
            return true;
        }
        else{
            return false;
        }
    }
}
