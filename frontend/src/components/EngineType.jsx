import React from "react";
import ChoiceList from "./ChoiceList";

export default function EngineType({engines, onSelectionChanged}) {

    const [selectedEngine, setSelectedEngine] = React.useState(0);
    const [selectedConfiguration, setSelectedConfiguration] = React.useState(0);

    function changeEngine(engine) {
        onSelectionChanged({
            engine: engines[engine].name,
            configuration: engines[engine].configurations[selectedConfiguration],
        })

        setSelectedEngine(engine);
    }

    function changeConfiguration(configuration) {
        onSelectionChanged({
            engine: engines[selectedEngine].name,
            configuration: engines[selectedEngine].configurations[configuration],
        })

        setSelectedConfiguration(configuration);
    }

    return (
        <table className="table is-striped is-narrow is-fullwidth">
            <thead>
                <tr>
                    <th>Engine</th>
                    <th>Options</th>
                </tr>
            </thead>

            <tbody>
                <tr>
                    <td className="is-size-5">Engine Type</td>
                    <td>
                        <ChoiceList className="tabs is-toggle is-gapless"
                            choices={engines.map(engine => engine.name)}
                            activeChoice={selectedEngine}
                            onChoiceClicked={changeEngine}
                        />
                    </td>
                </tr>
                <tr>
                    <td className="is-size-5">Configuration</td>
                    <td>
                        <ChoiceList className="tabs is-toggle is-gapless"
                            choices={engines[selectedEngine].configurations}
                            activeChoice={selectedConfiguration}
                            onChoiceClicked={changeConfiguration}
                        />
                    </td>
                </tr>
            </tbody>
        </table>
    );
}