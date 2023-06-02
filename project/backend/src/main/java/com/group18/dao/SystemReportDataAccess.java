package com.group18.dao;

import java.util.List;
import java.util.UUID;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.group18.misc.LocationCount;
import com.group18.models.SystemReport;

import lombok.RequiredArgsConstructor;

@Repository("SystemReport") @Transactional
@RequiredArgsConstructor
public class SystemReportDataAccess implements SystemReportDAO
{
    private final JdbcTemplate jdbcTemplate;

    @Override
    public int insertSystemReport(UUID id, SystemReport systemReport) 
    {
        final String sql = "INSERT INTO SystemReport VALUES(?, ?, ?)";

        return jdbcTemplate.update(sql, new Object[] { systemReport.getTitle(), systemReport.getContent(), systemReport.getAdminId() });
    }

    @Override
    public List<SystemReport> getAllSystemReports() 
    {
        final String sql = "SELECT * FROM SystemReport";

        List<SystemReport> allSystemReports = jdbcTemplate.query(sql, (resultSet, i) -> {
            String title = resultSet.getString("title");
            String content = resultSet.getString("content");
            UUID id = UUID.fromString(resultSet.getString("admin_id"));
            return new SystemReport(
                title,
                content,
                id
            );
        });
        return allSystemReports;
    }

    @Override
    public List<LocationCount> getLocationCount() 
    {
        final String sql = "SELECT location, COUNT(*) as count FROM rental GROUP BY location";

        List<LocationCount> objects = jdbcTemplate.query(sql, (resultSet, i) -> {
            String location = resultSet.getString("location");
            int count = resultSet.getInt("count");
            return new LocationCount(
                location,
                count
            );
        });
        return objects;
    }

    @Override
    public int getMostReputableHomeowners() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getMostReputableHomeowners'");
    }

    @Override
    public int getHighestRatedRentals() {
        final String sql = "SELECT location, COUNT(*) as count FROM rental GROUP BY location";

        return 0;
    }

    @Override
    public int getMostExpensiveRentals() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getMostExpensiveRentals'");
    }

    @Override
    public int getLeastExpensiveRentals() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getLeastExpensiveRentals'");
    }
    
}
