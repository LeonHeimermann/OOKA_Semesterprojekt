import './App.css';
import MicroserviceController from "./components/MicroserviceController";
import ConfigurationController from "./components/ConfigurationController";
import SaveConfigurationModal from "./components/SaveConfigurationModal";
import React from "react";


const microservices = [
    {name: "Engine Systems"},
    {name: "Power Transmission"},
    {name: "Control Systems"},
    {name: "Auxiliary Systems"},
    {name: "Mounting Systems"}
];

function App() {

    const [showSaveModal, setShowSaveModal] = React.useState(false);

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
        }).then(response => alert(response.status))
    }

    return (
        <>
            <ConfigurationController onSaveClicked={() => setShowSaveModal(true)}/>
            <MicroserviceController services={microservices}/>

            <SaveConfigurationModal isActive={showSaveModal} onSave={saveConfiguration} onClose={() => setShowSaveModal(false)}/>
        </>
    );
}

export default App;