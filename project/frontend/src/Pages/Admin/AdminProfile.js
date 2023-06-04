import React, { useState, useEffect } from 'react';
import axios from 'axios';
import Modal from 'react-modal'; 
import { useNavigate } from 'react-router-dom';
import html2canvas from 'html2canvas';
import jsPDF from 'jspdf';
import { saveAs } from 'file-saver';



Modal.setAppElement('#root');
const AdminProfile = () => {
    const [userInfo, setUserInfo] = useState({});
    const [email, setEmail] = useState('');
    const [phone, setPhone] = useState('');
    const [modalIsOpen, setModalIsOpen] = useState(false); 
    const [title, setTitle] = useState('');
    const [selectedOption, setSelectedOption] = useState(''); 
    const navigate = useNavigate();
    const handleOpenModal = () => {
        setModalIsOpen(true);
    };

    const handleCloseModal = () => {
        setModalIsOpen(false);
    };

    useEffect(() => {
        axios.get('http://localhost:8080/api/admin/id=' + window.localStorage.getItem('user'))
            .then(response => setUserInfo(response.data))
            .catch(error => console.error(error));
    }, []);

    const handleChangeEmail = () => {
        axios.put('http://localhost:8080/api/user/a/id=' + window.localStorage.getItem('user') + '/email=' + email)
            .then(response => setUserInfo(response.data))
            .catch(error => console.error(error));
    };

    const handleChangePhone = () => {
        axios.put('http://localhost:8080/api/user/a/id=' + window.localStorage.getItem('user') + '/phone=' + phone)
            .then(response =>{
                console.log("print");
                console.log(response.data);
                console.log("print");
                setUserInfo(response.data)
            } )
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

    const handlePasswordClick = () => {
        navigate('/reset-password');
    };

    const generateReport = async () => {
        try {
          const response = await axios.post('http://localhost:8080/api/system-report', {
            "title": null,
            "content": null,
            "adminId": window.localStorage.getItem('user')
          });
          console.log(response.data);
            var text = String(response.data);
      
            const element = document.createElement('a');
            const file = new Blob([text], {type: 'text/plain'});
            element.href = URL.createObjectURL(file);
            element.download = "System Report";
            document.body.appendChild(element);
            element.click();
            document.body.removeChild(element);
                    } catch (error) {
                    console.error('Error generating report:', error);
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

    const buttonStyle2 = {
        backgroundColor: '#FFBD59',
        color: '#4b0082',
        padding: '20px 40px',
        border: 'none',
        fontWeight: 'bold',
        borderRadius: '60px',
        cursor: 'pointer',
        fontSize: '25px',
        margin: '40px 0',
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
                
                    <p style={pStyle}>Name: {userInfo.fullName}</p>
                    <p style={pStyle}>E-mail: {userInfo.email}</p>
                    <p style={pStyle}>TCK: {userInfo.tck}</p>
                    <p style={pStyle}>Date of Birth: {userInfo.dob}</p>
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
                    <button style={buttonStyle} onClick = {handlePasswordClick}>Change Password</button>
                    <p></p>
                </div>
                
            </div>
            <button style={buttonStyle2} onClick = {handleOpenModal}>Create System Report</button>

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
                    backgroundColor: '#FFBD59', // yellow background
                    padding: '20px',
                    borderRadius: '10px',
                    display: 'flex',
                    flexDirection: 'column',
                    alignItems: 'center'
                }
            }}
        >
            <h2 style={{ color: '#4B0082' }}>System Report Generated</h2> {/* purple title */}
            <button style={{...buttonStyle2, backgroundColor: '#4b0082', color: '#FFBD59', alignSelf: 'center' }} onClick={generateReport}>Download</button>
        </Modal>
        </div>
    );
};

export default AdminProfile;
