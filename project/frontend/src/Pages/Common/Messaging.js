import React, { useState, useEffect } from 'react';
import axios from 'axios';

const MessagingPage = () => {
  const [chats, setChats] = useState([]);
  const [selectedChat, setSelectedChat] = useState(null);
  const [messageInput, setMessageInput] = useState('');

  useEffect(() => {
    // Fetch chats data from the server using axios GET request
    axios.get('/api/chats')
      .then(response => {
        setChats(response.data);
      })
      .catch(error => {
        console.error('Error fetching chats:', error);
      });
  }, []);

  const handleChatClick = (chat) => {
    setSelectedChat(chat);
  };

  const handleMessageSend = () => {
    if (messageInput.trim() === '') {
      return;
    }

    // Send message to the server using axios POST request
    axios.post('/api/chats/' + selectedChat.id + '/messages', { text: messageInput })
      .then(response => {
        const updatedChat = { ...selectedChat };
        updatedChat.messages.push(response.data);
        setSelectedChat(updatedChat);
        setMessageInput('');
      })
      .catch(error => {
        console.error('Error sending message:', error);
      });
  };

  const handleGoBack = () => {
    // Go back logic here
  };

  return (
    <div className="messaging-page" style={{ backgroundColor: '#4B0082' }}>
      <div className="header">
        <div className="logo-container">
          <img src="logo.png" alt="Logo" className="logo" />
        </div>
        <button className="go-back-button" onClick={handleGoBack}>Go Back</button>
      </div>
      <div className="content">
        <div className="left-panel" style={{ backgroundColor: '#FFBD59' }}>
          {/* Chat window */}
          {selectedChat && (
            <div className="chat-window">
              <div className="chat-header">
                <img src={selectedChat.profilePhoto} alt="Profile" className="profile-photo" />
                <h2>{selectedChat.name}</h2>
              </div>
              <div className="messages">
                {/* Display messages */}
                {selectedChat.messages.map(message => (
                  <div key={message.id} className="message">
                    <p>{message.text}</p>
                  </div>
                ))}
              </div>
              <div className="message-input">
                <input
                  type="text"
                  value={messageInput}
                  onChange={e => setMessageInput(e.target.value)}
                  placeholder="Type here..."
                />
                <button className="send-button" onClick={handleMessageSend}>
                  <img src="send-icon.png" alt="Send" />
                </button>
              </div>
            </div>
          )}
        </div>
        <div className="right-panel" style={{ backgroundColor: '#FFBD59' }}>
          {/* Chat list */}
          <div className="chat-list">
            <h3>Your Chats</h3>
            {chats.map(chat => (
              <div
                key={chat.id}
                className={`chat ${selectedChat && selectedChat.id === chat.id ? 'selected' : ''}`}
                onClick={() => handleChatClick(chat)}
              >
                <img src={chat.profilePhoto} alt="Profile" className="profile-photo" />
                <div className="chat-details">
                  <h4>{chat.name}</h4>
                  <p>{chat.messages.length > 0 ? chat.messages[chat.messages.length - 1].text : 'No messages'}</p>
                </div>
              </div>
            ))}
          </div>
        </div>
      </div>
    </div>
  );
};

export default MessagingPage;
