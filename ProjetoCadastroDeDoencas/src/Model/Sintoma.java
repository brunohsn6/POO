package Model;

public class Sintoma {
    private String sintoma;

    public Sintoma(String sintoma) {
        this.sintoma = sintoma;
    }


    public void setSintoma(String nome){
        this.sintoma = nome;
    }

    public String getSintoma(){
        return this.sintoma;
    }
}

