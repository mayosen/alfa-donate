import React from 'react';
import './App.css';
import Landing from './pages/landing/landing';
import {BrowserRouter} from 'react-router-dom';
import { Route, Routes } from 'react-router';
import Blank from './pages/blank/blank';
import Analytics from './pages/analytics/analytics';

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Landing/>}/>
        <Route path="/analytics" element={<Analytics/>}/>
        <Route path="/donates" element={<Blank/>}/>
      </Routes>
    </BrowserRouter>
  );
}

export default App;
