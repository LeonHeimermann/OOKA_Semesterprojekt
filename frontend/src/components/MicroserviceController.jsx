import React from "react";


export default function MicroserviceController({services, activeServices}) {

    return (
        <table className="table is-striped is-narrow is-fullwidth">
            <thead>
            <tr>
                <th className="column is-full">Microservice</th>
                <th className="has-text-centered" style={{width: "13rem"}}>Status</th>
            </tr>
            </thead>
            <tbody>
            {services.map((service, i) => (
                <tr key={service.id}>
                    <td className="is-size-5">{service.name}</td>
                    <td>
                        <ServiceStatusComponent service={service} activeServices={activeServices}/>
                    </td>
                </tr>
            ))}
            </tbody>
        </table>
    );
}

function ServiceStatusComponent({service, activeServices}) {
    const serviceStatus = activeServices.includes(service.id) ? "Available" : "Unavailable";
    return (
        <span className={`tag is-large is-full-width ${activeServices.includes(service.id) ? "is-success" : "is-danger"}`}>
            {serviceStatus}
        </span>
    );
}
