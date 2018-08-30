/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pan.jdbc;

import com.dto.Pan;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author root
 */
public interface IDaoPan {
    public int insert (Pan pan) throws SQLException;
    
    public int delete (Pan pan) throws SQLException;
    
    public int update (Pan pan) throws SQLException;
    
    public List<Pan> select () throws SQLException;
}
