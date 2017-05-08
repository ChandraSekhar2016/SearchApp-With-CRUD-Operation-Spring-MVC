/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.SpringMaven.DAO;

import com.leapfrog.SpringMaven.Entity.User;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Chandra
 */
public interface UserDAO {
    public int insert(User user) throws SQLException, ClassNotFoundException;
    public int delete(int id) throws SQLException, ClassNotFoundException;
    public int update(User user) throws SQLException, ClassNotFoundException;
    public List<User>getAll() throws SQLException, ClassNotFoundException;
    public User getById(int id) throws SQLException, ClassNotFoundException;
        public List<User>Search(String pattern) throws SQLException, ClassNotFoundException;
}
