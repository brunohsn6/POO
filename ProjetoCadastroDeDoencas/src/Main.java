
import View.ViewDoenca;
import View.ViewSintoma;
import View.ViewUsuario;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        ViewUsuario usuario = new ViewUsuario();
        ViewSintoma sintoma = new ViewSintoma();
        ViewDoenca doenca = new ViewDoenca();
        Scanner scanner = new Scanner(System.in);
        int opp;
        do{
            System.out.println("1- Usuarios\n2- Sintomas\n3- Doenca\n0- Sair\nDigite a opção: ");
            opp = scanner.nextInt();

            switch(opp){

                case 1:
                    usuario.menuUsuario();
                    break;
                case 2:
                    sintoma.menuSintomas();
                    break;
                case 3:
                    doenca.menuDoenca();
                    break;
                default:
                    break;
            }
        }while(opp !=0);
    }
}