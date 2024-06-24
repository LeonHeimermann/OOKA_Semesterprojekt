import React from "react";
import OptionalEquipment from "./OptionalEquipment";
import EngineType from "./EngineType";
import {Status} from "../entites/Status";

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
    const [status, setStatus] = React.useState({
        startingSystem: Status.WAITING,
        auxiliaryPTO: Status.WAITING,
        oilSystem: Status.WAITING,
        fuelSystem: Status.WAITING,
        coolingSystem: Status.WAITING,
        exhaustSystem: Status.WAITING,
        mountingSystem: Status.WAITING,
        engineManagementSystem: Status.WAITING,
        monitoringSystem: Status.WAITING,
        powerTransmission: Status.WAITING,
        gearboxOptions: Status.WAITING,
    })
    const [startEnabled, setStartEnabled] = React.useState(true);

    React.useEffect(() => {
        const bffEvents = new EventSource("http://localhost:8085/analysis/sse");
        bffEvents.onmessage = (event) => {
            updateStatus(JSON.parse(event.data));
        };
        bffEvents.onerror = () => console.error("Verbindung fehlgeschlagen !");
        bffEvents.onopen = () => console.log("Verbindung erfolgreich");
    }, [])

    function updateStatus(result) {
        if(result.service === "auxiliarysystems") {
            setStatus((oldState) => {
                return {
                    ...oldState,
                    auxiliaryPTO: result.success ? Status.SUCCESS : Status.ERROR
                };
            });
        } else if (result.service === "controlsystems") {
            setStatus((oldState) => {
                return {
                    ...oldState,
                    startingSystem: result.success ? Status.SUCCESS : Status.ERROR,
                    engineManagementSystem: result.success ? Status.SUCCESS : Status.ERROR,
                    monitoringSystem: result.success ? Status.SUCCESS : Status.ERROR
                };
            });
        } else if (result.service === "enginesystems") {
            setStatus((oldState) => {
                return {
                    ...oldState,
                    oilSystem: result.success ? Status.SUCCESS : Status.ERROR,
                    fuelSystem: result.success ? Status.SUCCESS : Status.ERROR,
                    coolingSystem: result.success ? Status.SUCCESS : Status.ERROR,
                    exhaustSystem: result.success ? Status.SUCCESS : Status.ERROR
                };
            });
        } else if (result.service === "mountingsystems") {
            setStatus((oldState) => {
                return {
                    ...oldState,
                    mountingSystem: result.success ? Status.SUCCESS : Status.ERROR
                };
            });
        } else if (result.service === "powertransmission") {
            setStatus((oldState) => {
                return {
                    ...oldState,
                    powerTransmission: result.success ? Status.SUCCESS : Status.ERROR,
                    gearboxOptions: result.success ? Status.SUCCESS : Status.ERROR
                };
            });
        }
    }

    function startAnalysis() {
        setStartEnabled(false);

        const newStatus = {...status};
        Object.keys(newStatus).forEach((s) => newStatus[s] = Status.RUNNING);
        setStatus(newStatus);

        fetch("http://localhost:8085/analysis", {
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
                status={status}
                enableStart={startEnabled}
                showStartingSystem={configuration.engine.cylinder_config !== 0}
                onConfigChanged={(newEquipmentConfig) => setConfiguration({...configuration, optionalEquipment: newEquipmentConfig})}
                onStart={() => startAnalysis()}
            />
        </>
    );
}