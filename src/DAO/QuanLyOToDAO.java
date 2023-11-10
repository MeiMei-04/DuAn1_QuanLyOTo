/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.util.List;

/**
 *
 * @author hieud
 */
public abstract class QuanLyOToDAO<E, K> {

    abstract public void insert(E entity);

    abstract public void update(E entity);

    abstract public void delete(K key);

    abstract public List<E> selectAll();

    abstract public E selectByID(K key);

    abstract protected List<E> selectBySQL(String sql, Object... args);
}
