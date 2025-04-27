import React from 'react';
import { Routes, Route } from 'react-router-dom';
import Navbar from './components/Navbar';
import HeroSection from './components/HeroSection';
import Chatbot from './components/Chatbot';
import Reviews from './components/Reviews';

function App() {
  return (
    <div>
      <Navbar />
      <Routes>
        <Route path="/" element={<HeroSection />} />
        <Route path="/about" element={<div>About Us</div>} />
        <Route path="/reviews" element={<Reviews />} />
        <Route path="/chat" element={<Chatbot />} />
      </Routes>
    </div>
  );
}

export default App;
