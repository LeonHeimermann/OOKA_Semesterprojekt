import React from "react";


export default function MicroserviceController({services}) {

    return (
        <table className="table is-striped is-narrow is-fullwidth">
            <thead>
                <tr>
                    <th>Microservice</th>
                    <th className="has-text-centered">Status</th>
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