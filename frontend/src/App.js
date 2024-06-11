import './App.css';
import OptionalEquipment from "./components/OptionalEquipment";

const optionalEqipment = [
    { name: "Starting system", choices: ["Air starter"] },
    { name: "Auxiliary PTO", choices: ["Alternator", "140A or 190A", "28V", "2 pole", "bilgepump", "on-engine PTOs"] },
    { name: "Oil System", choices: ["Oil replenishment system", "diverter valve for duplex system"] },
    { name: "Fuel System", choices: ["Duplex fuel pre-filter", "diverter valve for fuel filter", "monitoring fuel leakage"] },
    { name: "Cooling System", choices: ["Coolant preheating system freestanding or engine mounted", "integrated seawater gearbox piping"] },
    { name: "Exhaust System", choices: ["90° Exhaust bellows discharge rotatable"] },
    { name: "Mounting System", choices: ["Resilient mounts at driving end"] },
    { name: "Engine Management System", choices: ["In compliance with Classification Society Regulations"] },
    { name: "Monitoring/Control System", choices: ["BlueVision|New Generation"] },
    { name: "Power Transmission", choices: ["Torsionally resilient coupling"] },
    { name: "Gearbox Options", choices: ["Reverse reduction gearbox", "el. actuated", "gearbox mounts", "trolling mode for dead-slow propulsion", "free auxiliary PTO", "hydraulic pump drives"] },
];

function App() {
  return (
      <>
        <table className="table is-striped is-fullwidth">
            <thead>
                <tr>
                    <th>Optional Equipment</th>
                    <th>Options</th>
                    <th>Status</th>
                </tr>
            </thead>
            <tbody>
                {optionalEqipment.map((option, index) => (
                    <OptionalEquipment name={option.name} choices={option.choices} key={option.name} />
                ))}
            </tbody>
        </table>
      </>
  );
}

export default App;
