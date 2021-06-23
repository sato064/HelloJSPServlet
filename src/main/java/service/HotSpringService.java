package service;

import dao.HotSpringDao;
import model.HotSpring;


import java.sql.Connection;
import java.time.LocalDateTime;
import java.util.List;

/** 
@author O.SATO
*/


public class HotSpringService {

    private Connection connection = null;

    public void registHotSpring(HotSpring hotspring){
        HotSpringDao dao = new HotSpringDao();
        this.connection = dao.createConnection();
        dao.registHotSpring(connection, hotspring);
        dao.closeConnection(connection);
    }

}