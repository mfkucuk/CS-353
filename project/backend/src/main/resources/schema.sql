CREATE TABLE User (
    user_id uuid PRIMARY KEY,
    full_name varchar(50) NOT NULL,
    e_mail varchar(50) NOT NULL,
    dob datetime,
    TCK varchar(11),
    password varchar(15) NOT NULL,
    phone_number varchar(15) NOT NULL
);

CREATE TABLE Rental (
    rental_id uuid PRIMARY
);