import React, { useState, useEffect } from 'react';
import axios from 'axios';
import "./TravelerRental.css";


const contentStyle = {
    fontSize: '18px',
    color: '#ffbd59',
    fontWeight: 'bold',
  };
  const buttonStyle = {
    backgroundColor: '#FFBD59',
    color: '#4B0082',
    padding: '10px 20px',
    border: 'none',
    fontWeight: 'bold',
    borderRadius: '5px',
    cursor: 'pointer',
    fontSize: '16px',
    margin: '10px 0',
    transition: 'all 0.3s ease',
    marginLeft: '10px',
  };

  const imageStyle = {
    width: '75%',
    marginRight: '20%',
    height: 'auto',
  };

  const homeownerStyle = {
    display: 'flex',
    alignItems: 'center',
    margin: '10px 0',
  };

  const homeownerImageStyle = {
    width: 50,
    height: 50,
    borderRadius: '50%',
    marginRight: '10px',
  };

  const switchContainerStyle = {
    display: 'flex',
    alignItems: 'center',
    marginTop: '50px',
    textAlign: 'center',
  };

  const switchButtonStyle = {
    position: 'relative',
    display: 'inline-block',
    width: '60px',
    height: '34px',
  };

  const switchSliderStyle = {
    position: 'absolute',
    cursor: 'pointer',
    top: '0',
    left: '0',
    right: '0',
    bottom: '0',
    backgroundColor: '#FFBD59',
    transition: '0.4s',
    borderRadius: '34px',
  };

  const switchLabelStyle = {
    marginLeft: '20px',
    marginRight: '20px',
    fontSize: '20px',
    fontWeight: 'bold',
    color: '#FFBD59',
  };

  const commentSectionStyle = {
    width: '80vw',
    margin: '20px auto',
    border: '1px solid #FFBD59',
    borderRadius: '5px',
    padding: '10px',
    alignContent: 'center',
  };

  const commentStyle = {
    marginBottom: '10px',
    padding: '10px',
    border: '1px solid #FFBD59',
    borderRadius: '5px',
    display: 'flex',
  };

  const commentInputContainerStyle = {
    display: 'flex',
    alignItems: 'center',
    justifyContent: 'flex-end', // Align items to the right
    marginTop: '20px',
  };

  const commentInputStyle = {
    width: '30vw',
    padding: '10px',
    border: '1px solid #FFBD59',
    borderRadius: '5px',
    marginRight: '10px',
    boxSizing: 'border-box',
  };

  const commentButtonStyle = {
    backgroundColor: '#FFBD59',
    color: '#4B0082',
    padding: '10px 20px',
    fontWeight: 'bold',
    border: 'none',
    borderRadius: '5px',
    cursor: 'pointer',
    fontSize: '16px',
    alignSelf: 'flex-start', // Align button to the top
  };

  const commentSectionScrollStyle = {
    maxHeight: '300px',
    overflowY: 'auto',
    scrollbarWidth: 'thin',
    scrollbarColor: '#4B0082 #FFBD59',
    // Add the following CSS properties for the track and thumb styles
    scrollbarTrackColor: '#ffbd59',
    scrollbarThumbColor: '#4b0082',
  };
  
  const commentSectionScrollInnerStyle = {
    // Add the following CSS property for the scrollbar pseudo-element styles
    scrollbarWidth: 'thin',
    scrollbarColor: '#4B0082 #FFBD59',
  };

