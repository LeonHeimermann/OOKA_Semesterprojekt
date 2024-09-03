import React from "react";
import ChoiceList from "./ChoiceList";
import {Status} from "../entites/Status";

export default function OptionalEquipment({configuration, onConfigChanged, enableStart, onStart, status, showStartingSystem}) {

    function result() {
        const stats = Object.keys(status);

        if(stats.filter((service) => status[service] === Status.WAITING || status[service] === Status.RUNNING).length > 0) {
            return {
                label: "Waiting",
                color: ""
            }
        } else if (stats.filter((stat) => status[stat] === Status.ERROR).length > 0) {
            return {
                label: "Failed",
                color: "is-danger"
            }
        }

        return {
            label: "Success",
            color: "is-success"
        }
    }

    return (
        <table className="table is-striped is-narrow is-fullwidth">
            <thead>
            <tr>
                <th>Optional Equipment</th>
                <th>Options</th>
                <th className="has-text-centered" style={{width: "13rem"}}>Status</th>
            </tr>
            </thead>
            <tbody>
                { showStartingSystem ?
                    <ChoiceList
                        description={"Starting system"}
                        choices={["Air starter"]}
                        activeChoice={configuration.starting_system}
                        onChoiceClicked={(choice) => onConfigChanged({...configuration, starting_system: choice})}
                        status={status.startingSystem}
                    /> : null
                }
                <ChoiceList
                    description={"Auxiliary PTO"}
                    choices={["Alternator", "140A or 190A", "28V", "2 pole", "bilgepump", "on-engine PTOs"]}
                    activeChoice={configuration.auxiliary_pto}
                    onChoiceClicked={(choice) => onConfigChanged({...configuration, auxiliary_pto: choice})}
                    status={status.auxiliaryPTO}
                />
                <ChoiceList
                    description={"Oil System"}
                    choices={["Oil replenishment system", "diverter valve for duplex system"]}
                    activeChoice={configuration.oil_system}
                    onChoiceClicked={(choice) => onConfigChanged({...configuration, oil_system: choice})}
                    status={status.oilSystem}
                />
                <ChoiceList
                    description={"Fuel System"}
                    choices={["Duplex fuel pre-filter", "diverter valve for fuel filter", "monitoring fuel leakage"]}
                    activeChoice={configuration.fuel_system}
                    onChoiceClicked={(choice) => onConfigChanged({...configuration, fuel_system: choice})}
                    status={status.fuelSystem}
                />
                <ChoiceList
                    description={"Cooling System"}
                    choices={["Coolant preheating system freestanding or engine mounted", "integrated seawater gearbox piping"]}
                    activeChoice={configuration.cooling_system}
                    onChoiceClicked={(choice) => onConfigChanged({...configuration, cooling_system: choice})}
                    status={status.coolingSystem}
                />
                <ChoiceList
                    description={"Exhaust System"}
                    choices={["90° Exhaust bellows discharge rotatable"]}
                    activeChoice={configuration.exhaust_system}
                    onChoiceClicked={(choice) => onConfigChanged({...configuration, exhaust_system: choice})}
                    status={status.exhaustSystem}
                />
                <ChoiceList
                    description={"Mounting System"}
                    choices={["Resilient mounts at driving end"]}
                    activeChoice={configuration.mounting_system}
                    onChoiceClicked={(choice) => onConfigChanged({...configuration, mounting_system: choice})}
                    status={status.mountingSystem}
                />
                <ChoiceList
                    description={"Engine Management System"}
                    choices={["In compliance with Classification Society Regulations"]}
                    activeChoice={configuration.engine_management_system}
                    onChoiceClicked={(choice) => onConfigChanged({...configuration, engine_management_system: choice})}
                    status={status.engineManagementSystem}
                />
                <ChoiceList
                    description={"Monitoring/Control System"}
                    choices={["BlueVision|New Generation"]}
                    activeChoice={configuration.monitoring_system}
                    onChoiceClicked={(choice) => onConfigChanged({...configuration, monitoring_system: choice})}
                    status={status.monitoringSystem}
                />
                <ChoiceList
                    description={"Power Transmission"}
                    choices={["Torsionally resilient coupling"]}
                    activeChoice={configuration.power_transmission}
                    onChoiceClicked={(choice) => onConfigChanged({...configuration, power_transmission: choice})}
                    status={status.powerTransmission}
                />
                <ChoiceList
                    description={"Gearbox Options"}
                    choices={["Reverse reduction gearbox", "el. actuated", "gearbox mounts", "trolling mode for dead-slow propulsion", "free auxiliary PTO", "hydraulic pump drives"]}
                    activeChoice={configuration.gearbox_options}
                    onChoiceClicked={(choice) => onConfigChanged({...configuration, gearbox_options: choice})}
                    status={status.gearboxOptions}
                />
            </tbody>
            <tfoot>
            <tr>
                <td className="is-size-5">
                    <button className="button is-primary"
                        onClick={() => onStart("Start clicked")}
                        disabled={!enableStart}>
                            Start analysis
                    </button>
                </td>
                <td className="is-size-5 has-text-right">
                    Result
                </td>
                <td>
                    <span className={`tag is-large is-full-width ${result().color}`}>{result().label}</span>
                </td>
            </tr>
            </tfoot>
        </table>
    );
}