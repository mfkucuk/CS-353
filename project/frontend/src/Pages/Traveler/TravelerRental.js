import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { useLocation } from 'react-router-dom';
import "./TravelerRental.css";

const contentStyle = {
    fontSize: '18px',
    color: '#ffbd59',
    fontWeight: 'bold',
  };

  const dateStyle = {
    fontSize: '18px',
    color: '#ffbd59',
    fontWeight: 'bold',
    marginLeft: '60vw',
  };

  const buttonStyle = {
    backgroundColor: '#FFBD59',
    color: '#4B0082',
    padding: '10px 20px',
    border: 'none',
    fontWeight: 'bold',
    borderRadius: '5px',
    cursor: 'pointer',
    fontSize: '16px',
    margin: '10px 0',
    transition: 'all 0.3s ease',
    marginLeft: '10px',
  };

  const imageStyle = {
    width: '75%',
    marginRight: '20%',
    height: 'auto',
  };

  const openAnswerWindowButtonStyle = {
    backgroundColor: '#ffbd59',
    color: '#fff',
    padding: '8px 16px',
    borderRadius: '4px',
    border: 'none',
    cursor: 'pointer',
    marginTop: '8px',
  };
  
const answerInputContainerStyle = {
    display: 'flex',
    justifyContent: 'center',
    alignItems: 'center',
    marginTop: '10px',
  };
  
  const answerInputStyle = {
    width: '300px',
    marginRight: '10px',
  };
  
  const answerButtonStyle = {
    padding: '5px 10px',
    backgroundColor: '#FFBD59',
    border: 'none',
    borderRadius: '5px',
    color: 'white',
    cursor: 'pointer',
  };

  const homeownerStyle = {
    display: 'flex',
    alignItems: 'center',
    margin: '10px 0',
  };

  const homeownerImageStyle = {
    width: 50,
    height: 50,
    borderRadius: '50%',
    marginRight: '10px',
  };

  const switchContainerStyle = {
    display: 'flex',
    alignItems: 'center',
    marginTop: '50px',
    textAlign: 'center',
  };

  const switchButtonStyle = {
    position: 'relative',
    display: 'inline-block',
    width: '60px',
    height: '34px',
  };

  const switchSliderStyle = {
    position: 'absolute',
    cursor: 'pointer',
    top: '0',
    left: '0',
    right: '0',
    bottom: '0',
    backgroundColor: '#FFBD59',
    transition: '0.4s',
    borderRadius: '34px',
  };

  const answerStyle = {
    marginLeft: '20px', // Indent the answer
    marginBottom: '10px',
    marginTop: '15px',
    padding: '10px',
    border: '1px solid #FFBD59',
    borderRadius: '5px',
    wordWrap: 'break-word', // Break long words into multiple lines
  };
  

  const questionSectionStyle = {
    width: '80vw',
    margin: '20px auto',
    border: '1px solid #FFBD59',
    borderRadius: '5px',
    padding: '10px',
    alignContent: 'center',
  };
  
  const questionStyle = {
    marginBottom: '10px',
    padding: '10px',
    border: '1px solid #FFBD59',
    borderRadius: '5px',
    wordWrap: 'break-word', // Break long words into multiple lines
  };
  
  const questionInputContainerStyle = {
    display: 'flex',
    alignItems: 'center',
    justifyContent: 'flex-end', // Align items to the right
    marginTop: '20px',
  };
  
  const questionInputStyle = {
    width: '30vw',
    padding: '10px',
    border: '1px solid #FFBD59',
    borderRadius: '5px',
    marginRight: '10px',
    boxSizing: 'border-box',
  };
  
  const questionButtonStyle = {
    backgroundColor: '#FFBD59',
    color: '#4B0082',
    padding: '10px 20px',
    fontWeight: 'bold',
    border: 'none',
    borderRadius: '5px',
    cursor: 'pointer',
    fontSize: '16px',
    alignSelf: 'flex-start', // Align button to the top
  };

  const switchLabelStyle = {
    marginLeft: '20px',
    marginRight: '20px',
    fontSize: '20px',
    fontWeight: 'bold',
    color: '#FFBD59',
  };

  const commentSectionStyle = {
    width: '80vw',
    margin: '20px auto',
    border: '1px solid #FFBD59',
    borderRadius: '5px',
    padding: '10px',
    alignContent: 'center',
  };

  const commentStyle = {
    marginBottom: '10px',
    padding: '10px',
    border: '1px solid #FFBD59',
    borderRadius: '5px',
    wordWrap: 'break-word', // Break long words into multiple lines
  };

  const commentInputContainerStyle = {
    display: 'flex',
    alignItems: 'center',
    justifyContent: 'flex-end', // Align items to the right
    marginTop: '20px',
  };

  const commentInputStyle = {
    width: '30vw',
    padding: '10px',
    border: '1px solid #FFBD59',
    borderRadius: '5px',
    marginRight: '10px',
    boxSizing: 'border-box',
  };

  const commentButtonStyle = {
    backgroundColor: '#FFBD59',
    color: '#4B0082',
    padding: '10px 20px',
    fontWeight: 'bold',
    border: 'none',
    borderRadius: '5px',
    cursor: 'pointer',
    fontSize: '16px',
    alignSelf: 'flex-start', // Align button to the top
  };

  const commentSectionScrollStyle = {
    maxHeight: '300px',
    overflowY: 'auto',
    scrollbarWidth: 'thin',
    scrollbarColor: '#4B0082 #FFBD59',
    // Add the following CSS properties for the track and thumb styles
    scrollbarTrackColor: '#ffbd59',
    scrollbarThumbColor: '#4b0082',
  };
  
  const commentSectionScrollInnerStyle = {
    // Add the following CSS property for the scrollbar pseudo-element styles
    scrollbarWidth: 'thin',
    scrollbarColor: '#4B0082 #FFBD59',
    display: 'flex', // Add display flex
    flexDirection: 'column', // Arrange comments in a column
  };

