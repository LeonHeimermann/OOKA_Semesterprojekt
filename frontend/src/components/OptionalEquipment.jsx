import React from "react";
import ChoiceList from "./ChoiceList";

export default function OptionalEquipment({equipment}) {

    return (
        <table className="table is-striped is-narrow is-fullwidth">
            <thead>
            <tr>
                <th>Optional Equipment</th>
                <th>Options</th>
                <th className="has-text-centered" style={{width: "10rem"}}>Status</th>
            </tr>
            </thead>
            <tbody>
                {equipment.map((e, i) => (
                    <tr>
                        <td className="is-size-5">{e.name}</td>
                        <td>
                            <ChoiceList
                                className="tabs is-toggle is-gapless"
                                choices={e.choices}
                                activeChoice={0}
                                onChoiceClicked={console.log}
                            />
                        </td>
                        <td>
                            <span className={`tag is-large is-full-width`}>
                                Not Implemented
                            </span>
                        </td>
                    </tr>
                ))}
            </tbody>
            <tfoot>
            <tr>
                <td className="is-size-5">
                    <button className="button is-primary" onClick={() => console.log("Start clicked")}>Start</button>
                </td>
                <td className="is-size-5 has-text-right">
                    Result
                </td>
                <td>
                    <span className="tag is-large">...</span>
                </td>
            </tr>
            </tfoot>
        </table>
    );
}