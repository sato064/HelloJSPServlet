package dao;

import model.Sample;
import utility.DriverAccessor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SampleDao extends DriverAccessor {
    
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

}