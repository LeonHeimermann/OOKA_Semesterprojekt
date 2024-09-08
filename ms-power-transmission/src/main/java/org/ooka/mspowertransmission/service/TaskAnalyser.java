package org.ooka.mspowertransmission.service;

import lombok.RequiredArgsConstructor;
import org.ooka.mspowertransmission.model.AnalysisConfigurationRequestModel;
import org.ooka.mspowertransmission.model.AnalysisResultModel;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TaskAnalyser {

    public AnalysisResultModel analyse(AnalysisConfigurationRequestModel analysisConfigurationRequestModel) {
        String result = String.format("Engine Type: %s, Engine Configuration: %s - result: Engine is good",
                analysisConfigurationRequestModel.getEngineType(),
                analysisConfigurationRequestModel.getEngineConfiguration()
        );
        return AnalysisResultModel.builder()
                .result(result)
                .build();
    }

}
