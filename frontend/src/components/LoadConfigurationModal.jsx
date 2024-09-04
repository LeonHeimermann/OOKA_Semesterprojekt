import React from "react";

export default function LoadConfigurationModal({configuratons, isActive, onLoad, onClose}) {

    function formattedDate(datetime) {
        const [year, month, dayAndTime] = datetime.split("-")
        const [day, timestamp] = dayAndTime.split("T")
        const [hour, minute, second] = timestamp.split(":")
        return `${year}.${month}.${day} ${hour}:${minute}`
    }

    return (
        <div className={`modal ${isActive ? "is-active" : ""}`}>
            <div className="modal-background"></div>
            <div className="modal-content">
                <div className="card">
                    <header className="card-header">
                        <p className="card-header-title">Load configuration</p>
                    </header>
                    <div className="card-content">
                        {configuratons.map((config, index) => (
                            <div className="columns load-config-container" onClick={() => onLoad(config)}>
                                <div className="column is-one-third">{config.title}</div>
                                <div className="column">{config.description}</div>
                                <div className="column is-one-quarter has-text-right">{formattedDate(config.createdAt)}</div>
                                <hr/>
                            </div>
                        ))}
                    </div>
                </div>
            </div>
            <button className="modal-close is-large" aria-label="close" onClick={() => onClose()}></button>
        </div>
    );
}