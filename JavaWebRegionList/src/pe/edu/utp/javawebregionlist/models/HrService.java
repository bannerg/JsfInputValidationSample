package pe.edu.utp.javawebregionlist.models;

import java.sql.Connection;
import java.util.List;

public class HrService {
    private Connection connection;
    private RegionsEntity regionsEntity;
    private CountriesEntity countriesEntity;

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

    public CountriesEntity getCountriesEntity() {
        if (getConnection() != null){
            if (countriesEntity == null){
                countriesEntity = new CountriesEntity();
                countriesEntity.setConnection(getConnection());
            }
        }
        return countriesEntity;
    }

    public List<Region> findAllRegions(){
        return getRegionsEntity() != null ?
                getRegionsEntity().findAll() : null;
    }
    public List<Country> findAllCountries(){
        return (getCountriesEntity() != null &&
        getRegionsEntity() != null) ?
        getCountriesEntity().findAll(getRegionsEntity()) : null;
    }

    public Region findRegionById(int id){
        return getRegionsEntity() != null ?
                getRegionsEntity().findById(id) : null;
    }


    public Region createRegion(String name){
        return getRegionsEntity() != null ?
                getRegionsEntity().create(name) : null;
    }

    public boolean deleteRegion(int id){
        return getRegionsEntity() != null ?
                getRegionsEntity().delete(id) : false;
    }

    public boolean updateRegion(Region region){
        return getRegionsEntity() != null ?
                getRegionsEntity().update(region) : false;
    }

    public List<Region> findAllWithCountries(Region region){
        return (getCountriesEntity() != null &&
                getRegionsEntity() != null) ?
                getRegionsEntity().findAllWithCountries(getCountriesEntity()) : null;
    }

    public List<Country> findCountriesByRegion(Region region){
        return
                (getCountriesEntity() != null &&
                        getRegionsEntity() != null) ?
                        getCountriesEntity()
                                .findForRegion(region, getRegionsEntity())
                : null;
    }
}
