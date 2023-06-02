import React, { useState, useEffect } from 'react';
import axios from 'axios';

const SystemReport = () => {
  const [title, setTitle] = useState('');
  const [selectedOption, setSelectedOption] = useState('');
  const [systemReport, setSystemReport] = useState([]);

  const handleTitleChange = (event) => {
    setTitle(event.target.value);
  };

  const handleOptionChange = (event) => {
    setSelectedOption(event.target.value);
  };

  const handleCreateReport = () => {
    const reportData = {
      title: title,
      option: selectedOption,
    };

    axios
      .post('/api/system-reports', reportData)
      .then((response) => {
        const newReport = response.data;
        setSystemReport([...systemReport, newReport]);
        setTitle('');
        setSelectedOption('');
      })
      .catch((error) => {
        console.error('Error creating system report:', error);
      });
  };

  useEffect(() => {
    axios
      .get('/api/system-reports')
      .then((response) => {
        const reports = response.data;
        setSystemReport(reports);
      })
      .catch((error) => {
        console.error('Error getting system reports:', error);
      });
  }, []);

  const logoStyle = {
    position: 'absolute',
    top: '20px',
    left: '20px',
    width: '250px',
    height: '100px',
  };

  return (
    <div
      style={{
        display: 'flex',
        flexDirection: 'column',
        alignItems: 'center',
        backgroundColor: '#4b0082',
        minHeight: '100vh',
        paddingTop: '20px',
      }}
    >
      <img src="/bilkent_logo.png" alt="Logo" style={logoStyle} />
      <h1 style={{ color: '#FFBD59' }}>System Report</h1>
      <input
        type="text"
        value={title}
        onChange={handleTitleChange}
        placeholder="Title"
        style={{ marginBottom: '10px', borderRadius: '10px' }}
      />
      <select
        value={selectedOption}
        onChange={handleOptionChange}
        style={{ marginBottom: '10px', borderRadius: '10px' }}
      >
        <option value="">--Please choose an option--</option>
        <option value="option1">option1</option>
        <option value="option2">option2</option>
        <option value="option3">option3</option>
        <option value="option4">option4</option>
        <option value="option5">option5</option>
      </select>
      <button
        onClick={handleCreateReport}
        style={{
          backgroundColor: '#FFBD59',
          color: '#000000',
          marginBottom: '10px',
          borderRadius: '10px',
        }}
      >
        Create System Report
      </button>
      <div>
        <h1 style={{ color: '#FFBD59' }}>Report</h1>
        <ul>
          {systemReport.map((report, index) => (
            <li key={index}>
              <h3>{report.title}</h3>
              <p>{report.option}</p>
            </li>
          ))}
        </ul>
      </div>
    </div>
  );
};

export default SystemReport;
