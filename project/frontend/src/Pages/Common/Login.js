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
    <div style={{ backgroundColor: '#4b0082', minHeight: '100vh' }}>
      <div style={{ display: 'flex', justifyContent: 'center', paddingTop: '100px' }}>
        <img src="bilkent_logo.png" alt="Logo" style={{ width: '600px', height: 'auto' }}/>
      </div>
      <div style={{ display: 'flex', justifyContent: 'center', paddingTop: '50px' }}>
        <div style={{ backgroundColor: '#FFBD59', padding: '20px', borderRadius: '5px' }}>
          <h2 style={{ textAlign: 'center', color: 'black' }}>Welcome</h2>
          <div style={{ display: 'flex', flexDirection: 'column' }}>
            <input
              type="email"
              placeholder="Email Address"
              value={email}
              onChange={(e) => setEmail(e.target.value)}
              style={{ marginBottom: '10px', padding: '5px' }}
            />
            <input
              type="password"
              placeholder="Password"
              value={password}
              onChange={(e) => setPassword(e.target.value)}
              style={{ marginBottom: '10px', padding: '5px' }}
            />
            <label style={{ marginBottom: '10px', display: 'flex', alignItems: 'center' }}>
              <input type="checkbox" style={{ marginRight: '5px' }} />
              Remember me
            </label>
            <button onClick={handleLogin} style={{ marginBottom: '10px', padding: '5px' }}>
              Login
            </button>
            <a href="#" style={{ textAlign: 'center', textDecoration: 'underline' }}>
              Forgot your password?
            </a>
          </div>
        </div>
      </div>
    </div>
  );
};

export default LoginPage;
