import './App.css';
import HomeOwnerProfile from './Pages/HomeOwner/HomeOwnerProfile';
import TravelerProfile from './Pages/Traveler/TravelerProfile';
import AdminProfile from './Pages/Admin/AdminProfile';
import TravelerMainPage from './Pages/Traveler/TravelerMainPage';
import Login from './Pages/Common/Login';
import Register from './Pages/Common/Register';
import ResetPasswordEmail from './Pages/Common/ResetPasswordEmail';

function App() {
  return (
    <div className="App">
     <ResetPasswordEmail></ResetPasswordEmail>
    </div>
  );
}

export default App;
