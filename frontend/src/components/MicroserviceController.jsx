import React from "react";


export default function MicroserviceController({services}) {

    return (
        <table className="table is-striped is-narrow is-fullwidth">
            <thead>
            <tr>
                <th style={{width: "100%"}}>Microservice</th>
                <th className="has-text-centered" style={{width: "13rem"}}>Status</th>
            </tr>
            </thead>
            <tbody>
            {services.map((service, i) => (
                <tr>
                    <td className="is-size-5">{service.name}</td>
                    <td>
                            <span className={`tag is-large is-full-width`}>
                                Not implemented
                            </span>
                    </td>
                </tr>
            ))}
            </tbody>
        </table>
    );
}