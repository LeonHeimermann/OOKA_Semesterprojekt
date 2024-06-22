import React from "react";
import OptionalEquipment from "./OptionalEquipment";
import EngineType from "./EngineType";


export default function ConfigurationController({configuration}) {

    return (
        <>
            <EngineType
                engines={configuration.engines}
                onSelectionChanged={console.log}
            />
            <OptionalEquipment
                equipment={configuration.optionalEquipment}
            />
        </>
    );
}