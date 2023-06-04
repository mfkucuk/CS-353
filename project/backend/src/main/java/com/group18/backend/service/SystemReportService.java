package com.group18.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.group18.backend.dao.SystemReportDAO;
import com.group18.backend.models.SystemReport;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SystemReportService 
{
    private final SystemReportDAO systemReportDAO;

    public String insertSystemReport(SystemReport systemReport) 
    {
        return systemReportDAO.insertSystemReport(systemReport);
    }

    public List<SystemReport> getAllSystemReports() 
    {
        return systemReportDAO.getAllSystemReports();
    }
}
