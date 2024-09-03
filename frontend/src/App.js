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
        alert(title, description)
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