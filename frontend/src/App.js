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


const microservices = [
    {name: "Engine Systems"},
    {name: "Power Transmission"},
    {name: "Control Systems"},
    {name: "Auxiliary Systems"},
    {name: "Mounting Systems"}
];

function App() {

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

    return (
        <>
            <ConfigurationController configuration={configuration}
                                     onConfigChanged={(config) => setConfiguration(config)}
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