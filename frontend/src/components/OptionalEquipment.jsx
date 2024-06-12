import React from "react";

const State = {
    WAITING: {
        value: "Waiting",
        color: "is-light",
    },
    RUNNING: {
        value: "Running",
        color: "",
    },
    SUCCESS: {
        value: "Success",
        color: "",
    },
    FAILED: {
        value: "Failed",
        color: "",
    },
};

export default function OptionalEquipment({name, choices}) {
    const [state, setState] = React.useState(State.WAITING);

    return (
        <tr>
            <td className="is-size-5">{name}</td>
            <td>
                <ChoiceList className="tabs is-toggle is-gapless" choices={choices}></ChoiceList>
            </td>
            <td>
                <span className={`tag is-large is-full-width ${state.color}`}>
                    {state.value}
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
                <button className={`button ${index === activeChoice ? "is-selected is-link" : ""}`} onClick={() => setActiveChoice(index)} key={choice + index}>
                    {choice}
                </button>)
            }
        </span>
    );
}