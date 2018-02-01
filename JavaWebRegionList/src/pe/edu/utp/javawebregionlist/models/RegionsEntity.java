package pe.edu.utp.javawebregionlist.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RegionsEntity extends BaseEntity{
    private static String DEFAULT_SQL = "SELECT * FROM hr.regions";

    private List<Region> findByCriteria(String sql)  {
        List<Region> regions = new ArrayList<>();
        if (getConnection() != null) {
            regions = new ArrayList<>();

            ResultSet resultSet = null;
            try {
                resultSet = getConnection()
                        .createStatement()
                        .executeQuery(sql);
                while (resultSet.next()) {
                    Region region = new Region()
                            .setId(resultSet.getInt("region_id"))
                            .setName(resultSet.getString("region_name"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }


        }
        return regions;
    }

    public List<Region> findAll(){
        return findByCriteria(DEFAULT_SQL);
    }

    public Region findById(int id){
        List<Region> regions = findByCriteria(
                DEFAULT_SQL +
                        "WHERE region_id = " +
                        String.valueOf(id)
        );
        return (regions != null ? regions.get(0) : null);
    }
}
