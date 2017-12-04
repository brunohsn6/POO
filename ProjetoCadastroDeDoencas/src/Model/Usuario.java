package Model;

import Controller.ControllerDoenca;
import Controller.DAODoencaFactory;
import DAO.DAODoenca;

import java.util.ArrayList;

public class  Usuario{

    private int idade;
    private String nome;
    private String endereco;
    private ArrayList<Sintoma> sintomas;
    private Doenca doenca;



    public Usuario(String nome,int idade, String endereco) {
        this.idade = idade;
        this.nome = nome;
        this.endereco = endereco;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public ArrayList<Sintoma> getSintomas() {
        return sintomas;
    }

    public void setSintomas(ArrayList<Sintoma> sintomas) {
        this.sintomas = sintomas;
    }


    public Doenca getDoenca() {
        return doenca;
    }
    public String getNomeDoenca(){
        if (doenca == null){
            return "Não foi possivel definir seu prognóstico!";
        }
        else{
            return doenca.getNome();
        }
    }
    public void setDoenca(Doenca doenca) {
        this.doenca = doenca;
    }

    public void defineDoenca() {
        ControllerDoenca d = new ControllerDoenca();
        int cont, contGeral = 0;
        ArrayList<Sintoma> sintomass = getSintomas();
        Doenca auxDoenca = null;
        ArrayList<Doenca> doencas = d.getDoencas();
        for(Doenca doenca: doencas){
            ArrayList<Sintoma> sint = doenca.getSintomas();
            cont = 0;
            for(Sintoma sintoma : sint){
                for(Sintoma s : sintomass){
                    if(sintoma.equals(s)){
                        cont++;
                        if(contGeral == cont){

                        }
                        else if(contGeral < cont){
                            contGeral= cont;
                            auxDoenca = doenca;
                        }
                        break;
                    }



                }
            }

        }
        if(contGeral == 0){
            setDoenca(null);
        }
        else{
            setDoenca(auxDoenca);
        }

    }
}

