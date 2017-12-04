package DAO;

import Model.Usuario;

import java.util.ArrayList;

public class DAOUsuario implements DAOUsuarioBridge {

    private static ArrayList<Usuario> listaDeUsuarios = new ArrayList<>();

    @Override
    public void inserir(Usuario usuario){
        listaDeUsuarios.add(usuario);
    }

    @Override
    public void remover (Usuario usuario){

        for(Usuario usu : listaDeUsuarios){
            if(usu.equals(usuario)){
                listaDeUsuarios.remove(usu);
                break;
            }
        }
    }

    @Override
    public Usuario consultar (String nome){
        for(Usuario usuario: listaDeUsuarios){
            if(usuario.getNome().equalsIgnoreCase(nome)){
                return usuario;
            }
        }
        return null;
    }

    @Override
    public void alterar(Usuario antigo, Usuario novo){
        this.remover(antigo);
        this.inserir(novo);
        novo.defineDoenca();
    }
    @Override
    public void listar() {
        if (!listaDeUsuarios.isEmpty()) {
            System.out.println("********USUÁRIOS********");
            for (Usuario usuario : listaDeUsuarios) {
                System.out.println("Nome: " + usuario.getNome() + "\nIdade: " + usuario.getIdade()
                        + "\nEndereço: " + usuario.getEndereco() + "\nPrognóstico: " + usuario.getNomeDoenca());
                System.out.println();
            }
        } else {
            System.out.println("não há usuários cadastrados!");
        }
    }
    @Override
    public void update(){
        for(Usuario usuario : listaDeUsuarios){
            usuario.defineDoenca();
        }

    }
}

