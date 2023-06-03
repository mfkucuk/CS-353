import React, { useState } from 'react';
import axios from 'axios';

const ResetPassword = () => {
  const [oldPassword, setOldPassword] = useState('');
  const [password, setPassword] = useState('');
  const [reenterPassword, setReenterPassword] = useState('');
  const [error, setError] = useState('');
  const [success, setSuccess] = useState(false);

  const userPassword = 'currentPassword';

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
      return;
    }

    if (!/(?=.*[A-Z])/.test(password)) {
      setError('Password should contain at least one capital letter.');
      return;
    }

    if (!/(?=.*\d)/.test(password)) {
      setError('Password should contain at least one number.');
      return;
    }

    if (!/(?=.*[?.!@#$%^&*])/.test(password)) {
      setError('Password should contain at least one special character.');
      return;
    }

    if (oldPassword !== userPassword){
      setError('Old password is wrong.')
    }

    if (password !== reenterPassword) {
      setError('Passwords do not match.');
      return;
    }

    // Perform the POST request to update the password
    axios.post('/api/reset-password', { password })
      .then(() => {
        setSuccess(true);
        setError('');
      })
      .catch((error) => {
        setError('An error occurred while resetting the password.');
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
        {success && <p style={{ color: 'green' }}>Password reset successful!</p>}
        <button  style={{ backgroundColor: '#FFBD59', color: '#4B0082', border: 'none', padding: '0.5rem 1rem', borderRadius: '20px', marginTop: '10px', marginBottom: '10px'}} onClick={handleResetPassword}>Reset Password</button>
        <br/>
      </div>
    </div>
  );
};

export default ResetPassword;
