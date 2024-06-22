import React from "react";

export default function ChoiceList({choices, activeChoice, onChoiceClicked}) {

    return (
        <span className="buttons has-addons">
            {choices.map((choice, index) =>
                <button className={`button ${index === activeChoice ? "is-selected is-link" : ""}`} onClick={() => onChoiceClicked(index)} key={choice + index}>
                    {choice}
                </button>)
            }
        </span>
    );
}