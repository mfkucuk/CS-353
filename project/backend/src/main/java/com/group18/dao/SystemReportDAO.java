package com.group18.dao;

import java.util.List;
import java.util.UUID;

import com.group18.models.SystemReport;

public interface SystemReportDAO 
{
    int insertSystemReport(UUID id, SystemReport systemReport);
    default int insertSystemReport(SystemReport systemReport) 
    {
        UUID id = UUID.randomUUID();
        return insertSystemReport(id, systemReport);
    }    

    List<SystemReport> getAllSystemReports();

    int getLocationCount();
    int getMostReputableHomeowners();
    int getHighestRatedRentals();
    int getMostExpensiveRentals();
    int getLeastExpensiveRentals();
}
