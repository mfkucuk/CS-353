/*import React from 'react';
import { Container, Row, Col, Button, Form, FormControl, InputGroup, Navbar, Nav, Image } from 'react-bootstrap';
import axios from 'axios';

const TravelerMainPage = () => {
  return (
    <div style={{ backgroundColor: '#4b0082', color: '#FFBD59', minHeight: '100vh' }}>
      <Navbar bg="transparent" variant="dark" expand="lg">
        <Navbar.Brand>
          <Image src="/bilkent_logo.png" alt="Logo" style={{margin:50, width: 250, height: 100 }} />
        </Navbar.Brand>
        <Navbar.Toggle aria-controls="navbar-nav" />
        <Navbar.Collapse id="navbar-nav">
          <Nav className="ml-auto">
            <Button variant="outline-light">Switch to Home Owner</Button>
            <Nav.Link>Username</Nav.Link>
            <Nav.Link>Balance</Nav.Link>
            <Image src="user-image.png" alt="User" height={30} className="ml-3" />
            <Nav.Link href="#"><i className="fa fa-bars"></i></Nav.Link>
          </Nav>
        </Navbar.Collapse>
      </Navbar>
      <Container className="py-4">
        <Row className="mb-3">
          <Col md={2}>
            <InputGroup>
              <InputGroup.Prepend>
                <Button variant="outline-light">Filter</Button>
              </InputGroup.Prepend>
              <FormControl placeholder="Search" />
              <InputGroup.Append>
                <Button variant="outline-light">Search</Button>
              </InputGroup.Append>
            </InputGroup>
          </Col>
        </Row>
        <Row>
          <Col md={4}>
            <Button variant="outline-light" className="d-flex flex-column align-items-center mb-3">
              <Image src="image1.png" alt="Image 1" height={150} />
              <div>Text Line 1</div>
              <div>Text Line 2</div>
              <div>Text Line 3</div>
              <div>Text Line 4</div>
              <div>Rating: 4.5</div>
            </Button>
          </Col>
          <Col md={4}>
            <Button variant="outline-light" className="d-flex flex-column align-items-center mb-3">
              <Image src="image2.png" alt="Image 2" height={150} />
              <div>Text Line 1</div>
              <div>Text Line 2</div>
              <div>Text Line 3</div>
              <div>Text Line 4</div>
              <div>Rating: 3.8</div>
            </Button>
          </Col>
          <Col md={4}>
            <Button variant="outline-light" className="d-flex flex-column align-items-center mb-3">
              <Image src="image3.png" alt="Image 3" height={150} />
              <div>Text Line 1</div>
              <div>Text Line 2</div>
              <div>Text Line 3</div>
              <div>Text Line 4</div>
              <div>Rating: 4.2</div>
            </Button>
          </Col>
        </Row>
      </Container>
    </div>
  );
};

export default TravelerMainPage;
*/