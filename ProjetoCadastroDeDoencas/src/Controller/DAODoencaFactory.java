package Controller;

import DAO.DAODoenca;

public class DAODoencaFactory {

    public static DAODoenca getInstance(){
        TipoDAODoenca tdd = TipoDAODoenca.DAODoencaMemoria;

        if(tdd == TipoDAODoenca.DAODoencaMemoria){
            return new DAODoenca();

        }
        else if(tdd == TipoDAODoenca.DAODoencaBD){
            throw new UnsupportedOperationException();
        }
        return null;
    }




    public enum TipoDAODoenca{
        DAODoencaMemoria,
        DAODoencaBD
    }
}
