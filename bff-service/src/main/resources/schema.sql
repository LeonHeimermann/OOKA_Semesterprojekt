create table if not exists Configuration (
    id numeric not null,
    title varchar(255) not null,
    description varchar(255) not null,
    createdAt timestamp not null,

    engineType varchar(45) not null,
    engineConfiguration varchar(45) not null,
    startingSystem varchar(45) not null,
    auxiliaryPTO varchar(45) not null,
    oilSystem varchar(45) not null,
    fuelSystem varchar(45) not null,
    coolingSystem varchar(45) not null,
    exhaustSystem varchar(45) not null,
    mountingSystem varchar(45) not null,
    engineManagementSystem varchar(45) not null,
    monitoringSystem varchar(45) not null,
    powerTransmission varchar(45) not null,
    gearboxOption varchar(45) not null
);