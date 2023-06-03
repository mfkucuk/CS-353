import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { AiOutlineClose } from 'react-icons/ai'; // import close icon
import { Button } from 'react-bootstrap';
import { Link } from 'react-router-dom';
import { useNavigate } from 'react-router-dom';
const HomeOwnerMainPage = () => {
    const [userInfo, setUserInfo] = useState({ name: '', balance: 0 });
    const [searchInput, setSearchInput] = useState('');
    const [rentals, setRentals] = useState([]);
    const [isSideMenuOpen, setIsSideMenuOpen] = useState(false);
    const navigate = useNavigate();
    useEffect(() => {
        axios.get('/api/user') // Replace this with your actual API call
            .then(response => setUserInfo(response.data))
            .catch(error => console.error(error));
    }, []);

    const handleLogoClick = () => setIsSideMenuOpen(!isSideMenuOpen);

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


  const sideMenuStyle = {
    position: 'fixed',
    top: 0,
    right: 0,
    height: '100vh',
    width: '250px',
    backgroundColor: '#FFBD59',
    padding: '20px',
    display: isSideMenuOpen ? 'block' : 'none',
    zIndex: 1000,
};

const closeButtonStyle = {
    cursor: 'pointer',
    position: 'absolute',
    right: '20px',
    color: '#4b0082'
};

const sideMenuButtonStyle = {
    backgroundColor: '#4b0082',
    color: 'white',
    padding: '10px 20px',
    border: 'none',
    borderRadius: '30px',
    cursor: 'pointer',
    height: '40px',
    width: '100%',
    marginBottom: '20px',
    display: 'flex',
    justifyContent: 'center',
    alignItems: 'center',
};
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
      marginLeft: '0px',
      marginRight: '3vw',
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
  const handleSwitchClick = () => {
    navigate('/traveler-main-page');
};
  const handleProfileClick = () => {
        navigate('/homeowner-profile');
    };
const handleAddRentalClick =() => {
        navigate('/homeowner-rental');
    };
    return (  
      <div style={wrapperStyle}>
        {isSideMenuOpen && (
                    <div style={sideMenuStyle}>
                        <AiOutlineClose style={closeButtonStyle} size={30} onClick={() => setIsSideMenuOpen(false)} />
                        <img src="/mor_logo.png" alt="Side Menu Logo" style={{...logoStyle, margin: '0 auto'}} />
                        <br></br><br></br><br></br>
                        <button onClick ={handleSwitchClick}style={sideMenuButtonStyle}>Switch to Traveler</button>
                        <br></br>
                        <button onClick ={handleProfileClick} style={sideMenuButtonStyle}>Profile</button>
                        <br></br>
                        <button onClick = {handleAddRentalClick}style={sideMenuButtonStyle}>Add Rental</button>
                        <br></br>
                    
                        <button style={sideMenuButtonStyle}>Logout</button>

                    </div>
                )}
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
                    <div style={userDetailStyle}>
                        <div>{`Ege Ayan`}</div>
                        <div>{`Balance: ${userInfo.balance}`}</div>
                    </div>
                    <img src="/default_pp.png" alt="Profile" style={profilePicStyle} />
                    <img src="/side_menu.png" alt="Menu" style={menuButtonStyle} onClick={() => setIsSideMenuOpen(true)}/>
                </div>
                
            </div>
            <div style={rentalsGridStyle}>
                {rentals.map((rental, index) => (
                    <Link to="/homeowner-review">
                    <div key={index} style={rentalCardStyle}>
                        <img src={rental.image} alt="Rental" style={rentalImageStyle} />
                        <div style={rentalInfoStyle}>{rental.location}</div>
                        <div style={rentalInfoStyle}>{rental.availableDates}</div>
                        <div style={rentalInfoStyle}>{rental.price}</div>
                        <div style={rentalInfoStyle}>{`Ratings: ${rental.ratings}`}</div>
                    </div>
                    </Link>
                ))}
            </div>
        </div>
    
        </div>
    );
};

export default HomeOwnerMainPage;
