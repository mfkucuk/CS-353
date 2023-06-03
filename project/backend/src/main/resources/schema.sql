CREATE TABLE IF NOT EXISTS Users (
    user_id uuid PRIMARY KEY,
    full_name text NOT NULL,
    e_mail text NOT NULL,
    dob date,
    TCK text,
    password text NOT NULL,
    phone_number text NOT NULL
);

CREATE TABLE IF NOT EXISTS Traveler (
    user_id uuid,
    written_reviews text,
    balance float,
    FOREIGN KEY (user_id) REFERENCES Users(user_id)
);

CREATE TABLE IF NOT EXISTS Homeowner (
    user_id uuid,
    received_reviews text,
    reputation float,
    FOREIGN KEY (user_id) REFERENCES Users(user_id)
);

CREATE TABLE IF NOT EXISTS Admin (
    user_id uuid,
    past_reports text,
    FOREIGN KEY (user_id) REFERENCES Users(user_id)
);

CREATE TABLE IF NOT EXISTS Rental (
    rental_id uuid PRIMARY KEY,
    location text,
    available_start date,
    available_end date,
    restrictions text,
    type text,
    rating int,
    features text[],
    comments text[],
    price float,
    traveler_id uuid,
    homeowner_id uuid,
    FOREIGN KEY (traveler_id) REFERENCES Users(user_id),
    FOREIGN KEY (homeowner_id) REFERENCES Users(user_id)
);

CREATE TABLE IF NOT EXISTS Flat (
    rental_id uuid,
    room_count int,
    FOREIGN KEY (rental_id) REFERENCES Rental(rental_id)
);

CREATE TABLE IF NOT EXISTS Room (
    rental_id uuid,
    capacity int,
    FOREIGN KEY (rental_id) REFERENCES Rental(rental_id)
);

CREATE TABLE IF NOT EXISTS SystemReport (
    title text,
    content text,
    admin_id uuid,
    FOREIGN KEY (admin_id) REFERENCES Users(user_id)
);

CREATE TABLE IF NOT EXISTS QAndA (
    ask_date date,
    answer_date date,
    question text,
    answer text,
    ask_id uuid,
    answer_id uuid,
    rental_id uuid,
    FOREIGN KEY (ask_id) REFERENCES Users(user_id),
    FOREIGN KEY (answer_id) REFERENCES Users(user_id),
    FOREIGN KEY (rental_id) REFERENCES Rental(rental_id)
);

-- CREATE VIEW HomeownerView AS
-- SELECT * 
-- FROM User U, Traveler T, Homeowner H
-- WHERE U.user_id = T.user_id AND T.user_id = H.user_id

-- CREATE VIEW TravelerView AS
-- SELECT *
-- FROM User U, Traveler T
-- WHERE U.user_id = T.user_id

-- CREATE VIEW AdminView AS 
-- SELECT *
-- FROM User U, Admin A
-- WHERE U.user_id = A.user_id

-- CREATE VIEW FlatView AS
-- SELECT *
-- FROM Rental R, Flat F
-- WHERE R.rental_id = F.rental_id

-- CREATE VIEW RoomView AS
-- SELECT *
-- FROM Rental R, Room Ro
-- WHERE R.rental_id = Ro.rental_id