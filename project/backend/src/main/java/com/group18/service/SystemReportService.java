package com.group18.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.group18.dao.SystemReportDAO;
import com.group18.models.SystemReport;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SystemReportService 
{
    private final SystemReportDAO systemReportDAO;

    public int insertSystemReport(SystemReport systemReport) 
    {
        return systemReportDAO.insertSystemReport(systemReport);
    }

    public List<SystemReport> getAllSystemReports() 
    {
        return systemReportDAO.getAllSystemReports();
    }
}
