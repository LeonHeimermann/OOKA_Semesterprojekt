import React from "react";
import OptionalEquipment from "./OptionalEquipment";
import Engine from "./Engine";
import {EngineConfiguration} from "../entities/enums";

export default function ConfigurationController({configuration, serviceStatus, enableAnalysisStart, onConfigChanged, onStartClicked, onSaveClicked, onLoadClicked}) {

    return (
        <>
            <Engine
                configuration={configuration}
                onConfigChanged={onConfigChanged}
            />
            <OptionalEquipment
                configuration={configuration}
                status={serviceStatus}
                enableStart={enableAnalysisStart}
                showStartingSystem={configuration.engineConfiguration !== EngineConfiguration.V10 && configuration.engineConfiguration !== EngineConfiguration.V10_ZF2050}
                onConfigChanged={onConfigChanged}
                onStart={() => onStartClicked()}
                onSaveClicked={() => onSaveClicked()}
                onLoadClicked={() => onLoadClicked()}
            />
        </>
    );
}