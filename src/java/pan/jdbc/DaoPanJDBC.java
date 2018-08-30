/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pan.jdbc;

import JDBC.DBConnection;
import com.dto.Pan;
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
public class DaoPanJDBC implements IDaoPan{
    private Connection userConn;
    private final String SQL_INSERT = "INSERT INTO pan(precio, nombre) VALUES(?,?)";
    private final String SQL_UPDATE = "UPDATE pan SET precio=?, nombre=? WHERE idpan=?";
    private final String SQL_DELETE = "DELETE FROM pan WHERE idpan = ?";
    private final String SQL_SELECT = "SELECT idpan, nombre, precio cohort FROM pan";

    public DaoPanJDBC() {
    }

    public DaoPanJDBC(Connection userConn) {
        this.userConn = userConn;
    }

    @Override
    public int insert(Pan pan) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = (this.userConn != null) ? this.userConn : DBConnection.getConnection();
            stmt = (PreparedStatement) conn.prepareStatement(SQL_INSERT);
            int index = 1;
            stmt.setFloat(index++, pan.getPrecio());
            stmt.setString(index, pan.getNombre());
            System.out.println("Executing Query: " + SQL_INSERT);
            rows = stmt.executeUpdate();
            System.out.println("Afected rows: " + rows);
        } finally {
            DBConnection.close(stmt);
            if (this.userConn == null) {
                DBConnection.close(conn);
            }
        }
        return rows;
    }

    @Override
    public int delete(Pan pan) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = (this.userConn != null) ? this.userConn : DBConnection.getConnection();
            stmt = (PreparedStatement) conn.prepareCall(SQL_DELETE);
            int index = 1;
            stmt.setInt(index, pan.getIdPan());
            System.out.println("Executing Query: " + SQL_DELETE);
            rows = stmt.executeUpdate();
            System.out.println("Afected rows: " + rows);
        } finally {
            DBConnection.close(stmt);
            if (this.userConn == null) {
                DBConnection.close(conn);
            }
        }
        return rows;
    }

    @Override
    public int update(Pan pan) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = (this.userConn != null) ? this.userConn : DBConnection.getConnection();
            stmt = (PreparedStatement) conn.prepareStatement(SQL_UPDATE);
            int index = 1;
            stmt.setFloat(index++, pan.getPrecio());
            stmt.setString(index++, pan.getNombre());
            stmt.setInt(index, pan.getIdPan());
            System.out.println("Executing Query: " + SQL_UPDATE);
            rows = stmt.executeUpdate();
            System.out.println("Afected rows: " + rows);
        } finally {
            DBConnection.close(stmt);
            if (this.userConn == null) {
                DBConnection.close(conn);
            }
        }
        return rows;
    }

    @Override
    public List<Pan> select() throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Pan> panes = new ArrayList<>();
        try {
            conn = (this.userConn != null) ? this.userConn : DBConnection.getConnection();
            stmt = (PreparedStatement) conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while(rs.next()) {
                int idPan = rs.getInt(1);
                float precio = rs.getFloat(2);
                String nombre = rs.getString(3);
                panes.add(new Pan(idPan, precio, nombre));
            }
        } finally {
            DBConnection.close(stmt);
            DBConnection.close(rs);
            if(userConn == null) {
                DBConnection.close(conn);
            }
        }
        return panes;
    }
    
    
}
