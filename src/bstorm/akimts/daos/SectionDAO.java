package bstorm.akimts.daos;

import bstorm.akimts.models.Section;
import bstorm.akimts.utils.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class SectionDAO {

    public List<Section> getAll(){

        String query = "SELECT * FROM section";
        try(
                Connection co = ConnectionFactory.createConnection();
                Statement stmt = co.createStatement();
                ResultSet rs = stmt.executeQuery( query )
        ){
            List<Section> sections = new ArrayList<>();
            while( rs.next() ){

                int id = rs.getInt( "section_id" );
                String name = rs.getString( "section_name" );
                Integer delegateId = rs.getInt( "delegate_id" ); // renvoi 0 malgré le NULL sql
                if( rs.wasNull() )  // verifie si le dernier get realisé avait la valeur NULL sql;
                    delegateId = null;

                Section section = new Section(id, name, delegateId);
                sections.add( section );
            }
            return sections;
        }
        catch (SQLException ex){
            throw new RuntimeException("Problème SQL - "+ ex.getSQLState() + ":" + ex.getErrorCode() + " - " + ex.getMessage());
        }
    }

    public Section getOne(int id){


        String query = "SELECT section_name, delegate_id " +
                " FROM section" +
                " WHERE section_id = " + id;
        try (
          Connection co = ConnectionFactory.createConnection();
          Statement stmt = co.createStatement();
          ResultSet rs = stmt.executeQuery( query )
        ) {
            if( rs.next() ){
                String name = rs.getString( "section_name" );
                Integer delegateId = rs.getInt( "delegate_id" ); // renvoi 0 malgré le NULL sql
                if( rs.wasNull() )  // verifie si le dernier get realisé avait la valeur NULL sql;
                    delegateId = null;

                return new Section(id, name, delegateId);
            }
            return null;

        }
        catch (SQLException ex){
            throw new RuntimeException("Problème SQL - "+ ex.getSQLState() + ":" + ex.getErrorCode() + " - " + ex.getMessage());
        }

    }

}
