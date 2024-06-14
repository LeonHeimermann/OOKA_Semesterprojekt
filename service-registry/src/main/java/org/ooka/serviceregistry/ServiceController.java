package org.ooka.serviceregistry;

import com.netflix.discovery.shared.Application;
import com.netflix.eureka.EurekaServerContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping()
public class ServiceController {

    @GetMapping("/registered-apps")
    public List<Application> getRegisteredApps() {
        var apps = EurekaServerContextHolder.getInstance().getServerContext().getRegistry().getApplications();
        return apps.getRegisteredApplications();
    }
}
