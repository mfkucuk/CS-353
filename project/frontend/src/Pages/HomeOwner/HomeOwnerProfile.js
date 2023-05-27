import React, { useState, useEffect } from 'react';
import axios from 'axios';

const HomeOwnerMainPage = () => {
    const [userInfo, setUserInfo] = useState({});
    const [email, setEmail] = useState('');
    const [phone, setPhone] = useState('');

    useEffect(() => {
        axios.get('/api/user')
            .then(response => setUserInfo(response.data))
            .catch(error => console.error(error));
    }, []);

    const handleChangeEmail = () => {
        axios.post('/api/user/email', { email })
            .then(response => setUserInfo(response.data))
            .catch(error => console.error(error));
    };

    const handleChangePhone = () => {
        axios.post('/api/user/phone', { phone })
            .then(response => setUserInfo(response.data))
            .catch(error => console.error(error));
    };

    const handleAddBalance = () => {
        axios.post('/api/user/addBalance')
            .then(response => setUserInfo(response.data))
            .catch(error => console.error(error));
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
        fontSize: '16px',
        width: '70%'
    }

    const pStyle = {
        fontSize: '18px',
        fontFamily: '"Arial", sans-serif'
    }

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
                        <img src="/add_icon.png" alt="Add Balance" style={{cursor: 'pointer', width: 30, height:30 , marginLeft: '10px'}} onClick={handleAddBalance} />
                    </div>
                    <p style={pStyle}>Reputation: {userInfo.reputation}</p>
                    <p style={pStyle}>Name: {userInfo.name}</p>
                    <p style={pStyle}>E-mail: {userInfo.email}</p>
                    <p style={pStyle}>TCK: {userInfo.tck}</p>
                    <p style={pStyle}>Date of Birth: {userInfo.dob}</p>
                    <p style={pStyle}>Phone No: {userInfo.phone}</p>
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
                    <button style={buttonStyle}>Change Password</button>
                    <button style={buttonStyle}>Written Reviews</button>
                    <button style={buttonStyle}>Received Reviews</button>
                </div>
            </div>
        </div>
    );
};

export default HomeOwnerMainPage;
