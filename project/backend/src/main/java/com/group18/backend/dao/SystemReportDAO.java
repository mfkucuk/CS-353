package com.group18.backend.dao;

import java.util.List;
import java.util.UUID;

import com.group18.backend.misc.LocationCount;
import com.group18.backend.models.SystemReport;

public interface SystemReportDAO 
{
    int insertSystemReport(UUID id, SystemReport systemReport);
    default int insertSystemReport(SystemReport systemReport) 
    {
        UUID id = UUID.randomUUID();
        return insertSystemReport(id, systemReport);
    }    

    List<SystemReport> getAllSystemReports();

    List<LocationCount> getLocationCount();
    int getMostReputableHomeowners();
    int getHighestRatedRentals();
    int getMostExpensiveRentals();
    int getLeastExpensiveRentals();
}
