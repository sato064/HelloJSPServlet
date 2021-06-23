package service;

import dao.SampleDao;
import dao.HotSpringDao;
import model.HotSpring;
import model.Sample;

import java.sql.Connection;
import java.time.LocalDateTime;
import java.util.List;

/** 
@author O.SATO
*/


public class HotSpringService {

    private Connection connection = null;

    private void createConnection(SampleDao dao) {
        this.connection = dao.createConnection();
    }

    private void closeConnection(SampleDao dao) {
        dao.closeConnection(this.connection);
        this.connection = null;
    }

    public List<Sample> getSample() {
        SampleDao dao = new SampleDao();
        createConnection(dao);
        List<Sample> sample = dao.findAll(connection);
        closeConnection(dao);
        return sample;
    }

    public void registHotSpring(HotSpring hotspring){
        HotSpringDao dao = new HotSpringDao();
        this.connection = dao.createConnection();
        dao.registHotSpring(connection, hotspring);
        dao.closeConnection(connection);
    }

}