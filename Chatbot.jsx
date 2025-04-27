import React, { useState } from 'react';
import axios from 'axios';

const Chatbot = () => {
  const [message, setMessage] = useState('');
  const [response, setResponse] = useState('');

  const handleSendMessage = async () => {
    try {
      const result = await axios.post('https://openrouter-api-endpoint', {
        message: message,
        headers: { 'Authorization': 'Bearer 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' },
      });
      setResponse(result.data.response);
    } catch (error) {
      setResponse('Sorry, there was an error. Please try again later.');
    }
  };

  return (
    <div>
      <textarea
        value={message}
        onChange={(e) => setMessage(e.target.value)}
        placeholder="Ask me anything..."
      />
      <button onClick={handleSendMessage}>Send</button>
      <p>Bot: {response}</p>
    </div>
  );
};

export default Chatbot;
