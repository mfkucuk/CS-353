import React, { useState } from 'react';
import axios from 'axios';

const ResetPasswordEmail = () => {
  const [email, setEmail] = useState('');

  const handleChange = (e) => {
    setEmail(e.target.value);
  };

  const handleSubmit = (e) => {
    e.preventDefault();

    axios
      .post('/api/register', { email })
      .then((response) => {
        // Handle success
        console.log(response.data);
      })
      .catch((error) => {
        // Handle error
        console.error(error);
      });
  };

  return (
    <div style={{ backgroundColor: '#4b0082', minHeight: '100vh', paddingTop: '50px' }}>
      <div style={{ display: 'flex', justifyContent: 'center' }}>
        <img src="bilkent_logo.png" alt="Logo" style={{ width: '600px', height: 'auto' }} />
      </div>
      <p style={{ color: '#FFBD59', textAlign: 'center' }}>
        Please enter the email of the account you want to change the password
      </p>

      <form onSubmit={handleSubmit} style={{ display: 'flex', justifyContent: 'center', marginTop: '2rem' }}>
        <input type="email" value={email} onChange={handleChange} placeholder="Enter email" style={{ marginRight: '1rem', width: '300px', height: '40px', borderRadius: '20px' }} />
        <button type="submit" style={{ backgroundColor: '#FFBD59', color: '#4B0082', border: 'none', padding: '0.5rem 1rem', borderRadius: '20px'}}>
          Confirm
        </button>
      </form>

      <p style={{ color: '#FFFFFF', textAlign: 'center', marginTop: '2rem' }}>
        <a href="/login" style={{ color: '#FFFFFF', textDecoration: 'none' }}>Login</a> | <a href="/register" style={{ color: '#FFFFFF', textDecoration: 'none' }}>Register</a>
      </p>
    </div>
  );
};

export default ResetPasswordEmail;
