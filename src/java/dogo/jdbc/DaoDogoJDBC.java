/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dogo.jdbc;

import JDBC.DBConnection;
import com.dto.Dogo;
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
public class DaoDogoJDBC implements IDaoDogo{
    private Connection userConn;
    private final String SQL_INSERT = "INSERT INTO dogo(idsalchicha, idpan, precio) VALUES(?,?,?)";
    private final String SQL_UPDATE = "UPDATE dogo SET idsalchicha=?, idpan=?, precio=? WHERE iddogo=?";
    private final String SQL_DELETE = "DELETE FROM dogo WHERE iddogo = ?";
    private final String SQL_SELECT = "SELECT iddogo, idsalchicha, idpan, precio cohort FROM dogo";

    public DaoDogoJDBC() {
    }

    public DaoDogoJDBC(Connection userConn) {
        this.userConn = userConn;
    }

    @Override
    public int insert(Dogo dogo) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = (this.userConn != null) ? this.userConn : DBConnection.getConnection();
            stmt = (PreparedStatement) conn.prepareStatement(SQL_INSERT);
            int index = 1;
            stmt.setInt(index++, dogo.getIdSalchicha());
            stmt.setInt(index++, dogo.getIdPan());
            stmt.setFloat(index, dogo.getPrecio());
            System.out.println("Executing Query: " + SQL_INSERT);
            stmt.executeUpdate();
            System.out.println("Afected rows: " + rows);
        } finally {
            DBConnection.close(stmt);
            if (conn == null) {
                DBConnection.close(conn);
            }
        }
        return rows;
    }

    @Override
    public int delete(Dogo dogo) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = (this.userConn != null) ? this.userConn : DBConnection.getConnection();
            stmt = (PreparedStatement) conn.prepareStatement(SQL_DELETE);
            int index = 1;
            stmt.setInt(index, dogo.getIdDogo());
            System.out.println("Executing Query: " + SQL_DELETE);
            rows = stmt.executeUpdate();
            System.out.println("Afected rows: " + rows);
        } finally {
            DBConnection.close(stmt);
            if (conn == null) {
                DBConnection.close(conn);
            }
        }
        return rows;
    }

    @Override
    public int update(Dogo dogo) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = (this.userConn != null) ? this.userConn : DBConnection.getConnection();
            stmt = (PreparedStatement) conn.prepareStatement(SQL_UPDATE);
            int index = 1;
            stmt.setInt(index++, dogo.getIdSalchicha());
            stmt.setInt(index++, dogo.getIdPan());
            stmt.setFloat(index++, dogo.getPrecio());
            stmt.setInt(index, dogo.getIdDogo());
            System.out.println("Executing Query: " + SQL_UPDATE);
            stmt.executeUpdate();
            System.out.println("Afected rows: " + rows);
        } finally {
            DBConnection.close(stmt);
            if (conn == null) {
                DBConnection.close(conn);
            }
        }
        return rows;
    }

    @Override
    public List<Dogo> select() throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Dogo> dogos = new ArrayList<>();
        try {
            conn = (this.userConn != null) ? this.userConn : DBConnection.getConnection();
            stmt = (PreparedStatement) conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while(rs.next()) {
                int idDogo = rs.getInt(1);
                int idSalchicha = rs.getInt(2);
                int idPan = rs.getInt(3);
                float precio = rs.getFloat(4);
                dogos.add(new Dogo(idDogo, idSalchicha, idPan, precio));
            }
        } finally {
            DBConnection.close(rs);
            DBConnection.close(stmt);
            if (conn == null) {
                DBConnection.close(conn);
            }
        }
        return dogos;
    }
    
    
}
