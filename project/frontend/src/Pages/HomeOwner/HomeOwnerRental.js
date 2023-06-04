import React, { useState } from 'react';
import axios from 'axios';
import Modal from 'react-modal';
Modal.setAppElement('#root')
const HomeOwnerRental = () => {
    const [rentalType, setRentalType] = useState('Room');
    const [location, setLocation] = useState('');
    const [roomCount, setRoomCount] = useState(1);
    const [capacity, setCapacity] = useState(1);
    const [startDate, setStartDate] = useState('');
    const [endDate, setEndDate] = useState('');
    const [restrictions, setRestrictions] = useState('');
    const [features, setFeatures] = useState([]);
    const [rentalId, setRentalId] = useState('');
    const [price, setPrice] = useState('');
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

    var today = new Date().toISOString().split("T")[0];


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
            console.log(window.localStorage.getItem('user'));
            if(price < 0){
                alert("Price cannot be a negative value!")
            }
            else
            {
                const response = await axios.post('http://localhost:8080/api/rental', {
                    "location": location,
                    "availableStart": startDate,
                    "availableEnd": endDate,
                    "restrictions": restrictions,
                    "type": rentalType,
                    "rating": 0,
                    "features": selectedFeatures,
                    "comments": [],
                    "price": price,
                    "travelerId": "",
                    "homeownerId": window.localStorage.getItem('user')
                });

                const newRentalId = response.data;
            setRentalId(newRentalId);
    
            console.log(newRentalId);
    
            if (rentalType === 'Room') {
                await axios.post(`http://localhost:8080/api/room/id=${newRentalId}`, {
                    "rentalId": null,
                    "capacity": capacity
                });
            } else {
                await axios.post(`http://localhost:8080/api/flat/id=${newRentalId}`, {
                    "rentalId": null,
                    "roomCount": roomCount
                });
            }
            }
            
            
    
            
        } catch (error) {
            console.error(error);
        }
    };
    


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
        marginLeft: '10px',
        marginRight: '10px',
        fontSize: '16px',
        width: '80%'
    }

    const labelStyle = {
        margin: '10px 0',
        fontSize: '16px',
        marginRight: '10px'
    }

    const switchContainerStyle = {
        display: 'flex',
        alignItems: 'center',
        marginTop: '20px',
        marginLeft: '100px',
        marginBottom: '20px',
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
        transform: rentalType == 'Room' ? 'translateX(0)' : 'translateX(26px)',
      };

    return (
        <div style={{ backgroundColor: '#4b0082', height: '100vh', display: 'flex', flexDirection: 'column', alignItems: 'center', justifyContent: 'center', color: 'white' }}>
            <div style={{ position: 'absolute', top: 0, left: 0 }}>
                <img src="/bilkent_logo.png" alt="Logo" style={{margin:50, width: 250, height: 100 }} />
            </div>
            <h1 style={{color: '#FFBD59'}}>Add New Rental</h1>
            <div style={{ display: 'flex', justifyContent: 'space-between', width: '80%', marginTop: 20 }}>
                <div>
                    <div style={switchContainerStyle}>
                        <span style={switchLabelStyle}>Room</span>
                        <label className="switch" style={switchButtonStyle}>
                        <input type="checkbox" checked={rentalType === 'Room'} onChange={e => setRentalType(e.target.checked ? 'Room' : 'Flat')} />
                        <span className="slider" style={switchSliderStyle}>
                            <span className="slider-before" style={switchSliderBeforeStyle}></span>
                        </span>
                        </label>
                        <span style={switchLabelStyle}>Flat</span>
                    </div>
                    <div style={{ display: 'flex', alignItems: 'center', marginBottom: 10 }}>
                        <label style={labelStyle}>Location:</label>
                        <input type="text" value={location} onChange={e => setLocation(e.target.value)} placeholder="Location" style={inputStyle} />
                    </div>
                    <div style={{ display: 'flex', alignItems: 'center', marginBottom: 10 }}>
                        <label style={labelStyle}>{rentalType === 'Room' ? 'Capacity:' : 'Room Count:'}</label>
                        {rentalType === 'Room' ? (
                            <input type="number" value={capacity} onChange={e => setCapacity(e.target.value)} placeholder="Capacity" min="1" style={inputStyle} />
                        ) : (
                            <input type="number" value={roomCount} onChange={e => setRoomCount(e.target.value)} placeholder="Room Count" min="1"  style={inputStyle} />
                        )}
                    </div>
                    <div style={{ display: 'flex', alignItems: 'center', marginBottom: 10 }}>
                        <label style={labelStyle}>Available dates:</label>
                        <input type="date" value={startDate} min={today} max={endDate} onChange={e => setStartDate(e.target.value)} style={inputStyle} />
                        <span>to</span>
                        <input type="date" value={endDate} min={startDate} onChange={e => setEndDate(e.target.value)} style={inputStyle} />
                    </div>
                    <div style={{ display: 'flex', alignItems: 'center', marginBottom: 10 }}>
                        <label style={labelStyle}>Restrictions:</label>
                        <textarea value={restrictions} onChange={e => setRestrictions(e.target.value)} placeholder="Restrictions" style={inputStyle} />
                    </div>
                    <div style={{ display: 'flex', alignItems: 'center', marginBottom: 10 }}>
                        <label style={labelStyle}>Price:</label>
                        <input
                            type="number"
                            value={price}
                            onChange={e => setPrice(parseFloat(e.target.value))}
                            placeholder="Price"
                            min="0"
                            style={inputStyle}
                        />
                        <label>$</label>
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
                        justifyContent: 'flex-start',
                        alignItems: 'center',
                        boxSizing: 'border-box'
                    }
                }}
            >
                <h2 style={{ color: '#FFBD59', marginBottom: '20px', backgroundColor: '#4b0082', width: '100%', textAlign: 'center', boxSizing: 'border-box' }}>Add Features</h2>
                <div style={{ overflowY: 'auto', maxHeight: 'calc(100% - 100px)', width: '100%' }}>
                    {featureList.map((feature, index) => (
                        <div key={index} style={{ marginBottom: '10px', backgroundColor: '#FFBD59', width: '100%', padding: '10px', display: 'flex', justifyContent: 'space-between', alignItems: 'center', boxSizing: 'border-box' }}>
                            <label style={{ marginRight: '10px', color: '#4b0082' }}>{feature.name}</label>
                            <input type="checkbox" checked={feature.enabled} onChange={() => handleAddFeature(index)} />
                        </div>
                    ))}
                </div>
                <button style={{ ...buttonStyle, alignSelf: 'center' }} onClick={closeModal}>Confirm</button>
            </Modal>
        </div>
    );
};

export default HomeOwnerRental;