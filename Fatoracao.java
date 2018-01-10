import java.util.ArrayList;
import java.util.Scanner;

public class Fatoracao {
    public static void main(String[] args){
        Scanner in  = new Scanner(System.in);
        ArrayList<Integer> numeros = null;
        int opcao;
        do{
            System.out.println("1 - Obter numeros\n2 - MMC\n3 - MDC\n4 - sair");
            opcao = in.nextInt();
            switch (opcao) {
                case 1:
                    numeros = new ArrayList<>();
                    obterNumeros(numeros);
                    break;
                case 2:
                    calculaMMC(numeros);
                    break;
                case 3:
                    calculaMDC(numeros);
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Opção Inválida!\n");
                    break;
            }
        }while(opcao != 4);


    }
    private static void calculaMMC(ArrayList<Integer> numeros) {
        int MMC = 1;
        int div = 2;
        int flag = 0;
        int fim = 0, status = 1;
        int num;
        if(numeros == null){
            System.out.println("É necessario informar os numeros primeiro!\n");
        }
        else{
            ArrayList<Integer>listaDeNumeros = (ArrayList<Integer>) numeros.clone();
            while(fim == 0){
                status = 0;
                for(int i = 0; i < listaDeNumeros.size(); i++){
                    num = listaDeNumeros.get(i);
                    if(num != 1) {
                        status = 1;
                    }
                    if(num % div == 0){
                        if(num / div >= 1) {
                            num = num / div;
                            listaDeNumeros.set(i, num);
                            fim = 0;
                            flag = 1;
                            status = 1;
                        }
                    }
                }
                if (flag == 1) {
                    flag = 0;
                    MMC = MMC * div;
                }
                else{
                    div++;
                    if(status == 0){
                        fim = 1;
                    }
                }
            }
            System.out.println("MMC: " + MMC);

        }
    }

    private static void calculaMDC(ArrayList<Integer> numeros){
        int MDC = 1;
        int div = 2;
        int flag = 0;
        int fim = 0, status = 1;
        int num;
        if(numeros == null){
            System.out.println("É preciso informar os numeros primeiro!");
        }
        else{
            ArrayList<Integer>listaDeNumeros = (ArrayList<Integer>) numeros.clone();
            while(fim == 0){
                flag = 1;
                for(int i = 0; i < listaDeNumeros.size(); i++){
                    num = listaDeNumeros.get(i);
                    if(num == 1) {
                        status = 0;
                    }
                    else{
                        status = 1;
                    }
                    if(num % div == 0){
                        if(num / div >= 1) {
                            num = num / div;
                            listaDeNumeros.set(i, num);
                            fim = 0;
                            status = 1;
                        }
                    }
                    else if(num % div == num && status == 1){
                        flag = 2;
                    }
                    else{
                        flag = 0;
                    }
                }
                if (flag == 1) {
                    MDC = MDC * div;
                }
                else if (flag == 2){
                    div = 2;
                }
                else{
                    div++;
                    if(status == 0){
                        fim = 1;
                    }
                }
            }
            System.out.println("MDC: " + MDC);
        }
    }

    private static void obterNumeros(ArrayList<Integer> numeros) {
        String op;
        System.out.println("Informe os numeros a serem calculados: ");
        Scanner entrada = new Scanner(System.in);
        do {
            System.out.println("Digite o numero: ");
            int numero = entrada.nextInt();
            numeros.add(numero);

            System.out.println("Deseja calcular mais um numero? (s/n): ");
            op = entrada.next();
            if (!(op.toLowerCase().equalsIgnoreCase("n")) && !(op.toLowerCase().equalsIgnoreCase("s"))) {
                System.out.println("Opção Inválida!\n");
            }
        } while (!(op.toLowerCase().equalsIgnoreCase("n")));
    }
}
