package fr.tmegemont.poec.repository;

import fr.tmegemont.poec.entity.Department;
import fr.tmegemont.poec.entity.Region;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

public class RegionRepository extends AbstractRepository<Region>{


    private static RegionRepository instance;

    public RegionRepository(){
        super("region");
    }

    public static RegionRepository getRepository() {
        if (instance == null) {
            instance = new RegionRepository();
        }
        return instance;
    }

    @Override
    protected Region getObject(ResultSet rs) {
        Region region = new Region();
        try {
            region.setId(rs.getLong("id"));
            region.setName(rs.getString("name"));
            region.setCode(rs.getDouble("code"));
        } catch (SQLException e) {
            System.out.println("Something goes wrong while creating a Region object : " + e.getMessage());
            tableName = null;
        }
        return region;
    }
}
