package org.ooka.bffservice.task;

import lombok.RequiredArgsConstructor;
import org.ooka.bffservice.model.AnalyseRequestModel;
import org.ooka.bffservice.model.AnalyseResponseModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @PostMapping("/create")
    public ResponseEntity<AnalyseResponseModel> createTask(@RequestBody AnalyseRequestModel analyseRequestModel) {
        String taskId = taskService.submitTaskRequest(analyseRequestModel);
        AnalyseResponseModel analyseResponseModel = new AnalyseResponseModel(taskId);
        return ResponseEntity.ok(analyseResponseModel);
    }

    @GetMapping("/results/{taskId}")
    public ResponseEntity<TaskResultDto> getResults(@PathVariable("taskId") String taskId) {
        TaskResultDto taskResultDto = taskService.getResults(taskId);
        return ResponseEntity.ok(taskResultDto);
    }

}
