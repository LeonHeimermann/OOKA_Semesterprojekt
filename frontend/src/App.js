import './App.css';
import MicroserviceController from "./components/MicroserviceController";
import ConfigurationController from "./components/ConfigurationController";
import SaveConfigurationModal from "./components/SaveConfigurationModal";
import React from "react";
import LoadConfigurationModal from "./components/LoadConfigurationModal";
import {
    AuxiliaryPTO,
    CoolingSystem,
    EngineConfiguration, EngineManagementSystem,
    EngineType, ExhaustSystem,
    FuelSystem, GearboxOptions, MonitoringSystem, MountingSystem,
    OilSystem, PowerTransmission,
    StartingSystem
} from "./entities/enums";
import {Status} from "./entities/Status";


const microservices = [
    {name: "Engine Systems"},
    {name: "Power Transmission"},
    {name: "Control Systems"},
    {name: "Auxiliary Systems"},
    {name: "Mounting Systems"}
];

function App() {

    let internalStatus = {
        auxiliarySystems: Status.WAITING,
        controlSystems: Status.WAITING,
        engineSystems: Status.WAITING,
        mountingSystems: Status.WAITING,
        powerTransmission: Status.WAITING,
    }

    const [showSaveModal, setShowSaveModal] = React.useState(false);
    const [showLoadModal, setShowLoadModal] = React.useState(false);
    const [loadedConfigurations, setLoadedConfigurations] = React.useState([]);
    const [configuration, setConfiguration] = React.useState({
        engineType: EngineType.M96_2000,
        engineConfiguration: EngineConfiguration.V10,
        startingSystem: StartingSystem.AIR_STARTER,
        auxiliaryPTO: AuxiliaryPTO.ALTERNATOR,
        oilSystem: OilSystem.REPLENISHMENT,
        fuelSystem: FuelSystem.PRE_FILTER,
        coolingSystem: CoolingSystem.COOLANT_PREHEATING,
        exhaustSystem: ExhaustSystem.EXHAUST_DISCHARGE_ROTATABLE,
        mountingSystem: MountingSystem.RESILIANT_MOUNTS,
        engineManagementSystem: EngineManagementSystem.SOCIETY_REGULATIONS,
        monitoringSystem: MonitoringSystem.BLUE_VISION,
        powerTransmission: PowerTransmission.TORSIONALLY_RESILLIANT_COUPLING,
        gearboxOption: GearboxOptions.REVERSE_REDUCTION
    });
    const [startButtonEnabled, setStartButtonEnabled] = React.useState(true);
    const [serviceStatus, setServiceStatus] = React.useState(internalStatus)

    function saveConfiguration(title, description) {
        fetch("http://localhost:8085/configuration",{
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify({
                ...configuration,
                title: title,
                description: description
            })
        })
            .then(response => {
                if(response.status === 200) {
                    setShowSaveModal(false);
                } else {
                    alert("Speichern fehlgeschlagen: " + response);
                }
            })
            .catch(reason => alert(reason));
    }

    function loadConfigurations() {
        fetch("http://localhost:8085/configuration")
            .then(async response => setLoadedConfigurations(await response.json()))
            .catch(reason => alert(reason))

        setShowLoadModal(true)
    }

    function startAnalysis() {
        setStartButtonEnabled(false);

        Object.keys(internalStatus).forEach((s) => internalStatus[s] = Status.RUNNING);
        setServiceStatus(internalStatus);

        fetch("http://localhost:8085/analysis", {
            method: "POST",
            mode: 'cors',
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(configuration)
        }).then(async (response) => {
            console.log("started analysis...");
            setStartButtonEnabled(false);

            const reader = response.body.getReader();
            while (true) {
                const {value, done} = await reader.read();
                if (done) break;

                const eventData = new TextDecoder().decode(value);
                if (eventData.startsWith("data:")) {
                    const analysisResult = JSON.parse(eventData.split("data:")[1])
                    updateStatus(analysisResult)
                }
            }
            console.log("stream finished")
        }).catch(error => {
            console.error(error);
        }).then(() => setStartButtonEnabled(true))
    }

    function updateStatus(result) {
        console.log(serviceStatus)
        switch (result.serviceId) {
            case "auxiliary-systems":
                internalStatus = {...internalStatus, auxiliarySystems: result.result == "success" ? Status.SUCCESS : Status.ERROR}
                setServiceStatus(internalStatus)
                break;
            case "engine-systems":
                internalStatus = {...internalStatus, engineSystems: result.result == "success" ? Status.SUCCESS : Status.ERROR}
                setServiceStatus(internalStatus)
                break;
            case "control-systems":
                internalStatus = {...internalStatus, controlSystems: result.result == "success" ? Status.SUCCESS : Status.ERROR}
                setServiceStatus(internalStatus)
                break;
            case "power-transmission":
                internalStatus = {...internalStatus, powerTransmission: result.result == "success" ? Status.SUCCESS : Status.ERROR}
                setServiceStatus(internalStatus)
                break;
            case "mounting-systems":
                internalStatus = {...internalStatus, mountingSystems: result.result == "success" ? Status.SUCCESS : Status.ERROR}
                setServiceStatus(internalStatus)
                break;
        }
    }

    return (
        <>
            <ConfigurationController configuration={configuration}
                                     serviceStatus={serviceStatus}
                                     enableAnalysisStart={startButtonEnabled}
                                     onConfigChanged={(config) => setConfiguration(config)}
                                     onStartClicked={() => startAnalysis()}
                                     onSaveClicked={() => setShowSaveModal(true)}
                                     onLoadClicked={() => loadConfigurations()}
            />
            <MicroserviceController services={microservices} />

            <SaveConfigurationModal isActive={showSaveModal}
                                    onSave={saveConfiguration}
                                    onClose={() => setShowSaveModal(false)}
            />
            <LoadConfigurationModal configuratons={loadedConfigurations}
                                    isActive={showLoadModal}
                                    onLoad={(configuration) => {setShowLoadModal(false); setConfiguration(configuration)}}
                                    onClose={() => setShowLoadModal(false)}
            />
        </>
    );
}

export default App;