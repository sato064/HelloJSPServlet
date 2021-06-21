package dao;

import model.Sample;
import model.HotSpring;
import utility.DriverAccessor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/** 
@author O.SATO
*/

public class HotSpringDao extends DriverAccessor {
    
    public List<Sample> findAll(Connection connection) {
        String findAll = "select * from sample";
        try {
            PreparedStatement statement = connection.prepareStatement(findAll);
            ResultSet resultSet = statement.executeQuery();
            List<Sample> sampleList = new ArrayList<Sample>();
            while(resultSet.next()) {
                Sample sample = new Sample();
                sample.setSampleId(resultSet.getInt("id"));
                sample.setContent(resultSet.getString("content"));
                sampleList.add(sample);
            }
            statement.close();
            resultSet.close();

            return sampleList;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void registHotSpring(Connection connection,HotSpring hotSpring){
        String sql = "INSERT INTO hotsprings VALUES(?,?,?)";
        String name = hotSpring.getName();
        int star = hotSpring.getStar();
        String comment = hotSpring.getComment();

        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1,name);
            stmt.setInt(2,star);
            stmt.setString(3,commnet);

            stmt.executeUpdate();
            stmt.close();

        }catch(SQLException e){
            e.printStackTrace();
            return 0;
        
        } finally{

        }

    }

}