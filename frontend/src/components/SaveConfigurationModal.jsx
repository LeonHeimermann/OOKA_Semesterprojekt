import React from "react";

export default function SaveConfigurationModal({isActive, onSave, onClose}) {

    const [title, setTitle] = React.useState("");
    const [description, setDescription] = React.useState("");

    return (
        <div className={`modal ${isActive ? "is-active" : ""}`}>
            <div className="modal-background"></div>
            <div className="modal-content">
                <div className="card">
                    <header className="card-header">
                        <p className="card-header-title">Save your configuration</p>
                        <button className="button is-primary m-2"
                                disabled={title.length === 0 || description.length === 0}
                                onClick={() => onSave(title, description)}>
                            Save</button>
                    </header>
                    <div className="card-content">
                        <input className="input" type="text" placeholder="Title"
                               name="title-input"
                               value={title}
                               onInput={e => setTitle(e.target.value)}/>
                        <textarea className="textarea mt-2" placeholder="Description"
                                  name="description-input"
                                  value={description}
                                  onInput={e => setDescription(e.target.value)}>
                        </textarea>
                    </div>
                </div>
            </div>
            <button className="modal-close is-large" aria-label="close" onClick={() => onClose()}></button>
        </div>
    );
}