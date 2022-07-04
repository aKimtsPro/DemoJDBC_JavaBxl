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


    public void insert( Section toInsert ){

        if( toInsert == null )
            throw new IllegalArgumentException();

        String query = "INSERT INTO section (section_id, section_name, delegate_id)"
                + " VALUES (?,?,?)";

        try (
                Connection co = ConnectionFactory.createConnection();
                PreparedStatement stmt = co.prepareStatement(query);
        ) {

            stmt.setInt( 1, toInsert.getId() );
            stmt.setString( 2, toInsert.getName() );
            if( toInsert.getDelegateId() != null )
                stmt.setInt(3, toInsert.getDelegateId());
            else
                stmt.setNull(3, Types.INTEGER);

            if( stmt.executeUpdate() != 1 )
                throw new RuntimeException("insertion failed");
        }
        catch (SQLException ex) {
            throw new RuntimeException("insertion failed");
        }
    }


    // supprimer une section
    public void delete(int id){
        // TODO implementer
    }

    // Peut modifier le nom et le délégué d'une section
    public void update(Section section){
        // TODO implementer
    }


}
