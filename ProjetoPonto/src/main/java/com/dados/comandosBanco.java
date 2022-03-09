/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dados;

import com.Classes.Funcionario;
import static com.dados.conectaBanco.FecharConexao;
import static com.dados.conectaBanco.getConexaoMySQL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author thayrone
 */
public class comandosBanco {

    public void insert(String tabela, String coluna1, String coluna2, String colunaComString, String valor1, String valor2, String valorComString) {

        String insertSql = "INSERT INTO " + tabela + "(" + coluna1 + ", " + coluna2 + "," + colunaComString + " ) Values (" + valor1 + "," + valor2 + ",'" + valorComString + "');";
        try {

            PreparedStatement stm = getConexaoMySQL().prepareStatement(insertSql);

            stm.execute();
            stm.close();

            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso", "SUCESSO!", JOptionPane.OK_OPTION);

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "Ocorreu um erro no cadastro", "Atenção!", JOptionPane.OK_OPTION);
            e.printStackTrace();
        }

        FecharConexao();
    }

}
