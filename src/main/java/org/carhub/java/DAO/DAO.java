package org.carhub.java.DAO;

public interface DAO<T> {

   int add(T model);
   void update(T model);
   void delete(T model);
   T get(T model);
}
