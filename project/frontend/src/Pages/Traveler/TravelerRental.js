import React, { useState, useEffect } from 'react';
import axios from 'axios';

const TravelerRental = () => {
    const [rentalData, setRentalData] = useState({});
    const [isLoading, setIsLoading] = useState(true);

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

    const contentStyle = {
        fontSize: '18px'
    }

    const buttonStyle = {
        backgroundColor: '#FFBD59',
        color: 'black',
        padding: '10px 20px',
        border: 'none',
        borderRadius: '5px',
        cursor: 'pointer',
        fontSize: '16px',
        margin: '10px 0',
        transition: 'all 0.3s ease',
        marginLeft: '10px'
    }

    const imageStyle = {
        width: '75%',
        marginRight: '20%',
        height: 'auto'
    }

    const homeownerStyle = {
        display: 'flex',
        alignItems: 'center',
        margin: '10px 0'
    }

    const homeownerImageStyle = {
        width: 50,
        height: 50,
        borderRadius: '50%',
        marginRight: '10px'
    }

    

    return (
        <div style={{ backgroundColor: '#4b0082', height: '100vh', display: 'flex', flexDirection: 'column', alignItems: 'center', justifyContent: 'center', color: 'white' }}>
            <div style={{ position: 'absolute', top: 0, left: 0 }}>
                <img src="/bilkent_logo.png" alt="Logo" style={{margin:50, width: 250, height: 100 }} />
            </div>
            <h1 style={{color: '#FFBD59'}}>Rental in {rentalData.location}</h1>
            <div style={{ display: 'flex', justifyContent: 'space-between', width: '80%', marginTop: 20 }}>
                <div>
                    <img src="/example_rental.jpg" alt="Rental" style={imageStyle} />
                </div>
                <div>
                    <p style={contentStyle}>Location: {rentalData.location}</p>
                    <p style={contentStyle}>Room Count: {rentalData.roomCount}</p>
                    <p style={contentStyle}>Rating: {rentalData.rating}/5</p>
                    <p style={contentStyle}>Available dates: {rentalData.startDate} to {rentalData.endDate}</p>
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
        </div>
    );
};

export default TravelerRental;
