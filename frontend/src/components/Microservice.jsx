import React from "react";

const State = {
    Unknown: "Unknown",
    Available: "Available",
    Unavailable: "Unavailable",
}

export default function Microservice({name, serviceUrl}) {
    const [state, setState] = React.useState(State.Unknown);

    React.useEffect(() => {
        fetch(`${serviceUrl}/health/alive`)
            .then((response) => {
                if (response.ok) {
                    setState(State.Available);
                } else {
                    setState(State.Unavailable);
                }
            })
            .catch((reason) => {
                setState(State.Unavailable);
            })
    }, [serviceUrl]);

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