/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.SpringMaven.DAOImpl;

import com.leapfrog.SpringMaven.DAO.UserDAO;
import com.leapfrog.SpringMaven.Entity.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Chandra
 */
@Repository(value = "userDAO")
public class UserDAOImpl implements UserDAO{

    //to instantiate the JdbcTemplete object spring framework - using dependency injection we have @autowired 
    @Autowired
    private JdbcTemplate jdbcTemplate;    //to use jdbc in spring framework we need jdbctemplete object
    
    @Override
    public int insert(User user) throws SQLException, ClassNotFoundException {
       
        String sql="INSERT into tbl_user(user_name,password,email,status) VALUES(?,?,?,?)";
       return  jdbcTemplate.update(sql, new Object[]{user.getUserName(),user.getPassword(),user.getEmail(),user.isStatus()});
    }

    @Override
    public List<User> getAll() throws SQLException, ClassNotFoundException {
        String query="SELECT * from tbl_user";
        return jdbcTemplate.query(query, new RowMapper<User>() {

            @Override
            public User mapRow(ResultSet rs, int i) throws SQLException {
              User user=new User();
              
              user.setId(rs.getInt("user_id"));
              user.setUserName(rs.getString("user_name"));
              user.setPassword(rs.getString("password"));
              user.setEmail(rs.getString("email"));
              user.setStatus(rs.getBoolean("status"));
              
              return user;
                      
            }
        }
        );
        
    }

    @Override
    public User getById(int id) throws SQLException, ClassNotFoundException {
      
        String query="SELECT * from  tbl_user where user_id=?";
        return jdbcTemplate.queryForObject(query, new Object[]{id}, new RowMapper<User>() {

            @Override
            public User mapRow(ResultSet rs, int i) throws SQLException {
              User user=new User();
              
              user.setId(rs.getInt("user_id"));
              user.setUserName(rs.getString("user_name"));
              user.setPassword(rs.getString("password"));
              user.setEmail(rs.getString("email"));
              user.setStatus(rs.getBoolean("status"));
              
              return user;
                      
            } 

        }
              );
                }

    @Override
    public List<User> Search(String pattern) throws SQLException, ClassNotFoundException {
       
        String query="SELECT * from tbl_user where user_name LIKE ? ";
        return jdbcTemplate.query(query, new Object[]{"%"+pattern+"%"}, new RowMapper<User>() {

            @Override
            public User mapRow(ResultSet rs, int i) throws SQLException {
                User user=new User();
              
              user.setId(rs.getInt("user_id"));
              user.setUserName(rs.getString("user_name"));
              user.setPassword(rs.getString("password"));
              user.setEmail(rs.getString("email"));
              user.setStatus(rs.getBoolean("status"));
              
              return user;
              
            }
        });
        
    }

    @Override
    public int delete(int id) throws SQLException, ClassNotFoundException {
       String query="DELETE from tbl_user where user_id=?";
       
       return jdbcTemplate.update(query,new Object[]{id});
           
    }

    @Override
    public int update(User user) throws SQLException, ClassNotFoundException {
               String sql="UPDATE  tbl_user SET user_name=?,password=?,email=?,status=? where user_id=?";
       return  jdbcTemplate.update(sql, new Object[]{user.getUserName(),user.getPassword(),user.getEmail(),user.isStatus(),user.getId()});
    }
    
}
