import React, { useState } from 'react';
import axios from 'axios';

const RegisterPage = () => {
  const [name, setName] = useState('');
  const [email, setEmail] = useState('');
  const [dob, setDob] = useState('');
  const [password, setPassword] = useState('');
  const [phoneNumber, setPhoneNumber] = useState('');
  const [tck, setTck] = useState('');
  const [confirmPassword, setConfirmPassword] = useState('');

  const handleRegister = async () => {
    try {
      // Make a POST request to register the user
      const response = await axios.post('/api/register', {
        name,
        email,
        dob,
        password,
        phoneNumber,
        tck,
        confirmPassword,
      });

      console.log(response.data); // Handle the response data as needed
    } catch (error) {
      console.error(error);
    }
  };

  return (
    <div style={{ backgroundColor: '#4b0082', minHeight: '100vh', paddingTop: '50px' }}>
      <div style={{ display: 'flex', justifyContent: 'center' }}>
        <img src="bilkent_logo.png" alt="Logo" style={{ width: '600px', height: 'auto' }} />
      </div>
      <div style={{ display: 'flex', justifyContent: 'center', paddingTop: '20px', color: '#FFBD59', fontSize: '24px' }}>
        Welcome
      </div>
      <div style={{ display: 'flex', justifyContent: 'center', paddingTop: '20px' }}>
        <div>
          <div>
            <input type="text" placeholder="Name" value={name} style={{ borderRadius: '20px', width: '300px', height: '40px' }} onChange={(e) => setName(e.target.value)} />
          </div>
          <div>
            <input type="email" placeholder="Email" value={email} style={{ borderRadius: '20px', width: '300px', height: '40px' }} onChange={(e) => setEmail(e.target.value)} />
          </div>
        </div>
        <div style={{ paddingLeft: '20px' }}>
          <div>
            <input type="text" placeholder="Date of Birth" value={dob} style={{ borderRadius: '20px', width: '300px', height: '40px' }} onChange={(e) => setDob(e.target.value)} />
          </div>
          <div>
            <input type="password" placeholder="Password" value={password} style={{ borderRadius: '20px', width: '300px', height: '40px' }} onChange={(e) => setPassword(e.target.value)} />
          </div>
          <div>
            <input type="text" placeholder="Phone Number" value={phoneNumber} style={{ borderRadius: '20px', width: '300px', height: '40px' }} onChange={(e) => setPhoneNumber(e.target.value)} />
          </div>
        </div>
        <div style={{ paddingLeft: '20px' }}>
          <div>
            <input type="text" placeholder="TCK" value={tck} style={{ borderRadius: '20px', width: '300px', height: '40px' }} onChange={(e) => setTck(e.target.value)} />
          </div>
          <div>
            <input type="password" placeholder="Confirm Password" value={confirmPassword} style={{ borderRadius: '20px', width: '300px', height: '40px' }} onChange={(e) => setConfirmPassword(e.target.value)} />
          </div>
        </div>
      </div>
      <div style={{ display: 'flex', justifyContent: 'center', paddingTop: '20px' }}>
        <button style={{ display: 'flex', justifyContent: 'center', alignItems: 'center', backgroundColor: '#FFBD59', borderRadius: '20px', width: '200px', height: '40px', fontSize: '16px' }} onClick={handleRegister}>Register</button>
      </div>
      <div style={{ display: 'flex', justifyContent: 'center', paddingTop: '20px', color: 'white' }}>
        Already have an account? <a href="/Login" style={{ color: 'white', paddingLeft: '5px' }}>Login</a>
      </div>
    </div>
  );
};

export default RegisterPage;