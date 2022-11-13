import React from 'react';
import './App.css';
import Landing from './pages/landing/landing';
import { Router, Route, Routes } from 'react-router';

function App() {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<Landing/>}/>
      </Routes>
    </Router>
  );
}

export default App;
