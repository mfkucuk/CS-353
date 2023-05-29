import React, { useState } from 'react';
import axios from 'axios';

const LoginPage = () => {
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');

  const handleLogin = () => {
    // Perform login logic
    axios
      .post('/login', { email, password })
      .then((response) => {
        // Handle successful login
        console.log('Login successful!');
      })
      .catch((error) => {
        // Handle login error
        console.error('Login failed:', error);
      });
  };

  return (
    <div style={{ backgroundColor: '#4b0082', minHeight: '100vh', paddingTop: '50px' }}>
      <div style={{ display: 'flex', justifyContent: 'center' }}>
        <img src="bilkent_logo.png" alt="Logo" style={{ width: '600px', height: 'auto' }} />
      </div>
      <div style={{ display: 'flex', justifyContent: 'center', paddingTop: '50px' }}>
        <div style={{ backgroundColor: '#FFBD59', padding: '30px', borderRadius: '20px' }}>
          <h2 style={{ textAlign: 'center', color: '#4b0082' }}>Welcome</h2>
          <div style={{ display: 'flex', flexDirection: 'column' }}>
            <input
              type="email"
              placeholder="Email Address"
              value={email}
              onChange={(e) => setEmail(e.target.value)}
              style={{ marginBottom: '10px', padding: '5px', borderRadius: '10px' }}
            />
            <input
              type="password"
              placeholder="Password"
              value={password}
              onChange={(e) => setPassword(e.target.value)}
              style={{ marginBottom: '10px', padding: '5px', borderRadius: '10px' }}
            />
            <label style={{ marginBottom: '10px', display: 'flex', alignItems: 'center', color: '#4b0082' }}>
              <input type="checkbox" style={{ marginRight: '5px' }} />
              Remember me
            </label>
            <button
              onClick={handleLogin}
              style={{
                marginBottom: '10px',
                padding: '5px',
                borderRadius: '10px',
                backgroundColor: '#4b0082',
                color: 'white',
              }}
            >
              Login
            </button>
            <a href="#" style={{ textAlign: 'center', textDecoration: 'underline', color: '#4b0082' }}>
              Forgot your password?
            </a>
          </div>
        </div>
      </div>
    </div>
  );
};

export default LoginPage;