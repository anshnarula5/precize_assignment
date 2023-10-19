import React, { useEffect, useState } from 'react'
import { deleteScoreByName, getAllStudentScores, updateScoreByName } from '../api/restService';
import Student from './Student';
import { Button } from 'react-bootstrap';
import StudentForm from './StudentForm';

const StudentList = () => {
  const [students, setStudents] = useState();
  const [showForm, setShowForm] = useState(false)
  const [addNewDataTrigger, setAddNewDataTrigger] = useState(false)
  const fetchAllStudents = async() => {
   const response = await getAllStudentScores()
   setStudents(response.data);
  }
  useEffect(() => {
    fetchAllStudents()
    setShowForm(false)
  }, [addNewDataTrigger])

  const handleDelete = async(name) => {
    await deleteScoreByName(name)
    setAddNewDataTrigger(!addNewDataTrigger)
  }

  const handleUpdate = async(formData) => {
    if(!formData) return
    setAddNewDataTrigger(!addNewDataTrigger)
    await updateScoreByName(formData.studentName, formData)
  }
  return (
    <div className='d-flex flex-column justify-content-center'>
      <Button onClick={() => setShowForm(!showForm)}>
        {showForm ? "Close" : "Add new Student"}
      </Button>
      {showForm && <StudentForm setAddNewDataTrigger = {setAddNewDataTrigger} />}
      {students && students.length > 0 && 
        students.map(student => (
          <Student key={student.studentName} student={student} handleDelete = {handleDelete} handleUpdate = {handleUpdate}/>
        ))
      }
    </div>
  )
}

export default StudentList