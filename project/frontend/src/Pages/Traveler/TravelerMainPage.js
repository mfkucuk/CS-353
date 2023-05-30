import {React, }from 'react';

const App = () => {
  return (
    <div style={{ backgroundColor: '#4b0082', color: '#FFBD59' }}>
      <header>
        <div style={{ display: 'flex', alignItems: 'center', padding: '10px', paddingTop: '0px' }}>
          <div>
            <img src="bilkent_logo.png" alt="Logo" style={{ height: '100px', width: '250px', margin: '50px', marginTop: '0.5vh' }} />
          </div>
          <div style={{ flexGrow: 1, display: 'flex', justifyContent: 'flex-end', alignItems: 'center', marginRight: '2vw' }}>
            <button style={{ color: '#4B0082', marginRight: '1vw', backgroundColor: '#FFBD59', borderRadius: '5px', fontSize: '15px', paddingTop: '3px', paddingBottom: '3px', paddingLeft: '15px', paddingRight: '15px' }}>Switch to Home Owner</button>
            <div style={{fontSize: '15px', padding: '1vw'}}>
              <p>Username</p>
              <p>Balance</p>
            </div>
            <img src="default_pp.png" alt="User" style={{ height: '70px', marginLeft: '0.7vw', marginRight: '0.7vw' }} />
            <div>
              <button style={{ marginLeft: '10px', backgroundColor: '#4B0082', border: 'transparent', padding: '0px' }}>
                <img src="hamburger_menu_img.png" alt="Menu" style={{width: '170px'}} />
              </button>
            </div>
          </div>
        </div>
      </header>

      <div style={{ padding: '10px'}}>
        <div style={{ display: 'flex', alignItems: 'center', width:'100%', justifyContent: 'center',}}>
          <button style={{ marginRight: '10px', border: '2px solid #FFBD59', backgroundColor: '#FFBD59', borderRadius: '10px', paddingLeft: '15px', paddingRight: '15px', marginRight: '1vw'}}>
            Filter
          </button>
          <input type="text" placeholder="Search" style={{ border: '15px solid #FFBD59', borderTop: '5px solid #FFBD59', borderBottom: '5px solid #FFBD59', borderRadius: '15px', paddingLeft: '30px', paddingRight: '30px'}} />
        </div>

        <div style={{ display: 'flex', flexWrap: 'wrap' }}>
          {/* Container 1 */}
          <div style={{ width: '30%', padding: '10px', backgroundColor: '#4B0082', alignContent: 'center'}}>
            <button style={{ width: '100%', display: 'flex', flexDirection: 'column', alignItems: 'center', backgroundColor: '#4B0082', border: 'transparent', alignContent: 'center' }}>
              <img src="image1.png" alt="Image 1" style={{ width: '100%', height: '150px', objectFit: 'cover' }} />
              <div style={{display: 'grid', backgroundColor: '#4B0082', color: '#FFBD59', fontSize: "12px", gridTemplateRows: "auto auto auto auto" }}>
                  <p>Text 1</p>
                  <p>Text 2</p>
                  <p>Text 3</p>
                  <p>Text 4</p>
                  <p>4.5</p>
              </div>
            </button>
          </div>

          {/* Container 2 */}
          <div style={{ width: '30%', padding: '10px', alignContent: 'center' }}>
            <button style={{ width: '30%', display: 'flex', flexDirection: 'column', alignItems: 'center', backgroundColor: '#4B0082', border: 'transparent'}}>
              <img src="image2.png" alt="Image 2" style={{ width: '100%', height: '150px', objectFit: 'cover' }} />
              <div style={{ backgroundColor: '#4B0082', color: '#FFBD59'}}>
                <p>Text 1</p>
                <p>Text 2</p>
                <p>Text 3</p>
                <p>Text 4</p>
                <p>Rating: 4.2</p>
              </div>
            </button>
          </div>

          {/* Container 3 */}
          <div style={{ width: '30%', padding: '10px', alignContent: 'center' }}>
            <button style={{ display: 'flex', flexDirection: 'column', alignItems: 'center', backgroundColor: '#4B0082', width: '30%', border: 'transparent' }}>
              <img src="image3.png" alt="Image 3" style={{ width: '100%', height: '150px', objectFit: 'cover' }} />
              <div style={{ backgroundColor: '#4B0082', color: '#FFBD59'}}>
                <p>Text 1</p>
                <p>Text 2</p>
                <p>Text 3</p>
                <p>Text 4</p>
                <p>Rating: 4.8</p>
              </div>
            </button>
          </div>

          {/* Add more containers here */}
        </div>
      </div>
    </div>
  );
};

export default App;
