/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Classes;

import static com.dados.conectaBanco.FecharConexao;
import static com.dados.conectaBanco.getConexaoMySQL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author thayrone
 */
public class Horario {
     private int id;
    private String nome;

    
    
    public static ArrayList<Horario> ArrayHorario = new ArrayList<>(); 
    public static List<String> ArrayNomesHorario = new ArrayList<String>(); 
    
    public static int localizaIndexHorario(int id_horario) {
        int i = 0;
        int index = 0;
        for (Horario hor : ArrayHorario) {
            if (hor.id == id_horario) {

                 index=i;
            }

            i++;
        }

        return index;
    }
   
    public static void listarHorarios() {

        ResultSet rs = null;
        String selectSql = "SELECT * FROM horarios;";
         
        try {

            Statement stm = getConexaoMySQL().createStatement();

            rs = stm.executeQuery(selectSql);
            while (rs.next()) {
                Horario hor = new Horario();
           
                hor.setNome(rs.getString("nome"));
                
                
                ArrayNomesHorario.add(hor.getNome());
                ArrayHorario.add(hor);
            }

            stm.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro na cconsulta", "Atenção!", JOptionPane.OK_OPTION);
            e.printStackTrace();
        }
        FecharConexao();

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    public String getNome() {
        return nome;
    }
    
    

    public void setNome(String nome) {
        this.nome = nome;
    }
    
}