const TravelerRental = () => {
  const [rentalData, setRentalData] = useState({});
  const [isLoading, setIsLoading] = useState(true);
  const [showComments, setShowComments] = useState(true);
  const [comments, setComments] = useState([]);
  const [newComment, setNewComment] = useState('');

  /*useEffect(() => {
      const fetchRentalData = async () => {
          try {
              const response = await axios.get('https://your-api-url.com/endpoint');
              setRentalData(response.data);
              setIsLoading(false);
          } catch (error) {
              console.error(error);
          }
      }

      fetchRentalData();
  }, []); 
  
  if (isLoading) {
      return <div>Loading...</div>
  }*/

  const switchSliderBeforeStyle = {
    content: "''",
    position: 'absolute',
    height: '26px',
    width: '26px',
    left: '4px',
    bottom: '4px',
    backgroundColor: '#4B0082',
    transition: '0.4s',
    borderRadius: '50%',
    transform: showComments ? 'translateX(0)' : 'translateX(26px)',
  };

  const handleSwitchComments = () => {
    setShowComments((prevState) => !prevState);
  };

  const handleCommentChange = (event) => {
    setNewComment(event.target.value);
  };

  const handleAddComment = () => {
    // Add the new comment to the comments array
    setComments((prevComments) => [...prevComments, newComment]);
    // Clear the text field
    setNewComment('');
  };

  return (
    <div
      style={{
        backgroundColor: '#4b0082',
        height: '100vh',
        display: 'flex',
        flexDirection: 'column',
        alignItems: 'center',
        justifyContent: 'center',
        color: 'white',
        overflowY: 'auto',
      }}
    >
      <div style={{ position: 'absolute', top: 0, left: 0 }}>
        <img src="/bilkent_logo.png" alt="Logo" style={{ margin: 50, width: 250, height: 100 }} />
      </div>
      <h1 style={{ color: '#FFBD59' }}>Rental in {rentalData.location}</h1>
      <div style={{ display: 'flex', justifyContent: 'space-between', width: '80%', marginTop: 20 }}>
        <div>
          <img src="/example_rental.jpg" alt="Rental" style={imageStyle} />
        </div>
        <div>
          <p style={contentStyle}>Location: {rentalData.location}</p>
          <p style={contentStyle}>Room Count: {rentalData.roomCount}</p>
          <p style={contentStyle}>Rating: {rentalData.rating}/5</p>
          <p style={contentStyle}>
            Available dates: {rentalData.startDate} to {rentalData.endDate}
          </p>
          <p style={contentStyle}>Features: {rentalData.features}</p>
          <p style={contentStyle}>Restrictions: {rentalData.restrictions}</p>
          <p style={contentStyle}>Rental Type: {rentalData.rentalType}</p>
          <p style={contentStyle}>Price: {rentalData.price}</p>
          <div style={homeownerStyle}>
            <img src="/default_pp.png" alt="Homeowner" style={homeownerImageStyle} />
            <p style={contentStyle}>{rentalData.homeownerName}</p>
            <button style={buttonStyle}>Ask Question</button>
          </div>
        </div>
      </div>
      <button style={buttonStyle}>Rent</button>
      <div style={switchContainerStyle}>
        <span style={switchLabelStyle}>Comments</span>
        <label className="switch" style={switchButtonStyle}>
          <input type="checkbox" checked={showComments} onChange={handleSwitchComments} />
          <span className="slider" style={switchSliderStyle}>
            <span className="slider-before" style={switchSliderBeforeStyle}></span>
          </span>
        </label>
        <span style={switchLabelStyle}>Questions</span>
      </div>
      {showComments ? (
        <div style={commentSectionStyle}>
        <h2 style={{ textAlign: 'center', color: '#ffbd59' }}>Comments</h2>
        <div style={commentSectionScrollStyle}>
          <div style={{commentSectionScrollInnerStyle}}>
            {comments.map((comment, index) => (
            <div key={index} style={commentStyle}>
              {comment}
            </div>
          ))}
          </div>
        </div>
        <div style={{ display: 'flex', justifyContent: 'center', flexDirection: 'column', alignItems: 'center' }}>
          <div style={commentInputContainerStyle}>
            <input
              type="text"
              value={newComment}
              onChange={handleCommentChange}
              style={commentInputStyle}
              placeholder="Add a comment"
            />
            <button style={commentButtonStyle} onClick={handleAddComment}>
              Comment
            </button>
          </div>
        </div>
      </div>
      ) : (
        <div>
          <h2 style={{ color: '#ffbd59' }}>Questions</h2>
          {/* Question section code goes here */}
        </div>
      )}
    </div>
  );
};

export default TravelerRental;
