package Model;

import java.util.ArrayList;

public class Doenca {
    private String nome;
    private int prioridade;
    private ArrayList<Sintoma> sintomasDaDoenca;


    public Doenca(String nome, int p, ArrayList<Sintoma> listaDeSintomas){
        this.nome = nome;
        this.prioridade = p;
        this.sintomasDaDoenca = listaDeSintomas;

    }

    public String getNome() {
        return nome;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public ArrayList<Sintoma> getSintomas() {
        return sintomasDaDoenca;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }

    public void setSintomasDaDoenca(ArrayList<Sintoma> sintomasDaDoenca) {
        this.sintomasDaDoenca = sintomasDaDoenca;
    }



}
