import './App.css';
import HomeOwnerProfile from './Pages/HomeOwner/HomeOwnerProfile';
import TravelerProfile from './Pages/Traveler/TravelerProfile';
import AdminProfile from './Pages/Admin/AdminProfile';
import TravelerMainPage from './Pages/Traveler/TravelerMainPage';
import Login from './Pages/Common/Login';
import Register from './Pages/Common/Register';
import ResetPasswordEmail from './Pages/Common/ResetPasswordEmail';
import ResetPassword from './Pages/Common/ResetPassword';
import Messaging from './Pages/Common/Messaging';
import HomeOwnerRental from './Pages/HomeOwner/HomeOwnerRental';
import TravelerRental from './Pages/Traveler/TravelerRental';

function App() {
  return (
    <div className="App">
     <TravelerRental></TravelerRental>
    </div>
  );
}

export default App;
