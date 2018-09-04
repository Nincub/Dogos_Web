/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package salchicha.jdbc;

import JDBC.DBConnection;
import com.dto.Salchicha;
import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author root
 */
public class DaoSalchichaJDBC implements IDaoSalchicha {
    private Connection userConn;
    private final String SQL_INSERT = "INSERT INTO salchicha(precio, nombre) VALUES(?,?)";
    private final String SQL_UPDATE = "UPDATE salchicha SET precio=?, nombre=? WHERE idsalchicha=?";
    private final String SQL_DELETE = "DELETE FROM salchicha WHERE idsalchicha = ?";
    private final String SQL_SELECT = "SELECT idsalchicha, nombre, precio FROM salchicha";

    public DaoSalchichaJDBC() {
    }

    public DaoSalchichaJDBC(Connection userConn) {
        this.userConn = userConn;
    }

    @Override
    public int insert(Salchicha salchicha) throws SQLException{
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
                conn = (this.userConn != null ) ? this.userConn : DBConnection.getConnection();
                stmt = (PreparedStatement) conn.prepareStatement(SQL_INSERT);
                int index = 1;
                stmt.setFloat(index++, salchicha.getPrecio());
                stmt.setString(index, salchicha.getNombre());
                System.out.println("Executing query: " + SQL_INSERT);
                rows = stmt.executeUpdate();
                System.out.println("Afected Rows: " + rows);
        } finally {
            DBConnection.close(stmt);
            if (this.userConn == null) {
                DBConnection.close(conn);
            }
        }
        return rows;
    }

    @Override
    public int delete(Salchicha salchicha) throws SQLException{
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = (this.userConn != null) ? this.userConn : DBConnection.getConnection();
            stmt = (PreparedStatement) conn.prepareStatement(SQL_DELETE);
            int index = 1;
            stmt.setInt(index, salchicha.getIdSalchicha());
            System.out.println("Executing query: " + SQL_DELETE);
            rows = stmt.executeUpdate();
            System.out.println("Afected rows: " + rows);
        } finally {
            DBConnection.close(stmt);
            if(this.userConn == null) {
                DBConnection.close(conn);
            }
        }
        return rows;
    }

    @Override
    public int update(Salchicha salchicha) throws SQLException{
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = (this.userConn != null) ? this.userConn : DBConnection.getConnection();
            stmt = (PreparedStatement) conn.prepareStatement(SQL_UPDATE);
            int index = 1;
            stmt.setFloat(index++, salchicha.getPrecio());
            stmt.setString(index++, salchicha.getNombre());
            stmt.setInt(index, salchicha.getIdSalchicha());
            System.out.println("Executing Query: " + SQL_UPDATE);
            rows = stmt.executeUpdate();
            System.out.println("Afected rows: " + rows);            
        } finally {
            DBConnection.close(stmt);
            if(this.userConn == null) {
                DBConnection.close(conn);
            }
        }
        return rows;
    }

    @Override
    public List<Salchicha> select() throws SQLException{
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Salchicha> salchichas = new ArrayList<>();
        try {
            conn = (this.userConn != null) ? this.userConn : DBConnection.getConnection();
            stmt = (PreparedStatement) conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while(rs.next()) {
                int idSalchicha = rs.getInt(1);
                String nombre = rs.getString(2);
                float precio = rs.getFloat(3);
                salchichas.add(new Salchicha(idSalchicha, precio, nombre));
            }
        } finally {
            DBConnection.close(stmt);
            DBConnection.close(rs);
            if(userConn == null) {
                DBConnection.close(conn);
            }
        }
        return salchichas;
    }
    
    
}
