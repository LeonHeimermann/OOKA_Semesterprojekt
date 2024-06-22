import React from "react";

export default function ChoiceList({description, choices, activeChoice, onChoiceClicked}) {

    return (
        <tr>
            <td className="is-size-5">{description}</td>
            <td>
                <span className="buttons has-addons">
                    {choices.map((choice, index) =>
                        <button
                            className={`button ${index === activeChoice ? "is-selected is-link" : ""}`}
                            onClick={() => onChoiceClicked(index)} key={choice + index}>
                            {choice}
                        </button>
                    )}
                </span>
            </td>
            <td>
                <span className={`tag is-large is-full-width`}>
                    Not Implemented
                </span>
            </td>
        </tr>
    );
}