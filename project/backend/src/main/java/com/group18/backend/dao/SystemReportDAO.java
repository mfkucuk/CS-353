package com.group18.backend.dao;

import java.util.List;

import com.group18.backend.misc.HomeownerReputation;
import com.group18.backend.misc.LocationCount;
import com.group18.backend.misc.RentalPrice;
import com.group18.backend.misc.RentalRating;
import com.group18.backend.models.SystemReport;

public interface SystemReportDAO 
{
    String insertSystemReport(SystemReport systemReport);

    List<SystemReport> getAllSystemReports();

    List<LocationCount> getLocationCount();
    List<HomeownerReputation> getMostReputableHomeowners();
    List<RentalRating> getHighestRatedRentals();
    List<RentalPrice> getMostExpensiveRentals();
    List<RentalPrice> getLeastExpensiveRentals();
}
