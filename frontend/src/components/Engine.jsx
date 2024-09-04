import React from "react";
import ChoiceList from "./ChoiceList";
import {EngineConfiguration, EngineType} from "../entities/enums";

export default function Engine({configuration, onConfigChanged}) {

    return (
        <table className="table is-striped is-narrow is-fullwidth">
            <thead>
            <tr>
                <th>Engine</th>
                <th>Options</th>
            </tr>
            </thead>

            <tbody>
            <ChoiceList
                description={"Engine Type"}
                choices={{
                    "2000 M96": EngineType.M96_2000,
                    "2000 M96 - with Gearbox type": EngineType.M96_2000_WITH_GEARBOX
                }}
                activeChoice={configuration.engineType}
                onChoiceClicked={(choice) => onConfigChanged({...configuration, engineType: choice})}
            />
            <ChoiceList
                description={"Configuration"}
                choices={configuration.engineType === EngineType.M96_2000 ? {
                    "10V": EngineConfiguration.V10,
                    "12V (1": EngineConfiguration.V12_A,
                    "12V (2": EngineConfiguration.V12_B,
                    "16V": EngineConfiguration.V16} : {
                    "10V - ZF 2050": EngineConfiguration.V10_ZF2050,
                    "12V - ZF 2060 (1": EngineConfiguration.V12_ZF2060_A,
                    "12V - ZF 2060 (2": EngineConfiguration.V12_ZF2060_B,
                    "16V - ZF 3060": EngineConfiguration.V16_ZF3060
                }}
                activeChoice={configuration.engineConfiguration}
                onChoiceClicked={(choice) => onConfigChanged({...configuration, engineConfiguration: choice})}
            />
            </tbody>
        </table>
    );
}