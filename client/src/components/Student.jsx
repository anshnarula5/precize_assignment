import React, { useEffect, useState } from 'react'
import { Button } from 'react-bootstrap'
import UpdateStudentForm from './UpdateStudentForm'
import { getStudentRank } from '../api/restService'

const Student = ({ student, handleDelete, handleUpdate }) => {
	const [rank, setRank] = useState()
	const [showForm, setShowForm] = useState(false)
	const getRank = async() => {
		const res = await getStudentRank(student.studentName)
		setRank(res.data)
	}
	useEffect(() => {
		getRank()
	},[])
	const updateData = (formData) => {
		setShowForm(false)
		handleUpdate(formData)
	}
	return (
		<li >
			<div className='bg-light p-3 my-2 d-flex flex-row align-items-center'>
			<div className='d-flex flex-column px-3'>
				<button className='my-2 btn btn-outline-warning'  onClick={() =>setShowForm(true)}>
					Update
				</button>
				<button className='btn btn-outline-danger' onClick={() => handleDelete(student.studentName)}>
					Delete
				</button>
			</div>
			<div className='d-flex flex-column px-4'>
				<h4>Rank : {rank}</h4>
			</div>
			<div className='flex-fill'>
				<div className='d-flex flex-row justify-content-between'>
					<h3>
						{student.studentName}
					</h3>
					<h4>
						{student.satScore}
					</h4>
				</div>
				<div className='d-flex justify-content-between align-items-center'>
					<div className='flex flex-column text-start'>
						<div>
							{student.address}, {student.pincode}
						</div>
						<div>
							{student.city}, {student.country}
						</div>
					</div>

					<div className={`px-2 py-1  ${student.passed ? `bg-success` : `bg-danger`}`}>
						{student.passed ? "Passed" : "Failed"}
					</div>
				</div>
			</div>

			</div>
			{showForm && <UpdateStudentForm updateData = {updateData} prevData={student}/>}
		</li>
	)
}

export default Student