/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dados;

/**
 *
 * @author thayrone
 */
public class dadosConexao {

    protected String driverName = "com.mysql.cj.jdbc.Driver";
    
    protected String serverName = "localhost";    //caminho do servidor do BD

    protected String mydatabase = "BancoPonto";        //nome do seu banco de dados

    protected String url = "jdbc:mysql://" + serverName + "/" + mydatabase;

    protected String username = "root";        //nome de um usuário de seu BD

    protected String password = "Shine@4242524";      //sua senha de acesso
}
