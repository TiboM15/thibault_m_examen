package fr.tmegemont.poec.repository;

import fr.tmegemont.poec.entity.City;
import fr.tmegemont.poec.entity.EntityInterface;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class CityRepository extends AbstractRepository<City>{

    private static CityRepository instance;

    private DepartmentRepository departmentRepository = DepartmentRepository.getRepository();
    public CityRepository(){
        super("city");
    }

    public static CityRepository getRepository() {
        if (instance == null) {
            instance = new CityRepository();
        }
        return instance;
    }


    @Override
    protected City getObject(ResultSet rs) {
        City city = new City();
        try {
            city.setId(rs.getLong("id"));
            city.setDepartment(departmentRepository.findOneBy("id",rs.getLong("department_id")));
            city.setSiren(rs.getDouble("siren"));
            city.setPopulation(rs.getDouble("population"));
            city.setName(rs.getString("name"));
            city.setCode(rs.getDouble("code"));
        } catch (SQLException e) {
            System.out.println("Something goes wrong while creating a City object : " + e.getMessage());
            city = null;
        }
        return city;
    }
}
