import React from "react";
import ChoiceList from "./ChoiceList";

export default function EngineType({configuration, onConfigChanged}) {

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
                choices={["2000 M96", "2000 M96 - with Gearbox type"]}
                activeChoice={configuration.type}
                onChoiceClicked={(choice) => onConfigChanged({...configuration, type: choice})}
            />
            <ChoiceList
                description={"Configuration"}
                choices={configuration.type === 0 ? ["10V", "12V", "12V", "16V"] : ["10V - ZF 2050", "12V - ZF 2060", "12V - ZF 2060", "16V - ZF 3060"]}
                activeChoice={configuration.cylinder_config}
                onChoiceClicked={(choice) => onConfigChanged({...configuration, cylinder_config: choice})}
            />
            </tbody>
        </table>
    );
}