/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dados;

import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.SQLException;

/**
 *
 * @author thayrone
 */
public class conectaBanco {

//Classes necessárias para uso de Banco de dados //
    public static String status = "Não conectou...";
//Início da classe de conexão//
//Método de Conexão//

    public static java.sql.Connection getConexaoMySQL() {

        Connection connection = null;          //atributo do tipo conectaBanco

        try {

            // Carregando o JDBC Driver padrão
            dadosConexao key = new dadosConexao();

            Class.forName(key.driverName);

            // Configurando a nossa conexão com um banco de dados//
            connection = DriverManager.getConnection(key.url, key.username, key.password);

            //Testa sua conexão//
            if (connection != null) {

                status = ("STATUS--->Conectado com sucesso!");

            } else {

                status = ("STATUS--->Não foi possivel realizar conexão");

            }
            System.out.println(status);
            return connection;

        } catch (ClassNotFoundException e) {  //Driver não encontrado

            System.out.println("O driver expecificado nao foi encontrado.");

            return null;

        } catch (SQLException e) {

            //Não conseguindo se conectar ao banco
            System.out.println("Nao foi possivel conectar ao Banco de Dados.");

            return null;

        }

    }

    //Método que retorna o status da sua conexão//
    public static String statusConection() {

        return status;

    }

    //Método que fecha sua conexão//
    public static boolean FecharConexao() {

        try {

            conectaBanco.getConexaoMySQL().close();

            return true;

        } catch (SQLException e) {

            return false;

        }

    }

    //Método que reinicia sua conexão//
    public static java.sql.Connection ReiniciarConexao() {

        FecharConexao();

        return conectaBanco.getConexaoMySQL();

    }

}
