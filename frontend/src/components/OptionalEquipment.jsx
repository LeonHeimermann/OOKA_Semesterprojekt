import React from "react";
import ChoiceList from "./ChoiceList";
import {Status} from "../entities/Status";
import {
    AuxiliaryPTO,
    CoolingSystem, EngineManagementSystem,
    ExhaustSystem,
    FuelSystem,
    GearboxOptions, MonitoringSystem, MountingSystem,
    OilSystem, PowerTransmission,
    StartingSystem
} from "../entities/enums";

export default function OptionalEquipment({configuration, onConfigChanged, enableStart, onStart, status, showStartingSystem, onSaveClicked, onLoadClicked}) {

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
                    choices={{
                        "Air starter": StartingSystem.AIR_STARTER
                    }}
                    activeChoice={configuration.startingSystem}
                    onChoiceClicked={(choice) => onConfigChanged({...configuration, startingSystem: choice})}
                    status={status.engineSystems}
                /> : null
            }
            <ChoiceList
                description={"Auxiliary PTO"}
                choices={{
                    "Alternator": AuxiliaryPTO.ALTERNATOR,
                    "140A or 190A": AuxiliaryPTO.A140_OR_A190,
                    "28V": AuxiliaryPTO.V28,
                    "2 pole": AuxiliaryPTO.TWO_POLE,
                    "bilgepump": AuxiliaryPTO.BILGEPUMP,
                    "on-engine PTOs": AuxiliaryPTO.ON_ENGINE_PTO
                }}
                activeChoice={configuration.auxiliaryPTO}
                onChoiceClicked={(choice) => onConfigChanged({...configuration, auxiliaryPTO: choice})}
                status={status.auxiliarySystems}
            />
            <ChoiceList
                description={"Oil System"}
                choices={{
                    "Oil replenishment system": OilSystem.REPLENISHMENT,
                    "diverter valve for duplex system": OilSystem.DIVERTER_VALVE
                }}
                activeChoice={configuration.oilSystem}
                onChoiceClicked={(choice) => onConfigChanged({...configuration, oilSystem: choice})}
                status={status.engineSystems}
            />
            <ChoiceList
                description={"Fuel System"}
                choices={{
                    "Duplex fuel pre-filter": FuelSystem.PRE_FILTER,
                    "diverter valve for fuel filter": FuelSystem.DIVERTER_VALVE,
                    "monitoring fuel leakage": FuelSystem.MONITORING_FUEL_LEAKAGE
                }}
                activeChoice={configuration.fuelSystem}
                onChoiceClicked={(choice) => onConfigChanged({...configuration, fuelSystem: choice})}
                status={status.engineSystems}
            />
            <ChoiceList
                description={"Cooling System"}
                choices={{
                    "Coolant preheating system freestanding or engine mounted": CoolingSystem.COOLANT_PREHEATING,
                    "integrated seawater gearbox piping": CoolingSystem.SEAWATER_PIPING
                }}
                activeChoice={configuration.coolingSystem}
                onChoiceClicked={(choice) => onConfigChanged({...configuration, coolingSystem: choice})}
                status={status.engineSystems}
            />
            <ChoiceList
                description={"Exhaust System"}
                choices={{
                    "90 degree Exhaust bellows discharge rotatable": ExhaustSystem.EXHAUST_DISCHARGE_ROTATABLE
                }}
                activeChoice={configuration.exhaustSystem}
                onChoiceClicked={(choice) => onConfigChanged({...configuration, exhaustSystem: choice})}
                status={status.engineSystems}
            />
            <ChoiceList
                description={"Mounting System"}
                choices={{
                    "Resilient mounts at driving end": MountingSystem.RESILIANT_MOUNTS
                }}
                activeChoice={configuration.mountingSystem}
                onChoiceClicked={(choice) => onConfigChanged({...configuration, mountingSystem: choice})}
                status={status.mountingSystems}
            />
            <ChoiceList
                description={"Engine Management System"}
                choices={{
                    "In compliance with Classification Society Regulations": EngineManagementSystem.SOCIETY_REGULATIONS
                }}
                activeChoice={configuration.engineManagementSystem}
                onChoiceClicked={(choice) => onConfigChanged({...configuration, engineManagementSystem: choice})}
                status={status.controlSystems}
            />
            <ChoiceList
                description={"Monitoring/Control System"}
                choices={{
                    "BlueVision | New Generation": MonitoringSystem.BLUE_VISION
                }}
                activeChoice={configuration.monitoringSystem}
                onChoiceClicked={(choice) => onConfigChanged({...configuration, monitoringSystem: choice})}
                status={status.controlSystems}
            />
            <ChoiceList
                description={"Power Transmission"}
                choices={{
                    "Torsionally resilient coupling": PowerTransmission.TORSIONALLY_RESILLIANT_COUPLING
                }}
                activeChoice={configuration.powerTransmission}
                onChoiceClicked={(choice) => onConfigChanged({...configuration, powerTransmission: choice})}
                status={status.powerTransmission}
            />
            <ChoiceList
                description={"Gearbox Options"}
                choices={{
                    "Reverse reduction gearbox": GearboxOptions.REVERSE_REDUCTION,
                    "el. actuated": GearboxOptions.EL_ACUTATED,
                    "gearbox mounts": GearboxOptions.GEARBOX_MOUNTS,
                    "trolling mode for dead-slow propulsion": GearboxOptions.SLOW_PROPULSION,
                    "free auxiliary PTO": GearboxOptions.FREE_AUXILIARY_PTO,
                    "hydraulic pump drives": GearboxOptions.HYDRAULIC_PUMP_DRIVES
                }}
                activeChoice={configuration.gearboxOption}
                onChoiceClicked={(choice) => onConfigChanged({...configuration, gearboxOption: choice})}
                status={status.powerTransmission}
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
                    <button className="button ml-2" onClick={() => onSaveClicked()}>
                        Save
                    </button>
                    <button className="button ml-2" onClick={() => onLoadClicked()}>
                        Load
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