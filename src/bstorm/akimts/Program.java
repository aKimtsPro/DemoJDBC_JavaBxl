package bstorm.akimts;

import bstorm.akimts.daos.SectionDAO;
import bstorm.akimts.models.Section;

import java.util.List;

public class Program {

    public static void main(String[] args) {

        SectionDAO dao = new SectionDAO();

        System.out.println(" > Get all");
        List<Section> sections = dao.getAll();
        sections.forEach( System.out::println );

        System.out.println(" > Get one");
        Section section = dao.getOne( 1320 );
        System.out.println( section );


        System.out.println(" > Insert");
        section.setId(8888);
        section.setDelegateId(12);

        dao.insert(section);


    }

}
