package pe.edu.utp.javawebregionlist.models;

import java.sql.Connection;
import java.util.List;

public class HrService {
    private Connection connection;
    private RegionsEntity regionsEntity;

//    Patron FACADE
    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
//    Patron SINGLETON
    public RegionsEntity getRegionsEntity() {
        if (getConnection() != null){
            if (regionsEntity == null){
                regionsEntity = new RegionsEntity();
                regionsEntity.setConnection(getConnection());
            }
        }
        return regionsEntity;
    }

    public List<Region> findAllRegions(){
        return getRegionsEntity() != null ?
                getRegionsEntity().findAll() : null;
    }

    public Region findRegionById(int id){
        return getRegionsEntity() != null ?
                getRegionsEntity().findById(id) : null;
    }

    public Region createRegion(String name){
        return getRegionsEntity() != null ?
                getRegionsEntity().create(name) : null;
    }
}
