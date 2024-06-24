import React from "react";
import OptionalEquipment from "./OptionalEquipment";
import EngineType from "./EngineType";


export default function ConfigurationController() {

    const [configuration, setConfiguration] = React.useState({
        engine: {
            type: 0,
            cylinder_config: 0,
        },
        optionalEquipment: {
            starting_system: 0,
            auxiliary_pto: 0,
            oil_system: 0,
            fuel_system: 0,
            cooling_system: 0,
            exhaust_system: 0,
            mounting_system: 0,
            engine_management_system: 0,
            monitoring_system: 0,
            power_transmission: 0,
            gearbox_options: 0
        }
    });

    function startAnalysis() {
        fetch("http://localhost:8087/analysis", {
            method: "POST",
            body: JSON.stringify(configuration)
        }).then(() => {
            console.log("started analysis");
        }).catch(error => {
            console.error(error);
        })
    }

    return (
        <>
            <EngineType
                configuration={configuration.engine}
                onConfigChanged={(newEngineConfig) => setConfiguration({...configuration, engine: newEngineConfig})}
            />
            <OptionalEquipment
                configuration={configuration.optionalEquipment}
                showStartingSystem={configuration.engine.cylinder_config !== 0}
                onConfigChanged={(newEquipmentConfig) => setConfiguration({...configuration, optionalEquipment: newEquipmentConfig})}
                onStart={() => startAnalysis()}
            />
        </>
    );
}