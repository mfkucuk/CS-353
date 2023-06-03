import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import HomeOwnerProfile from './Pages/HomeOwner/HomeOwnerProfile';
import TravelerProfile from './Pages/Traveler/TravelerProfile';
import AdminProfile from './Pages/Admin/AdminProfile';
import TravelerMainPage from './Pages/Traveler/TravelerMainPage';
import Login from './Pages/Common/Login';
import Register from './Pages/Common/Register';
import ResetPasswordEmail from './Pages/Common/ResetPasswordEmail';
import ResetPassword from './Pages/Common/ResetPassword';
import TravelerRental from './Pages/Traveler/TravelerRental';
import TravelerListing from './Pages/Traveler/TravelerListing';
import AdminSystemReport from './Pages/Admin/AdminSystemReport';
import HomeOwnerMainPage from './Pages/HomeOwner/HomeOwnerMainPage';
import HomeOwnerRental from './Pages/HomeOwner/HomeOwnerRental';

function App() {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<Login />} />
        <Route path="/register" element={<Register />} />
        <Route path="/reset-password-email" element={<ResetPasswordEmail />} />
        <Route path="/reset-password" element={<ResetPassword />} />
        <Route path="/homeowner-profile" element={<HomeOwnerProfile />} />
        <Route path="/traveler-profile" element={<TravelerProfile />} />
        <Route path="/admin-profile" element={<AdminProfile />} />
        <Route path="/traveler-main-page" element={<TravelerMainPage />} />
        <Route path="/homeowner-rental" element={<HomeOwnerRental />} />
        <Route path="/traveler-rental" element={<TravelerRental />} />
        <Route path="/traveler-listing" element={<TravelerListing />} />
        <Route path="/system-report" element={<AdminSystemReport />} />
        <Route path="/homeowner-main-page" element={<HomeOwnerMainPage />} />

      </Routes>
    </Router>
  );
}

export default App;
