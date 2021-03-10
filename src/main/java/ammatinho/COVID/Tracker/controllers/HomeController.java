package ammatinho.COVID.Tracker.controllers;

import ammatinho.COVID.Tracker.models.LocationStats;
import ammatinho.COVID.Tracker.services.COVIDDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    COVIDDataService COVIDDataService;

    @GetMapping("/")
    public String home(Model model) {
        List<LocationStats> allStats = COVIDDataService.getAllStats();
        int totalReportedCases = allStats.stream().mapToInt(stat -> stat.getLatestReportedCases()).sum();
        int totalReportedNewCases = allStats.stream().mapToInt(stat -> stat.getDiffFromPrevDay()).sum();
        model.addAttribute("locationStats", allStats);
        model.addAttribute("totalReportedCases", totalReportedCases);
        model.addAttribute("totalReportedNewCases", totalReportedNewCases);

        return "home";
    }
}
