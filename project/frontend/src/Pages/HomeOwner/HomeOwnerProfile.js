import React, { useState, useEffect } from 'react';
import axios from 'axios';
import Modal from 'react-modal'; // Import Modal
import { useNavigate } from 'react-router-dom';

// Make sure to bind modal to your appElement (http://reactcommunity.org/react-modal/accessibility/)
Modal.setAppElement('#root')

const HomeOwnerProfile= () => {
    const [userInfo, setUserInfo] = useState({});
    const [email, setEmail] = useState('');
    const [phone, setPhone] = useState('');
    const [modalIsOpen, setModalIsOpen] = useState(false); // New state for managing modal
    const [paymentMethod, setPaymentMethod] = useState(''); // New state for managing selected payment method
    const [amount, setAmount] = useState(0); // New state for managing amount to add
    const navigate = useNavigate();
    useEffect(() => {
        axios.get('http://localhost:8080/api/homeowner/id=' + window.localStorage.getItem('user'))
            .then(response => setUserInfo(response.data))
            .catch(error => console.error(error));
    }, []);

    const handleChangeEmail = () => {
        axios.put('http://localhost:8080/api/user/h/id=' + window.localStorage.getItem('user') + "/email=" + email)
            .then(response => setUserInfo(response.data))
            .catch(error => console.error(error));
    };

    const handleChangePhone = () => {
        axios.put('http://localhost:8080/api/user/h/id=' + window.localStorage.getItem('user') + '/phone=' + phone)
            .then(response => setUserInfo(response.data))
            .catch(error => console.error(error));
    };

    const handleAddBalance = () => {
        let x = userInfo.balance + parseFloat(amount);
        axios.put('http://localhost:8080/api/homeowner/id=' + window.localStorage.getItem('user') + "/balance=" + x)
            .then(response => setUserInfo(response.data))
            .catch(error => console.error(error));
        handleCloseModal();
    };

    const handleAmountChange = (event) => {
        setAmount(event.target.value);
    };

    const handleOpenModal = () => {
        setModalIsOpen(true);
    };

    const handleCloseModal = () => {
        setModalIsOpen(false);
    };

    const handlePaymentMethodChange = (event) => {
        setPaymentMethod(event.target.value);
    };

    const handleConfirm = () => {
        // Here you can do something with the selected payment method
        // For example, make an API request

        // Close the modal after confirming
        handleCloseModal();
    };

    const labelStyle = {
        display: 'flex',
        flexDirection: 'column',
        alignItems: 'center',
        width: '100%',
        marginTop: '10px',
    };

    const modalStyle = {
        content: {
            top: '50%',
            left: '50%',
            right: 'auto',
            bottom: 'auto',
            marginRight: '-50%',
            transform: 'translate(-50%, -50%)',
            backgroundColor: '#4b0082',
            color: 'white',
            borderRadius: '10px',
            padding: '20px',
            display: 'flex',
            flexDirection: 'column',
            justifyContent: 'center',
            alignItems: 'center',
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
        width: '70%',
        border: '1px solid #ccc',
    borderRadius: '5px',
    padding: '10px',
    }

    
    const selectStyle = {
        ...inputStyle, // This will apply the same styles to the select as the input
        appearance: 'none', // This will remove default browser styling
        background: '#fff',
        cursor: 'pointer',
    };
    

    const pStyle = {
        fontSize: '18px',
        fontFamily: '"Arial", sans-serif'
    }
    const handlePasswordClick = () => {
        navigate('/reset-password');
    };
    const options = { day: '2-digit', month: '2-digit', year: 'numeric' };
    const formattedDate = new Date(userInfo.dob).toLocaleDateString('en-GB', options);
    return (
        <div style={{ backgroundColor: '#4b0082', height: '100vh', display: 'flex', flexDirection: 'column', alignItems: 'center', justifyContent: 'center', color: 'white' }}>
            <div style={{ position: 'absolute', top: 0, left: 0 }}>
                <img src="/bilkent_logo.png" alt="Logo" style={{margin:50, width: 250, height: 100 }} />
            </div>
            <h1 style={{color: '#FFBD59'}}>HOMEOWNER</h1>
            <div style={{ display: 'flex', justifyContent: 'center', alignItems: 'center', flexDirection: 'column' }}>
                <img src={"/default_pp.png"} alt="Profile" style={{ width: 100, height: 100, borderRadius: '50%' }} />
                <button style={buttonStyle}>Change Profile Picture</button>
            </div>
            <div style={{ display: 'flex', justifyContent: 'space-between', width: '80%', marginTop: 20 }}>
                <div>
                    <div style={{ display: 'flex', alignItems: 'center' }}>
                        <p style={pStyle}>Balance: {userInfo.balance}</p>
                        <img src="/add_icon.png" alt="Add Balance" style={{cursor: 'pointer', width: 30, height:30 , marginLeft: '10px'}} onClick={handleOpenModal} />
                    </div>
                    <p style={pStyle}>Reputation: {userInfo.reputation}</p>
                    <p style={pStyle}>Name: {userInfo.fullName}</p>
                    <p style={pStyle}>E-mail: {userInfo.email}</p>
                    <p style={pStyle}>TCK: {userInfo.tck}</p>
                    <p style={pStyle}>Date of Birth: {formattedDate}</p>
                    <p style={pStyle}>Phone No: {userInfo.phoneNumber}</p>
                </div>
                <div>
                    <div style={{ display: 'flex', alignItems: 'center', marginBottom: 10 }}>
                        <input type="email" value={email} onChange={e => setEmail(e.target.value)} style={inputStyle} />
                        <button style={buttonStyle} onClick={handleChangeEmail}>Change Email</button>
                    </div>
                    <div style={{ display: 'flex', alignItems: 'center', marginBottom: 10 }}>
                        <input type="tel" value={phone} onChange={e => setPhone(e.target.value)} style={inputStyle} />
                        <button style={buttonStyle} onClick={handleChangePhone}>Change Phone Number</button>
                    </div>
                    <button onClick = {handlePasswordClick} style={buttonStyle}>Change Password</button>
                </div>
            </div>
            <Modal
                isOpen={modalIsOpen}
                onRequestClose={handleCloseModal}
                style={modalStyle}
                contentLabel="Add Balance"
            >
                <h2 style={{color: '#FFBD59'}}>Add Balance</h2>
                <div style={labelStyle}>
    <label>
        Choose Payment Method:
        <select value={paymentMethod} onChange={handlePaymentMethodChange} style={selectStyle}>
            <option value="">--Please choose an option--</option>
            <option value="gpay">G-PAY</option>
            <option value="creditCard">Credit Card</option>
        </select>
    </label>

    <input type="number" placeholder="Enter the amount" onChange={handleAmountChange} style={inputStyle} />

</div>
{paymentMethod === 'creditCard' && (
    
    <div style={{ display: 'flex', flexDirection: 'column', alignItems: 'center', width: '100%' }}>
        <input type="text" placeholder="Credit Card Number" style={inputStyle} />
        <input type="text" placeholder="CVC" style={inputStyle} />
        <input type="text" placeholder="Expiration Date" style={inputStyle} />
    </div>
)}
                <button style={buttonStyle} onClick={handleAddBalance}>Confirm</button>
            </Modal>
        </div>
    );
};

export default HomeOwnerProfile;