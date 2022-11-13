import React from 'react';
import './App.css';
import Landing from './pages/landing/landing';
import {BrowserRouter} from 'react-router-dom';
import { Route, Routes } from 'react-router';

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={[<Landing/>]}/>
      </Routes>
    </BrowserRouter>
  );
}

export default App;
