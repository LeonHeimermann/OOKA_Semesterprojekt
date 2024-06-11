import React from "react";

export default function Microservice({name}) {
    const [state, setState] = React.useState("available");

    return (
        <tr>
            <td className="is-size-5">{name}</td>
            <td>
                <span className="tag is-large is-success">
                    {state}
                </span>
            </td>
        </tr>
    );
}