package fr.tmegemont.poec.repository;

import fr.tmegemont.poec.entity.Department;
import fr.tmegemont.poec.entity.EntityInterface;
import fr.tmegemont.poec.entity.Region;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class DepartmentRepository extends AbstractRepository<Department>{

    private static DepartmentRepository instance;

    private RegionRepository regionRepository = RegionRepository.getRepository();

    public DepartmentRepository(){
        super("department");
    }

    public static DepartmentRepository getRepository() {
        if (instance == null) {
            instance = new DepartmentRepository();
        }
        return instance;
    }

    public List<Department> findDepartmentsByRegion(Region){
        List<Department> listDep = new ArrayList<>();
        return listDep;
    }
    @Override
    protected Department getObject(ResultSet rs) {
        Department department = new Department();
        try {
            department.setId(rs.getLong("id"));
            department.setName(rs.getString("name"));
            department.setCode(rs.getDouble("code"));
            department.setRegion(regionRepository.findOneBy("id", rs.getLong("region_id")));
        } catch (SQLException e) {
            System.out.println("Something goes wrong while creating a Department object : " + e.getMessage());
            tableName = null;
        }
        return department;
    }

}
