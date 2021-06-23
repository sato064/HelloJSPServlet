package dao;

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
    

    public void registHotSpring(Connection connection,HotSpring hotSpring){
        String sql = "INSERT INTO hotsprings VALUES(?,?,?)";
        String name = hotSpring.getName();
        int star = hotSpring.getStar();
        String comment = hotSpring.getComment();

        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1,name);
            stmt.setInt(2,star);
            stmt.setString(3,comment);
            stmt.executeUpdate();
            stmt.close();

        }catch(SQLException e){
            e.printStackTrace();
        
        } finally{

        }

    }
    public List<HotSpring> showHotSpring(Connection connection){

        String sql = "SELECT * FROM hotsprings";
        List<HotSpring> hotsprings = new ArrayList<>();

        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            boolean Flag = rs.first();
            do{
                HotSpring hs = new HotSpring();
                hs.setName(rs.getString("name"));
                hs.setStar(rs.getInt("star"));
                hs.setComment(rs.getString("comment"));
                hotsprings.add(hs);
                Flag = rs.next();
            } while(Flag);

            stmt.close();
            rs.close();

            return hotsprings;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally{

        }

    }

}