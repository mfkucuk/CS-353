import React, { useState, useEffect } from 'react';
import axios from 'axios';

const TravelerMainPage = () => {
    const [userInfo, setUserInfo] = useState({ name: '', balance: 0 });
    const [searchInput, setSearchInput] = useState('');
    const [rentals, setRentals] = useState([]);

    useEffect(() => {
        axios.get('/api/user') // Replace this with your actual API call
            .then(response => setUserInfo(response.data))
            .catch(error => console.error(error));
    }, []);

    useEffect(() => {
      // Mocked API response
      const rentalsResponse = [
          {
              image: '/example_rental.jpg',
              location: 'Ankara, Turkey',
              availableDates: '10/05/2023 - 20/05/2023',
              price: '$50/night',
              ratings: 4.5
          },
          {
              image: '/example_rental.jpg',
              location: 'Istanbul, Turkey',
              availableDates: '15/06/2023 - 30/06/2023',
              price: '$80/night',
              ratings: 4.0
          },
          {
              image: '/example_rental.jpg',
              location: 'Izmir, Turkey',
              availableDates: '01/07/2023 - 10/07/2023',
              price: '$60/night',
              ratings: 4.3
          },
          {
            image: '/example_rental.jpg',
            location: 'Ankara, Turkey',
            availableDates: '10/05/2023 - 20/05/2023',
            price: '$50/night',
            ratings: 4.5
        },
        {
            image: '/example_rental.jpg',
            location: 'Istanbul, Turkey',
            availableDates: '15/06/2023 - 30/06/2023',
            price: '$80/night',
            ratings: 4.0
        },
        {
            image: '/example_rental.jpg',
            location: 'Izmir, Turkey',
            availableDates: '01/07/2023 - 10/07/2023',
            price: '$60/night',
            ratings: 4.3
        },
        {
          image: '/example_rental.jpg',
          location: 'Ankara, Turkey',
          availableDates: '10/05/2023 - 20/05/2023',
          price: '$50/night',
          ratings: 4.5
      },
      {
          image: '/example_rental.jpg',
          location: 'Istanbul, Turkey',
          availableDates: '15/06/2023 - 30/06/2023',
          price: '$80/night',
          ratings: 4.0
      },
      {
          image: '/example_rental.jpg',
          location: 'Izmir, Turkey',
          availableDates: '01/07/2023 - 10/07/2023',
          price: '$60/night',
          ratings: 4.3
      },
      {
        image: 'example_rental.jpg',
        location: 'Ankara, Turkey',
        availableDates: '10/05/2023 - 20/05/2023',
        price: '$50/night',
        ratings: 4.5
    },
    {
        image: '/example_rental.jpg',
        location: 'Istanbul, Turkey',
        availableDates: '15/06/2023 - 30/06/2023',
        price: '$80/night',
        ratings: 4.0
    },
    {
        image: '/example_rental.jpg',
        location: 'Izmir, Turkey',
        availableDates: '01/07/2023 - 10/07/2023',
        price: '$60/night',
        ratings: 4.3
    },
          // ...more rentals...
      ];

      setRentals(rentalsResponse);
  }, []);

  const rentalsGridStyle = {
    display: 'grid',
    gridTemplateColumns: 'repeat(3, 1fr)',
    gap: '20px',
    padding: '20px',
    marginTop: '200px', // offset for the top bar
};

const rentalCardStyle = {
    display: 'flex',
    flexDirection: 'column',
    alignItems: 'center',
    backgroundColor: '#4b0082', // purple background
    padding: '20px',
    borderRadius: '10px',
};

const rentalImageStyle = {
    width: '350px',
    height: '200px',
    marginBottom: '20px',
    objectFit: 'cover',
    borderRadius: '10px',
};

const rentalInfoStyle = {
  color: '#FFBD59', // yellow text color
};

    const topBarStyle = {
        display: 'flex',
        justifyContent: 'space-between',
        alignItems: 'center',
        height: '250px',
        backgroundColor: '#4b0082',
        color: 'white',
        padding: '0 20px',
        position: 'fixed',
        top: 0,
        left: 0,
        width: '100%',
        zIndex: 100
    };

    const logoStyle = {
        margin: '20px',
        width: '250px',
        height: '100px'
    };

    const filterStyle = {
        display: 'flex',
        alignItems: 'flex-end',
        marginBottom: '20px'
    };

    const buttonStyle = {
        backgroundColor: '#FFBD59',
        color: 'black',
        padding: '10px 20px',
        border: 'none',
        borderRadius: '30px',
        cursor: 'pointer',
        height: '40px',
        marginLeft: '30px'
    };

    const switchButtonStyle = {
        backgroundColor: '#FFBD59',
        color: 'black',
        padding: '10px 20px',
        border: 'none',
        borderRadius: '30px',
        cursor: 'pointer',
        height: '40px',
        marginRight: '30px'


    };

    const searchInputStyle = {
        width: '280px',
        height: '40px',
        border: 'none',
        padding: '0 10px',
        marginRight: '10px',
        borderRadius: '30px',
    };

    const userInfoStyle = {
        display: 'flex',
        alignItems: 'center',
        height: '100%'
    };

    const userDetailStyle = {
        display: 'flex',
        flexDirection: 'column',
        marginRight: '10px',
        textAlign: 'left',
        color: '#FFBD59',
    };

    const profilePicStyle = {
        width: '100px',
        height: '100px',
       
        borderRadius: '50%', // Added for smooth edges
        marginLeft: '30px' // Added some extra margin
    };

    const filterSearchContainerStyle = {
      display: 'flex',
      justifyContent: 'center', // Add this
      alignItems: 'center',
      marginTop: 'auto',
      marginBottom: '20px',
      marginLeft: '100px'
  };

  const searchContainerStyle = {
      display: 'flex',
      backgroundColor: 'white',
      borderRadius: '30px',
      marginLeft: '20px'

  };

    const menuButtonStyle = {
        width: '40px',
        height: '50px',
        marginLeft: '20px',
        marginRight: '50px',
        cursor: 'pointer'
    };
    const wrapperStyle = {
      backgroundColor: '#4b0082', // Set the background color here
      minHeight: '100vh', // Ensures the color covers the entire height of the view
      color: 'white'
  };
    return (  
      <div style={wrapperStyle}>
        <div>
            <div style={topBarStyle}>
                <img src="/bilkent_logo.png" alt="Logo" style={logoStyle} />
                <div style={filterSearchContainerStyle}>
                    <button style={buttonStyle}>Filter</button>
                    <div style={searchContainerStyle}>
                        <input 
                            type="text" 
                            placeholder="Search..." 
                            value={searchInput} 
                            onChange={e => setSearchInput(e.target.value)} 
                            style={searchInputStyle}
                        />
                        <button style={buttonStyle}>Search</button>
                    </div>
                </div>
                <div style={userInfoStyle}>
                    <button style={switchButtonStyle}>Switch to Homeowner</button>
                    <div style={userDetailStyle}>
                        <div>{`Ege Ayan`}</div>
                        <div>{`Balance: ${userInfo.balance}`}</div>
                    </div>
                    <img src="/default_pp.png" alt="Profile" style={profilePicStyle} />
                    <img src="/side_menu.png" alt="Menu" style={menuButtonStyle} />
                </div>
            </div>
            <div style={rentalsGridStyle}>
                {rentals.map((rental, index) => (
                    <div key={index} style={rentalCardStyle}>
                        <img src={rental.image} alt="Rental" style={rentalImageStyle} />
                        <div style={rentalInfoStyle}>{rental.location}</div>
                        <div style={rentalInfoStyle}>{rental.availableDates}</div>
                        <div style={rentalInfoStyle}>{rental.price}</div>
                        <div style={rentalInfoStyle}>{`Ratings: ${rental.ratings}`}</div>
                    </div>
                ))}
            </div>
        </div>
        </div>
    );
};

export default TravelerMainPage;
