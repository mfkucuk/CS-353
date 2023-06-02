import React, { useState } from 'react';
import axios from 'axios';
import Modal from 'react-modal';
Modal.setAppElement('#root')
const HomeOwnerRental = () => {
    const [rentalType, setRentalType] = useState('Room');
    const [location, setLocation] = useState('');
    const [roomCount, setRoomCount] = useState(1);
    const [startDate, setStartDate] = useState('');
    const [endDate, setEndDate] = useState('');
    const [restrictions, setRestrictions] = useState('');
    const [features, setFeatures] = useState([]);
    const [modalIsOpen, setIsOpen] = useState(false);
     const [featureList, setFeatureList] = useState([
        { name: 'Wi-Fi', enabled: false },
        { name: 'Large Room', enabled: false },
        { name: 'Swimming Pool', enabled: false },
        { name: 'Close to Sea', enabled: false },
        { name: 'Air Conditioner', enabled: false },
        { name: 'Fridge', enabled: false },
        { name: 'Near to Restaurants', enabled: false },
        { name: 'Near Tourist Attractions', enabled: false },
        { name: 'Near public transport', enabled: false },
    ]);


    const openModal = () => {
        setIsOpen(true);
    }

    const closeModal = () => {
        setIsOpen(false);
    }

    const handleAddFeature = (index) => {
        setFeatureList(featureList.map((feature, i) => i === index ? { ...feature, enabled: !feature.enabled } : feature));
    }



    const handleConfirmRental = async () => {
        const selectedFeatures = featureList
            .filter(feature => feature.enabled)
            .map(feature => feature.name);
    
        try {
            const response = await axios.post('https://your-api-url.com/endpoint', {
                rentalType,
                location,
                roomCount,
                startDate,
                endDate,
                restrictions,
                features: selectedFeatures  // use selectedFeatures here
            });
            
            console.log(response.data);
        } catch (error) {
            console.error(error);
        }
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

    const inputStyle = {
        margin: '10px 0',
        height: '40px',
        borderRadius: '5px',
        padding: '0 10px',
        fontSize: '16px',
        width: '80%'
    }

    const labelStyle = {
        margin: '10px 0',
        fontSize: '16px',
        marginRight: '10px'
    }


    return (
        <div style={{ backgroundColor: '#4b0082', height: '100vh', display: 'flex', flexDirection: 'column', alignItems: 'center', justifyContent: 'center', color: 'white' }}>
            <div style={{ position: 'absolute', top: 0, left: 0 }}>
                <img src="/bilkent_logo.png" alt="Logo" style={{margin:50, width: 250, height: 100 }} />
            </div>
            <h1 style={{color: '#FFBD59'}}>Add New Rental</h1>
            <div style={{ display: 'flex', justifyContent: 'space-between', width: '80%', marginTop: 20 }}>
                <div>
                    <div style={{ display: 'flex', alignItems: 'center', marginBottom: 10 }}>
                        <label style={labelStyle}>Rental Type:</label>
                        <label>
                            <input type="radio" value="Room" checked={rentalType === 'Room'} onChange={e => setRentalType(e.target.value)} />
                            Room
                        </label>
                        <label>
                            <input type="radio" value="Flat" checked={rentalType === 'Flat'} onChange={e => setRentalType(e.target.value)} />
                            Flat
                        </label>
                    </div>
                    <div style={{ display: 'flex', alignItems: 'center', marginBottom: 10 }}>
                        <label style={labelStyle}>Location:</label>
                        <input type="text" value={location} onChange={e => setLocation(e.target.value)} placeholder="Location" style={inputStyle} />
                    </div>
                    <div style={{ display: 'flex', alignItems: 'center', marginBottom: 10 }}>
                        <label style={labelStyle}>Room Count:</label>
                        {rentalType === 'Room' ? (
                            <input type="number" value={1} disabled style={inputStyle} />
                        ) : (
                            <input type="number" value={roomCount} onChange={e => setRoomCount(e.target.value)} placeholder="Room Count" min="1" style={inputStyle} />
                        )}
                    </div>
                    <div style={{ display: 'flex', alignItems: 'center', marginBottom: 10 }}>
                        <label style={labelStyle}>Available dates:</label>
                        <input type="date" value={startDate} onChange={e => setStartDate(e.target.value)} style={inputStyle} />
                        <span>to</span>
                        <input type="date" value={endDate} onChange={e => setEndDate(e.target.value)} style={inputStyle} />
                    </div>
                    <div style={{ display: 'flex', alignItems: 'center', marginBottom: 10 }}>
                        <label style={labelStyle}>Restrictions:</label>
                        <textarea value={restrictions} onChange={e => setRestrictions(e.target.value)} placeholder="Restrictions" style={inputStyle} />
                    </div>
                    <div style={{ marginBottom: 10 }}>
                        <label style={labelStyle}>Features:</label>
                        <ul>
                            {features.map((feature, index) => (
                                <li key={index}>{feature}</li>
                            ))}
                        </ul>
                    </div>
                    <button style={buttonStyle} onClick={openModal}>Add Features</button>
                </div>
                <div style={{display: 'flex', flexDirection: 'column', alignItems: 'flex-end'}}>
                    <button style={buttonStyle} onClick={handleConfirmRental}>Confirm Rental</button>
                    <img src="/example_rental.jpg" alt="Rental" style={{ width: '60%', height: 'auto', marginTop: '20px', marginLeft: '20px' }} />
                </div>
            </div>
            <Modal
                isOpen={modalIsOpen}
                onRequestClose={closeModal}
                style={{
                    overlay: { backgroundColor: 'rgba(0, 0, 0, 0.5)' },
                    content: {
                        backgroundColor: '#4b0082',
                        color: 'white',
                        width: '300px',
                        height: '500px',
                        margin: 'auto',
                        padding: '20px',
                        display: 'flex',
                        flexDirection: 'column',
                        justifyContent: 'center',
                        alignItems: 'center'
                    }
                }}
            >
                <h2 style={{ color: '#FFBD59', marginBottom: '20px' }}>Add Features</h2>
                {featureList.map((feature, index) => (
                    <div key={index} style={{ marginBottom: '10px' }}>
                        <label style={{ marginRight: '10px' }}>{feature.name}</label>
                        <input type="checkbox" checked={feature.enabled} onChange={() => handleAddFeature(index)} />
                    </div>
                ))}
                <button style={buttonStyle} onClick={closeModal}>Confirm</button>
            </Modal>
        </div>
    );
};

export default HomeOwnerRental;
