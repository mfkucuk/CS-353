package com.group18.api;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.group18.models.SystemReport;
import com.group18.service.SystemReportService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/system-report")
@RequiredArgsConstructor
public class SystemReportController 
{

    private final SystemReportService systemReportService;

    @PostMapping
    public int insertSystemReport(@RequestBody SystemReport systemReport) 
    {
        return systemReportService.insertSystemReport(systemReport);
    }

    @GetMapping
    public List<SystemReport> getAllSystemReports() 
    {
        return systemReportService.getAllSystemReports();
    }
}
