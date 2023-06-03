import React, { useEffect, useState } from "react";
import axios from "axios";
import Modal from 'react-modal';


Modal.setAppElement('#root')
const TravelerListing = () => {
  const [currentAccommodations, setCurrentAccommodations] = useState([]);
  const [previousAccommodations, setPreviousAccommodations] = useState([]);
  const [modalIsOpen, setIsOpen] = useState(false);
  const [selectedAccommodationId, setSelectedAccommodationId] = useState(null);
  const [reviewText, setReviewText] = useState('');
  const [rating, setRating] = useState(0);
  useEffect(() => {
    const mockData = [
      { id: 1, name: 'Accommodation 1' },
      { id: 2, name: 'Accommodation 2' },
      { id: 3, name: 'Accommodation 3' },
    ];
    setPreviousAccommodations(mockData);

    const mockData2 = [
      { id: 1, name: 'Accommodation 1' },
      { id: 2, name: 'Accommodation 2' },
      { id: 3, name: 'Accommodation 3' },
    ];
    setCurrentAccommodations(mockData2);
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

  const handleReviewClick = (accommodationId) => {
    setSelectedAccommodationId(accommodationId);
    setIsOpen(true);
  };

  const closeModal = () => {
    setIsOpen(false);
    setReviewText('');
    setRating(0);
  }

  const handleSubmitReview = () => {
    console.log('Submitted review:', reviewText, 'Rating:', rating);
    closeModal();
    // Here you can send the review to the server.
  }

  const handleRatingChange = (event) => {
    setRating(Number(event.target.value));
  }

  const handleReviewTextChange = (event) => {
    setReviewText(event.target.value);
  }
  const logoStyle = {
    margin: "20px",
    width: "250px",
    height: "100px"
  };
  const inputStyle = {
    width: '350px',
    height: '60px',
    borderRadius: '10px',
    padding: '5px',
    fontSize: '16px',
    marginBottom: '20px'
  };

  const buttonStyle = {
    backgroundColor: '#4b0082',
    color: '#FFF',
    padding: '10px 20px',
    borderRadius: '10px',
    border: 'none'
  };

  const cardStyle = {
    borderRadius: '10px',
    backgroundColor: '#4b0082',
    color:'#FFBD59',
    padding: '20px',
    margin: '10px 0',
    display: 'flex',
    justifyContent: 'space-between',
    alignItems: 'center'
  }

  const reviewButtonStyle = {
    backgroundColor: '#FFBD59',
    color: '#4b0082',
    padding: '5px 10px',
    borderRadius: '5px',
    border: 'none',
    cursor: 'pointer'
  
  }

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
              <div key={accommodation.id} style={cardStyle}>
              <p>{accommodation.name}</p>
            </div>
            ))}
          </ul>
        </div>
        <div style={listStyle}>
          <h2 style={{ color: "#4b0082" }}>Previous Accommodations</h2>
          
          {previousAccommodations.map(accommodation => (
        <div key={accommodation.id} style={cardStyle}>
          <p>{accommodation.name}</p>
          <button style={reviewButtonStyle} onClick={() => handleReviewClick(accommodation.id)}>Review</button>
        </div>
      ))}
        
        </div>
      </div>
      <Modal
        isOpen={modalIsOpen}
        onRequestClose={closeModal}
        style={{
          overlay: {
            backgroundColor: 'rgba(0, 0, 0, 0.5)'
          },
          content: {
            backgroundColor: '#FFBD59', // Yellow background
            color: '#4b0082', // Purple text
            padding: '20px',
            display: 'flex',
            flexDirection: 'column',
            alignItems: 'center',
            justifyContent: 'space-between',
            borderRadius: '10px',
            width: '30%',
            height: '70%',
            margin: 'auto'
          }
        }}
      >
        <h2>Make a Review</h2>
        <div>
          <h3 style={{ marginTop: '20px' }}>Review:</h3>
          <textarea style={inputStyle} value={reviewText} onChange={handleReviewTextChange} />
          <h3>Rating:</h3>
          <input type="number" min="0" max="5" style={inputStyle} value={rating} onChange={handleRatingChange} />
        </div>
        <button onClick={handleSubmitReview} style={buttonStyle}>Submit</button>
      </Modal>
    </div>
  );
};

export default TravelerListing;
