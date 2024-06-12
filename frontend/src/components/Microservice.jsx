import React from "react";

const State = {
    UNKNOWN: {
        name: "Unknown",
        color: "is-danger"
    },

}

export default function Microservice({name}) {
    const [state, setState] = React.useState(State.UNKNOWN);

    return (
        <tr>
            <td className="is-size-5">{name}</td>
            <td>
                <span className={`tag is-large is-full-width is-success ${state.color}`}>
                    {state.name}
                </span>
            </td>
        </tr>
    );
}