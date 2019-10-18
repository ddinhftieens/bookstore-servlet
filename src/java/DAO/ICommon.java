/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;

/**
 *
 * @author Dell
 */
public interface ICommon <T> {
    void add(T t);
    void edit(T t);
    void delete(int ID);
    T getByID(int ID);
    T getByName(String name);
    List<T> getAll();
    List<T> getAllbyID(int ID);
}
