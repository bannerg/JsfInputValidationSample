package pe.edu.utp.javawebregionlist.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CountriesEntity extends BaseEntity{
    private static String DEFAULT_SQL = "SELECT * FROM hr.countries";

    private List<Country> findByCriteria(String sql, RegionsEntity regionsEntity)  {
        List<Country> countries;
        if (getConnection() != null) {
            countries = new ArrayList<>();

            try {
                ResultSet resultSet = getConnection()
                        .createStatement()
                        .executeQuery(sql);
                while (resultSet.next()) {
                    regionsEntity = new RegionsEntity();
                    Country country = new Country()
                            .setId(resultSet.getString("country_id"))
                            .setName(resultSet.getString("country_name"))
                            .setRegion(regionsEntity.findById(resultSet.getInt("region_id"))
                            );
                    countries.add(country);
                }
                return countries;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
    //    Find All Method
    public List<Country> findAll(RegionsEntity regionsEntity){
        return getConnection() != null ?
                findByCriteria(DEFAULT_SQL, regionsEntity) : null;
    }
    //  Find by Region Method
    public List<Country> findForRegion(Region region,
                                       RegionsEntity regionsEntity){
        List<Country> countries = findByCriteria(
                DEFAULT_SQL + " WHERE region_id = " +
                        String.valueOf(region.getId()),regionsEntity
        );
        return ((countries.isEmpty()) ? null : countries);
    }
}
