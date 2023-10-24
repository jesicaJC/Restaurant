/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author rafa
 */
public class Login {
    private int id;
    private String usuario,pass;

    public Login() {
    }

    public Login(int id, String usuario, String pass) {
        this.id = id;
       
        this.usuario = usuario;
        this.pass = pass;
    }

    public Login( String usuario, String pass) {
        this.usuario = usuario;
        this.pass = pass;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public String toString() {
        return "Login{" + "id=" + id  + ", usuario=" + usuario + ", pass=" + pass + '}';
    }
    
    
}
