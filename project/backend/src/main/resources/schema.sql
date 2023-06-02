CREATE TABLE User (
    user_id uuid PRIMARY KEY,
    full_name varchar(50) NOT NULL,
    e_mail varchar(50) NOT NULL,
    dob datetime,
    TCK varchar(11),
    password varchar(15) NOT NULL,
    phone_number varchar(15) NOT NULL
);

CREATE TABLE Traveler (
    user_id uuid,
    written_reviews text,
    balance float,
    FOREIGN KEY user_id REFERENCES User(user_id)
)

CREATE TABLE Homeowner (
    user_id uuid,
    received_reviews text,
    reputation float,
    FOREIGN KEY user_id REFERENCES User(user_id)
)

CREATE TABLE Admin (
    user_id uuid,
    past_reports text,
    FOREIGN KEY user_id REFERENCES User(user_id)
)

CREATE TABLE Rental (
    rental_id uuid PRIMARY KEY,
);

CREATE TABLE Flat (
    rental_id uuid,
    room_count int
);

CREATE TABLE Room (
    rental_id uuid,
    capacity int
);

CREATE TABLE SystemReport (
    title varchar(50),
    content text,
    admin_id uuid,
    FOREIGN KEY admin_id REFERENCES User(user_id)
);

CREATE VIEW HomeownerView AS
SELECT * 
FROM User U, Traveler T, Homeowner H
WHERE U.user_id = T.user_id AND T.user_id = H.user_id

CREATE VIEW TravelerView AS
SELECT *
FROM User U, Traveler T
WHERE U.user_id = T.user_id

CREATE VIEW AdminView AS 
SELECT *
FROM User U, Admin A
WHERE U.user_id = A.user_id

CREATE VIEW FlatView AS
SELECT *
FROM Rental R, Flat F
WHERE R.rental_id = F.rental_id