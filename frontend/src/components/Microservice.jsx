import React from "react";

const State = {
    Unknown: "Unknown",
    Available: "Available",
    Unavailable: "Unavailable",
}

export default function Microservice({name}) {
    const [state, setState] = React.useState(State.Unknown);

    return (
        <tr>
            <td className="is-size-5">{name}</td>
            <td>
                <span className={`tag is-large is-success ${state === State.Available ? "is-success" : "is-danger"}`}>
                    {state}
                </span>
            </td>
        </tr>
    );
}