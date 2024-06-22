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
    optionalEquipment: [
        {
            name: "Starting system",
            choices: ["Air starter"]
        },
        {
            name: "Auxiliary PTO",
            choices: ["Alternator", "140A or 190A", "28V", "2 pole", "bilgepump", "on-engine PTOs"]
        },
        {
            name: "Oil System",
            choices: ["Oil replenishment system", "diverter valve for duplex system"]
        },
        {
            name: "Fuel System",
            choices: ["Duplex fuel pre-filter", "diverter valve for fuel filter", "monitoring fuel leakage"]
        },
        {
            name: "Cooling System",
            choices: ["Coolant preheating system freestanding or engine mounted", "integrated seawater gearbox piping"]
        },
        {
            name: "Exhaust System",
            choices: ["90° Exhaust bellows discharge rotatable"]
        },
        {
            name: "Mounting System",
            choices: ["Resilient mounts at driving end"]
        },
        {
            name: "Engine Management System",
            choices: ["In compliance with Classification Society Regulations"]
        },
        {
            name: "Monitoring/Control System",
            choices: ["BlueVision|New Generation"]
        },
        {
            name: "Power Transmission",
            choices: ["Torsionally resilient coupling"]
        },
        {
            name: "Gearbox Options",
            choices: ["Reverse reduction gearbox", "el. actuated", "gearbox mounts", "trolling mode for dead-slow propulsion", "free auxiliary PTO", "hydraulic pump drives"]
        },
    ]
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
            <ConfigurationController configuration={configuration}/>

            <MicroserviceController services={microservices}/>
        </>
    );
}

export default App;
