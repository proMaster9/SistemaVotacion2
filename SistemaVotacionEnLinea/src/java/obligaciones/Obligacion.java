/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import java.util.List;

/**
 *
 * @author Icchigo
 */
public interface Obligacion <Tabla> {
    public boolean create(Tabla c);
    public boolean delete(Object key);
    public boolean update(Tabla c);
    public List<Tabla> readAll();
    //public Tabla read(Object key);
    
    
}
