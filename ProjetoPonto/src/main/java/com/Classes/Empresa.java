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
public class Empresa {
    
    private int id;
    private String nome;

    
    
    public static ArrayList<Empresa> ArrayEmpresa = new ArrayList<>(); 
    public static List<String> ArrayNomesEmpresa = new ArrayList<String>(); 
    
  
   
    public static void listarEmpresas() {

        ResultSet rs = null;
        String selectSql = "SELECT * FROM empresas;";
         
        try {

            Statement stm = getConexaoMySQL().createStatement();

            rs = stm.executeQuery(selectSql);
            while (rs.next()) {
                Empresa emp = new Empresa();
           
                emp.setNome(rs.getString("nome"));
                
                
                ArrayNomesEmpresa.add(emp.getNome());
                ArrayEmpresa.add(emp);
            }

            stm.close();
        } catch (SQLException e) {
            System.out.println("2");
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
