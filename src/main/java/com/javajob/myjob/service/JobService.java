package  com.javajob.myjob.service;

import  java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.javajob.myjob.model.Job;

@Service
public class JobService {

    private final String API_URL = "https://remotive.com/api/remote-jobs";

    public List<Job> getFilteredJobs(String skills) {

        RestTemplate restTemplate = new RestTemplate();
        Map response = restTemplate.getForObject(API_URL, Map.class);

        List<Map<String, Object>> jobList = (List<Map<String, Object>>) response.get("jobs");

        List<Job> filteredJobs = new ArrayList<>();

        List<String> skillList = Arrays.asList(skills.toLowerCase().split(","));

        for (Map<String, Object> job : jobList) {
            String title = job.get("title").toString().toLowerCase();
            String description = job.get("description").toString().toLowerCase();

            boolean match = skillList.stream().anyMatch(skill ->
                    title.contains(skill.trim()) || description.contains(skill.trim())
            );

            if (match) {
                filteredJobs.add(new Job(
                        job.get("title").toString(),
                        job.get("company_name").toString(),
                        job.get("candidate_required_location").toString(),
                        job.get("url").toString()
                ));
            }
        }

        return filteredJobs;
    }
}
