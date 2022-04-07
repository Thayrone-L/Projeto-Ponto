/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dados;

import com.telas.telaCriaBanco;
import java.sql.SQLException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

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
            telaCriaBanco telaCriaBanco = new telaCriaBanco();
            telaCriaBanco.setVisible(true);

            return null;

        }

    }

    public static boolean criaBanco() {
        dadosConexao key = new dadosConexao();
        String url = "jdbc:mysql://localhost";

        // SQL command to create a database in MySQL.
        scriptCriaBanco strg = new scriptCriaBanco();

        try ( Connection conn = DriverManager.getConnection(url, key.username, key.password);  PreparedStatement stmt = conn.prepareStatement(strg.criaBanco)) {

            stmt.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean criaTabelas() {
        dadosConexao key = new dadosConexao();
        String url = "jdbc:mysql://localhost";

        // SQL command to create a database in MySQL.
        scriptCriaBanco strg = new scriptCriaBanco();
        try ( Connection conn = DriverManager.getConnection(key.url, key.username, key.password);  Statement stmt = conn.createStatement();) {

            stmt.executeUpdate(strg.criaTabelaFuncoes);
            stmt.executeUpdate(strg.criaTabelaEmpresas);
            stmt.executeUpdate(strg.criaTabelaFuncionarios);
            stmt.executeUpdate(strg.criaTabelaBatidas);
            stmt.executeUpdate(strg.criaTabelaCalculos);
            stmt.executeUpdate(strg.criaTabelaEquipamentos);
            stmt.executeUpdate(strg.criaTabelaEscalas);
            stmt.executeUpdate(strg.criaTabelaFeriados);
            stmt.executeUpdate(strg.criaTabelaUsuarios);
            stmt.executeUpdate(strg.criaTabelaHorarios);
            stmt.executeUpdate(strg.criaTabelaJustificativas);
            stmt.executeUpdate(strg.criaTabelaRegistro_sistema);
            stmt.executeUpdate(strg.criaTabelaSelecao_impressao);
            
            

            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
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