const TravelerRental = () => {
  const [rentalData, setRentalData] = useState({});
  const [showComments, setShowComments] = useState(true);
  const [comments, setComments] = useState([]);
  const [questions, setQuestions] = useState([]);
  const [newQuestion, setNewQuestion] = useState('');
  const [answers, setAnswers] = useState([]);
  const [answerInputs, setAnswerInputs] = useState([]);
  const [selectedQuestionIndex, setSelectedQuestionIndex] = useState(null);
  const [profileImage, setProfileImage] = useState('/default_pp.png');
  const [username, setUsername] = useState('John Doe');


  const location = useLocation();
  const index = new URLSearchParams(location.search).get('index');

  // const formatDateTime = (localDateTime) => {
  //   const year = localDateTime.getFullYear();
  //   const month = String(localDateTime.getMonth() + 1).padStart(2, '0');
  //   const day = String(localDateTime.getDate()).padStart(2, '0');
  //   const hours = String(localDateTime.getHours()).padStart(2, '0');
  //   const minutes = String(localDateTime.getMinutes()).padStart(2, '0');
  
  //   const formattedDateTime = `${hours}:${minutes} ${day}/${month}/${year}`;
  
  //   return formattedDateTime;
  // };

 
  useEffect(() => {
    const fetchData = async () => {
      try {
        const res = await axios.get(`http://localhost:8080/api/rental/id=${index}`);
        setRentalData(res.data);
        setComments(res.data.comments);
  
        if (res.data.type == 'Room') {
          const res1 = await axios.get(`http://localhost:8080/api/room/get/id=${index}`);
          setRentalData(res1.data);
        } else {
          const res2 = await axios.get(`http://localhost:8080/api/flat/get/id=${index}`);
          setRentalData(res2.data);
        }
      } catch (error) {
        // Handle error here
        console.error(error);
      }
    };

    fetchData();
  }, []);

  useEffect(() => {
    axios
      .get(`http://localhost:8080/api/qanda/rental_id=${index}`)
      .then(res => {
        let questions = []
        let answers = []
        res.data.forEach((qanda) => {
          questions.push(
            {
              "question": qanda.question, 
              "username": qanda.askName, 
              "date": qanda.askDate});
          answers.push(
            {
              "answer": qanda.answer, 
              "username": qanda.answerName, 
              "date": qanda.answerDate});
        });

        setQuestions(questions);
        setAnswers(answers);
      })
  }, []);
  

  const switchSliderBeforeStyle = {
    content: "''",
    position: 'absolute',
    height: '26px',
    width: '26px',
    left: '4px',
    bottom: '4px',
    backgroundColor: '#4B0082',
    transition: '0.4s',
    borderRadius: '50%',
    transform: showComments ? 'translateX(0)' : 'translateX(26px)',
  };


  // ...

  const handleQuestionChange = (event) => {
    setNewQuestion(event.target.value);
  };

  
  const handleAddQuestion = () => {
    setQuestions((prevQuestions) => [...prevQuestions, newQuestion]);
    setAnswers((prevAnswers) => [...prevAnswers, '']);
    setAnswerInputs((prevInputs) => [...prevInputs, '']);
    
    axios
    .post('http://localhost:8080/api/qanda', 
    {
          "askId": window.localStorage.getItem('user'),
          'answerId': null,
          "rentalId": index,
          "askDate": null,
          "answerDate": null,
          "question": newQuestion,
          "answer": null
        }
      )
    .then(setNewQuestion(''));
  };

  const handleAnswerInputChange = (index, event) => {
    setAnswerInputs((prevInputs) => {
      const updatedInputs = [...prevInputs];
      updatedInputs[index] = event.target.value;
      return updatedInputs;
    });
  };
  const handleSwitchComments = () => {
    setShowComments((prevState) => !prevState);
  };
  
  const handleAnswer = (index) => {
    const answer = answerInputs[index];
    if (answer) {
      handleAddAnswer(index, answer);
      setAnswerInputs((prevInputs) => {
        const updatedInputs = [...prevInputs];
        updatedInputs[index] = '';
        return updatedInputs;
      });
      setSelectedQuestionIndex(null); // Close the mini window after submitting the answer
    }
  };

  const handleOpenAnswerWindow = (index) => {
    setSelectedQuestionIndex(index);
  };

  const handleAddAnswer = (questionIndex, answer) => {
    setAnswers((prevAnswers) => {
      const updatedAnswers = [...prevAnswers];
      updatedAnswers[questionIndex] = answer;
      return updatedAnswers;
    });
  };

  const handleRentButton = () => {
    axios.put(`http://localhost:8080/api/rental/id=${index}/traveler=${window.localStorage.getItem('user')}`)
      .then();
  }

  const dateFormat = (dateFromSQL) => {

    const options = { day: '2-digit', month: '2-digit', year: 'numeric' };
    const formattedDate = new Date(dateFromSQL).toLocaleDateString('en-GB', options);
    return formattedDate;
  }
  
  return (
      <div style={{ backgroundColor: '#4b0082', height: '100vh', overflowY: 'auto' }}>
        <div style={{ width: '100%', height: '120px', backgroundColor: '#4b0082', position: 'absolute', top: 0 }}>
          <div style={{ position: 'absolute', top: 0, left: 0 }}>
            <img src="/bilkent_logo.png" alt="Logo" style={{ marginLeft: 50, marginTop: 20, width: 250, height: 100 }} />
          </div>
        </div>
        <div
          style={{
            display: 'flex',
            flexDirection: 'column',
            alignItems: 'center',
            justifyContent: 'center',
            color: 'white',
            padding: '40px',
          }}
        >
          <h1 style={{ color: '#FFBD59', marginTop: '100px' }}>Rental in {rentalData.location}</h1>
          <div style={{ display: 'flex', justifyContent: 'space-between', width: '80%', marginTop: 20 }}>
            <div>
              <img src="/example_rental.jpg" alt="Rental" style={imageStyle} />
            </div>
            <div>
              <p style={contentStyle}>Location: {rentalData.location}</p>
              {rentalData.type == 'Room' ? (
                <p style={contentStyle}>Capacity: {rentalData.capacity}</p>
              ) : 
              <p style={contentStyle}>Room Count: {rentalData.roomCount}</p>
              }
              <p style={contentStyle}>Rating: {rentalData.rating}/5</p>
              <p style={contentStyle}>
                Available dates: {dateFormat(rentalData.availableStart)} to {dateFormat(rentalData.availableEnd)}
              </p>
              <p style={contentStyle}>Features: {rentalData.features}</p>
              <p style={contentStyle}>Restrictions: {rentalData.restrictions}</p>
              <p style={contentStyle}>Rental Type: {rentalData.rentalType}</p>
              <p style={contentStyle}>Price: {rentalData.price}</p>
              <div style={homeownerStyle}>
                <img src="/default_pp.png" alt="Homeowner" style={homeownerImageStyle} />
                <p style={contentStyle}>{rentalData.homeownerName}</p>
              </div>
            </div>
          </div>
          <button style={buttonStyle} onClick={handleRentButton}>Rent</button>
          <div style={switchContainerStyle}>
            <span style={switchLabelStyle}>Comments</span>
            <label className="switch" style={switchButtonStyle}>
              <input type="checkbox" checked={showComments} onChange={handleSwitchComments} />
              <span className="slider" style={switchSliderStyle}>
                <span className="slider-before" style={switchSliderBeforeStyle}></span>
              </span>
            </label>
            <span style={switchLabelStyle}>Questions</span>
          </div>
          {showComments ? (
            <div style={commentSectionStyle}>
              <h2 style={{ textAlign: 'center', color: '#ffbd59' }}>Comments</h2>
              <div style={commentSectionScrollStyle}>
                <div style={commentSectionScrollInnerStyle}>
                  {comments.map((comment, index) => (
                    <div key={index} style={commentStyle}>
                      <div style={homeownerStyle}>
                        <img src="/default_pp.png" alt="User" style={homeownerImageStyle} />
                      </div>
                      {comment}
                    </div>
                  ))}
                </div>
              </div>
            </div>
          ) : (
            <div style={questionSectionStyle}>
              <h2 style={{ textAlign: 'center', color: '#ffbd59' }}>Questions</h2>
              <div style={commentSectionScrollStyle}>
                <div style={commentSectionScrollInnerStyle}>
                  {questions.map((question, index) => (
                    <div key={index} style={questionStyle}>
                      <div style={homeownerStyle}>
                        <img src="/default_pp.png" alt="User" style={homeownerImageStyle} />
                        <p style={contentStyle}>{question.username}</p>
                        <p style={dateStyle} placeholder='hh:mm dd/MM/yyyy'>{dateFormat(question.date)}</p>
                      </div>
                      {question.question}
                      {answers[index].answer && (
                        <div style={answerStyle}>
                          <div style={homeownerStyle}>
                            <img src="/default_pp.png" alt="User" style={homeownerImageStyle} />
                            <p style={contentStyle}>{answers[index].username}</p>
                            <p style={dateStyle} placeholder='hh:mm dd/MM/yyyy'>{dateFormat(answers[index].date)}</p>
                          </div>
                          {answers[index].answer}
                        </div>
                      )}
                    </div>
                  ))}
                </div>
              </div>
              <div style={{ display: 'flex', justifyContent: 'center', flexDirection: 'column', alignItems: 'center' }}>
                <div style={questionInputContainerStyle}>
                  <input
                    type="text"
                    value={newQuestion}
                    onChange={handleQuestionChange}
                    style={questionInputStyle}
                    placeholder="Ask a question"
                  />
                  <button style={questionButtonStyle} onClick={handleAddQuestion}>
                    Ask
                  </button>
                </div>
              </div>
            </div>
          )}
        </div>
      </div>
  );
};
export default TravelerRental;
