import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { AiOutlineClose } from 'react-icons/ai'; 
import { Button } from 'react-bootstrap';
import { Link } from 'react-router-dom';
import { useNavigate } from 'react-router-dom';
import Modal from 'react-modal';
const TravelerMainPage = () => {
    const [userName, setUserName] = useState('');
    const [userBalance, setUserBalance] = useState(0);
    const [searchInput, setSearchInput] = useState('');
    const [rentals, setRentals] = useState([]);
    const [isSideMenuOpen, setIsSideMenuOpen] = useState(false);
    const navigate = useNavigate();
    const [filterType, setFilterType] = useState("");
const [minPrice, setMinPrice] = useState(0);
const [maxPrice, setMaxPrice] = useState(0);
const [startDate, setStartDate] = useState("");
const [endDate, setEndDate] = useState("");
    const [modalIsOpen, setModalIsOpen] = useState(false);
    useEffect(() => {
        axios.get('http://localhost:8080/api/traveler/id=' + window.localStorage.getItem('user') ) 
            .then(response => {
                                setUserName(response.data.fullName);
                                setUserBalance(response.data.balance);
                                console.log(userName);
                            })
            .catch(error => console.error(error));
    }, []);

    const handleLogoClick = () => setIsSideMenuOpen(!isSideMenuOpen);

    useEffect(() => {
      
        axios.get("http://localhost:8080/api/rental")
            .then(res => setRentals(res.data))
            .catch();
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
    marginTop: '200px', 
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
       
        borderRadius: '50%', 
        marginLeft: '30px' 
    };

    const filterSearchContainerStyle = {
      display: 'flex',
      justifyContent: 'center', 
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
      backgroundColor: '#4b0082', 
      minHeight: '100vh', 
      color: 'white'
  };
  const handleSwitchClick = () => {
    navigate('/homeowner-main-page');
};
  const handleProfileClick = () => {
        navigate('/traveler-profile');
    };
const handleRentalListClick =() => {
        navigate('/traveler-listing');
    };

    const handleSubmitFilter =() => {
        setModalIsOpen(false);
    }
    return (  
      <div style={wrapperStyle}>
        {isSideMenuOpen && (
                    <div style={sideMenuStyle}>
                        <AiOutlineClose style={closeButtonStyle} size={30} onClick={() => setIsSideMenuOpen(false)} />
                        <img src="/mor_logo.png" alt="Side Menu Logo" style={{...logoStyle, margin: '0 auto'}} />
                        <br></br><br></br><br></br>
                        <button onClick={handleSwitchClick} style={sideMenuButtonStyle}>Switch to Homeowner</button>
                        <br></br>
                        <button onClick={handleProfileClick} style={sideMenuButtonStyle}>Profile</button>
                        <br></br>
                        <button onClick= {handleRentalListClick}style={sideMenuButtonStyle}>Rental List</button>
                        <br></br>
                        <button style={sideMenuButtonStyle}>Logout</button>
                    </div>
                )}
                <Modal 
  isOpen={modalIsOpen}
  onRequestClose={() => setModalIsOpen(false)}
  style={{
    overlay: {
      zIndex: 1002,
    },
    content: {
      backgroundColor: '#FFBD59',
      color: '#4b0082',
      display: 'flex',
      flexDirection: 'column',
      alignItems: 'center',
      justifyContent: 'space-around',
      width: '40%',
      height: '70%',
      padding: '20px',
      borderRadius: '10px',
      outline: 'none',
      fontSize: '1.2em',
      lineHeight: '1.5',
      position: 'absolute',
      top: '50%',
      left: '50%',
      transform: 'translate(-50%, -50%)'
    }
  }}
>
  <h2>Filter</h2>
  <div style={{marginBottom: '20px'}}>
    <label>
      <input 
        type="checkbox"
        checked={filterType === "room"}
        onChange={() => setFilterType("room")}
        style={{
          margin: '0 10px',
          transform: 'scale(1.5)'
        }}
      /> 
      Room
    </label>
    <label>
      <input 
        type="checkbox"
        checked={filterType === "flat"}
        onChange={() => setFilterType("flat")}
        style={{
          margin: '0 10px',
          transform: 'scale(1.5)'
        }}
      /> 
      Flat
    </label>
  </div>
  <div style={{marginBottom: '20px'}}>
    Price Range: 
    <input 
      type="number" 
      value={minPrice} 
      onChange={e => setMinPrice(e.target.value)} 
      style={{
        margin: '0 10px',
        padding: '5px',
        borderRadius: '5px'
      }}
    />
    -
    <input 
      type="number" 
      value={maxPrice} 
      onChange={e => setMaxPrice(e.target.value)} 
      style={{
        margin: '0 10px',
        padding: '5px',
        borderRadius: '5px'
      }}
    />
  </div>
  <div style={{marginBottom: '20px'}}>
    Date Range: 
    <input 
      type="date" 
      value={startDate} 
      onChange={e => setStartDate(e.target.value)} 
      style={{
        margin: '0 10px',
        padding: '5px',
        borderRadius: '5px'
      }}
    />
    -
    <input 
      type="date" 
      value={endDate} 
      onChange={e => setEndDate(e.target.value)} 
      style={{
        margin: '0 10px',
        padding: '5px',
        borderRadius: '5px'
      }}
    />
  </div>
  <button 
    style={{
      alignSelf: 'center', 
      backgroundColor: '#4b0082', 
      color: '#FFBD59', 
      padding: '10px 20px', 
      borderRadius: '5px',
      border: 'none',
      fontSize: '1em',
      cursor: 'pointer'
    }} onClick={handleSubmitFilter}
  >
    Confirm
  </button>
</Modal>


        <div>
            <div style={topBarStyle}>
                <img src="/bilkent_logo.png" alt="Logo" style={logoStyle} />
                <div style={filterSearchContainerStyle}>
                    <button onClick = {() => setModalIsOpen(true)} style={buttonStyle}>Filter</button>
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
                        <div>{userName}</div>
                        <div>{`Balance: ${userBalance}`}</div>
                    </div>
                    <img src="/default_pp.png" alt="Profile" style={profilePicStyle} />
                    <img src="/side_menu.png" alt="Menu" style={menuButtonStyle} onClick={() => setIsSideMenuOpen(true)}/>
                </div>
                
            </div>
            <div style={rentalsGridStyle}>
                {rentals.map((rental, index) => (
                    <Link to={`/traveler-rental?index=${rental.rentalId}`}>
                    <div key={index} style={rentalCardStyle}>
                        <img src="/example_rental.jpg" alt="Rental" style={rentalImageStyle} />
                        <div style={rentalInfoStyle}>{rental.location}</div>
                        <div style={rentalInfoStyle}>{rental.availableStart}-{rental.availableEnd}</div>
                        <div style={rentalInfoStyle}>{rental.price}</div>
                        <div style={rentalInfoStyle}>{`Ratings: ${rental.rating}`}</div>
                    </div>
                    </Link>
                ))}
            </div>
        </div>
        
        </div>
    );
};

export default TravelerMainPage;
