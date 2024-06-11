import './App.css';
import OptionalEquipment from "./components/OptionalEquipment";
import Microservice from "./components/Microservice";

const optionalEquipment = [
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

const microservices = [
    { name: "Engine Systems", url: "http://localhost:8082" },
    { name: "Power Transmission", url: "http://localhost:8084" },
    { name: "Control Systems", url: "http://localhost:8081" },
    { name: "Auxiliary Systems", url: "http://localhost:8080" },
    { name: "Mounting Systems", url: "http://localhost:8083" }
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
                {optionalEquipment.map((option, index) => (
                    <OptionalEquipment name={option.name} choices={option.choices} key={option.name + index} />
                ))}
            </tbody>
            <tfoot>
                <tr>
                    <td className="is-size-5">
                        <button className="button is-primary">Start</button>
                    </td>
                    <td className="is-size-5 has-text-right">
                        Result
                    </td>
                    <td>
                        <span className="tag is-large">...</span>
                    </td>
                </tr>
            </tfoot>
        </table>

          <table className="table is-striped is-fullwidth">
              <thead>
              <tr>
                  <th>Microservice</th>
                  <th className="is-narrow has-text-centered">Status</th>
              </tr>
            </thead>
            <tbody>
                {microservices.map((microservice, index) => (
                    <Microservice name={microservice.name} serviceUrl={microservice.url} key={microservice.name + index} />
                ))}
            </tbody>
        </table>
      </>
  );
}

export default App;
