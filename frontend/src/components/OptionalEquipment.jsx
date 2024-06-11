import React from "react";

export default function OptionalEquipment({name, choices}) {
    const [status, setStatus] = React.useState("ok");

    return (
        <tr className="">
            <td className="is-size-5">{name}</td>
            <td>
                <ChoiceList className="tabs is-toggle is-gapless" choices={choices}></ChoiceList>
            </td>
            <td>
                <span className="tag is-large is-success">
                    {status}
                </span>
            </td>
        </tr>
    );
}

function ChoiceList({choices}) {
    const [activeChoice, setActiveChoice] = React.useState(0);

    return (
        <span className="buttons has-addons">
            {choices.map((choice, index) =>
                <button className={`button ${index === activeChoice ? "is-selected is-link" : ""}`} onClick={() => setActiveChoice(index)}>
                    {choice}
                </button>)
            }
        </span>
    );
}