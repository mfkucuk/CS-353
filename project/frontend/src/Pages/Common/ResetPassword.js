import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';

const ResetPassword = () => {
  const [userInfo, setUserInfo] = useState({});
  const [oldPassword, setOldPassword] = useState('');
  const [password, setPassword] = useState('');
  const [reenterPassword, setReenterPassword] = useState('');
  const [error, setError] = useState('');
  const [success, setSuccess] = useState(false);
  const navigate = useNavigate();


  const handleReturn = () => {
      if(userInfo.admin){
          navigate("/admin-profile")
      }
      else{
        navigate("/traveler-main-page")
      }
  } 

  useEffect(() => {
    axios.get('http://localhost:8080/api/user/id=' + window.localStorage.getItem('user'))
        .then(response => setUserInfo(response.data))
        .catch(error => console.error(error));
  }, []);

  const userPassword = userInfo.password;

  const handleOldPasswordChange = (event) => {
    setOldPassword(event.target.value);
  };

  const handlePasswordChange = (event) => {
    setPassword(event.target.value);
  };

  const handleReenterPasswordChange = (event) => {
    setReenterPassword(event.target.value);
  };

  const handleResetPassword = () => {
    if (password.length < 8) {
      setError('Password should be at least 8 characters long.');
      setSuccess(false);
      return;
    }

    if (!/(?=.*[A-Z])/.test(password)) {
      setError('Password should contain at least one capital letter.');
      setSuccess(false);
      return;
    }

    if (!/(?=.*\d)/.test(password)) {
      setError('Password should contain at least one number.');
      setSuccess(false);
      return;
    }

    if (!/(?=.*[?!@#$%^&*])/.test(password)) {
      setError('Password should contain at least one special character.');
      setSuccess(false);
      return;
    }

    if (oldPassword !== userPassword){
      setError('Old password is wrong.')
      setSuccess(false);
      return;
    }

    if (password !== reenterPassword) {
      setError('Passwords do not match.');
      return;
    }

    axios.put('http://localhost:8080/api/user/t/id=' + window.localStorage.getItem('user') + "/password=" + encodeURIComponent(password) )
      .then((response) => {
        setUserInfo(response.data)
        setSuccess(true);
        setError('');
      })
      .catch((error) => {
        setError('An error occurred while resetting the password.');
        setSuccess(false);
        console.error(error);
      });
  };

  return (
    <div style={{ backgroundColor: '#4b0082', minHeight: '100vh', paddingTop: '50px' }}>
      <div style={{ textAlign: 'center', color: '#FFFFFF' }}>
      <img src="bilkent_logo.png" alt="Logo" style={{ width: '600px', height: 'auto' }} />
        
        <h2 style={{ color: '#FFBD59' }}>Enter your old password</h2>
        <input
          style={{ marginRight: '1rem', width: '300px', height: '40px', borderRadius: '20px' }}
          type="password"
          placeholder="Old Password"
          value={oldPassword}
          onChange={handleOldPasswordChange}
        />
        <h2 style={{ color: '#FFBD59' }}>Enter your new password</h2>
        <input
          style={{ marginRight: '1rem', width: '300px', height: '40px', borderRadius: '20px' }}
          type="password"
          placeholder="New Password"
          value={password}
          onChange={handlePasswordChange}
        />
        <br />
        <input
          style={{ marginRight: '1rem', width: '300px', height: '40px', borderRadius: '20px' }}
          type="password"
          placeholder="Re-enter Password"
          value={reenterPassword}
          onChange={handleReenterPasswordChange}
        />
        <br />
        {error && <p style={{ color: 'red' }}>{error}</p>}
        {success && <p style={{ color: 'green'}}>Password reset successful!</p>}
        <button  style={{ backgroundColor: '#FFBD59', width: "8vw", color: '#4B0082', border: 'none', padding: '0.5rem 1rem', borderRadius: '20px', marginTop: '20px', marginBottom: '10px'}} onClick={handleResetPassword}>Reset Password</button>
        <br/>
        <button  style={{ backgroundColor: '#FFBD59', width: "8vw", color: '#4B0082', border: 'none', padding: '0.5rem 1rem', borderRadius: '20px', marginTop: '5px', marginBottom: '10px'}} onClick={handleReturn}>Return</button>
        <br/>
      </div>
    </div>
  );
};

export default ResetPassword;
