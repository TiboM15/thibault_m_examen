package fr.tmegemont.poec.repository;

import fr.tmegemont.poec.entity.Department;
import fr.tmegemont.poec.entity.EntityInterface;
import fr.tmegemont.poec.entity.PostalCode;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PostalCodeRepository extends AbstractRepository<PostalCode> {



    private CityRepository cityRepository = CityRepository.getRepository();

    public PostalCodeRepository(){
        super("department");
    }


    @Override
    protected PostalCode getObject(ResultSet rs) {
        PostalCode postalCode = new PostalCode();
        try {
            postalCode.setId(rs.getLong("id"));
            postalCode.setCode(rs.getDouble("code"));
            postalCode.setCity(cityRepository.findOneBy("id", rs.getLong("region_id")));
        } catch (SQLException e) {
            System.out.println("Something goes wrong while creating a PostalCode object : " + e.getMessage());
            tableName = null;
        }
        return postalCode;
    }
}
