import React, { useState, useEffect } from 'react';
import axios from 'axios';
import Modal from 'react-modal'; 

Modal.setAppElement('#root');
const AdminProfile = () => {
    const [userInfo, setUserInfo] = useState({});
    const [email, setEmail] = useState('');
    const [phone, setPhone] = useState('');
    const [modalIsOpen, setModalIsOpen] = useState(false); // For modal
    const [title, setTitle] = useState(''); // For modal title
    const [selectedOption, setSelectedOption] = useState(''); // For selected report option
    const handleOpenModal = () => {
        setModalIsOpen(true);
    };

    const handleCloseModal = () => {
        setModalIsOpen(false);
    };

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
    const handleCreateReport = () => {
        // API call to create report
        axios.post('/api/user/report', { title, option: selectedOption })
            .then(response => {
                setModalIsOpen(false); // Close the modal after creating the report
                // handle the response
            })
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
            <div style={{ display: 'flex', justifyContent: 'center', alignItems: 'center', flexDirection: 'column' }}>
                <img src={"/default_pp.png"} alt="Profile" style={{ width: 100, height: 100, borderRadius: '50%', marginBottom:'40px' }} />
            </div>
            <div style={{ display: 'flex', justifyContent: 'space-between', width: '80%', marginTop: 20 }}>
                <div>
                
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
                    <p></p>
                    <button style={buttonStyle} onClick = {handleOpenModal}>Create System Report</button>
                </div>
            </div>
            

        <Modal 
            isOpen={modalIsOpen}
            onRequestClose={handleCloseModal}
            style={{ 
                content: { 
                    top: '50%', 
                    left: '50%', 
                    right: 'auto', 
                    bottom: 'auto', 
                    marginRight: '-50%', 
                    transform: 'translate(-50%, -50%)',
                    backgroundColor: '#ffff00', // yellow background
                    padding: '20px',
                    borderRadius: '10px',
                    display: 'flex',
                    flexDirection: 'column',
                    alignItems: 'center'
                }
            }}
        >
            <h2 style={{ color: '#800080' }}>Create System Report</h2> {/* purple title */}
            <input 
                type="text" 
                value={title} 
                onChange={e => setTitle(e.target.value)} 
                placeholder="Title" 
                style={{ width: '100%', padding: '10px', marginBottom: '20px', borderRadius: '5px' }} 
            />
            <div style={{ marginBottom: '20px', backgroundColor: '#f0f0f0', padding: '10px', borderRadius: '5px' }}>
                <input type="radio" id="option1" name="reportOption" value="option1" onChange={e => setSelectedOption(e.target.value)} />
                <label htmlFor="option1">Top 10 rentals with highest rate</label>
            </div>
            <div style={{ marginBottom: '20px', backgroundColor: '#f0f0f0', padding: '10px', borderRadius: '5px' }}>
                <input type="radio" id="option2" name="reportOption" value="option2" onChange={e => setSelectedOption(e.target.value)} />
                <label htmlFor="option2">Top 5 popular homeowners</label>
            </div>
            <button style={{...buttonStyle, backgroundColor: '#800080', color: '#ffff00', alignSelf: 'center' }} onClick={handleCreateReport}>Create</button>
        </Modal>
        </div>
    );
};

export default AdminProfile;
