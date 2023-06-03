package com.group18.backend.dao;

import java.util.List;
import java.util.UUID;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.group18.backend.misc.HomeownerReputation;
import com.group18.backend.misc.LocationCount;
import com.group18.backend.misc.RentalPrice;
import com.group18.backend.misc.RentalRating;
import com.group18.backend.models.SystemReport;

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

        List<LocationCount> locationCounts = getLocationCount();
        List<HomeownerReputation> homeownerReputations = getMostReputableHomeowners();
        List<RentalRating> rentalRatings = getHighestRatedRentals();
        List<RentalPrice> mostRentalPrices = getMostExpensiveRentals();
        List<RentalPrice> leastRentalPrices = getLeastExpensiveRentals();

        String content = "";

        content += "1-) Rental count per location\n";
        for (LocationCount locationCount : locationCounts) {
            content += locationCount.getLocation() + ": " + locationCount.getCount() + " rentals\n";
        }

        content += "2-) Top 10 most reputable homeowners\n";
        for (HomeownerReputation homeownerReputation : homeownerReputations) {
            content += homeownerReputation.getFullName() + ": " + homeownerReputation.getReputation() + " reputation\n";
        }

        content += "3-) Top 10 rental ratings\n";
        for (RentalRating rentalRating : rentalRatings) {
            content += rentalRating.getRentalId() + ": " + rentalRating.getRating() + ", Location: " + rentalRating.getLocation();
        } 

        content += "4-) Top 10 most expensive rentals\n";
        for (RentalPrice rentalPrice : mostRentalPrices) {
            content += rentalPrice.getRentalId() + ": " + rentalPrice.getPrice() + ", Location: " + rentalPrice.getLocation();
        }

        content += "5-) Top 10 least expensive rentals\n";
        for (RentalPrice rentalPrice : leastRentalPrices) {
            content += rentalPrice.getRentalId() + ": " + rentalPrice.getPrice() + ", Location: " + rentalPrice.getLocation();
        }

        return jdbcTemplate.update(sql, new Object[] { systemReport.getTitle(), content, systemReport.getAdminId() });
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
    public List<HomeownerReputation> getMostReputableHomeowners() {
        final String sql = "SELECT full_name, reputation FROM HomeownerView ORDER BY reputation DESC LIMIT 10";

        List<HomeownerReputation> objects = jdbcTemplate.query(sql, (resultSet, i) -> {
            String fullName = resultSet.getString("full_name");
            float reputation = resultSet.getFloat("reputation");
            return new HomeownerReputation(
                fullName,
                reputation
            );
        });
        return objects;
    }

    @Override
    public List<RentalRating> getHighestRatedRentals() {
        final String sql = "SELECT rental_id, location, rating FROM rental ORDER BY rating DESC LIMIT 10";

        List<RentalRating> objects = jdbcTemplate.query(sql, (resultSet, i) -> {
            UUID id = UUID.fromString(resultSet.getString("rental_id"));
            String location = resultSet.getString("location");
            int rating = resultSet.getInt("rating");
            return new RentalRating(
                id,
                location,
                rating
            );
        });
        return objects;
    }

    @Override
    public List<RentalPrice> getMostExpensiveRentals() {
        final String sql = "SELECT rentalId, location, price FROM rental ORDER BY price DESC LIMIT 10";

        List<RentalPrice> objects = jdbcTemplate.query(sql, (resultSet, i) -> {
            UUID id = UUID.fromString(resultSet.getString("rental_id"));
            String location = resultSet.getString("location");
            float price = resultSet.getFloat("price");
            return new RentalPrice(
                id,
                location,
                price
            );
        });
        return objects;
    }

    @Override
    public List<RentalPrice> getLeastExpensiveRentals() {
        final String sql = "SELECT rentalId, location, price FROM rental ORDER BY price ASC LIMIT 10";

        List<RentalPrice> objects = jdbcTemplate.query(sql, (resultSet, i) -> {
            UUID id = UUID.fromString(resultSet.getString("rental_id"));
            String location = resultSet.getString("location");
            float price = resultSet.getFloat("price");
            return new RentalPrice(
                id,
                location,
                price
            );
        });
        return objects;
    }
    
}
