import './App.css';
import MicroserviceController from "./components/MicroserviceController";
import ConfigurationController from "./components/ConfigurationController";


const configuration = {
    engines: [
        {
            name: "2000 M96",
            configurations: ["10V", "12V", "12V", "16V"]
        },
        {
            name: "2000 M96 - with Gearbox type",
            configurations: ["10V - ZF 2050", "12V - ZF 2060", "12V - ZF 2060", "16V - ZF 3060"]
        },
    ],
}

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
