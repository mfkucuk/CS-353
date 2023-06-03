import React, { useEffect, useState } from "react";
import axios from "axios";

const TravelerListing = () => {
  const [currentAccommodations, setCurrentAccommodations] = useState([]);
  const [previousAccommodations, setPreviousAccommodations] = useState([]);

  useEffect(() => {
    // Fetch current accommodations
    axios
      .get("/api/currentAccommodations")
      .then((response) => {
        setCurrentAccommodations(response.data);
      })
      .catch((error) => {
        console.error("Error fetching current accommodations:", error);
      });

    // Fetch previous accommodations
    axios
      .get("/api/previousAccommodations")
      .then((response) => {
        setPreviousAccommodations(response.data);
      })
      .catch((error) => {
        console.error("Error fetching previous accommodations:", error);
      });
  }, []);

  const logoStyle = {
    margin: "20px",
    width: "250px",
    height: "100px"
  };

  const listContainerStyle = {
    display: "flex",
    justifyContent: "space-between",
    margin: "20px 10%",
  };
  
  const listStyle = {
    backgroundColor: "#FFBD59",
    padding: "20px",
    borderRadius: "10px",
    width: "400px",
  };

  const handleReviewClick = (accommodationId) => {
    // Handle review button click for a specific accommodation
    console.log("Review clicked for accommodation with ID:", accommodationId);
    // You can replace the console.log statement with your desired logic for handling the review button click.
  };

  return (
    <div style={{ backgroundColor: "#4b0082", height: "100vh" }}>
      <div style={{ display: "flex" }}>
        <div style={{ flex: 1 }}>
          <img src="/bilkent_logo.png" alt="Logo" style={logoStyle} />
        </div>
      </div>
      <div style={listContainerStyle}>
        <div style={listStyle}>
          <h2 style={{ color: "#4b0082" }}>Current Accommodations</h2>
          <ul>
            {currentAccommodations.map((accommodation) => (
              <li key={accommodation.id}>
                {accommodation.name}
              </li>
            ))}
          </ul>
        </div>
        <div style={listStyle}>
          <h2 style={{ color: "#4b0082" }}>Previous Accommodations</h2>
          <ul>
            {previousAccommodations.map((accommodation) => (
              <li key={accommodation.id}>
                {accommodation.name}
                <button onClick={() => handleReviewClick(accommodation.id)}>
                  Review
                </button>
              </li>
            ))}
          </ul>
        </div>
      </div>
    </div>
  );
};

export default TravelerListing;
