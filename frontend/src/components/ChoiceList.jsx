import React from "react";
import {Status} from "../entities/Status";

export default function ChoiceList({description, choices, activeChoice, onChoiceClicked, status}) {

    function statusDescription() {
        switch (status){
            case Status.WAITING:
                return "Waiting";
            case Status.RUNNING:
                return "Running";
            case Status.SUCCESS:
                return "Success";
            case Status.ERROR:
                return "Failed";
            default:
                return "Unknown";
        }
    }

    function statusColor() {
        switch (status) {
            case Status.RUNNING:
                return "is-info";
            case Status.SUCCESS:
                return "is-success";
            case Status.ERROR:
                return "is-danger";
            default:
                return "";
        }
    }

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
            {status ?
                <td>
                    <span className={`tag is-large is-full-width ${statusColor()}`}>{statusDescription()}</span>
                </td> : null}
        </tr>
    );
}