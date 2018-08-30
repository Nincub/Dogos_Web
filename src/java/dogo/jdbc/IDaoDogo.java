/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dogo.jdbc;

import com.dto.Dogo;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author root
 */
public interface IDaoDogo {
    public int insert (Dogo dogo) throws SQLException;
    
    public int delete (Dogo dogo) throws SQLException;
    
    public int update (Dogo dogo) throws SQLException;
    
    public List<Dogo> select () throws SQLException;
}
