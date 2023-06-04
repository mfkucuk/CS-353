CREATE TABLE IF NOT EXISTS Users (
    user_id uuid PRIMARY KEY,
    full_name text NOT NULL,
    e_mail text NOT NULL,
    dob date,
    TCK text,
    password text NOT NULL,
    phone_number text NOT NULL,
    is_admin boolean
);

CREATE TABLE IF NOT EXISTS Traveler (
    user_id uuid,
    written_reviews text,
    balance float
);

CREATE TABLE IF NOT EXISTS Homeowner (
    user_id uuid,
    received_reviews text,
    reputation float
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
    ask_name text,
    answer_name text,
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

DROP VIEW IF EXISTS HomeownerView;
DROP VIEW IF EXISTS TravelerView;
DROP VIEW IF EXISTS AdminView;
DROP VIEW IF EXISTS FlatView;
DROP VIEW IF EXISTS RoomView;

CREATE VIEW HomeownerView AS
SELECT U.user_id, U.full_name, U.e_mail, U.dob, U.TCK, U.password, U.phone_number, U.is_admin, T.written_reviews, T.balance, H.received_reviews, H.reputation
FROM Users U
JOIN Traveler T ON U.user_id = T.user_id
JOIN Homeowner H ON U.user_id = H.user_id;

CREATE VIEW TravelerView AS
SELECT U.user_id, U.full_name, U.e_mail, U.dob, U.TCK, U.password, U.phone_number, U.is_admin, T.written_reviews, T.balance
FROM Users U
JOIN Traveler T ON U.user_id = T.user_id;

CREATE VIEW AdminView AS 
SELECT U.user_id, U.full_name, U.e_mail, U.dob, U.TCK, U.password, U.phone_number, U.is_admin, A.past_reports
FROM Users U
JOIN Admin A ON U.user_id = A.user_id;

CREATE VIEW FlatView AS
SELECT R.rental_id, R.location, R.available_start, R.available_end, R.restrictions, R.type, R.rating, R.features, R.comments, R.price, R.traveler_id, R.homeowner_id, F.room_count
FROM Rental R
JOIN Flat F ON R.rental_id = F.rental_id;

CREATE VIEW RoomView AS
SELECT R.rental_id, R.location, R.available_start, R.available_end, R.restrictions, R.type, R.rating, R.features, R.comments, R.price, R.traveler_id, R.homeowner_id, Ro.capacity
FROM Rental R
JOIN Room Ro ON R.rental_id = Ro.rental_id;

-- CREATE TRIGGER TravelerBalanceDecrease
-- AFTER UPDATE OF traveler_id ON Rental
-- UPDATE Traveler
-- SET balance = balance - price
-- WHERE user_id = NEW.traveler_id;

-- CREATE TRIGGER HomeownerBalanceIncrease
-- AFTER UPDATE OF traveler_id ON Rental
-- UPDATE Traveler
-- SET balance = balance + price
-- WHERE user_id = NEW.homeowner_id;

