import './App.css';
import MicroserviceController from "./components/MicroserviceController";
import ConfigurationController from "./components/ConfigurationController";
import SaveConfigurationModal from "./components/SaveConfigurationModal";
import React from "react";
import LoadConfigurationModal from "./components/LoadConfigurationModal";


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

    function saveConfiguration(title, description) {
        fetch("http://localhost:8085/configuration",{
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify({
                title: title,
                description: description,
                // testdata - replace with real configuration later
                engineType: "M96_2000",
                engineConfiguration: "V10",
                startingSystem: "AIR_STARTER",
                auxiliaryPTO: "ALTERNATOR",
                oilSystem: "DIVERTER_VALVE",
                fuelSystem: "MONITORING_FUEL_LEAKAGE",
                coolingSystem: "SEAWATER_PIPING",
                exhaustSystem: "EXHAUST_DISCHARGE_ROTATABLE",
                mountingSystem: "RESILIANT_MOUNTS",
                engineManagementSystem: "SOCIETY_REGULATIONS",
                monitoringSystem: "BLUE_VISION",
                powerTransmission: "TORSIONALLY_RESILLIANT_COUPLING",
                gearboxOption: "HYDRAULIC_PUMP_DRIVES"
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
            <ConfigurationController onSaveClicked={() => setShowSaveModal(true)}
                                     onLoadClicked={() => loadConfigurations()}
            />
            <MicroserviceController services={microservices} />

            <SaveConfigurationModal isActive={showSaveModal}
                                    onSave={saveConfiguration}
                                    onClose={() => setShowSaveModal(false)}
            />
            <LoadConfigurationModal configuratons={loadedConfigurations}
                                    isActive={showLoadModal}
                                    onLoad={(configuration) => {setShowLoadModal(false); alert(configuration)}}
                                    onClose={() => setShowLoadModal(false)}
            />
        </>
    );
}

export default App;