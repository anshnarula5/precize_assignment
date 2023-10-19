import React, { useState } from 'react';
import { Form, Button, Row, Col } from 'react-bootstrap';
import { addNewSATScore } from '../api/restService';

const StudentForm = ({setAddNewDataTrigger}) => {
  const [formData, setFormData] = useState({
    studentName: '',
    address: '',
    city: '',
    country: '',
    pincode: '',
    satScore: '',
  });

  const handleInputChange = (e) => {
    const { name, value } = e.target;
    setFormData({ ...formData, [name]: value });
  };

  const handleSubmit = async(e) => {
    e.preventDefault();
    await addNewSATScore(formData)
    setAddNewDataTrigger((prev) => !prev)
  };

  return (
    <div className="p-4 my-2 text-start bg-light " >
      <Form onSubmit={handleSubmit}>
        <Form.Group controlId="studentName py-1 ">
          <Form.Label>Student Name</Form.Label>
          <Form.Control
            type="text"
            className='my-2'
            placeholder="Enter student name"
            name="studentName"
            value={formData.studentName}
            onChange={handleInputChange}
            required
          />
        </Form.Group>

        <Form.Group controlId="address py-1">
          <Form.Label>Address</Form.Label>
          <Form.Control
            className='my-2'
            type="text"
            placeholder="Enter address"
            name="address"
            value={formData.address}
            required
            onChange={handleInputChange}
          />
        </Form.Group>

        <Row>
          <Col>
            <Form.Group controlId="city py-1">
              <Form.Label>City</Form.Label>
              <Form.Control
                type="text"
            className='my-2'
            placeholder="Enter city"
                name="city"
                value={formData.city}
            required
            onChange={handleInputChange}
              />
            </Form.Group>
          </Col>
          <Col>
            <Form.Group controlId="country py-1">
              <Form.Label>Country</Form.Label>
              <Form.Control
                type="text"
            className='my-2'
            placeholder="Enter country"
                name="country"
                value={formData.country}
            required
            onChange={handleInputChange}
              />
            </Form.Group>
          </Col>
          <Col>
            <Form.Group controlId="pincode py-1">
              <Form.Label>Pincode</Form.Label>
              <Form.Control
                type="text"
            className='my-2'
            placeholder="Enter pincode"
                name="pincode"
                value={formData.pincode}
            required
            onChange={handleInputChange}
              />
            </Form.Group>
          </Col>
        </Row>

        <Form.Group controlId="satScore py-1">
          <Form.Label>SAT Score</Form.Label>
          <Form.Control
            type="number"
            step="0.01"
            max={100}
            min={0}
            placeholder="Enter SAT score"
            className='my-2'
            name="satScore"
            value={formData.satScore}
            required
            onChange={handleInputChange}
          />
        </Form.Group>
        <Button variant="primary" type="submit" className='mt-3'>
          Submit
        </Button>
      </Form>
    </div>
  );
};

export default StudentForm;
