import './App.css';
import MicroserviceController from "./components/MicroserviceController";
import ConfigurationController from "./components/ConfigurationController";


const microservices = [
    {name: "Engine Systems"},
    {name: "Power Transmission"},
    {name: "Control Systems"},
    {name: "Auxiliary Systems"},
    {name: "Mounting Systems"}
];

function App() {

    return (
        <>
            <ConfigurationController/>

            <MicroserviceController services={microservices}/>
        </>
    );
}

export default App;